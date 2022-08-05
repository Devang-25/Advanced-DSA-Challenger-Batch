Date : 5th August 2022
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







Q-2: [Microsoft] Check if Two trees are Identical or Not


      1           |        1
    2   3         |     2    3
       4          |         4

OP: true



      1           |        1
    2   3         |     3    2
       4          |      4   

OP: false




Edge Cases:

A: Empty
B: Empty

OP: true


A: Empty
B: Not Empty

OP: false




boolean areIdentical(Node a, Node b)
{

}



Solution:

(A) Conditions:
- root = same
- left subtree of first = left subtree of second
- right subtree of first = right subtree of second



boolean areIdentical(Node a, Node b)
{ 
  // Both Empty - return true
  if (a==null && b==null)
    return true;

  // Either One Empty other non empty - return false
  if (a==null || b== null)
    return false;

  // Both Non Empty - 3 Conditions
  return (a.data == b.data) && areIdentical(a.left, b.left) && areIdentical(a.right, b.right);
}

TC: O(M+N)
SC: O(M+N)




(B) Approach-2:

Do Any Traversal (DFS)
If Same --> Identical Trees


TC: O(M+N)
SC: O(M+N)















Q-3: [Microsoft] Check if Two trees are Mirror Images or Not


      1           |        1
    2   3         |     2    3
       4          |         4

OP: false



      1           |        1
    2   3         |     3    2
       4          |      4   

OP: true




Edge Cases:

A: Empty
B: Empty

OP: true


A: Empty
B: Not Empty

OP: false




boolean areMirror(Node a, Node b)
{

}



Solution:

(A) Conditions:
- root = same
- left subtree of first = right subtree of second
- right subtree of first = left subtree of second



boolean areMirror(Node a, Node b)
{ 
  // Both Empty - return true
  if (a==null && b==null)
    return true;

  // Either One Empty other non empty - return false
  if (a==null || b== null)
    return false;

  // Both Non Empty - 3 Conditions
  return (a.data == b.data) && areMirror(a.left, b.right) && areMirror(a.right, b.left);
}



TC: O(M+N)
SC: O(M+N)





Q-4: [LC-101] Symmetric Tree
https://leetcode.com/problems/symmetric-tree/


Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true


Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?





    public boolean isSymmetric(TreeNode root) {
        
    }



Solution:


// T - O(N), S - O(N)

class Solution {
    public boolean isSymmetric(TreeNode root) 
    {
        if (root == null)
            return true;
        
        return areMirror(root.left, root.right);
    }
    
    public boolean areMirror(TreeNode a, TreeNode b)
    { 
  // Both Empty - return true
  if (a==null && b==null)
    return true;

  // Either One Empty other non empty - return false
  if (a==null || b== null)
    return false;

  // Both Non Empty - 3 Conditions
  return (a.val == b.val) && areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }

}





Q-5: [Adobe] Sum of All Nodes in a Binary Tree



    1
  2   3  
 4 5



Sum = 1 + 2 + 3 + 4 + 5 = 15


int sumOfTree(Node root)
{

  if (root == null)
    return 0;

  return root.data + sumOfTree(root.left) + sumOfTree(root.right);
}


TC: O(N)
SC: O(N)




Q-6: [Walmart] Variation - Sum of All Left Nodes in a Binary Tree



    1
  2    3  
 4 5  9 10



Sum = 1 + 2 + 4 = 7

int leftSum(Node root)
{

  if (root == null)
    return 0;

  return root.data + leftSum(root.left);
}



Q-7: [Walmart] Variation - Sum of All Right Nodes in a Binary Tree



    1
  2    3  
 4 5  9 10



Sum = 1 + 3 + 10 = 14

int rightSum(Node root)
{

  if (root == null)
    return 0;

  return root.data + rightSum(root.right);
}



TC of leftSum/rightSum of Tree



(1) Full/Complete Binary Tree



                        1
                 2             3     
             4      5       6       7    
          8   9   10  11  12  13  14 15  



N = 15
N/2 = 7
leftSum = 1-2-4-8, Total Traversals = 4!=7

TC: O(log N)



(2) Skewed Tree


Left Skewed: No Right Children
Right Skewed: No Left Children





Left Skewed Tree:


            1
          2  
        3  
      4 



leftSum = 10
TC: O(N)




Right Skewed Tree:


            1
              2  
                3  
                  4 



rightSum = 10
TC: O(N)




Calculate leftSum for Right Skewed Tree, TC - O(1)

Calculate rightSum for Left Skewed Tree, TC - O(1)





Final Ans: O(1) - Best Case, O(N) - Worst Case









-----> BINARY SEARCH TREE (BST)

- Special Kind of Binary Tree


Property:
Left < Root < Right


This Property is followed for ALL Nodes in BST


Note:
Every BST is a BT, Reverse is Not True


    
        5
      4   6  


BST: 4 < 5 < 6: YES
BT:  YES 



    
        1
      2   3  


BST: 2 < 1 < 3: NO
BT:  YES 



          6
       4    8   
     1  5  9  7  


BST: NO
BT: YES


4 < 6 < 8: YES (Root)
1 < 4 < 5: YES (Left Subtree)
9 < 8 < 7: NO (Right Subtree)




