Date : 6th August 2022
Mentor: DEVANG SHARMA
Batch: March Batch (Advanced DSA) - Challenger

Agenda:

- User Input in Trees and Graphs

"Please Type 'Hi' in the Chat Box if you have joined and Can See this Screen".


25-30 Mins



(1) User Input in Trees


Case -1:        

         1
      2    3  
     4 5  6 NULL


arr = [1 2 3 4 5 6]
OR
arr = [1 2 3 4 5 6 -1]


Case -2:        

            1
        2      3  
     4    5   6  6
   6  6  6 


arr = [1 2 3 4 5 6 6 6 6 6]



Task:

How to Populate/Generate a Binary Tree from Array as Input



         1
      2    3  
     4 5  6 NULL


arr = [1 2 3 4 5 6]


Parent: arr[i]
Left Child: arr[2*i+1]
Right Child: arr[2*i+2]



i = 0
Parent: arr[i]= arr[0] = 1: ROOT
Left Child: arr[2*i+1]: arr[1] = 2: Left Child
Right Child: arr[2*i+2]: arr[2] = 3: Right Child


i = 1
Parent: arr[i]= arr[1] = 2: PARENT
Left Child: arr[2*i+1]: arr[3] = 4: Left Child
Right Child: arr[2*i+2]: arr[4] = 5: Right Child



i = 2
Parent: arr[i]= arr[2] = 3: PARENT
Left Child: arr[2*i+1]: arr[5] = 6: Left Child
Right Child: arr[2*i+2]: arr[6] - No Element



CODE:



/*

Parent: arr[i]
Left Child: arr[2*i+1]
Right Child: arr[2*i+2]

*/

public Node insertLevelOrder(int[] arr, int i)
{
  Node root = null;

  if (i < arr.length)
  {
    // Parent
    root = new Node(arr[i]);

    // Left Child
    root.left = insertLevelOrder(arr, 2*i+1);

    // Right Child
    root.right = insertLevelOrder(arr, 2*i+2);

  }

  return root;
}


public inOrderTraversal(Node root)
{

}



public static void main(String[] args)
{
  int arr[] = {1,2,3,4,5,6};
  t.root = t.insertLevelOrder(arr,0);
  inOrderTraversal(t.root);
}















(2) User Input in Graphs

- Adjacency Matrix
- Adjacency Lists





- Adj List Input

https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

// Author: @devangs

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args) {
        int q = in.nextInt();
        while(q-->0){
            int n, m;
            
            // Input Part Starts
            n = in.nextInt();
            m = in.nextInt();
            
            // Adjacency List
            // Vertex: [List of Directly Connected Vertices]
            // 0: [1,2,3]
            // 1: [0,2,4]
            
            HashMap<Integer, HashSet<Integer>> g = new HashMap<>(n);
            for(int i=0; i<n; i++){
                g.put(i,  new HashSet<Integer>());
            }
            for(int i=0; i<m; i++){
                int p = in.nextInt()-1; // 0 Based Index
                int r = in.nextInt()-1; // 0 Based Index
                g.get(p).add(r);
                g.get(r).add(p);
                
            }
            
            // Input Part Ends
            
            int s = in.nextInt()-1;
            Queue<Integer> queue = new LinkedList<>();
            long[] dist = new long[n];
            Arrays.fill(dist, -1);
            dist[s]=0;
            queue.add(s);
            boolean[] mark = new boolean[n];
            mark[s]=true;
            
            while(!queue.isEmpty()){
                int u = queue.poll();
                
                for(int v: g.get(u)){
                    if (!mark[v]){
                        mark[v]=true;
                        queue.add(v);
                        dist[v]=dist[u]+1;
                    }
                }
            }
            
            for(int i=0; i<n; i++){
                if (i==s) continue;
                System.out.print((mark[i]?6*dist[i]:-1)+" ");
            }
            System.out.println();
            
        }
    }
    
    static Scanner in = new Scanner(System.in);

}





- Adj Matrix
https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean shouldVisit(boolean[][] visited,int row,int col,int ROW,int COL){
       // System.out.println("in if should visit with operands" + Integer.toString(row)+' '+Integer.toString(col)+' '+Integer.toString(ROW)+' '+Integer.toString(COL));

        if((row>=0)&&(col>=0)&&(row<ROW)&&(col<COL)){
           // System.out.println("in if should visit returning"+Boolean.toString(!visited[row][col]));
            return (!visited[row][col]);
        }else{
           // System.out.println("in should visit returning"+Boolean.toString(false));
            return false;
        }
    }
    public static int countConnected(int[][] matrix,boolean[][] visited,int row,int col,int ROW,int COL){
        //System.out.println("in count connected with the following operands" + Integer.toString(row)+Integer.toString(col));
        int count= 1;
        if(visited[row][col]|| matrix[row][col]==0){
            //System.out.println("in if count connected returning 0");
            return 0;
        }
        else{
            visited[row][col]=true;
            int rows[]={-1,-1,-1,0,0,1,1,1};
            int cols[]={-1,0,1,-1,1,-1,0,1};
            for(int z=0;z<8;z++){
                 //System.out.println("in for loop");
                if(shouldVisit(visited,row+rows[z],col+cols[z],ROW,COL)){
                    //System.out.println("in if with the following operands" + Integer.toString(row+rows[z])+Integer.toString(col+cols[z]));
                    
                    count+=countConnected(matrix,visited,row+rows[z],col+cols[z],ROW,COL);
                }
            }
           // System.out.println("in end of count connected and returning" + Integer.toString(count));
            return count;
        }
    }
    public static int getBiggestRegion(int[][] matrix, boolean[][] visited,int row, int col) {
        int max=0;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                count=countConnected(matrix,visited,i,j,row,col);
                if(count>max){
                    max=count;
                }
            }
        }
            
        return max;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Input Starts
        int n = in.nextInt();
        int m = in.nextInt();
        
        // Adjacency matrix
        int grid[][] = new int[n][m];
        boolean visited[][]= new boolean[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                visited[grid_i][grid_j] = false;
            }
        }
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        
        // Input Ends
        
        System.out.println(getBiggestRegion(grid,visited,n,m));
    }
}

