Date : 16th August 2022
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







Hard: BST Questions



Q: [LC-110] Balanced Binary Tree
https://leetcode.com/problems/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104


public boolean isBalanced(TreeNode root) 
    {
    }







CODE:


// T - O(N), S - O(N)

class Solution {
    public boolean result = true;
    
    public boolean isBalanced(TreeNode root) 
    {
        maxDepth(root);
        return result;        
    }
    
    public int maxDepth(TreeNode root)
    {
        if (!result)
            return 0;
        
        if (root == null)
            return 0;
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        // Not Height Balanced: diff > 1
        if (Math.abs(leftHeight - rightHeight) > 1)
            result = false;
        
        // Height Balanced: diff <= 1, recur for next node
        return 1 + Math.max(leftHeight, rightHeight);        
    }
}




















[IMP] Q: [LC-530] Minimum Absolute Difference in BST
https://leetcode.com/problems/minimum-absolute-difference-in-bst


Given the root of a Binary Search Tree (BST), 
return the minimum absolute difference between the values of any two different nodes in the tree.

 
Example 1:

Input: root = [4,2,6,1,3]
Output: 1


Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105



    public int getMinimumDifference(TreeNode root) {
        
    }




Solution:


Inorder Traversal of BST --> Sorted List of Values

Minimum Absolute Difference in Sorted Array: Between Adjacent Values


Maximum Absolute Difference in Sorted Array: Between First and Last Values


[4,2,6,1,3]

After Sorting: [1 2 3 4 6]

Min Diff = 1,2 = 2,3 = 3,4 = 1
Max Diff = 1,6 = 5



Note: 
No Need to store Inorder Traversal, 
Just keep a variable to store minimum absolute Adjacent difference in Inorder Traversal


Approach:

(1) Inorder Traversal
(2) Difference of Adjacent Values
(3) Minimum Adjacent Value Difference





Edge Case:

[0, null, 2236, 1277, 2776, 519]
      

          0
       _      2236   
           1277  2776 
          519  


Inorder Traversal:
[0 519 1277 2236 2776]

Correct OP: 519

curr > 0: curr will never become 0

diff = 1277-519, 2236-1277, 2776-2236

Min Value = 2776-2236 = 540
OP: 540



// T - O(N), S- O(N)

class Solution {
    
    // Global because Recursive function will reuse same value everytime
    int min_diff = Integer.MAX_VALUE; // Ans: Min Diff between any 2 Nodes
    int curr_diff = -1; // Min Diff between any 2 ADJACENT Nodes in Inorder Tarversal

    public int getMinimumDifference(TreeNode root) 
    {
        // Inorder: Left - Root - Right
        
        // Recur on Left
        if (root.left!=null)
            getMinimumDifference(root.left);
        
        if (curr_diff >= 0)
            min_diff = Math.min(min_diff, root.val - curr_diff);
        
        // Hold previous value
        // root.val - curr_diff -> curr - prev value
        curr_diff = root.val;

        // Recur on Right        
        if (root.right!=null)
            getMinimumDifference(root.right);
            
        return min_diff;        
    }
}





HW:

LC - 700
https://leetcode.com/problems/search-in-a-binary-search-tree: 

LC - 938
https://leetcode.com/problems/range-sum-of-bst: 
