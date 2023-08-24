# LAB INFORMATIONS

In this lab you are going to implement a basic binary tree which has 7 nodes and print it in 4 different orders.

Here is the general binary tree structure:

```
     A
   /   \
  B     C
 / \    /\
D   E  F  G

```

## Step 1: Implement the missing parts in Node.java.

A binary tree node can be thought of as a linked list node. But instead of having previous or next links, it has left and right child nodes.

Eg: A.left = B and A.right = C.

- Every node should have a variable to store its key (A) and its left child node (B) as well as its right child node (C).
- Each node key is initialized in the constructor.
- The left and right child of each node is "null" unless a new child is added.

## Step 2: Understand the Construction of the Binary Tree structure and implement the missing parts in BinaryTree.java.

By defining the root node in BinaryTree.java, we can add left and right children as in the template of Main.java starting by initalizing the value of root as

tree.root = "A";

Then we can simply add its left and right children as

tree.root.left = "B";

and

tree.root.right = "B";

To traverse and print the tree, we are going to use a recursive approach.

- traverseLeft(tree.root): Think A's left part as a subtree with the root B, and right part as a subtree that the root is C. In the result subtree, the print order should be left>parent>right.
    
    D B E A F C G
    
- traverseRight(): right>parent>left.
    
    G C F A E B D
    
- traverseParentLeft():
    
    A B D E C F G
    
- traverseParentRight():
    
    A C G F B E D
    
- **Important Tip:** While coding the traverse methods, keep in mind that you should call that method in itself by passing node.left or node.right to recursively reach the last node of that tree branch and be carefull of your print order. They should print all nodes until they reach the null children of the leafs. tree.traverse…() should only take the **root** as input.

## Step 3: Complete the Main.java

Your program should be able to run with any 8-length input String array and the first String should determine the mode of the traversal algorithm. Possible modes are:

- left
- right
- Pleft
- Pright

Eg. valid input:

- in: left A B C D E F G / out: D B E A F C G
- in: Pright Q U K L M N Z / out: Q K Z N U M L

Your program should check if an invalid traverse mode is entered. Print the error message ""Invalid traversal type!" if that is the case.
