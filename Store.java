// Bound Coffee Company
//   $15 value, $4.99 surprise bag
//   2110 S Coash Hwy suite c, Oceanside, Ca, 92054
//   About - (empty)
//   2 years
//   500+ meals saved
//   What you could get: bread & passtries
//   Overall experience based on 85 recent reviews 4.8 stars, pickup experience 5.0, food quality 4.7,
//   variety of contents 4.3, food quantitiy 4.8
//   menu: bagel $5, cookie $3, cinnamon roll $5.25, scone $5.25

// Rose Cafe
//     $18 value, 5.99 surprise bag
//   1902 s coast hwy, oceanside, ca, 92054
//   About - welcome to rose care, a cozy cafe and lounge in Oceanside, Ca. Our cozy spot is a hidden gem fueled by our
//   passion for serving delightful twists on classif favortites. From the moment you step through our doors , you'll
//   feel the warmth and care that goes into every aspect of oue cafe.
//   6 months
//   500+ meals saved
//   what you could get: bread & pastries
//   overall experience based on 218 recent reviews 4.8 stars, pickup experience 4.9, food quality 4.9, variety of
//   contents 4.8 food quantity 4.8
// menu: Croissant $5, Vanilla bean stuffed croissant $7.25, Passion Guava cream cheese stuffed croissant $7.25,
// evoo pistachio blood orange cake $6, lemon tart $4, cocoa quinoa cookie $3.5, gf banana chocolate chip muffin $5.5,
// raspberry shortbread cookie $2, dirty chocolate chip cooke $3.5

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
 *
 * @version 1.0
 ***/


/**
 * UML CLASS DIAGRAM: Store
 * -----------------------------------------
 * - name : String
 * - menu : MenuItem[]
 * - surpriseBagCost : double
 * - allegedBagValue : double
 * -----------------------------------------
 * + Store(name : String, menu : MenuItem[], surpriseBagCost : double,  allegedBagValue : double)
 * + getName() : String
 * + getMenu() : MenuItem[]
 * + getSurpriseBagCost() : double
 * + getAllegedBagValue() : double
 * + setName(name : String) : void
 * + setMenu(menu : MenuItem[]) : boolean
 * + setSurpriseBagCost(surpriseBagCost : double) : boolean
 * + setAllegedBagValue(allegedBagValue : double) : boolean
 * + setAll(name : String, menu : MenuItem[], surpriseBagCost : double, allegedBagValue : double) : void
 * + equals(other : Object) : boolean
 * + toString() : String
 * - copyMenu(original : MenuItem[]) : MenuItem[]
 */

public class Store
{
    /***** INSTANCE VARIABLES *****/

    private String name;
    private MenuItem[] menu;
    private double surpriseBagCost;
    private double allegedBagValue;
    static String DEFAULT_NAME = "Unknown";
    static MenuItem[] DEFAULT_MENU = new MenuItem[]{new MenuItem()};
    static double DEFAULT_ALLEGED_BAG_VALUE = 10.0;
    static double DEFAULT_SURPRISE_BAG_COST = 1.0;

    /***** CONSTRUCTOR *****/

    /**
     * Default (no-argument) constructor
     */
    public Store()
    {
        this.name = DEFAULT_NAME;
        this.menu = Store.copyMenu(DEFAULT_MENU);
        this.allegedBagValue = DEFAULT_ALLEGED_BAG_VALUE;
        this.surpriseBagCost = DEFAULT_SURPRISE_BAG_COST;
    }

    /**
     * Full constructor
     *
     * @param name            Name of the store
     * @param menu            Array of MenuItems that items on the store's menu
     * @param surpriseBagCost Actual cost of a surprise bag from this store
     * @param allegedBagValue Alleged value of a surprise bag from this store
     */
    public Store(String name, MenuItem[] menu, double surpriseBagCost, double allegedBagValue)
    {
        this.setName(name);
        this.setMenu(menu);
        this.setSurpriseBagCost(surpriseBagCost);
        this.setAllegedBagValue(allegedBagValue);
    }

    /**
     * Copy constructor
     *
     * @param original Original store object
     */
    public Store(Store original)
    {
        if (original != null)
        {
            this.setName(original.getName());
            this.setMenu(original.getMenu());
            this.setSurpriseBagCost(original.getSurpriseBagCost());
            this.setAllegedBagValue(original.getAllegedBagValue());
        }
        else
        {
            System.err.println("ERROR: attempt to copy null object");
            System.exit(0);
        }
    }

    /***** ACCESSORS *****/

    /**
     * Gets the name of the store
     *
     * @return The name of the store
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Gets the actual cost of a surprise bag from the given store
     *
     * @return The actual cost of a surprise bag from the given store
     */
    public double getSurpriseBagCost()
    {
        return this.surpriseBagCost;
    }

    /**
     * Gets the alleged value of a surprise bag from the given store
     *
     * @return The alleged value of a surprise bag from the store
     */
    public double getAllegedBagValue()
    {
        return this.allegedBagValue;
    }

    /**
     * Gets the menu. Returns a deep copy since field is a mutable object
     *
     * @return Deep copy of the menu of the store
     */
    public MenuItem[] getMenu()
    {
        return this.copyMenu(this.menu);
    }

    /***** MUTATORS *****/

    /**
     * Sets the name of the store
     *
     * @param name Name of the store
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets the menu for the store. Checks for null array, and null inner objects.
     *
     * @param menu Items available in a surprise bag
     * @return boolean indicating whether set was successful
     */
    public boolean setMenu(MenuItem[] menu)
    {
        if (menu == null)
        {
            return false;
        }
        for (MenuItem item : menu)
        {
            if (item == null)
            {
                return false;
            }
        }
        this.menu = copyMenu(menu);
        return true;
    }

    /**
     * Sets the actual cost of the surprise bag. Checks for positive value.
     *
     * @param surpriseBagCost Actual cost in USD of bag
     * @return boolean indicating whether set was successful
     */
    public boolean setSurpriseBagCost(double surpriseBagCost)
    {
        if (surpriseBagCost > 0.0)
        {
            this.surpriseBagCost = surpriseBagCost;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Sets the alleged value of the bag. Checks that the value is greater than 0
     *
     * @param allegedBagValue Alleged value of bag in USD
     * @return boolean indicating whether set was successful
     */
    public boolean setAllegedBagValue(double allegedBagValue)
    {
        if (allegedBagValue > 0.0)
        {
            this.allegedBagValue = allegedBagValue;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Sets all data for the Store
     *
     * @param name            Name of the store
     * @param menu            Menu of items for the store
     * @param surpriseBagCost Actual cost of a surprise bag from the store
     * @param allegedBagValue Alleged value of a surprise bag from the store
     */
    public void setAll(String name, MenuItem[] menu, double surpriseBagCost, double allegedBagValue)
    {
        this.setName(name);
        this.setMenu(menu);
        this.setSurpriseBagCost(surpriseBagCost);
        this.setAllegedBagValue(allegedBagValue);
    }

    /**
     * Required equals method for model-like classes
     *
     * @param o Object to be compared
     * @return true for else and false for otherwise
     */
    public boolean equals(Object o)
    {
        boolean equalMenus = true;

        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        for (int i = 0; i < store.getMenu().length; i++) // Check each element of the array
        {
            if (!this.getMenu()[i].equals(store.getMenu()[i]))
            {
                return false;
            }
        }
        return this.getSurpriseBagCost() == store.getSurpriseBagCost() // menu was checked above
                && this.getAllegedBagValue() == store.getAllegedBagValue()
                && this.getName().equals(store.getName());
    }

    public String toString()
    {
        String result = "";
        result += String.format("Name: %s%nMenu:%n", this.getName());
        for (MenuItem item : this.getMenu())
        {
            result += String.format("  %s%n", item);
        }
        result += String.format("Surprise Bag Cost: %s%nAlleged Bag Value: %s", surpriseBagCost, allegedBagValue);
        return result;
    }

    public String formatMenu()
    {
        String result = "╔" + "═".repeat(72) + "╗\n";
        result += String.format("║%36s%36s║%n", this.getName(),"");
        result += "╠" + "═".repeat(72) + "╣\n";

        for (int i = 0; i < this.getMenu().length; i++)
        {
            result += String.format("║%2d │ %-67s║%n", i, this.getMenu()[i].getName());
        }
        result += "╚" + "═".repeat(72) + "╝\n";

        return result;
    }

    /**
     * Helper method since the menu instance variable is a mutable object and thus requires a deep copy
     *
     * @param original Original MenuItem array
     * @return duplicate of original with unique reference
     */
    private static MenuItem[] copyMenu(MenuItem[] original)
    {
        MenuItem[] copy = new MenuItem[original.length];
        for (int i = 0; i < original.length; i++)
        {
            copy[i] = new MenuItem(original[i]);
        }
        return copy;
    }

}