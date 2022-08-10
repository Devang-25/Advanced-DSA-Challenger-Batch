Date : 8th August 2022
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







Every BST is a BT but Every BT is NOT a BST


BT: Superset
BST: Subset



----> Inorder of BST:

          6
       4    8   
     1  5  7  9  


Inorder = [1 4 5 6 7 8 9]

Inorder: left - root - right

BST    : left < root < right


Note:
(1) Inorder Traversal of a BST will ALWAYS give a Strictly Increasing Sorted Array
(2) Left Most Child: Smallest
(3) Right Most Child: Largest



How to Check if a BT is a BST or Not?
- Best Solution: Do Inorder Traversal, If Sorted -> Yes, Else -> No


Interview Questions:

Question, Company, IP, OP
30 Sec


Code, TC, SC



Structure of Node of Tree:

Node
{
  left
  right
  data: int
}







Q-1: [Amazon] Find Smallest Element in a BST


            20
         8      22   
       4   12    
          10  14


OP: 4



int minValue(Node root)
{


}



Solution:

Smallest Element ---> Leftmost Node in a BST

Approach:
Go to Leftmost Node and print it



---> Recursive Code

int minValue(Node root)
{
  if (root == null)
    return -1;

  minValue(root.left);
  return root.data;
}



---> Iterative Code

int minValue(Node root)
{ 
  if (root == null)
    return -1;

  Node temp = root; // Dummy Node
  while (temp.left != null)
  {
    temp = temp.left;
  }

  return temp.data;
}

TC: O(1) - Best case  O(N) - Worst Case
SC: O(N)






Q-2: [Adobe] Find All Pairs with Given Sum in a BST - Medium


No Duplicate Values in BST:

left < root < right -- All Unique Values


BST: Duplicates not allowed
BT: Duplicates Allowed


                  15
              10       20    
           8     12  16  24  


target = 28

OP: [[12,16], [8,20]]




void twoSuminBST(Node root, int target)
{

}



Solutions:

Inorder of BST: Sorted Array

"Find pairs Given Sum in Sorted Array"

- Variation of Two Sum (Unsorted Array)


3 Approaches:
(1) Nested Loops : T  - O(N^2), S- O(1)
(2) Sorting and Two Pointer: T  - O(N), S- O(1)
(3) Hashing:  T  - O(N), S- O(N)


This Ques: Sorted Array
Best Ans: Second Ans
Two Pointer: Because its already sorted from Inorder Traversal

T - O(N)
S - O(1)





Q-3: [Paypal] Find the Kth Smallest (or Largest) Element in a BST


            20
         8      22   
       4   12    
          10  14



K = 3
OP: 10


K = 5
OP: 14

Constraints:
 
1 <= K <= N


int KthSmallest(Node root, int K)
{

}





Solution:


(1) Brute Force:

Use Heap (Min-Heap - Kth Min) or (Max Heap - Kth Max) and pop K times

Space Complexity will increase due to Heap/Priority Queue


TC: O(NlogN)
SC: O(N)


(2) Inorder Traversal:

Inorder Traversal of BST ---> Sorted Array


Store in Array

Kth Smallest value = return arr[k-1]

Kth Largest value = return arr[N-k+1]


T - O(N) - Inorder
S - O(N) - Array

arr[10^9] - Stack Overflow - Space Complexity: Overhead
Inorder Traversal: O(N) = 10^9 Traversals - Time Complexity: Overhead


N = 10^9
K = 2


(3) Inorder Traversal:

Inorder Traversal of BST ---> Sorted Array


Initialise count == 0
  During Inorder Traversal:
    if count == K:
      return temp.data


OR

During Inorder Traversal:
  if K == 0:
    return temp.data

  inorder(root.data, k-1);



T - O(K) , 1 <= K <= N
S - O(1)

Note: Optimised Both in Time and Space
T: O(N) -> O(K) - Optimised
S: O(N) -> O(1) - Optimised


HW:

LC-230: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
