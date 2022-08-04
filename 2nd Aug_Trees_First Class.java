Date : 2nd August 2022
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




Intro:

DEVANG SHARMA
Senior Developer - 2 at Meta

Grab, Cisco, Google


Teaching: 4 Years

CP:
TCO 21,22 WF, GCJ 2019,2020 - WSF, KS- 0.8 %- 2 In India
FHC 2019: WSF



Advanced DSA:

15th June: 1.5 Months

45 Days: 50-60 Hrs of Classes


ROI:

- DP: DONE
- Backtracking: DONE
- Trees: DONE
- Graphs: DONE
- Heap Sort: DONE

- Greedy



Most Important Topics to Cover:

- Trees
- Graphs
- DP




Trees: This Week
Tue, Wed, Thu
- Finish Trees with LC Questions




Leetcode
Lintcode - Premium Questions on LC for Free






---> TREES:

- What (Use Case/Problem): DONE
- Why (Applications): DONE
- How (Coding/Implementation)



(1) Linear DS
- Arrays
- Linked Lists
- Stacks
- Queues

(2) Hierarchical DS
- Trees
- Graphs



(A) Elements are Stored in Continuous Locations - Linear: INCORRECT
(B) There is More than one Logical Way of Traversal: CORRECT


Linear DS
- Arrays: L to R, R to L
- Linked Lists: Head to Tail
- Stacks: Top to Bottom
- Queues: Front to Rear


Hierarchical DS:

- DFS (Depth First Search) - Preorder, Inorder, PostOrder

- BFS (Breadth First Search) - LOT (Level Order Traversal)







(2) Tree vs DLL


DLL:


A <---------> B <--------> C
All on Same Levels

B.prev = A
B.next = C
A.next = B



Tree:

Root ----> Children ---> Subchildren
Level 0    Level 1       Further Levels


Root: Top Most Node
Child: Immediate Children Under Root
Child Can Also Have Subchildren


                 A
              B     C       
            D  E   F G   

Root: A
Children: B, C
Subchildren: D E F G



Note:

Parent to Child: YES
Child to Parent: NO


A.left = B
A.right = C



Note:

LCA of Two Nodes in a Binary Tree/BST (LC)
- Without a Parent Pointer
- With a Parent Pointer (Child to Parent Pointer)








--> Types of Trees:


(1) Binary Trees


A Tree with a MAXIMUM of 2 Children (0,1,2) for EACH NODE is called a Binary Tree

Leaf Node: A Node which does not have any children

Complete/Full Binary Tree:
All Non-Leaf Nodes will have EXACTLY 2 Children

IMP: 

Property:
Complete Binary Tree:
Number of Nodes at Height h = 2^h (Assuming, root level height = 0)
Number of Nodes at Height h = 2^(h-1) (Assuming, root level height = 1)


                 A            h = 1
              B     C         h = 2
            D  E   F G        h = 3


Total Number of Nodes in a Complete Binary Tree:
= Sum of Number of Nodes at Each Level
= 2^0 + 2^1 + 2^2 + .........+ 2 ^h

Formula: a(r^n-1)/(r-1), r > 1

Total Nodes = 2^0 * (2^h-1) = 2^h-1

Test, h = 3
Total Nodes = 7


Eg- 1

                 A
              B     C       
            D  E   F G   


OP:

Binary Tree: YES
Leaf Nodes: D E F G
Complete/Full Binary Tree: YES



Eg- 2


                 A
              B     C       
            D  E   F NULL  


OP:

Binary Tree: YES (Max 2 - 0,1,2)
Complete/Full Binary Tree: NO


Eg- 3


                 A         h=0
      
OP:

Binary Tree: YES (Max 2 - 0,1,2)
Complete/Full Binary Tree: YES




Eg- 4


                 A
              B     C        h = 1

OP:

Binary Tree: YES (Max 2 - 0,1,2)
Complete/Full Binary Tree: YES







(2) N- Ary Trees (Generic Trees)


A Tree with a MAXIMUM of N Children (0,1,2....N) of EACH NODE is called N- Ary Tree (Generic Trees)

Leaf Node: A Node which does not have any children

Complete/Full N-Ary Tree:
All Non-Leaf Nodes will have EXACTLY N Children


Eg- 1

N-Ary Trees (N = 3)


                      A
              B       C        D          
             EFG      HI       JKL 


N-Ary Tree: YES (Max of 3 Children Per Node)
Complete N-Ary Tree: NO (EXACTLY 3 Children Per Node)




Eg- 2

N-Ary Trees (N = 3)


                           A
              B       C        D      P  
             EFG      HI       JKL    Q


N-Ary Tree:  NO (Max of 3 Children Per Node)
Complete N-Ary Tree: NO (EXACTLY 3 Children Per Node)




Code:

Node *left, *right: 2 Children  - Binary Tree

vector<Node*> children(N, NULL); N Children - N-Ary Tree (Generic Tree)








--------> Applications of Tree:


(1) File Storage System

PC:

C:
D:
E:
F:


Folder A:
  - Images
  - Videos
  - GIFs



Path: /D/Folder/Folder 1/Folder /file.png


---> Hierarchical Order: Trees


(2) Ordering: BST (Binary Search Trees)

Search and Access: Faster than Arrays


(3) Complexity of Insertion and Deletion:

Arrays          LL          Tree (BST)

O(N)            O(1)        O(log N)


(4) No Upper Limits

Array: Upto a Limit (Continuous Memory)
LL: No Limit
Tree: No Limit

(5) Dynamic Allocation
- Increase/Decrease Size of Tree at Run Time




