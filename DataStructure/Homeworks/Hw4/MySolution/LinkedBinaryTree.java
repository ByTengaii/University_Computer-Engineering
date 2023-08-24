public class LinkedBinaryTree<E>  {
    protected static class Node<E>{
        private E element;
        private Node<E> parent;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild){
            this.element = element;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        // Access
        public E getElement(){return element;}

        public Node<E> getParent(){return parent;}
        public Node<E> getLeftChild(){return leftChild;}
        public Node<E> getRightChild(){return rightChild;}


        // Update
        public void setElement (E newElement){this.element = newElement;}
        public void setParent (Node<E> newParent){this.parent = newParent;}
        public void setLeftChild (Node<E> newLeftChild){this.leftChild = newLeftChild;}
        public void setRightChild (Node<E> newRightChild){this.rightChild = newRightChild;}

    }


    // LinkedBinaryTree Variables
    protected Node<E> root = null; // Root of Tree
    private int size = 0; // Number of childs of tree

    public LinkedBinaryTree(){} // Create Empty LinkedBinaryTree


    public int getSize(){return size;}

    public boolean isEmpty(){
        return (size <= 0);
    }

    public boolean isInternal(Node<E> node){
        return (node.getLeftChild() != null && node.getRightChild() != null);
    }

    public int numOfChild(Node<E> node){
        int count = 0;

        if(node.getLeftChild() != null)
            count++;
        if(node.getLeftChild() != null)
            count++;

        return count;
    }

    // Returns parent of node
    public Node<E> parent(Node<E> node){
        return node.getParent();
    }

    // Returns leftChild of node
    public Node<E> left(Node<E> node){
        return node.getLeftChild();
    }

    // Returns rightChild of node
    public Node<E> right(Node<E> node){
        return node.getRightChild();
    }

    // Set new root with zero childs and returns root.
    public Node<E> setRoot(E data){
        if(!isEmpty()){
            System.out.println("Tree i not empty so we cannot set root!");
            return null;
        }
        root = new Node<E>(data,null,null,null);
        size = 1;
        return root;
    }

    // Add Left child to parent node with data [data] and returns leftChild if added succesfully, null otherwise.
    public Node<E> setLeftChild(Node<E> parent, E data){
        if(parent.leftChild != null){
            System.out.println("parent already has left child!");
            return null;
        }
        parent.setLeftChild(new Node<E>(data,parent, null,null));
        return parent.leftChild;
    }

    // Add Right child to parent node with data [data] and returns rightChild if added succesfully, null otherwise.
    public Node<E> setRightChild(Node<E> parent, E data){
        if(parent.rightChild != null){
            System.out.println("parent already has right child!");
            return null;
        }
        parent.setRightChild(new Node<E>(data,parent, null,null));
        return parent.rightChild;
    }

    // Sets element of node and returns old value
    public E setData(Node<E> node,E newData){
        E tempElement = node.getElement();
        node.setElement(newData);
        return tempElement;
    }


    public void attach(Node<E> node, LinkedBinaryTree<E> tree1, LinkedBinaryTree<E> tree2){

        if(isInternal(node)){
            System.out.println("Node is a not leaf so we couldn't attach trees to it!");
            return;
        }

        size = tree1.getSize() + tree2.getSize();
        if(!tree1.isEmpty()){
            tree1.root.setParent(node);
            node.setLeftChild(tree1.root);
            tree1.root = null;
            tree1.size = 0;
        }
        if(!tree2.isEmpty()){
            tree2.root.setParent(node);
            node.setLeftChild(tree2.root);
            tree2.root = null;
            tree2.size = 0;
        }
    }

    public E remove(Node<E> node){
        if(numOfChild(node) == 2){
            System.out.println("Node has two childern so we couldn't remove node.");
            return null;
        }
        Node<E> child = (node.getLeftChild() != null) ? node.getLeftChild() : node.getRightChild();

        if(child != null){
            child.setParent(node.getParent());
        }
        if(node == root){
            root = child;
        }else{
            Node<E> parent = node.getParent();
            if(node == parent.getLeftChild()){
                parent.setLeftChild(child);
            }else{
                parent.setRightChild(child);
            }
        }
        size--;
        E tempData = node.getElement();
        node.setElement(null);
        node.setRightChild(null);
        node.setLeftChild(null);
        node.setParent(null);
        return tempData;
    }


}