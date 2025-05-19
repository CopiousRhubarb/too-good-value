/**
 * Represents one menu item on the menu in a store
 * Authors: Caitlin Lim, Ryan Moore
 *
 * @version 1.0
 ***/


/**
 * UML CLASS DIAGRAM: MenuItem
 -----------------------------------------
 - name : String
 - price : double
 - category : String
 + CATEGORY_LIST : String[]
 -----------------------------------------
 + MenuItem()
 + MenuItem(name : String, price : double, category : String)
 + getName() : String
 + getPrice() : double
 + getCategory() : String
 + setName(name : String) : void
 + setPrice(price : double) : boolean
 + setCategory(category : String) : boolean
 + setAll(name : String, price : double) : void
 + equals(o : Object) : boolean
 + toString() : String
 **/

public class MenuItem
{

    /***** INSTANCE VARIABLES *****/
    private String name;
    private double price;
    private String category;

    public static String[] ALLOWED_CATEGORIES = new String[]{
            "Bagel","Croissant", "Bread", "Cookie", "Cake", "Scone", "Tart","Muffin", "Bar", "Cinnamon Roll"
    };

    /***** CONSTRUCTOR *****/
    public MenuItem()
    {
        this.setName("Unknown");
        this.setPrice(1.0);
        this.setCategory("Bagel");
    }

    public MenuItem(String name, double price, String category)
    {
        this.setName(name);
        this.setPrice(price);
        this.setCategory(category);
    }

    public MenuItem(MenuItem original)
    {
        if (original != null)
        {
            this.setAll(original.name, original.price, original.category);
        }
        else
        {
            System.err.println("ERROR: attempt to copy null object");
            System.exit(0);
        }
    }
    /***** ACCESSORS *****/

    /**
     * Gets the name of the menuItem
     *
     * @return The name of the menuItem
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the price of the menuItem in USD
     * @return The price of the menuItem in USD
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Gets the category of the item
     *
     * @return the category of the item
     */
    public String getCategory()
    {
        return category;
    }

    /***** MUTATORS *****/

    /**
     * Sets the name of the menuItem
     *
     * @param name The name of the menuItem
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets the price of the menuItem. Error-checking ensures a positive double value
     *
     * @param price The menu price of the menuItem
     */
    public boolean setPrice(double price)
    {
        if (price <= 0.0)
        {
            return false;
        }
        else
        {
            this.price = price;
            return true;
        }
    }

    /**
     * Sets the category of the menuItem. Must exist in ALLOWED_CATEGORIES
     * @param category Category of the menuItem
     * @return boolean indicating whether the set was successful
     */
    public boolean setCategory(String category)
    {
        boolean isValid = false;

        for (String allowedCategory : ALLOWED_CATEGORIES)
        {
            if (category.equals(allowedCategory))
            {
                isValid = true;
                break;
            }
        }
        if (isValid)
        {
            this.category = category;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Sets all fields
     *
     * @param name  Name of the item
     * @param price Price of the item in USD
     */
    public void setAll(String name, double price, String category)
    {
        this.setName(name);
        this.setPrice(price);
        this.setCategory(category);
    }

    /**
     * Required equals method for model-like classes
     * @param o object to be compared
     * @return true if equal, false if not
     */
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return this.getPrice() == menuItem.getPrice() && this.getName().equals(menuItem.getName()) &&
                this.getCategory().equals(menuItem.getCategory());
    }

    public String toString()
    {
        return String.format("Name: %s, Price: $%.2f, Category: %s", this.getName(), this.getPrice(), this.getCategory());
    }
}
