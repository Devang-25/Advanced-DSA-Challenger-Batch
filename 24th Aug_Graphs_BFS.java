Date : 24th August 2022 
Batch: March Batch (Advanced DSA) - Challenger
Mentor: DEVANG SHARMA
Agenda : GRAPHS

GRAPHS:

Basic:(70%)

Theory - DONE
Applications - DONE

Adjacency Matrix - 
Adjacency List - 
BFS - IMP

TODO:

Detect Cycle in a Graph - 
BFS in Disconnected Graphs - 

Advanced: (30%)

DFS - IMP
MST- Prim and Kruskal - IMP
Shortest Distance - Dijkstra, Bellman Ford, Floyd Warshall - IMP
Topological Sort - CP

Morris Traversal
Tries and AP - CP

"Please Type 'Hi' in the Chat Box if you have joined and Can See this Screen".








---------> TRAVERSALS:


Hierarchical DS:
More than 1 Logical Way of Traversal


BFS: Breadth First Search
DFS: Depth First Search

BFS: Breadth First Search -> Go to Breadth (Adjacent Value)
DFS: Depth First Search -> Go to Depth (Directly Connected Vertex)


Explanation Using Trees:


            1
         2     3
       4  5   6  7   



You are at 2:

3: Breadth (Adjacent)
4: Depth

Select 3: BFS 
Select 4: DFS 


BFS/LOT:

1
2 3
4 5 6 7



Explanation Using Graphs:



You Cover All the DIRECTLY CONNECTED VERTICES (Adjacent Vertices)
You DONT Go to Any Other Vertex -- BFS   

DFS: Depth Vertex is Travelled Before Completing All Adjacent Vertices

  0---1----2
  |   |
  |   |
  |   |
  |   |
  3---4




You are at 0:
Directly Connected Vertex : 1, 3 (Adjacent Vertices)


0 1 3 2 4 or 0 3 1 4 2 : BFS (Visited ALL Directly Connected Vertices Before)

0 1 2 3 4 or 0 1 2 4 3 : DFS (NOT Visited ALL Directly Connected Vertices and Moved to Depth)


Note:


BFS/DFS in Graph == BFS/DFS in Trees

Difference:

Graph May Contain Cycle,
So To Avoid Visiting Same Vertex Again and Again,
We Keep Track of Visited Vertex Using Boolean Array.






Refer: Image

Starting Vertex: 2
Directly Connected Vertices for 2: [0, 3]


BFS: 2 0 3 1 OR 2 3 0 1

DFS: 2 0 1 3



Pseudo Code:

(1) Keep Track of Visited Vertex, To Avoid Visiting Again the Already Visited Vertex
(2) Go to Vertex 
  -> Mark It Visited
  -> Travel All DIRECTLY CONNECTED VERTEX from that (BFS)
  -> Mark All them as Visited
(3) Continue this until All Vertex are visited



CODE:


from collections import defaultdict

class Graph:
    
    def __init__(self):
        self.graph = defaultdict(list)
    
    def addEdge(self, src, dest):
        self.graph[src].append(dest)
        
    def BFS(self, source):
        # Boolean Array to Check If Already Visited Vertex
        # Graph May Contain Cycle
        visited = [False] * (max(self.graph) + 1)
        queue = []
        queue.append(source)
        visited[source] = True
        
        while queue: # Till All vertices are traversed
            source = queue.pop(0)
            print(source, end = " ") # print source
//                    0: [1 2]
 //                   graph[0] -> [1,2]

            for neighbour in self.graph[source]: # for all directly connected vertices from source
                if visited[neighbour] == False: # not already visited
                    queue.append(neighbour)
                    visited[neighbour] = True
        
        

g = Graph()
g.addEdge(0,1)
g.addEdge(0,2)
g.addEdge(1,2)
g.addEdge(2,0)
g.addEdge(2,3)
g.addEdge(3,3)
        
print("BFS from 0: ")
g.BFS(0)
        

        
        
OP:

BFS from 2: 
2 0 3 1 

BFS from 1: 
1 2 0 3 


BFS from 0: 
0 1 2 3 


TC: O(V) + O(E) = O(V+E)
SC: O(V) - Storing Vertex in Queues



     