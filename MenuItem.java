/**
 * Represents one menu item on the menu in a store
 * Authors: Caitlin Lim, Ryan Moore
 * @version  1.0
 ***/

 /**
  * UML CLASS DIAGRAM: MenuItem
  -----------------------------------------
  - name : String
  - price : double
  - itemNumber : int
  -----------------------------------------
  + MenuItem(name : String, cost : double)
  + getName() : String
  + getPrice() : double
  + getItemNumber() : int

  + setName(name : String) : void
  + setPrice(price : double) : void
  + setItemNumber(itemNumber : int) : void
  + setAll(name : String, price : double, itemNumber : int) : void
**/ 

public class MenuItem {

    /***** INSTANCE VARIABLES *****/
    private String name;
    private double price;
    private int itemNumber;

    /***** CONSTRUCTOR *****/
    // No argument constructor assigns default values for each instance variable
    public MenuItem(String name, double price, int itemNumber){
        this.name = name;
        this.price = price;
        this.itemNumber = itemNumber;
    }

    /***** ACCESSORS *****/

     // @return String representing name to the get function
    public String getName(){
        this.name = name;
    }

     // @return double representing price to the get function
    public double getPrice(){
        this.price = price;
    }

     // @return int representing itemNumber to the get function
     public int getItemNumber(){
        this.itemNumber = itemNumber;
    }

    /***** MUTATORS *****/

    //sets the name to the set function @param name is valid and exists
    public setName(String name){
        this.name = name;
    }

    //sets the price to the set function @param price is valid and exists
    public setPrice(double price){
        this.price = price;
    }

    //sets the itemNumber to the set function @param itemNumber is valid and exists 
    public setItemNumber(int itemNumber){
        this.itemNumber = itemNumber;
    }
    
    /* sets all data for the object
     * @param name String is representing item name is valid and exists
     * @param price double represents the listed full price of an item is valid and exists
     * @param itemNumber int represents the position on the menu is valid and exists
     */
    public setAll(String name, double price, int itemNumber){
        this.name = name;
        this.price = price;
        this.itemNumber = itemNumber;
    }
}
