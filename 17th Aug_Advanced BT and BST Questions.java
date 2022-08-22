Date : 17th August 2022
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







LC - 103: DONE

LCA

LC - 938
https://leetcode.com/problems/range-sum-of-bst: 





Q: [Google, Meta] [LC-103] Binary Tree Zigzag Level Order Traversal
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/


Given the root of a binary tree, return the zigzag level order traversal of its nodes values. 
(i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100


 public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
   
   }



OP:


List of Lists/ Vector of Vectors

Each Level: [List] - L to R, R to L based upon Level (Alternate)
Final Ans: [List of Lists]


CODE:


// T - O(N), S - O(N) - Queue

// Approach - Using BFS/LOT - Go to each level and figure L to R or R to L based upon count of each level

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> answer = new ArrayList<>();
        
        if (root == null)
            return answer;
        
        int level = 0;
        bfsHelper(root, answer, level);
        
        return answer;
    }
    
    // ZigZag BFS/LOT
    public void bfsHelper(TreeNode root, List<List<Integer>> answer, int level)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty())
        {
            int size = q.size();
            
            // Results of Nodes at 1 Particular Level
            
            List<Integer> levelNodeList = new ArrayList<>();
            int i = 0;
            
            for (i=0; i<size; i++)
            {
                TreeNode temp = q.poll(); //q.pop();
                levelNodeList.add(temp.val);
                
                // Recur on Left Subtree
                if (temp.left!=null)
                    q.add(temp.left);
                
                
                // Recur on Right Subtree
                if (temp.right!=null)
                    q.add(temp.right);                
            }
            
            // After this for loop, 
            // I have LEFT TO RIGHT Values of a A Particular Level 
            
            // Based upon ODD/EVEN, Change the Direction (Reverse)
            
            // for odd level, reverse the levelNodeList            
            if (level % 2 != 0)
                Collections.reverse(levelNodeList);
            // [9 20 ] -> [20 9]
            
            level++;
            
            answer.add(levelNodeList);                        
        }        
    }
}




Easier/Quicker Solution:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def zigzagLevelOrder(self, root):
        if not root: return []
        queue = deque([root])
        result, direction = [], 1
        
        while queue:
            level = []
            for i in range(len(queue)):
                node = queue.popleft()
                level.append(node.val)
                if node.left:  queue.append(node.left)
                if node.right: queue.append(node.right)
            result.append(level[::direction])
            direction *= (-1)
        return result

# Trick    
# -1 * -1 * -1......Even Time = 1    
# -1 * -1 * -1......Odd Times = -1
# arr[::-1]: reverse (R to L)
# arr[::1]: same (L to R)








Q: [LC-938] Range Sum of BST
https://leetcode.com/problems/range-sum-of-bst


Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

 

Example 1:


Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.


Example 2:


Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 

Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.



CODE:


// Approach:
// Every value such that: L <= node.val <= R would be taken into sum

// T - O(N), S- O(N)

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) 
    {
        if (root == null)
            return 0;
        
        return (low <= root.val &&  root.val <= high ? root.val :0)
            + rangeSumBST(root.left, low, high)
            + rangeSumBST(root.right, low, high);
    }
}
