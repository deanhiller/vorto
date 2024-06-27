package com.vorto.routing;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> routes = new ArrayList<>();

    //denormalizing a bit so don't have to iterate later AND for debugging as well
    private List<Double> routeCosts = new ArrayList<>();

    public void add(List<Integer> route, double routeCost) {
        routes.add(route);
        routeCosts.add(routeCost);
    }

    public List<List<Integer>> getRoutes() {
        return routes;
    }

    public List<Double> getRouteCosts() {
        return routeCosts;
    }
}
