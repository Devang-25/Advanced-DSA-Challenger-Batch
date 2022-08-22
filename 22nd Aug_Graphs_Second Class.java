Date : 22nd August 2022 
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







------> HOW (Coding/Implementation)

Representation:
(1) Adjacency Matrix 
(2) Adjacency List 



Case 1: Adjacency Matrix


V*V = V^2 Matrix

Rows = V
Columns = V


(A) Unweighted Graph:

If Direct Path (Direct Edge) Exist from a to b, value = 1
Else, value = 0

Undirected Graph: Symmetric  (a----b)
Bi-Directed Graph: Symmetric (a <----> b)
Uni-Directed Graph: Non Symmetric (a ----> b)


(B) Weighted Graph:

If Direct Path (Direct Edge) Exist from a to b, 
And All Weights are Positive

value = weight
Else, value = -1


If Direct Path (Direct Edge) Exist from a to b, 
And Weights can be Negative

value = weight
Else, value = -INF (-10^9: int)




-> Unweighted Graph

  0---1----2
  |   |
  |   |
  |   |
  |   |
  3---4


V = 5
Matrix = VxV = 5x5 


D  0   1   2   3   4

S

0  0   1   0   1   0

1  1   0   1   0   1

2  0   1   0   0   0
 
3  1   0   0   0   1

4  0   1   0   1   0


adj_matrix[i][i] = 0
- No Self Edge

Adjacency Matrix - Undirected Graph/ Bi-Directional Graph

- ALWAYS Symmetrical across Primary Diagonal

a --- b
b --- a

0   1   0   1   0

1   0   1   0   1

0   1   0   0   0
 
1   0   0   0   1

0   1   0   1   0


TC: O(V^2)
SC: O(V^2)













-> Weighted Graph



    20   0
  0---1----2
  |   |
  |   | 15
8 |   |
  |   |
  3---4
    7



V = 5
Matrix = VxV = 5x5 


D  0   1   2   3   4

S

0  0   20  0   8   0

1          0

2  
 
3  

4 


TC: O(V^2)
SC: O(V^2)




Case 2: Adjacency List


Array of Lists:
Size of Array = Number of Vertices

Adjacency List Denotes the List of Vertices a particular Vertex is DIRECTLY Connected with.


---> Un-Weighted Graph:

  0---1----2
  |   |
  |   |
  |   |
  |   |
  3---4




Adjacency List Representation:

0 - [1 3]
1 - [0 2 4]
2 - [1]
3 - [0 4]
4 - [1 3]




---> Weighted Graph


    20   10
  0---1----2
  |   |
  |   | 15
8 |   |
  |   |
  3---4
    7




Adjacency List Representation: Pair of Values: (vertex, weight)

0 - [(1,20), (3,8)] 
1 - [(0,20) (2,10) (4,15)]
2 - 
3 - 
4 - 



Complexity: O(V)



Pros: O(V^2)  -->    O(V)
      Adj Matrix     Adj List




Cons:

Case where Adjacency Matrix performs BETTER THAN Adjacency List


Ques: Check if Direct Path Exist between source and destination

(Assuming Adj Matrix and List is ALREADY Created,
Dont Count the Time for Population of Adj Matrix and Adj List)


  0---1----2
  |   |
  |   |
  |   |
  |   |
  3---4




source: 1
destination: 4

OP: true



source: 1
destination: 3

OP: false



Adj Matrix: O(_) 
Adj List: O(_)



Solutions:

(1) Adjacency Matrix

if (adj_matrix[source][destination] == 1)
  return true;
else
  return false;


TC: O(1)


(2) Adjacency List

0 - [1 3]
1 - [0 2 4]
2 - [1]
3 - [0 4]
4 - [1 3]



source: 1
destination: 4

OP: true

1 - [0 2 4]


To Check if 1 --> 3 or 1 --> 4 path exist or not
Need to Go Through All Directly Connected Vertices of 1

[0 2 4]: Search for 3 and 4


TC: O(1) : Best Case
    O(V) : Worst Case








----> CODE:

--- Adjacency List

Py:
(1) Use a Module
(2) Custom Class


Java:
(1) Use Collection Framework
(2) Custom Class


C++:
(1) Use STL
(2) Custom Class




Dictionary in Python = HashMap in Java = Map in C++



Normal Dictionary:

d = dict() # Map
d["a"] = 1 #Key - Value Pair
d["b"] = 2

print(d) # [a-1, b-2]
print(d["a"]) # .get() or .getValue()
print(d["b"])
print(d["c"]) # Key does not exist in HashMap


OP:

{'a': 1, 'b': 2}
1
2

KeyError: 'c'
    print(d["c"]) # Key does not exist in HashMap
Line 8 in <module> (Solution.py)





Default Dictionary

