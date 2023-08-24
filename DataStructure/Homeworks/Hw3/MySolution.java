// Name      :Gürkan 
// Surname   :AĞIR
 class Node {

    private int data;
    public Node next;

    public Node(int dd) {
        data = dd;
    }

    public int getData(){
        return data;
    }

//You can add more functions but you can't change the given code.
}

////////////////////////////////////////////////////////////////
class MyStack {

    private Node first;

    public MyStack() {
        first = null;
    }

    public void push(int dd) {
       Node newNode = new Node(dd);
       newNode.next = first;
       first = newNode; 
    }

    public int peek() {
        if(first!= null){
            return first.getData();
        }else{
            return -1;
        }
    }

    public int pop() {
        if(first != null){
            int data = first.getData();
            first = first.next;
            return data;
        }else{
            return -1;
        }
   	}

    public boolean isEmpty(){
        return first == null;
    }
    
    public String evaluate(String command) {
        StringBuilder sb = new StringBuilder("");
        String[] commands = command.split(" ");
    
        for (String cmd : commands) {
            try {
                int num = Integer.parseInt(cmd);
                push(num);
            } catch (NumberFormatException e) {
                switch (cmd) {
                    case "print":
                        sb.append("[");
                        Node current = first;
                        while (current != null) {
                            sb.append(current.getData());
                            if (current.next != null) {
                                sb.append(", ");
                            }
                            current = current.next;
                        }
                        sb.append("]\n");
                        break;
                    case "pop":
                        if (!isEmpty()) {
                            sb.append(pop());
                            sb.append("\n");
                        }
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "%":
                        if (first != null && first.next != null) {
                            int num1 = pop();
                            int num2 = pop();
                            int result = 0;
                            try {
                                switch (cmd) {
                                    case "+":
                                        result = num2 + num1;
                                        break;
                                    case "-":
                                        result = num2 - num1;
                                        break;
                                    case "*":
                                        result = num2 * num1;
                                        break;
                                    case "/":
                                        if (num1 == 0) {
                                            throw new ArithmeticException();
                                        }
                                        result = num2 / num1;
                                        break;
                                    case "%":
                                        result = num2 % num1;
                                        break;
                                }
                                push(result);
                            } catch (ArithmeticException ex) {
                                sb.append("error\n");
                                push(num2);
                                push(num1);
                            }
                        } else {
                            sb.append("Not enough integers in the stack\n");
                        }
                        break;
                    case "exit":
                        sb.append("$\n");
                        break;
                    default:
                        sb.append("Invalid operator\n");
                }
            }
        }
    
        return sb.toString();
    }
     
}

    // You can add more functions but you can't change the given code.
