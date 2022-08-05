Date : 3rd August 2022
Mentor: DEVANG SHARMA
Batch: March Batch (Advanced DSA) - Challenger

Agenda:

- Trees
- Binary Search Trees
- Interview Questions on BT and BST

Trees- Binary Trees

https://leetcode.com/problems/minimum-depth-of-binary-tree/: DONE
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/: DONE
https://leetcode.com/problems/balanced-binary-tree/: DONE
LC - Premium : https://leetcode.com/problems/binary-tree-upside-down/ 


Trees- Binary Search Trees

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree - IMP
https://leetcode.com/problems/minimum-absolute-difference-in-bst: DONE
https://leetcode.com/problems/search-in-a-binary-search-tree: DONE
https://leetcode.com/problems/range-sum-of-bst: DONE

"Please Type 'Hi' in the Chat Box if you have joined and Can See this Screen".





CODE:


Linked Lists:


// Structure of Linked List Node
class Node
{
  int data;
  Node next = null; // Self referential Object

  Node(int data)
  {
    this.data = data;
  }
}

// Driver Code
public static void main(String[] args)
{
  Node first = new Node(1);
  Node second = new Node(2);
  Node third = new Node(3);

  1              2             3
  null           null          null

  first -> next = second;  // 1->2
  second -> next = third;  // 2->3

  LL: 1->2->3->NULL
}







TREES:



// Structure of Tree Node
class Node
{
  int data;
  Node left = null; // Self referential Object
  Node right = null; // Self referential Object

  Node(int data)
  {
    this.data = data;
  }
}

// Driver Code
public static void main(String[] args)
{
  Node root = new Node(1);

           1
      null   null

  root.left = new Node(2);

           1
      2       null

  root.right = new Node(3);

           1
      2        3

  root.left.right = new Node(4);

             1
        2          3
    null   4  null   null
}


root.left or root.right: (DOT): Java or Python 

C++:
-> : Arrow Operator



Input from Array:
-1: Null

For ith Node:
Child: 2*i: Left, 2*i+1: Right





----> TRAVERSALS:


(1) DFS (Depth First Search)
- PreOrder
- InOrder
- PostOrder


(2) BFS (Breadth First Search)
- Level Order Traversal




-------> DFS Tarversals:

- InOrder  (Left -> Root -> Right)
- PreOrder  (Root -> Left -> Right)
- PostOrder  (Left -> Right -> Root)


        A
      B   C  

InOrder: B A C
PreOrder: A B C
PostOrder: B C A


TREE:


          1                        1
       2      3     ----> [4 2 5]     3 ------> [4 2 5 1 3]
     4   5     



InOrder: 4 2 5 1 3
PreOrder: 1 2 4 5 3
PostOrder: 4 5 2 3 1



-----> BFS Traversal:

Level Order Traversal: 1 2 3 4 5



CODE:

// Inorder: Left -> Root -> Right
void inOrder(Node root)
{
  if (root == null)
    return;

  inOrder(root.left); // Recurring on Left
  System.out.print(root.data + " "); // Root
  inOrder(root.right); // Recurring on Right
}




// Preorder: Root -> Left -> Right
void preOrder(Node root)
{
  if (root == null)
    return;

  System.out.print(root.data + " "); // Root
  preOrder(root.left); // Recurring on Left
  preOrder(root.right); // Recurring on Right
}




// Postorder: Left -> Right -> Root
void postOrder(Node root)
{
  if (root == null)
    return;

  postOrder(root.left); // Recurring on Left
  postOrder(root.right); // Recurring on Right
  System.out.print(root.data + " "); // Root
}


TC: O(N)
SC: O(N) - Recursion Stack - Auxiliary Memory - Heap






Interview Questions:

Question, Company, Sample IP, Sample OP

30 Sec:
Code/Approach, TC, SC




Q-1: [Amazon] Height/Depth of Binary Tree


IP:        

                    1
                2        3    
                      4     5
                    6    


OP: 4


IP: 

    1

OP: 1


IP: 
  Empty Tree

OP: 0



[LC - 104] Maximum Depth of Binary Tree
https://leetcode.com/problems/maximum-depth-of-binary-tree/

Given the root of a binary tree, return its maximum depth.

A binary trees maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3


Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100


CODE:


// TC: O(N), SC: O(N)

class Solution {
    public int maxDepth(TreeNode root) 
    {
        if (root==null)
            return 0;
        
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        
        return 1 + Math.max(left_depth, right_depth);
    }
}



