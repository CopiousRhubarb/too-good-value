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
  -----------------------------------------
  + MenuItem(name : String, cost : double)
  + getName() : String
  + getPrice() : double

  + setName(name : String) : void
  + setPrice(price : double) : void
  + setAll(name : String, price : double) : void
**/ 

public class MenuItem {

    /***** INSTANCE VARIABLES *****/
    private String name;
    private double price;

    /***** CONSTRUCTOR *****/

    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    /***** ACCESSORS *****/

    public getName(){
        this.name = name;
    }

    public getPrice(){
        this.price = price;
    }

    /***** MUTATORS *****/

    public setName(String name){
        this.name = name;
    }

    public setPrice(double price){
        this.price = price;
    }

    public setAll(String name, double price){
        this.name = name;
        this.price = price;
    }
}
