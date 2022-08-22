Date : 18th August 2022 
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








GRAPHS:

1-10: 
Average: 2-3


Target: 9-10







----> GRAPHS:


Master any DS/Algo:

- What (Use Case) - DONE
- Why (Applications/Need)
- How (Coding/Implementation)


What?


Graph: 
"Finite" Set of "Vertices" and Set of "Edges" which connects a Pair of Vertices


Vertices: Nodes in a Graph
Edges: Connections that connects the Vertices

  0---1----2
  |   |
  |   |
  |   |
  |   |
  3---4


Vertices =  Nodes = V = {0,1,2,3,4}
Edges = E = {0-1, 1-2, 0-3, 3-4, 1-4}


Types:

(1) Weight or Not

 - Weighted: Cost is Associated with "Each and Every Edge"


    20   45
  0---1----2
  |   |
  |   | 15
8 |   |
  |   |
  3---4
    7


 - Un-Weighted: No Cost is Associated with Any Edge


  0---1----2
  |   |
  |   |
  |   |
  |   |
  3---4



(2) Direction or Not

- Directed Graph: One Way
- Un-Directed Graph: Two Way


0 -----> 1 : Can Go from 0 to 1, but not from 1 to 0
Directed (Uni-Directional)


0 ----- 1  : Undirected

OR  

0 <-----> 1 : Directed (Bi-Directional)

Travel Both Ways

u <---> v: w


u.Graph[v] = w // Uni-Directional
v.Graph[u] = w // Bi-Directional






--- WHY ?
(Applications)




    20   45
  0---1----2
  |   |
  |   | 15
8 |   |
  |   |
  3---4
    7




(1) Navigation Services:

GPS: Google Maps

Source: 0 (Delhi)
Destination: 4 (Bangalore)


0-1-4 (Delhi- Mumbai - Bangalore)
0-3-4 (Delhi - Hyderabad - Bangalore)

Cost:

0-1-4 = (Delhi- Mumbai - Bangalore) = 20 + 15 = 35

0-3-4 = (Delhi - Hyderabad - Bangalore) = 8 + 7 = 15

Ans = Min (0-1-4, 0-3-4) = 15



(2) Networks and Circuits

- Topology in Computer Networks


Vertex/Nodes: Server
Edges: Cables


Eg: 
10 Servers, Star Topology, Min Cable Length


Graph Problem: 
Return the Minimum Edge Sum Weight 



(3) Social Media:
Instagram/Facebook/Snapchat/Twitter


Instagram/Facebook:

A --- B --- C: Facebook

A: Person/Page: Node/Vertex

------: Follow/ Friends

Suggested Friends:

A will visit profile of C:
Mutual Friends with B

Use of Graphs:

(1) Direction

A ---> B <--- C: Instagram

A follows B, B does not follow back A

C follows B, B does not follow back C

- Uni- directional



A --- B --- C: Facebook/Linkedin

A is connected to B = B is connected to A

- Bi-directional


(2) Weight (Personalisation)
- Core of Recommended Systems


  100      10
A <---> B <---> C: Instagram


Score of A and B: 100
Score of B and C: 10


If New Post from A and C is shown,
B is MORE LIKELY to Engage with A Post

Profile News Feed/Home Page Feed Generation:

A Post ---> Top


Instagram:
- Feed : My favorites
       : Default


(3) Suggested Friends









------> HOW (Coding/Implementation)

Representation:
(1) Adjacency Matrix 
(2) Adjacency List 

