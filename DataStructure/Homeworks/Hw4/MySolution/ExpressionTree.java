//Gürkan AĞIR

public class ExpressionTree extends LinkedBinaryTree<String>{
    private String[] expressions;
    private MyStack<Node<String>> stackOperand = new MyStack<Node<String>>();

    private MyStack<Node<String>> stackOperator = new MyStack<Node<String>>();

    private String validOperator = "( ) * + - sin cos";

    public ExpressionTree(String parenthesizeExpression){
        expressions = parenthesizeExpression.split(" ");
        createTree();
    }

    private void createTree(){
        for (String ch : expressions){

            Node <String> newNode = new Node<String>(String.valueOf(ch),null,null,null);

            if (newNode.getElement().equals(")")){
                Node<String> littleNode = new Node<String>(stackOperator.pop().getElement(),null,null,null);

                if (littleNode.getElement().equals("sin") || littleNode.getElement().equals("cos")){ //Sin Cos situation
                    littleNode.setRightChild(null);
                    littleNode.setLeftChild(stackOperand.pop());
                }else{ // Other Operands
                    littleNode.setRightChild(stackOperand.pop());
                    littleNode.setLeftChild(stackOperand.pop());
                }

                root = littleNode;
                stackOperand.push(littleNode);
                stackOperator.pop();
                continue;
            }

            if (isOperator(newNode.getElement())){
                stackOperator.push(newNode);
            } else if (isOperand(newNode.getElement())) {
                root = newNode;
                stackOperand.push(newNode);
            }
        }
    }

    private boolean isOperand(String symbol){
        if (symbol.equals("X")){
            return true;
        }
        try {
            Integer.parseInt(symbol);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isOperator(String symbol){
        if (symbol.isBlank() || symbol.isEmpty()){
            return false;
        }
        if (validOperator.contains(symbol))
            return true;

        return false;
    }



    public void displayTree(){
        inorderTraversalTree(root,0);
    }

    private void inorderTraversalTree(Node<String> node, int depth){
        if(node.getLeftChild() != null){
            inorderTraversalTree(node.getLeftChild(),depth+1);
        }

        for(int i = 0;i < depth; i++){
            System.out.print(".");
        }
        System.out.println(node.getElement());

        if(node.getRightChild() != null){
            inorderTraversalTree(node.getRightChild(),depth+1);
        }
    }

    public int evaluate(int xValue){
        return (int)(inorderTraversalEvaluate(xValue ,root));
    }

    private double inorderTraversalEvaluate(int xValue , Node<String> node){

        double leftOperand = 0;
        double rigthOperand = 0;

        if(isOperator(node.getElement())){

            leftOperand = inorderTraversalEvaluate(xValue, node.getLeftChild());

            if(node.getElement().equals("sin") || node.getElement().equals("cos")){
                switch(node.getElement()){
                    case "sin":
                        return Math.sin(Math.toRadians(leftOperand));
                    case "cos":
                        return Math.cos(Math.toRadians(leftOperand));
                }
            }else{
                rigthOperand = inorderTraversalEvaluate(xValue, node.getRightChild());
                switch(node.getElement()){
                    case "*":
                        return leftOperand * rigthOperand;
                    case "+":
                        return leftOperand + rigthOperand;
                    case "-":
                        return leftOperand - rigthOperand;
                }

            }

        }else{
            if(node.getElement().equals("X"))
                return (double)xValue;
            return Double.parseDouble(node.getElement());
        }


        return 0;
    }

    @Override
    public String toString(){
        return inorderTraversalString(root);
    }

    private String inorderTraversalString(Node<String> node){

        String expression = "";

        if(node.getElement().equals("cos") || node.getElement().equals("sin")){
            expression += node.getElement() + " ";
        }

        if(node.getLeftChild() != null){
            expression += inorderTraversalString(node.getLeftChild());
        }

        if(!node.getElement().equals("cos") && !node.getElement().equals("sin")){
            if(isOperator(node.getElement())){
                expression += " " + node.getElement() + " ";
            }else{
                expression += node.getElement();
            }
        }

        if(node.getRightChild() != null){
            expression += inorderTraversalString(node.getRightChild());
        }

        if(isOperator(node.getElement())){
            expression = "( " + expression + " )";
        }

        return expression;
    }
}
