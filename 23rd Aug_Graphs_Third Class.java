Date : 23rd August 2022 
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






Dictionary in Python = HashMap in Java = Map in C++



-----> Normal Dictionary:

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





----> Default Dictionary


-- Using a Function

from collections import defaultdict

def default_value():
    return "Not Present"

d = defaultdict(default_value)
d["a"] = 1
d["b"] = 2

print(d["a"])
print(d["b"])
print(d["c"]) # {c - "Not Present"}

OP:

1
2
Not Present


-- Using A List

from collections import defaultdict

d = defaultdict(list)
d["a"] = 1
d["b"] = 2

print(d["a"])
print(d["b"])
print(d["c"]) # {c - []}


OP:

1
2
[]



Note:

Why We need Default Dictionary?

- We need a Structure like:

vertex: [list of directly connected vertex]

Eg: 1 - [0 2 4]

- Map/HashMap/Dictionary

In Normal Dictionary, 
If a Key is NOT Present, it will lead to KeyError

Before My Traversal,
I dont know the Exact Vertices to Travel.

Initially, Need Structure like

0 - []
1 - []

Before:
vertex: []

After Traversal:
vertex: [list of directly connected vertex]


Later, I will fill the empty list values


Normal Dictionary cannot provide that, 
Hence we used defaultdict








Graph Code
- Adjacency List

Structure:
key -> [list values]


  0---1----2
  |   |
  |   |
  |   |
  |   |
  3---4


0 - [1 3]
1 - [0 2 4]
2 - [1]
3 - [0 4]
4 - [1 3]




Adjacency List CODE:

(1) Unweighted Graph:


(A) Undirected/Bi-Directional Graph:



from collections import defaultdict

graph = defaultdict(list)
# vertex : []

def addEdge(graph, src, dest):
    graph[src].append(dest) # src --> dest
    graph[dest].append(src) # dest --> src
    # Delete this line, it will become Directed Graph
    
#Structure: 
#    key -> [list]
#    graph[src] -> []
#    graph[src].append(dest) -> [___,dest]


# a---c---b--e
#    |
#    d

addEdge(graph, 'a', 'c')
addEdge(graph, 'b', 'c')
addEdge(graph, 'b', 'e')
addEdge(graph, 'c', 'd')

print(graph)



OP:

defaultdict(<class 'list'>, {'a': ['c'], 'c': ['a', 'b', 'd'], 'b': ['c', 'e'], 'e': ['b'], 'd': ['c']})




(B) Directed Graph:


from collections import defaultdict

graph = defaultdict(list)
# vertex : []

def addEdge(graph, src, dest):
    graph[src].append(dest) # src --> dest
    # graph[dest].append(src) # dest --> src
    # Delete this line, it will become Directed Graph
    
#Structure: 
#    key -> [list]
#    graph[src] -> []
#    graph[src].append(dest) -> [,dest]


# delhi -> bangalore -> hyderabad
#           \ | /
#            Pune
        
addEdge(graph, 'delhi', 'bangalore')
addEdge(graph, 'bangalore', 'hyderabad')
addEdge(graph, 'bangalore', 'Pune')

print(graph)



OP:


defaultdict(<class 'list'>, {'delhi': ['bangalore'], 'bangalore': ['hyderabad', 'Pune']})





(2) Weighted Graph:

(A) Undirected/Bi-directional Graph


import java.io.*;
import java.util.*;

class Graph
{
    int v;
    
            // Unweighted Graph
       // ArrayList<ArrayList<<Integer>> adj;
        // 1 - [0,2,4]
    
    // Weighted Graph
    ArrayList<ArrayList<HashMap<Integer, Integer>>> adj;
    // 1 - [(0:20), (2:40), (4: 60)]
    // Hashmap - key : directly connected vertex, value: weight
    
    // Structure:
    // vertex -> []: Empty List   
    Graph(int v)
    {
        this.v = v;
        this.adj = new ArrayList<>();
            
        for (int i=0; i<v; i++) // O(V)
            this.adj.add(new ArrayList<>());
    }

    void addEdge(int src, int dest, int weight)
    { 
        // Want: 1-> [(2,20)]
        this.adj.get(src).add(new HashMap<>()); // 1 -> [(key,value)]
        this.adj.get(src).get(this.adj.get(src).size()-1).put(dest, weight); // 1-> [(2,20)]
        // C++: adj[src].push({dest, weight})
        
        //1 -> [(0:20), (1:40)] // get(dest).size()-1 -> Append at End

        this.adj.get(dest).add(new HashMap<>()); // 1 -> [(key,value)]
        this.adj.get(dest).get(this.adj.get(dest).size()-1).put(src, weight); 
        // C++: adj[dest].push({src, weight})
    }
    
    
    // src -> [{dest1, weight1}, {dest2, weight2}, {dest3, weight3}..]
    void printGraph()
    {
        for (int i=0; i<this.v; i++)
        {   
            // For Each Vertex
            System.out.println("Vertex: " + i);
            
            // Travel All Directly Connected Vertices
            for (HashMap<Integer, Integer> mp: this.adj.get(i))
            {
                mp.entrySet().forEach( e -> System.out.println("Connected With: " + e.getKey() + " Weight: " + e.getValue()));
            }
            
        System.out.println(" ");

        }
    }
}

//      10   20   30   40
//    0----1----2----3----4


public class Main {
    public static void main(String[] args) 
    {
        int v = 5;
        Graph obj = new Graph(v);
        obj.addEdge(0,1,10);
        obj.addEdge(1,2,20);
        obj.addEdge(2,3,30);
        obj.addEdge(3,4,40);
        
        obj.printGraph();
    }
}



OP:


Vertex: 0
Connected With: 1 Weight: 10
 
Vertex: 1
Connected With: 0 Weight: 10
Connected With: 2 Weight: 20
 
Vertex: 2
Connected With: 1 Weight: 20
Connected With: 3 Weight: 30
 
Vertex: 3
Connected With: 2 Weight: 30
Connected With: 4 Weight: 40
 
Vertex: 4
Connected With: 3 Weight: 40








(B) Directed Graph

import java.io.*;
import java.util.*;

class Graph
{
    int v;
    
            // Unweighted Graph
       // ArrayList<ArrayList<<Integer>> adj;
        // 1 - [0,2,4]
    
    // Weighted Graph
    ArrayList<ArrayList<HashMap<Integer, Integer>>> adj;
    // 1 - [(0:20), (2:40), (4: 60)]
    
    // Structure:
    // vertex -> []: Empty List   
    Graph(int v)
    {
        this.v = v;
        this.adj = new ArrayList<>();
            
        for (int i=0; i<v; i++) // O(V)
            this.adj.add(new ArrayList<>());
    }

    void addEdge(int src, int dest, int weight)
    { 
        // Want: 1-> [(2,20)]
        this.adj.get(src).add(new HashMap<>()); // 1 -> [(key,value)]
        this.adj.get(src).get(this.adj.get(src).size()-1).put(dest, weight); // 1-> [(2,20)]
        // C++: adj[src].push({dest, weight})
        
        //1 -> [(0:20), (1:40)] // get(dest).size()-1

        // this.adj.get(dest).add(new HashMap<>()); // 1 -> [(key,value)]
        // this.adj.get(dest).get(this.adj.get(dest).size()-1).put(src, weight); 
        // C++: adj[dest].push({src, weight})
    }
    
    
    // src -> [{dest1, weight1}, {dest2, weight2}, {dest3, weight3}..]
    void printGraph()
    {
        for (int i=0; i<this.v; i++)
        {   
            // For Each Vertex
            System.out.println("Vertex: " + i);
            
            // Travel All Directly Connected Vertices
            for (HashMap<Integer, Integer> mp: this.adj.get(i))
            {
                mp.entrySet().forEach( e -> System.out.println("Connected With: " + e.getKey() + " Weight: " + e.getValue()));
            }
            
        System.out.println(" ");

        }
    }
}

//      10    20      30     40
//    0----> 1----> 2----> 3----> 4


public class Main {
    public static void main(String[] args) 
    {
        int v = 5;
        Graph obj = new Graph(v);
        obj.addEdge(0,1,10);
        obj.addEdge(1,2,20);
        obj.addEdge(2,3,30);
        obj.addEdge(3,4,40);
        
        obj.printGraph();
    }
}


OP:

Vertex: 0
Connected With: 1 Weight: 10
 
Vertex: 1
Connected With: 2 Weight: 20
 
Vertex: 2
Connected With: 3 Weight: 30
 
Vertex: 3
Connected With: 4 Weight: 40
 
Vertex: 4














