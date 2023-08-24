# Lab8 Trees 2

[33298f09-fb50-459b-94bd-86db946a84be.zip](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8251fcc2-8802-4c87-8839-77ff58e68ad9/33298f09-fb50-459b-94bd-86db946a84be.zip)

In this lab you are going to implement the Binary Search Tree (BST) structure which has 10 elements (fixed). We want to sort the given array by traversing the BST with the inorder method. Also we want to output the leaves and the paths to them.

# To Do

- We want to use the BST structure to sort the given array in ascending order.
- Your program should take any 10-length int array input from the user and create a BST from that.
- By traversing the tree with the inorder method, your program should output the sorted version of the given input.
- Your program should determine the leaf nodes and print them.
- Finally, your program should find and print all the paths to the leaf nodes.

# Step 1: Implement the missing parts in Node.java.

- Nodes must have an integer variable to store its data.
- Data is passed in the constructor.
- Nodes must have left and right children of type “Node”.
- Left/right child must be null unless a new child is added.

# Step 2: Implement the missing parts in BinarySearchTree.java.

- BST must have a root of type “Node” and it should be initialized in the constructor as “null”.

### insertRecursive

- “insert” method calls “insertRecursive” by passing the root of the tree and the data to be added. It takes the data to be added as its parameter.
- “insertRecursive” should instantiate a new node if the current node is root (“null” at first) or a child of a leaf (which is “null”). (if condition #1)
- If the data to be added is smaller than the root data, it should be added as the left child. It should be added as the right otherwise. Also add it as the right if there is an equality. If the left or the right children are the roots of subtrees, it should recursively traverse until it reaches a leaf.(if condition #2 and 3)

### inorderRecursive

- “inorder” method calls “inorderRecursive” by passing the root of the tree.
- “inorderRecursive” should traverse the tree recursively in the following order:

1) Left child or subtree

2) Parent

3) Right child or subtree

and print the elements in this order as shown in the class.

### printLeavesRecursive

- “printLeaves” method calls the “printLeavesRecursive” by passing the root of the tree.
- “printLeavesRecursive” should traverse the tree recursively strating from the root and print each visited element if both children are null, which indicates that they are leaf nodes.

### PathsToLeavesRecursive

- “printPathsToLeaves” instantiates a list to save visited nodes and calls “PathsToLeavesRecursive” by passing the root and the path list.
- “PathsToLeavesRecursive “ should add each visited node to the path and print the path when it reaches a node such that its both children are null, which means when it reaches a leaf, similar to printLeavesRecursive.

# Step 3: Complete Main.java

- Most of the main method method is already implemented.
- The program must have 3 modes:

1) inorder: Prints the constructed tree in inorder fashion. (4 points)

2) leaf: Prints the leaves of the tree. (2 points)

3) path: Prints the paths to the leaves. (4 points)

- Call the methods “inorder”, “printLeaves” and “printPathsToLeaves” according to the mode provided in the first line of the input. Second line is the array from which the tree will be constructed.

# Test Cases

Here is an example of a BST (from the class):
-> 10, 8, 20, 1, 9, 15, 25, 12, 16, 24

     10
    /  \
  8     20
 / \    / \
1   9  15  25
       /\  /
     12 16 24

Case#1 inorder
- Input:
inorder
10 8 20 1 9 15 25 12 16 24
- Output:
Inorder traversal:
1 8 9 10 12 15 16 20 24 25

Case#2 leaf
- Input:
leaf
10 8 20 1 9 15 25 12 16 24
- Output:
Leaf Nodes:
1 9 12 16 24

Case#3 path
- Input :
path
10 8 20 1 9 15 25 12 16 24
- Output:
Path to each leaf:
[10, 8, 1]
[10, 8, 9]
[10, 20, 15, 12]
[10, 20, 15, 16]
[10, 20, 25, 24]
