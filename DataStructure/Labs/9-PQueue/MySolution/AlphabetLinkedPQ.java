public class AlphabetLinkedPQ {
    private Node head;
    private int size;
    private String order;

    public AlphabetLinkedPQ(String order) {
        this.order = order;
        this.size = 0;
        this.head = null;
    }

    private int getAlphabeticalIndex(String str) {
        if (this.order.equals("normal")){
            return str.charAt(0) - 'a';
        }else{
            return 25 - (str.charAt(0)-'a');
        }
    }

    public void enqueue(String str) {

        int priority = getAlphabeticalIndex(str);
        System.out.println("Priority:" + priority);
        Node newNode = new Node(str,priority);

        //Finding available position then put on it.
        if (this.head == null || this.head.getPriority() > priority) { // put low alphabet.
            newNode.setNext(this.head);
            this.head = newNode;
        } else {  //put high alphabet.
            Node current = this.head;
            while (current.getNext()!= null && current.getNext().getPriority() <= priority) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        this.size++;
        this.printQueue();
        System.out.println("Size:"+this.size);
    }

    public String dequeue() {
        if (this.head != null) {
            String dequeue = this.head.getData();
            this.head = this.head.getNext();
            this.size--;
            return dequeue;
        }
        return null;
    }

    public int getSize() {
        return this.size;
    }

    public void printQueue() {

        Node temp = this.head;
        while (temp!=null){
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        }
        System.out.println();
    }


}


////////////////////////////////////////////////////////
