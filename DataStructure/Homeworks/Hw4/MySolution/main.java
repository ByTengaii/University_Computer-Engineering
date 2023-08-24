//Gürkan AĞIR

public class main {
    
    public static void main(String[] args) {


        int xValue = 12;

        // Test 1
        ExpressionTree expression = new ExpressionTree("( ( cos ( X * 2 ) ) + ( 5 * 7 ) )");

        // Test 2
        //ExpressionTree expression = new ExpressionTree("( ( sin ( 25 + 5 ) * ( 7 + 2 ) ) )");

        // Test 3
        //ExpressionTree expression = new ExpressionTree("( ( 5 * 7 ) + X )");

        // Test 4
        //ExpressionTree expression = new ExpressionTree("( ( cos ( X * 2 ) ) - ( sin ( X * 2 ) ) )");

        // Test 5
        //ExpressionTree expression = new ExpressionTree("( ( ( sin ( 45 * X ) ) + ( 4 * X ) ) + ( 5 + ( X * X ) ) )");



        System.out.println("\nDot Tree of Expression:\n--------------------");
        expression.displayTree();

        System.out.println("\nExpression:\n--------------------\n" + expression);

        System.out.println("\nResult of Expression:\n--------------------\n" + expression.evaluate(xValue));
    }
}
