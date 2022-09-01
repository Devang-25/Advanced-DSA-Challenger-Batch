Date : 1st September 2022 
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
- Prim and Kruskal - IMP - DONE
- LC - Find Centre of Graph - DONE

- Connected Components in A Graph - DFS - IMP - DONE
- Shortest Distance - Dijkstra, Bellman Ford, Floyd Warshall - IMP - WIP


Topological Sort - CP
Morris Traversal
Tries and AP - CP

"Please Type 'Hi' in the Chat Box if you have joined and Can See this Screen".













Ques: Connected Components in A Graph - DFS - IMP - TODO
(DFS in Disconnected Graph)

Connected Components:
Reachable Vertices Within a Sub-Graph



1-----0     3------4
|
|
|
2

V: 5
E: 3

OP: [[0,1,2],[3,4]]


Reachable Vertices Within Subgraph 1: [0 1 2]


Reachable Vertices Within Subgraph 2: [3 4]




Solution:

Approach:

(1) Mark all Vertices as Unvisited Initially

(2) From Each Vertex 'v':
- If 'v' is Unvisited - Mark Visited
- DFS from v


(3) Else, if 'v' is Already visited,
Ignore

(4) Finally Append all DFS OP from All Subgraphs in Answer





DRY RUN:



1-----0     3------4
|
|
|
2



Expected OP: [[0,1,2],[3,4]]

Initially, Unvisited:  0 1 2 3 4


DFS from 0: [0 1 2]

Visited: 0 1 2

Unvisited: 3 4

DFS from 3: [3 4]

Visited: 3 4

Final OP: [[0 1 2 ], [3 4]]


TC: O(V+E)* K - DFS
SC: O(V) - Recursion Stack



CODE: TODO

class Graph:

  def __init__(self, V):
    self.V = V
    self.adj = [[] for i in range(V)]

  def DFSUtil(self, temp, v, visited):
    visited[v] = True
    temp.append(v)

    for i in self.adj[v]:
      if visited[i] == False:
        temp = self.DFSUtil(temp, i, visited)
    return temp

  def addEdge(self, v, w):
    self.adj[v].append(w)
    self.adj[w].append(v)

  def connectedComponents(self, v):
    visited = [] # List - 1 D Array -  O(V)
    result = [] # List of Lists-2 D Array

    for i in range(self.V):
      visited.append(False) # All Unvisited vertices

    for v in range(self.V):
      if visited[v] == False:
        subgraph_result = [] # Connected Components for Subgraph -> [0,1,2], [3,4]
        result.append(self.DFSUtil(subgraph_result, v, visited))

    return result    

# DFS called k times for k subgraphs
# K = 2
    
#    0--2      3---5
#    |         |
#    1--6      4
    
if __name__ == "__main__":
  g = Graph(7)
  g.addEdge(1, 0)
  g.addEdge(1, 6)
  g.addEdge(0, 2)
  g.addEdge(3, 4)
  g.addEdge(3, 5)  
  cc = g.connectedComponents(0)
  print("Following are connected components")
  print(cc)


OP:

Following are connected components
[[0, 1, 6, 2], [3, 4, 5]]  
 
        














---> Shortest Distance Algorithms


(1) Single Source Shortest Path

(2) All Pairs Shortest Path





-----> Single Source Shortest Path


Single Source ---> Multiple Destinations

Shortest Path from Only 1 Source to Each Individual Destinations


Real Life Example:

Delhi -> Mumbai: 2 Hrs: Flight
Delhi -> Mumbai: 4 Hrs: Train
Delhi -> Bangalore: 3 Hrs: Flight
Delhi -> Bangalore: 6 Hrs: Train
Delhi -> Pune: 4 Hrs: Flight
Delhi -> Pune: 8 Hrs: Train



Delhi -> [Delhi(0), Mumbai(2), Bangalore(3), Pune(4)]




V: vertices
s: Starting Vertex

Ans = [d0, d1, d2, d3, d4....dv] - 1 D Array


1 D Array: 
Size- V


d0: Shortest Distance of 0 Vertex from Source

d1: Shortest Distance of 1 Vertex from Source

d2: Shortest Distance of 2 Vertex from Source

d3: Shortest Distance of 3 Vertex from Source

dv: Shortest Distance of v Vertex from Source


ds: Shortest Distance of Source Vertex from Source = 0



Algos:

- Dijkstra
- Bellman Ford








----> All Pairs Shortest Path

Multiple Source ---> Multiple Destinations

Shortest Path from EACH Source to Each Individual Destinations


V: Vertices
s[i]: All Vertices become Source Vertex


Ans = 

[

[d0, d1, d2, d3, d4....dv]

[d0, d1, d2, d3, d4....dv]

[d0, d1, d2, d3, d4....dv]

....V Times

]


2D Array - Array of Arrays

Matrix: V*V

Algo:
- Floyd Warshall






Shortest Distance:

- Weights (Distance, Cost, Time......)
- Edges (Minimum Sum of Edges to reach from src to dest)


Graph: V, E





