class Node {
   
  String key;
  //

  public Node(String newNode) {

  //
  }
}
  
  
  class BinaryTree {
  Node root;

  
  public void traverseLeft(Node node) {
    if (node != null) {
      //
      System.out.print(node.key + " ");
      
    }
  }
  
  public void traverseRight(Node node) {
    if (node != null) {
      //
      System.out.print(node.key + " " );
      
    }
  }
  
  public void traverseParentLeft(Node node) {
    if (node != null) {
       //
       System.out.print(node.key + " ");    
            
    }
  }
  
  public void traverseParentRight(Node node) {
    if (node != null) {
       //
       System.out.print(node.key + " ");
      
    }
  }
}
  
  
import java.util.Scanner;

public class Main{

public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    
    String input = sc.nextLine();
    String[] command = input.split(" ");
    
    
    
    
    BinaryTree tree = new BinaryTree();

    
    tree.root = new Node(command[1]);
    tree.root.left = new Node(command[2]);
    tree.root.right = new Node(command[3]);
    tree.root.left.left = //
    //
    
    
    
    
    if(command[0].equals("left")){
       
     //
       
       }
    else if(command[0].equals("right")){
    
    //
  }
    else if(command[0].equals("Pleft")){
    
     //
     
  } else if(command[0].equals("Pright")){
    
    //
  }
  else{
     
     //
     
     }
    
    
    
  
}

