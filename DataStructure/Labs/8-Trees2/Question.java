
class Node {
    //

    public Node( ) {
        //
    }
}

import java.util.ArrayList;
import java.util.List;

class BinarySearchTree {
    //

    BinarySearchTree(//) {
        //
    }

    void insert() {
        root = //
    }

    Node insertRecursive(Node root, int data) {
        if (root == null) {
            //
            return root;
        }

        if ()
            //
        else if ()
            //

        return root;
    }

    void inorder() {
        //
    }

    void inorderRecursive(Node root) {
        if (root != null) {
            //
            System.out.print(root.data + " ");
            
        }
    }

    void printLeaves() {
        //
        System.out.println();
    }

    void printLeavesRecursive(Node root) {
        if (root != null) {
            if ()
                {System.out.print(root.data + " ");}
                
            //
            //
        }
    }
    
     public void printPathsToLeaves() {
        List<Integer> path = new ArrayList<>();
        PathsToLeavesRecursive(root, path);
    }

    
    private void PathsToLeavesRecursive(Node node, List<Integer> path) {
        if (node == null) {
            return;
        }
        
        //
        
        if () {
            System.out.println(path);
        } else {
            
           //
           //
        
        
    }
    
    path.remove(path.size() - 1); // do not edit this line (removes the current node's (last) value)
                                  
    }

import java.util.Scanner;
     
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
              
        
        
        Scanner sc = new Scanner(System.in);
        
        String mode = sc.nextLine();
        
        int[] tree_arr = new int[10];
        
        for (int i = 0; i < 10; i++) {
            if (sc.hasNextInt()) {
                tree_arr[i] = sc.nextInt();
            }
        }                          
        
        for (int i = 0; i < 10; i++)
            tree.insert(tree_arr[i]);
            
            
        if (){
        System.out.println("Inorder traversal: ");
        //}
        else if (){
        System.out.println("Leaf Nodes: ");
        //}
        else if (){
        System.out.println("Path to each leaf: ");
        //}
        
    }
}
