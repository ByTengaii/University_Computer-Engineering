public class Node {
    private String data;
    private int priority;
    private Node next;
    Node(String data, int priority){
        this.data = data;
        this.priority = priority;
        this.next = null;
    }

    //GET
    public String getData() {
        return data;
    }

    public int getPriority() {
        return priority;
    }

    public Node getNext() {
        return next;
    }

    //SET
    public void setData(String data) {
        this.data = data;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
