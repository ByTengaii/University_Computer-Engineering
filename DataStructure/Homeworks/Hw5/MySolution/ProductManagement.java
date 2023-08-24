//Gürkan AĞIR

import java.io.IOException;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.util.*;

public class ProductManagement {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    class Product{
        String name;
        double price;

        Product (String name , double price){
            this.name = name;
            this.price = price;
        }
    }

    //Create a min heap priority queue with Lambda expresion.
    private PriorityQueue<Product> productPriorityQueue = new PriorityQueue<>(Comparator.comparingDouble(product -> product.price));
    //Create a map for checking values for is in there any product at database.
    private Map<String,Product> productMap = new HashMap<>();

    public static void main(String[] args)throws IOException{
        new ProductManagement().start("process.txt");
    }

    /**
     * Take inputs and call the appropriate function for command.
     * @param fileName the name of the file that include the commands.It's need to be in same directory.
     * @throws IOException if it can't  find the file. Throw error
     */
    public void start(String fileName) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines){
            String[] inputs = line.split(" ");
            String command = inputs[0];
            switch (command){
                case "ListMin":
                    listMin();
                    break;
                case "RemoveMin":
                    removeMin();
                    break;
                case "Add":
                    add(inputs[1], Double.parseDouble(inputs[2]));
                    break;
                case "DecreasePrice":
                    decreasePrice(inputs[1], Double.parseDouble(inputs[2]));
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    /**
     * Find and list the product which has the minimum price.
     */
    private void listMin(){
        if (productPriorityQueue.isEmpty()){
            System.out.println("Error, no item added yet.");
        }else{
            Product minProduct = productPriorityQueue.peek();
            System.out.println(minProduct.name + " with price " +decimalFormat.format(minProduct.price) + " listed (without removing).");
        }
    }

    /**
     * This function find minimum value then it will remove it.
     * If min value has more product than one. All of them will be removed.
     */
    private void removeMin(){
        if (productPriorityQueue.isEmpty()){
            System.out.println("Error, no item added yet.");
        }else{
            Product minProduct = productPriorityQueue.poll();
            productMap.remove(minProduct.name);
            System.out.println(minProduct.name + " is removed since it has the min price.");
            while(!productPriorityQueue.isEmpty() && productPriorityQueue.peek().price == minProduct.price){
                minProduct = productPriorityQueue.poll();
                productMap.remove(minProduct.name);
                System.out.println(minProduct.name + " is removed since it has the min price");
            }
        }
    }

    /**
     * You can't add the product that already in database.
     * Just new products.
     * Create a product object then add to PriorityQueue & Map
     * @param productName
     * @param price
     *
     * */
    private void add(String productName, double price){
        if (productMap.containsKey(productName)){
            System.out.println("Error, product with the same name already exists.");
        }else{
            Product product = new Product(productName,price);
            productPriorityQueue.add(product);
            productMap.put(productName,product);
            System.out.println(productName + " with price " + decimalFormat.format(price) +" added.");
        }
    }

    /**
     * If product it has not been existed the function will throw error message.
     * If it is, first remove the product which has old price from database,
     * update price of the price object then put it again to database.
     *
     * @param productName
     * @param decreaseAmount
     */
    private void decreasePrice(String productName, double decreaseAmount){
        if ( !productMap.containsKey(productName)){
            System.out.println("Error, no item added yet.");
        }else{
            Product product = productMap.get(productName);
            productPriorityQueue.remove(product);
            product.price -= decreaseAmount;
            productPriorityQueue.add(product);
            System.out.println(productName + "'s price decreased by " + decreaseAmount + " (making it "+decimalFormat.format(product.price)+")");
        }
    }
}
