package com.vorto.routing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CalculateBest {

    private static final Logger log = LoggerFactory.getLogger(CalculateBest.class.getName());

    public Solution routes(MyMatrix<Double> distances) {
        Solution solution = nearestNeighbor(distances);

        return solution;
    }

    public Solution nearestNeighbor(MyMatrix<Double> distMatrix) {
        Solution solution = new Solution();
        int numPoints = distMatrix.length();
        Set<Integer> notVisited = new HashSet<>();
        int length = distMatrix.length();
        for(int i = 1; i < length; i++) {
            notVisited.add(i);
        }

        //NOTE: We are going to modify so that nearest INCLUDES BOTH
        // 1. previous route's dropoff to next route's pickup
        // 2. this route's pickup to this route's dropoff
        // At this point, there is just not enough time to think about this problem so I am
        // going with a make it work, make it better approach which sometimes means going down the wrong path and
        // backing out later sometimes
        log.info("test");
        while(notVisited.size() > 0) {
            int currentNode = 0;  // Start at node 0
            List<Integer> route = new ArrayList<>();
            route.add(currentNode);
            notVisited.remove(currentNode);
            double routeCost = 0;

            Double costToHomeOnLastDropoff = 0.0;
            while (routeCostLessThanMax(routeCost)) {
                int current = route.get(route.size() - 1);
                Integer nearest = null;
                double minDist = Double.POSITIVE_INFINITY;

                for (int neighbor = 0; neighbor < numPoints; neighbor++) {
                    double timeToRoute = distMatrix.get(current, neighbor);
                    double onRoutesTime = distMatrix.get(neighbor, neighbor);
                    double distance = timeToRoute + onRoutesTime;
                    double timeToGetHome = distMatrix.get(neighbor, 0);

                    //the route cost is routecost + distance of getting to route and time to get home or
                    //we cannot do the route
                    double tempCost = routeCost + distance + timeToGetHome;

                    if(!visited(notVisited, neighbor) && routeCostLessThanMax(tempCost) && distance < minDist) {
                        //if (!visited[neighbor] && demands[neighbor] + currentCapacity <= capacity && distMatrix[current][neighbor] < minDist) {
                        nearest = neighbor;
                        minDist = distance;
                        costToHomeOnLastDropoff = timeToGetHome;
                    }
                }

                if (nearest == null) {
                    break;
                }

                routeCost += minDist;
                route.add(nearest);
                notVisited.remove(nearest);  // we found it so remove.
            }

            //They do not want home base included as you get an error "load 0 was included in at least two driver schedules"
            route.remove(0);
            solution.add(route, routeCost+costToHomeOnLastDropoff);
        }

        return solution;
    }

    //make this a method so the code using it is easier to read
    private boolean visited(Set<Integer> notVisited, int node) {
        if(notVisited.contains(node)) {
            //node is in not-visited list so return visited=false
            return false;
        }
        return true;
    }

    private boolean routeCostLessThanMax(double routeCost) {
        if(routeCost < 12*60)
            return true;
        return false;
    }

}
