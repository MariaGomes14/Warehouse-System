import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        //Modify the addProduct method so that a new product cannot be added to the product list with the same ID as an existing one.
        if ((findProduct(item.getID()) == null)){
            stock.add(item);
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {/*The delivery method should find the Product with the given ID in the list of products and then call its increaseQuantity method*/
       //Implement the delivery method using a similar approach to that used in numberInStock. 
            // findProduct(id).increaseQuantity(amount);
        Product p = findProduct(id);
            if (p!= null){
                p.increaseQuantity(amount);
            }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {/*The findProduct method should look through the collection for a product whose id field matches the id argument of this method. 
        If a matching product is found, that Product should be returned as the method's result.  If no matching product is found, 
        return null from the method.
        //Implement the findProduct method. This differs from the printProductDetails method in that it will not necessarily have to examine every product
        in the collection before a match is found.  For instance, if the first product in the collection matches the product name, iteration can finish and 
        that first Product returned.  On the other hand, it is possible that there might be no match for the name in the collection. In that case, 
        the whole collection will be examined,
        without finding a product to return.  In this case the null value should be returned.*/
     // Product p =    stock.stream()
                       // .filter(product -> product.getID() == id)
                       // .findFirst().get();
     Product p = null;
        Iterator<Product>it=stock.iterator();
        while(it.hasNext()){
            Product demo = it.next();
            if(demo.getID()==id){
                p=demo;
                break;
            }
        }
     if (p!=null){
         return p;
         
        }
     else{return null;}
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {/*The numberInStock method should locate a product in the collection with a matching ID, and return the current quantity of 
        that product as a method result. If no product with a matching ID is found, return zero.
        return 0; */
        Product p = findProduct(id);
        if (p!= null){
            return p.getQuantity();
        }else{
            return 0;
        }
    
      /*Implement the numberInStock method.  This is relatively simple to implement once the findProduct method has been completed. For instance, 
       * numberInStock can call the findProduct method to do the searching, 
        and then call the getQuantity method on the result. Watch out for products that cannot be found, though.*/
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {//The printProductDetails method should iterate over the list of products and print the result of calling the toString() method on each.//
    /*Implement the printProductDetails method to ensure that you are able to iterate over the collection of Products. 
    //Just print out each product using System.out.  Using an Iterator is
    //the preferred approach, but use an integer index variable if you find that easier to understand. */  
       Iterator<Product>it=stock.iterator();
        while(it.hasNext()){
           Product p=it.next();
           System.out.println(p.toString());
        }
    }
    //Implement a method in StockManager to print details of all products with stock levels below a given value (passed as a parameter to the method).
    //MUST be implemented in functional style (using lambdas and streams).
    public void printDetailsBelowValue(int stockLevel){
        stock.stream()
             .filter(record->record.getQuantity()< stockLevel)
             .forEach(record->System.out.println(record.toString()));
    }
    //Add to StockManager a method that finds a product from its name rather than its ID:
    //public Product findProduct(String name) In order to do this, you need to know that two String objects s1 and s2 can be tested for
    //equality with the Boolean expression: s1.equals(s2)
    public Product findProduct(String name){
        Product p = stock.stream()
                         .filter(record->record.getName().equals(name))
                         .findFirst().get();
        
        if (p!=null){
         return p;
         
        }
        else{return null;}
    }
}
