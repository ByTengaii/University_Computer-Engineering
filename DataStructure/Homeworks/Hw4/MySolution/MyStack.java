class Node<E> {

    private E data;
    public Node<E> next;

    public Node(E dd) {
        data = dd;
        next = null;
    }

    // You can add more functions but you can't change the given code.
    public E getData(){
        return data;
    }

}

public class MyStack<E> {
    private Node<E> first;

    public MyStack() {
        first = null;
    }

    public void push(E dd) {
        Node<E> tempNode = new Node<E>(dd);

        if(isEmpty()){
            first = tempNode;
            return;
        }

        tempNode.next = first;
        first = tempNode;
    }

    public E peek() {

        if(isEmpty()){
            return null;
        }
        return first.getData();
    }

    public E pop() {

        if (isEmpty()){
            return null;
        }

        E dd = first.getData();
        first = first.next;
        return dd;
    }


    private boolean checkSize(){
        if(getSize() < 2){
            return false;
        }
        return true;
    }


    private boolean isEmpty(){
        return (first == null);
    }

    public int getSize(){
        Node<E> tempNode = first;
        int size = 0;
        while(tempNode != null){
            tempNode = tempNode.next;
            size++;
        }
        return size;
    }
}
