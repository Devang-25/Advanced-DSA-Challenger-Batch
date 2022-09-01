Date : 31st August 2022 
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
Detect Cycle in a Graph - 
BFS in Disconnected Graphs - - DONE

Advanced: (30%)

DFS - IMP - DONE
Connected Components in A Graph - DFS 
MST- 
- Theory: DONE
- Applications: DONE

TODO:
- Prim and Kruskal - IMP - DONE
- LC - Find Centre of Graph - DONE
- Connected Components in A Graph - DFS - IMP - TODO

Shortest Distance - Dijkstra, Bellman Ford, Floyd Warshall - IMP
Topological Sort - CP
Morris Traversal
Tries and AP - CP

"Please Type 'Hi' in the Chat Box if you have joined and Can See this Screen".





        
------> CODE

Algorithm to Determine MST

- Kruskal (GREEDY)
- Prim (GREEDY)






Kruskal Algo: (GREEDY)

(1) Sort all the edges as per weight // O(E*logE)
(2) Pick the smallest Edge Weight // GREEDY
(3) Check if Cycle is performed 
If Cycle Made: Ignore that Edge (Dont Include in your MST)

Else:
Include Edge in MST
(4) Repeat Step-2,3 Until V-1 Edges // O(V-1)
(Any Spanning Tree has V-1 Edges)


TC: O(E*logE) + O(V)
SC: O(V)


DRY RUN:


MST: Minimum Cost


2-3-0-1: 19 - MST 
1-0-3-2: 19 - MST


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

0-1: 10
0-2: 6
0-3: 5
1-3: 15
2-3: 4


After Sorting:

[4 5 6 10 15]

Total Number of Edges in a Spanning Tree = V-1 = 4-1 = 3



val = 4       Edge = 2-3       No of Edges: 1      W: 4         Cycle: NO

val = 5       Edge = 3-0       No of Edges: 2      W: 4+5       Cycle: NO

val = 6       Edge = 0-2       No of Edges: 3        W: 4+5+6   Cycle: YES - NOT INCLUDE IN MST

val = 10      Edge = 0-1      No of Edges: 3      W: 4+5+10    Cycle: NO - Included


No of Edges = 3 = V-1 : STOP
MST: 2-3-0-1

Minimum Cost = W = 4+5+10 = 19


TC: O(E*logE) + O(V)
SC: O(V)
















Q: [Adobe][LC - 1791] Find Center of Star Graph
https://leetcode.com/problems/find-center-of-star-graph/


There is an undirected star graph consisting of n nodes labeled from 1 to n. 
A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. 
Return the center of the given star graph.

 

Example 1:

Input: edges = [[1,2],[2,3],[4,2]]
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.

Example 2:

Input: edges = [[1,2],[5,1],[1,3],[1,4]]
Output: 1
 

Constraints:

3 <= n <= 105
edges.length == n - 1
edges[i].length == 2
1 <= ui, vi <= n
ui != vi
The given edges represent a valid star graph.






 public int findCenter(int[][] edges) 
    {
   

   }





Solution:


A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
---> Star Vertex: Connected to N-1 Edges

The given edges represent a valid star graph.
---> Answer Will ALWAYS Exist



Star Vertex: A Vertex Connected to Every Other Vertex
The Star Vertex will be PRESENT in ALL [u,v] for Edges[]

Solution:
Common Vertex for All Edges: Ans


To Find the Common Vertex for All Edges, NO NEED to traverse All Edges.
--> Just Check in First Two Edges


Why First 2 Only?

3 <= n <= 105
edges.length == n - 1

edges.length Min Value = n-1 = 3-1 = 2


Compare in:

edges[0][0] == edges[1][0]
      OR
edges[0][1] == edges[1][1]

Ans = Either edges[0][0] or edges[1][1]




CODE:



// TC - O(1), SC - O(1)

class Solution 
{
    public int findCenter(int[][] edges) 
    {
        int startVertex = -1;
        
    if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            startVertex = edges[0][0];
    else
            startVertex = edges[0][1];
        
        return startVertex;
    }
}







Ques: Connected Components in A Graph - DFS - IMP - TODO


Connected Components:
Reachable Vertices Within a Sub-Graph



1-----0     3------4
|
|
|
2



OP: [[0,1,2],[3,4]]


Reachable Vertices Within Subgraph 1: [0 1 2]


Reachable Vertices Within Subgraph 2: [3 4]





