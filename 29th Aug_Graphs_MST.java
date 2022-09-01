Date : 29th August 2022 
Batch: March Batch (Advanced DSA) - Challenger
Mentor: DEVANG SHARMA
Agenda : GRAPHS

GRAPHS:

Basic:(70%)

Theory - DONE
Applications - DONE

Adjacency Matrix - DONE
Adjacency List - DONE
BFS - IMP- DONE

Indegree - DONE
Outdegree - DONE
LC - Town Judge - DONE

Detect Cycle in a Graph - 
BFS in Disconnected Graphs - - DONE

Advanced: (30%)


DFS - IMP - DONE
Connected Components in A Graph - DFS - TODO


MST- 
- Theory: DONE
- Applications: DONE

TODO:
- Prim and Kruskal - IMP - WIP
- LC - Find Centre of Graph
- Connected Components in A Graph - DFS - TODO

Shortest Distance - Dijkstra, Bellman Ford, Floyd Warshall - IMP
Topological Sort - CP

Morris Traversal
Tries and AP - CP

"Please Type 'Hi' in the Chat Box if you have joined and Can See this Screen".













----> SPANNING TREES

Definition:
Any Subgraph that connects all the vertices in a graph



MST:
- Minimum Spanning Tree
- Special Kind of Spanning Tree


Minimum: Weight of Spanning Tree is Minimum
Weight of Spanning Tree: Sum of All Edges Weight


MST:
A Subgraph connecting all vertices with MINIMUM SUM of all Edges Weight is called MST




                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4      


Undirected and Weighted Graph

Vertex: 4 (0,1,2,3)
Edges: 5 (0-1, 0-2, 2-3, 1-3, 0-3)


Spanning Trees:

Any Subgraph that connects all the vertices in a graph

Weight of Spanning Tree: Sum of All Edges Weight


(A) 0-1-3-2: 10 + 15 + 4 = 29
(B) 0-2-3-1: 6 + 4 + 15 = 25
(C) 2-0-3-1: 6 + 5 + 15 = 26
(D) 1-3-2-0: 15 + 4 + 6 = 25 
...............


MST: Minimum Cost


2-3-0-1: 19 - MST 
1-0-3-2: 19 - MST


Q: Can Graph can have Multiple MST?

Ans: YES


(Eg: Make Every Edge Weight - SAME)
(Every Spanning Tree will become MST)


Property of Spanning Trees:

Vertices: V
Edges: V-1







------> Applications of MST

Campus Building:
- Admin
- CSE
- IT
- Mech


Task: Rope of infinite length, connect all buildings together with MINIMUM length of Rope

Graph:

Buildings: Vertex

Min Edge Sum Cost for Graph --> MST


(1) Travelling Salesman problem

Hackerrank:
https://www.hackerrank.com/challenges/tsp-grid/problem


NP Hard


Postman -> Visit All Houses to deliver Shipments with Minimum Travel


Graph -> Visit All Vertices with Minimum Edge Sum Weight -> MST



(2) Computer Network Design

Topologies: Various Ways to Connect Multiple Servers together

Eg: Bus, Mesh, Star, Hybrid etc


Task: Minimum Cable Length to Connect all Servers in a Network

Server Nodes: Vertices
Cable Length: Weight of Edges


Graph: Minimum Length of Cable required to connect all Server Nodes in a Network - MST


(3) Machine Learning: K-Clustering

MST, Delete the (K-1)th Node






-----> DP vs Greedy, Fundamental Difference:



DP:
- Find me ALL VALID Solutions 
- Then Select the Best One


GREEDY:
- Find me the BEST SOLUTION NOW
- Dont Care About Future




Eg:
Goldmine Probem

Task:

Given the gold coins in every cell in a matrix, 
Find the Maximum Number of Gold Coins that can be collected from S to D

Directions: Right or Down

Matrix:

[
S:1  10    20
100  1000  80
50   90    500: D
]

Correct Answer: 1 -> 100 -> 1000 -> 90 -> 500


DP Way:
- Find me ALL VALID Solutions 
- Then Select the Best One


Valid Solutions:

1 10 1000 90 500
1 100 1000 90 500: ANS - MAX
1 100 1000 80 500
............

DP Solution: 1 100 1000 90 500



Greedy Way:
- Find me the BEST SOLUTION NOW
- Dont Care About Future


Local Maxima = Global Maxima

If you are at 1, you can go to 10(Right) or 100(Down)

According to Greedy, "ALWAYS" go to 100 because MAX(10,100) = 100

"At the current state, Choose the BEST SOLUTION there, Dont think about Future"


Greedy Solution: 1 -> 100 (10/100) -> 1000 (50/1000) -> 90 (80/90) -> 500




Test Case - 1: Greedy Gives Correct OP

[
S:1  10    20
100  1000  80
50   90    500: D
]

Expected OP: 1 100 1000 90 500
DP Solution: 1 100 1000 90 500
Greedy Solution: 1 100 1000 90 500


Test Case - 2: 


[
S:1  10    2000
100  1000  80
50   90    500: D
]

Expected OP: 1 10 2000 80 500

DP Solution: 1 10 2000 80 500: CORRECT
Greedy Solution: 1 100 1000 90 500: INCORRECT


Greedy Solution: 1 -> 100 (10/100) -> 1000 (50/1000) -> 90 (80/90) -> 500






------> CODE

Algorithm to Determine MST

- Kruskal (GREEDY)
- Prim (GREEDY)






