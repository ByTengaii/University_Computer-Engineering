import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String order  = scanner.nextLine();
        String dequeueMode = scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");

        AlphabetLinkedPQ queue = new AlphabetLinkedPQ(order);
        for(String str : input){
            System.out.println("Enqueue:" +str);
            queue.enqueue(str);
            System.out.println("Size:" + queue.getSize());
        }

        if (dequeueMode.equals("on")){
            System.out.println("Dequeue mode:" + dequeueMode );
            while (queue.getSize()>0){
                System.out.println("Dequeue:" +queue.dequeue());
                queue.printQueue();
                System.out.println("Size:" +queue.getSize());
            } }
        else
            System.out.println("Dequeue mode:" + dequeueMode);
    }
}