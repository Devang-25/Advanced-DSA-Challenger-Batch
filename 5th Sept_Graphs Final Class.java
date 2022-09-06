Date : 5th September 2022 
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
- Shortest Distance - Dijkstra, Bellman Ford, Floyd Warshall - IMP - DONE

https://leetcode.com/problems/find-if-path-exists-in-graph/

Topological Sort - CP
Morris Traversal
Tries and AP - CP

"Please Type 'Hi' in the Chat Box if you have joined and Can See this Screen".









-----> Single Source Shortest Path



(1) DIJKSTRA ALGO


- Example: DONE
- Underlying Algo: GREEDY 
- Constraints: NEGATIVE EDGES WONT WORK
- Code: DONE




   10       15
 0----> 1 -----> 2
 |              /|\
 | 5             |
 |               | 18
\|/              |
 3----------------





V: 4 (0,1,2,3)
E: 4



Source: 0

0: Min Cost = 0
1: Min Cost = 10
2: Min Cost = Min(25, 23) = 23
3: Min Cost = 5


OP: [0, 10, 23, 5]


const int INF = 1000000000000;

Source: 1

0: Min Cost = INF
1: Min Cost = 0
2: Min Cost = 15
3: Min Cost = INF


OP: [1000000000000, 0, 10, 1000000000000]


Change 18 to -18

OP from Source 0: [0, 10, INF, 5] - Dijkstra

OP from Source 0: [0, 10, 0, 5] - Bellman Ford


JAVA  Code:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraAlgoForShortestDistance {

  static class Node implements Comparable<Node> {
    int v;
    int distance;

    public Node(int v, int distance)
    {
      this.v = v;
      this.distance = distance;
    }

    @Override 
        public int compareTo(Node n)
    {
      if (this.distance <= n.distance) {
        return -1;
      }
      else {
        return 1;
      }
    }
  }

  static int[] dijkstra(
    int V,
    ArrayList<ArrayList<ArrayList<Integer> > > adj,
    int S)
  {
    boolean[] visited = new boolean[V];
    HashMap<Integer, Node> map = new HashMap<>();
    PriorityQueue<Node> q = new PriorityQueue<>();

    map.put(S, new Node(S, 0));
    q.add(new Node(S, 0));

    while (!q.isEmpty()) {
      Node n = q.poll();
      int v = n.v;
      int distance = n.distance;
      visited[v] = true;

      ArrayList<ArrayList<Integer> > adjList
        = adj.get(v);
      for (ArrayList<Integer> adjLink : adjList) {

        if (visited[adjLink.get(0)] == false) {
          if (!map.containsKey(adjLink.get(0))) {
            map.put(
              adjLink.get(0),
              new Node(v,
                  distance
                    + adjLink.get(1)));
          }
          else {
            Node sn = map.get(adjLink.get(0));
            if (distance + adjLink.get(1)
              < sn.distance) {
              sn.v = v;
              sn.distance
                = distance + adjLink.get(1);
            }
          }
          q.add(new Node(adjLink.get(0),
                distance
                  + adjLink.get(1)));
        }
      }
    }

    int[] result = new int[V];
    for (int i = 0; i < V; i++) {
      result[i] = map.get(i).distance;
    }

    return result;
  }

  public static void main(String[] args)
  {
    ArrayList<ArrayList<ArrayList<Integer> > > adj
      = new ArrayList<>();
    HashMap<Integer, ArrayList<ArrayList<Integer> > >
      map = new HashMap<>();

    int V = 6;
    int E = 5;
    int[] u = { 0, 0, 1, 2, 4 };
    int[] v = { 3, 5, 4, 5, 5 };
    int[] w = { 9, 4, 4, 10, 3 };

    for (int i = 0; i < E; i++) {
      ArrayList<Integer> edge = new ArrayList<>();
      edge.add(v[i]);
      edge.add(w[i]);

      ArrayList<ArrayList<Integer> > adjList;
      if (!map.containsKey(u[i])) {
        adjList = new ArrayList<>();
      }
      else {
        adjList = map.get(u[i]);
      }
      adjList.add(edge);
      map.put(u[i], adjList);

      ArrayList<Integer> edge2 = new ArrayList<>();
      edge2.add(u[i]);
      edge2.add(w[i]);

      ArrayList<ArrayList<Integer> > adjList2;
      if (!map.containsKey(v[i])) {
        adjList2 = new ArrayList<>();
      }
      else {
        adjList2 = map.get(v[i]);
      }
      adjList2.add(edge2);
      map.put(v[i], adjList2);
    }

    for (int i = 0; i < V; i++) {
      if (map.containsKey(i)) {
        adj.add(map.get(i));
      }
      else {
        adj.add(null);
      }
    }
    int S = 1;

    int[] result
      = DijkstraAlgoForShortestDistance.dijkstra(
        V, adj, S);
    System.out.println(Arrays.toString(result));
  }
}










(2) BELLMAN FORD ALGO

- Optimisation Over Dijkstra
- Handles Negative Weight Values
- Underlying Algo: GREEDY


Change 18 to -18

OP from Source 0: [0, 10, INF, 5] - Dijkstra

OP from Source 0: [0, 10, 0, 5] - Bellman Ford






src           dest
Delhi ---   Bangalore



Delhi -> Bangalore: 10 Hrs
Delhi -> Mumbai : 3 Hrs
Mumbai -> Bangalore: 5 Hrs

Mumbai: INTERMEDIATE VERTEX



ans[u] + weight < ans[v]

ans[v]: u->v
ans[u]: u->p
weight: p->v




Complete Code:


#include <bits/stdc++.h>
using namespace std;

// STL- Weighted Graph
vector<int> dijkstra(int n, int source, vector<pair<int, int>> G[])
{
int INF = (1e9); // 100000000
vector<int> ans(n,INF); // Shortest distance to all vertices from source
ans[source] = 0;  // src-src = 0
set<pair<int,int>> Q; // First: Distance to that vertex, Second: Vertex
Q.insert({0,source});

while (!Q.empty())
{
auto top = Q.begin();
int u = top->second;  // u: Intermediate Vertex
Q.erase(top);

for (auto next:G[u]) // For All the Intermediate Vertex
{
int v = next.first, weight = next.second;
if (ans[u] + weight < ans[v]) // ans[u] = src-u, ans[v] = src-v, weight = u-v
{
  if (Q.find({ans[v],v})!= Q.end())
    Q.erase(Q.find({ans[v],v}));

  ans[v] = ans[u] + weight;
  Q.insert({ans[v], v});
}

}
}

return ans;
}


// T : O(VE)
// S: O(V)
vector<int> bellmanford(int n, int source, vector<pair<int, int>> G[])
{
int INF = (1e9); // 100000000
vector<int> D(n,INF); // Shortest distance to all vertices from source

D[source] = 0; // src-src = 0

int i=0,u=0;

for (i=0; i<n-1; i++)
{
for (u=0; u<n; u++) // u: Intermediate Vertex
{

for (auto edge: G[u])
{

int v = edge.first;
int w = edge.second;

if (D[u]!=INF)
  D[v] = min(D[v], D[u] + w);

}

}
}



for (u=0; u<n ;u++)
{

for (auto edge: G[u])
{
int v =edge.first;
int w = edge.second;

if (D[u]!=INF and D[v]>D[u] + w) // Negative Cycle
{
  assert(0);
}

}
}

return D;

}

int main() 
{
int n, e, s, u, v, w;
cin>>n>>e>>s;
int i;
vector<pair<int, int>> *G=new vector<pair<int, int>>[n]; // Adjacency List
vector<int> ans,ans2;
for (i=0; i<e; i++)
{
cin>>u>>v>>w;
G[u].push_back(make_pair(v,w)); // u -> v: w
G[v].push_back(make_pair(u,w)); // v -> u: w
}

ans= dijkstra(n,s,G);
cout<<"Using Dijkstra Algo: "<<endl;
cout<<"\n";
for (i=0; i<n; i++)
cout<<"Shortest Distance from "<<s<<" to "<<i<<" is "<<ans[i]<<endl;
cout<<endl;

ans2= bellmanford(n,s,G);
cout<<"Using Bellman Fold Algo: "<<endl;
cout<<"\n";    
for (i=0; i<n; i++)
cout<<"Shortest Distance from "<<s<<" to "<<i<<" is "<<ans2[i]<<endl;
cout<<endl;

}



IP:

9 14 0
0 1 4
0 7 8
1 2 8
1 7 11
7 8 7
7 6 1
8 6 6
2 8 2
6 5 2
2 3 7
2 5 4
3 5 14
3 4 9
4 5 10



OP:



Using Dijkstra Algo: 

Shortest Distance from 0 to 0 is 0
Shortest Distance from 0 to 1 is 4
Shortest Distance from 0 to 2 is 12
Shortest Distance from 0 to 3 is 19
Shortest Distance from 0 to 4 is 21
Shortest Distance from 0 to 5 is 11
Shortest Distance from 0 to 6 is 9
Shortest Distance from 0 to 7 is 8
Shortest Distance from 0 to 8 is 14

Using Bellman Fold Algo: 

Shortest Distance from 0 to 0 is 0
Shortest Distance from 0 to 1 is 4
Shortest Distance from 0 to 2 is 12
Shortest Distance from 0 to 3 is 19
Shortest Distance from 0 to 4 is 21
Shortest Distance from 0 to 5 is 11
Shortest Distance from 0 to 6 is 9
Shortest Distance from 0 to 7 is 8
Shortest Distance from 0 to 8 is 14









-----> All Pairs Shortest Path


(3) Floyd Warshall

Underlying Algo: DP


CODE:

#include <bits/stdc++.h>
#define INF 1000000000
using namespace std;

int main(){
    int m,s,x,y,z,n;
    cin>>n>>m>>s; //Input the number of nodes(0 based), number of edges and the source vertex.
    int G[n][n];
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            if(i==j)
                G[i][j]=0; // source - source = 0
            else
                G[i][j]=INF;
        }

    for(int i=0;i<m;i++){
        cin>>x>>y>>z; //Input the starting vertex of the edge, the ending vertex and the cost of the edge.
        G[x][y]=z;
    }
    
    //Code for Floyd Warshall which computes all pair shortest path.
    for(int k=0; k<n; k++)  // k: Intermediate Vertex
    {
        for(int i=0; i<n; i++)  
        {
          for(int j=0; j<n; j++)  
          {
            G[i][j] = min(G[i][j], G[i][k] + G[k][j]);
          }
        }
    }
    
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
            cout<<G[i][j]<<" ";
        cout<<endl;
    }
    return 0;
}



IP:

9 14 0
0 1 4
0 7 8
1 2 8
1 7 11
7 8 7
7 6 1
8 6 6
2 8 2
6 5 2
2 3 7
2 5 4
3 5 14
3 4 9
4 5 10


OP:

0 4 12 19 28 11 9 8 14 
1000000000 0 8 15 24 12 12 11 10 
1000000000 1000000000 0 7 16 4 8 1000000000 2 
1000000000 1000000000 1000000000 0 9 14 1000000000 1000000000 1000000000 
1000000000 1000000000 1000000000 1000000000 0 10 1000000000 1000000000 1000000000 
1000000000 1000000000 1000000000 1000000000 1000000000 0 1000000000 1000000000 1000000000 
1000000000 1000000000 1000000000 1000000000 1000000000 2 0 1000000000 1000000000 
1000000000 1000000000 1000000000 1000000000 1000000000 3 1 0 7 
1000000000 1000000000 1000000000 1000000000 1000000000 8 6 1000000000 0 






Complexities:

Dijkstra: O(ElogV)
Bellman Ford: O(E*V)
Floyd Warshall: O(V^3) - DP



