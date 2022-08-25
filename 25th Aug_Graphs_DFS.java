Date : 25th August 2022 
Batch: March Batch (Advanced DSA) - Challenger
Mentor: DEVANG SHARMA
Agenda : GRAPHS

GRAPHS:

Basic:(70%)

Theory - DONE
Applications - DONE

Adjacency Matrix - DONE
Adjacency List - DONE
BFS - IMPDONE

Indegree - DONE
Outdegree - DONE

Detect Cycle in a Graph - 
BFS in Disconnected Graphs - - DONE

Advanced: (30%)

TODO:

DFS - IMP
MST- Prim and Kruskal - IMP
Shortest Distance - Dijkstra, Bellman Ford, Floyd Warshall - IMP
Topological Sort - CP

Morris Traversal
Tries and AP - CP

"Please Type 'Hi' in the Chat Box if you have joined and Can See this Screen".










Indegree:
Number of Edges Closing at a vertex 


Outdegree:
Number of Edges Emerging from a vertex





 0 ------> 1  -------> 2

 |
 |
 |
\ /

 5 <------------------- 6


Indegree(0) = 0
Outdegree(0) = 2


Indegree(5) = 2
Outdegree(5) = 0







Q: BFS for Disconnected Graph


Normal Graph:


  0---1----2
  |   |
  |   |
  |   |
  |   |
  3---4



Starting Vertex: 0 
BFS:  0 1 3 2 4


Disconnected Graph:


  0---1                 2----5
  |   |
  |   |
  |   |
  |   |
  3   4

Starting Vertex: 0 
BFS OP: [0 1 3 4 2 5]




Solution:

Simple BFS  -- Will Not Give me Answer

Modified BFS:
Simple BFS from EACH Unvisited Vertex


BFS from 0:

OP: 0 1 3 4

BFS from 1: NO (Already Visited)
BFS from 3: NO (Already Visited)
BFS from 4: NO (Already Visited)

BFS from 2: YES (Unvisited Vertex)

OP: 2 5

BFS from 5: NO (Already Visited)


Final Output: [0 1 3 4 ].append([2 5]) = [0 1 3 4 2 5]


TC: O(V+E)
SC: O(V)




Leetcode Questions:


Q: [Amazon] [LC-997] Find the Town Judge
https://leetcode.com/problems/find-the-town-judge/


In a town, there are n people labeled from 1 to n. 
There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

- The town judge trusts nobody.
- Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2

Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 

Constraints:

1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n



Understanding:

trust[i] = [ai, bi]

a ---> b: Edge

- Directed and Unweighted Graph

Conditions:

- The town judge trusts nobody. (Outdegree of town judge = 0)

- Everybody (except for the town judge) trusts the town judge. (Indegree of town judge = n-1)


Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2



1 ---> 2
OP: 2: Town Judge



Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

1 --->  3 <---- 2

OP: 3: Town Judge



Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 

 1 <--->  3 <---- 2

OP: -1: No Town Judge




  public int findJudge(int n, int[][] trust) 
    {

    }
  



Approach:

trust[i] = [ai, bi]

a ---> b: Edge

- Directed and Unweighted Graph

Conditions:

- The town judge trusts nobody. (Outdegree of town judge = 0)

- Everybody (except for the town judge) trusts the town judge. (Indegree of town judge = n-1)


Or


Diff of indegree - outdegree = n-1-0 = n-1



CODE:

// TC - O(V+E)
// SC - O(V)

class Solution {
    public int findJudge(int n, int[][] trust) 
    {
        int[] trust_score = new int[n+1];
        
        // Calculare Indegree and Outdegree
        
        for (int[] edges: trust) // O(E)
        {
            trust_score[edges[0]]--; // Outdegree
            trust_score[edges[1]]++; // Indegree
        }
        
     //   Diff of indegree - outdegree = n-1-0 = n-1
       for (int i=1; i<=n; i++)  // O(V)
       {
           if (trust_score[i] == n-1)
               return i;
       }
        
        return -1;
    }
}





HW:

https://leetcode.com/problems/find-the-celebrity/









-----> DFS
(Depth First Search)


Before Completing All Adjacent Vertices, 
Move to Any Depth Vertex


Refer: Image

Start: 2
DFS OP: 2 0 1 3




Approach:

(1) Create a Recursive Utility (helper) Function that takes a node
and Visited array

(2) Mark the current vertex --> visited

(3) Traverse all the Depth Vertices and Unvisited Vertices by RECURRING on Depth


dfshelper(index, visited):



1 ------ 2 ------ 4
|
|
|
|
3


DFS Starting from 1: 
1 2 4 3



Code for DFS:

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
            # 0: [1 2]
            # graph[0] -> [1,2]

            for neighbour in self.graph[source]: # for all directly connected vertices from source
                if visited[neighbour] == False: # not already visited
                    queue.append(neighbour)
                    visited[neighbour] = True
                    

    def DFSUtil(self, vertex, visited):
        # Print the Current Vertex
        visited.add(vertex)
        print(vertex, end = " ")
        
        # DFS - Recur on Depth for Current Vertex
        for neighbour in self.graph[vertex]:
            if neighbour not in visited:
                self.DFSUtil(neighbour, visited)
                            
    def DFS(self, source):
        visited = set()
        self.DFSUtil(source, visited)
                    
        
g = Graph()
g.addEdge(0,1)
g.addEdge(0,2)
g.addEdge(1,2)
g.addEdge(2,0)
g.addEdge(2,3)
g.addEdge(3,3)
        
# print("BFS from 2: ")
# g.BFS(2)
        

print("DFS from 2: ")
g.DFS(2)

        
        
     
OP:

DFS from 2: 
2 0 1 3 



DFS Complexity:

TC - O(V+E)
SC - O(V): Recursion Stack        
        
        
        