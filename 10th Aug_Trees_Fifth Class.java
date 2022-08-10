Date : 10th August 2022
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






LC-230: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/





Q-5: [CISCO] Find Largest Number in a BST which is less than or Equal to K


                5
             2       12   
           1  3     9    21
                      19  25



K = 21
OP: 21


K = 24
OP: 21


K = 3
OP: 3


K = 4
OP: 3






int largestlessthanK(Node root, int K)
{

}




Solution:


                5
             2       12   
           1  3     9    21
                      19  25




Inorder Traversal: [1 2 3 5 9 12 19 21 25]



K = 21
OP: 21


K = 24
OP: 21


prev = INT_MIN;
prev = Integer.MIN_VALUE;



Inside Inorder Traversal:

while (root.data <= K)
{
  prev = root.data;
}

return prev;



TC: O(1) - Best Case, O(N) - Worst Case
SC: O(N) - Recursion Stack


N = 9, Total 9 Nodes
K can be any value


K = 25 TC- O(N)
K = 10000 TC - O(N)







Dry Run:


Inorder Traversal: [1 2 3 5 9 12 19 21 25]

K = 4

prev = MIN_VALUE -> 1 -> 2 -> 3: ANS

prev!=5 , 5 > 4





Easy, Medium: Done
Hard LC Ques




Q-6: [LC-111] Minimum Depth of Binary Tree
https://leetcode.com/problems/minimum-depth-of-binary-tree/

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:
The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000





    public int minDepth(TreeNode root) 
    {
    
    }






Solution:


Need: Smaller of Child = min(leftHeight, rightHeight)

Case-1: Normal BT: Works Fine

Case-2: Skewed Tree:


The minimum depth is the "number of nodes along the shortest path from the root node down to the nearest leaf node".


Shortest Count of Nodes from Root --> Leaf Node


1
  2
    3
      4
        5


1: Not a Leaf node
Leaf Node: 5
Shortest Count of Nodes from Root --> Leaf Node: 5 - ANS

leftHeight from root = 0
rightHeight from root = 4



        1
      2  
    3  
  4 
5


1: Not a Leaf node
Leaf Node: 5

Shortest Count of Nodes from Root --> Leaf Node: 5 - ANS

leftHeight from root = 4
righHeight from root = 0




Note:

If Skewed Tree, min(leftHeight, rightHeight) from root = 0


if min(leftHeight, rightHeight) from root == 0
  Select ans = max(leftHeight, rightHeight) + 1




CODE:
https://leetcode.com/submissions/detail/770285915/

// TC- O(N), SC- O(N)

class Solution {
    public int minDepth(TreeNode root) 
    {
        if (root == null)
            return 0;
        
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        
        // Skewed Tree - Return Max+1
        if (Math.min(leftHeight, rightHeight) == 0)
            return 1 + Math.max(leftHeight, rightHeight);
        
        // Normal Binary Tree - Return Min+1
        else
            return 1 + Math.min(leftHeight, rightHeight);

    }
}
