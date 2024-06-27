# vorto

Rather than be stuck in analysis paralysis, I am launching with a KISS based somewhat on the code found here https://medium.com/@writingforara/solving-vehicle-routing-problems-with-python-heuristics-algorithm-2cc57fe7079c

HOWEVER with modifications accounting for differences due to time limits and pickup/dropoff all noted with comments in the code

I am starting with nearest neighbor and depending on time can use the further optimization of two_opt.

this code is all single threaded and I wonder if there are locactions that could be multi-threaded or multi-server to yield quicker outputs 

I have to balance this interview with 2 other take homes and other things on my plate so I am debating here how much effort to put in.  ie. risk vs. reward here.  Not sure the reward is big enough to go through this process at this point in time (just thinking out loud and being honest) though the problem is super fun.   I am just a bit busy and did not realize it was going to be this intense.

explored links
https://logvrp.com/logvrpsite/en/vrp.types.algorithms.html
https://www.mdpi.com/2076-3417/11/21/10295
https://www.routific.com/blog/what-is-the-vehicle-routing-problem
shucks, normally would just buy it -> https://link.springer.com/chapter/10.1007/978-3-319-24584-3_108

LOL, would love to cheat and call the route optimization api though the assingment did not specifically say that was not allowed.... lol.   I am guessing you would not want that solution but work smart, not hard ;) ... joking.

https://www.sciencedirect.com/science/article/pii/S2192440620300034
https://www.sciencedirect.com/science/article/abs/pii/S0305054803001588
https://towardsdatascience.com/the-vehicle-routing-problem-exact-and-heuristic-solutions-c411c0f4d73
https://medium.com/@writingforara/solving-vehicle-routing-problems-with-python-heuristics-algorithm-2cc57fe7079c4

Nearest Neighbor Algorithm vs. Two-Opt Algorithm - hmmmmm, thinking KISS get this done vs. better and I may lean towards KISS for now

I wonder, go KISS but run it massively parallel.  I will use threads but in real-world, I split to multiple servers.
