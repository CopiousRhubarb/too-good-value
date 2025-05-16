// Bound Coffee Company
//   $15 value, $4.99 surprise bag
//   2110 S Coash Hwy suite c, Oceanside, Ca, 92054
//   About - (empty)
//   2 years
//   500+ meals saved
//   What you could get: bread & passtries
//   Overall experience based on 85 recent reviews 4.8 stars, pickup experience 5.0, food quality 4.7, variety of contents 4.3, food quantitiy 4.8
//   menu: bagel $5, cookie $3, cinnamon roll $5.25, scone $5.25

// Rose Cafe
//     $18 value, 5.99 surprise bag
//   1902 s coast hwy, oceanside, ca, 92054
//   About - welcome to rose care, a cozy cafe and lounge in Oceanside, Ca. Our cozy spot is a hidden gem fueled by our passion for serving delightful twists on classif favortites. From the moment you step through our doors , you'll feel the warmth and care that goes into every aspect of oue cafe. 
//   6 months
//   500+ meals saved
//   what you could get: bread & pastries
//   overall experience based on 218 recent reviews 4.8 stars, pickup experience 4.9, food quality 4.9, variety of contents 4.8 food quantity 4.8 
// menu: Croissant $5, Vanilla bean stuffed croissant $7.25, Passion Guava cream cheese stuffed croissant $7.25, evoo pistachio blood orange cake $6, lemon tart $4, cocoa quinoa cookie $3.5, gf banana chocolate chip muffin $5.5, raspberry shortbread cookie $2, dirty chocolate chip cooke $3.5

//   Blackmarket Bakery Oceanside
//   $18 value, $5.99 surprise bag
//   510 vista way, oceanside, ca, 92054
//   About - empty
//   1 year
//   500+ meals saved
//   what you could get: bread & pastries
//     overall experience based on 218 recent reviews 4.9 stars, pickup experience 5.0, food quality 5.0, variety of contents 4.9 food quantity 4.9
// menu: croissant $4.5, almond croissant $6.5, ham and swiss croissant $7.0, tomato provolone croissant $5.5, Scone $4.8, Almond Cherry Bar $5.8, Cinnamon Sweet Roll $6.0, Muffin $4.3, Cookie $4.5, Loaf of Bread $7.0


/**
 * Represents one store selling food on the too good to go app
 * Authors: Caitlin Lim, Ryan Moore
 * @version  1.0
 ***/

 /**
  * UML CLASS DIAGRAM: Store
  -----------------------------------------
  - name : String
  - menu : MenuItem[]
  - surpriseBagCost : double
  - allegedBagValue : int  
  -----------------------------------------
  + Store(name : String, menu : MenuItem[], surpriseBagCost : double,  allegedBagValue : int)
  + getName() : String
  + getMenu() : MenuItem[]
  + getSurpriseBagCost() : double
  + getAllegedBagValue() : int

  + setName(name : String) : void
  + setMenu(MenuItem[]) : void
  + setSurpriseBagCost(surpriseBagCost : double) : boolean
  + setAllegedBagValue(allegedBagValue : int) : boolean
  + setAll(name : String, menu : MenuItem[], surpriseBagCost : double, allegedBagValue : int) : void
**/  

public class Store
{
    /***** INSTANCE VARIABLES *****/

    private String name;
    private MenuItem[] menu;
    private double surpriseBagCost;
    private int allegedBagValue;

    /***** CONSTRUCTOR *****/
    public Store(String name, MenuItem[] menu, double surpriseBagCost, int allegedBagValue) {
        this.name = name;
        this.menu = menu;
        this.surpriseBagCost = surpriseBagCost;
        this.allegedBagValue = allegedBagValue;
    }
    
    /***** ACCESSORS *****/

    // @return string representing name to the get function
    public String getName(){
        return this.name;
    }

    // @return double representing surpriseBagCost to the get function
    public double getSurpriseBagCost(){
        return this.surpriseBagCost;
    }

     // @return int representing allegedBagValue to the get function
    public int getAllegedBagValue(){
        return this.allegedBagValue;
    }

    // @return array representing menu to the get function
    public MenuItem[] getMenu() {
        return menu;
    }

    /***** MUTATORS *****/

    //sets the name to the set function @param name is valid and exists
    public void setName(String name){
        this.name = name;
    }

    // DELETE THIS AFTER READING - Used chatGPT to write this one
    //sets the menu to the set function @param MenuItem[] is valid and exists
    public void setMenu(MenuItem[] menu) {
        if (menu != null) {
            this.menu = new MenuItem[menu.length];
            for (int i = 0; i < menu.length; i++) {
                this.menu[i] = menu[i]; // Or use a deep copy if MenuItem is mutable
            }
        } else {
            this.menu = new MenuItem[0]; // or null, depending on your design choice
        }
    }

    //sets the surpriseBagCost to the set function @param surpriseBagCost is valid and exists
    public void setSurpriseBagCost(double surpriseBagCost){
        this.surpriseBagCost = surpriseBagCost;
    }

    //sets the allegedBagValue to the set function @param allegedBagValue is valid and exists
    public void setAllegedBagValue(int allegedBagValue){
        this.allegedBagValue = allegedBagValue;
    }

    // DELETE THIS AFTER READING - Used chatGPT to write this
    /*sets all data for the object
    @param name String is representing store name is valid and exists
    @param menu MenuItem[] array of menuItems representing items that could be in surprise bad is valid and exists
    @param surpriseBagCost double repesenting how much the user paid for the surprise bag is valid and exists
    @param allegedBagValue int given by the app representing how much the surprise bag should cost if bought at full price
    **/
    public void setAll(String name, MenuItem[] menu, double surpriseBagCost, int allegedBagValue) {
        this.name = name;
        this.surpriseBagCost = surpriseBagCost;
        this.allegedBagValue = allegedBagValue;
    
        if (menu != null) {
            this.menu = new MenuItem[menu.length];
            for (int i = 0; i < menu.length; i++) {
                this.menu[i] = menu[i]; // consider deep copy if MenuItem is mutable
            }
        } else {
            this.menu = new MenuItem[0]; // or null, depending on design
        }
    }
}