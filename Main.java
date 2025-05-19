/**
 * AUTHORS: Ryan Moore & Caitlin Lim
 *
 * Tests all methods of the Store and MenuItem classes
 */
public class Main
{
    public static void main(String[] args)
    {
        /*** DECLARATION ***/
        MenuItem[] menu = new MenuItem[7];
        Store[] stores = new Store[8];

        System.out.println("Testing Constructors & toString");

        menu[0] = new MenuItem(); // test default constructor
        menu[1] = new MenuItem();
        menu[2] = new MenuItem("Everything Bagel", 5.0, "Bagel");
//        menu[3] = new MenuItem(menu[6]); // throws "ERROR: attempt to copy null object"
        menu[3] = new MenuItem(menu[2]);
        menu[4] = new MenuItem(menu[2]);
        menu[5] = new MenuItem(menu[2]);

        stores[0] = new Store(); // test default constructor
        stores[1] = new Store();
        stores[2] = new Store("Rose Cafe", new MenuItem[]{
                new MenuItem("Regular croissant", 5.0, "Croissant"),
                new MenuItem("Vanilla bean stuffed croissant", 7.25, "Croissant"),
                new MenuItem("Pistachio blood orange cake", 6.0, "Cake")},
                5.99, 18.00);
//        stores[3] = new Store(stores[7]); // throws ERROR: attempt to copy null object
        stores[3] = new Store(stores[2]);
        stores[4] = new Store(stores[2]);
        stores[5] = new Store(stores[2]);
        stores[6] = new Store(stores[2]);

        displayMenu(menu);
        System.out.println();
        displayStores(stores);

        /* Test setters and getters */

        System.out.println("\n Testing setters & getters");

        System.out.println("\n MenuItem test\n");

        menu[3].setName("Guava and custard filled croissant");
        System.out.println("Name: " + menu[3].getName());

        menu[4].setPrice(4.0);
        System.out.println("Price: " + menu[4].getPrice());

        menu[5].setCategory("Cookie");
        System.out.println("Category: " + menu[4].getCategory());

        menu[0].setAll("Everything Bagel", 5.0, "Bagel");
        System.out.println("All data: " + menu[0].toString());

        System.out.println("\n Store test\n");

        stores[3].setName("Black Market Bakery");
        System.out.println("Name: " + stores[3].getName());


        stores[4].setMenu(new MenuItem[]{new MenuItem("Regular croissant", 4.5, "Croissant"),
                new MenuItem("Chocolate chip cookie", 4.5, "Cookie"),
                new MenuItem("Loaf of Rosemary Bread", 7.0, "Bread")});
        System.out.println("Menu: ");
        for (MenuItem item : stores[4].getMenu())
        {
            System.out.printf("  %s%n", item.toString());
        }

        stores[5].setAllegedBagValue(30.0);
        System.out.println("Alleged Bag Value: " + stores[5].getAllegedBagValue());

        stores[6].setSurpriseBagCost(7.99);
        System.out.println("Surprise Bag Cost: " + stores[6].getSurpriseBagCost());

        stores[0].setAll("Rose Cafe", new MenuItem[]{
                new MenuItem("Regular croissant", 5.0, "Croissant"),
                new MenuItem("Vanilla bean stuffed croissant", 7.25, "Croissant"),
                new MenuItem("Pistachio blood orange cake", 6.0, "Cake")},
                5.99, 18.00);
        /* Testing deep copy */

        System.out.println("Testing deep copy");
        System.out.println("\n MenuItem test\n");
        System.out.println("Note: menu[2] should not have changed");

        displayMenu(menu);

        System.out.println("\n Store test\n");
        System.out.println("Note: stores[2] should not have changed");

        displayStores(stores);

        /* Testing equals */

        System.out.println("Testing equals");
        System.out.println("\n MenuItem test\n");

        System.out.println("Note: menu[0] should equal itself and menu[2]. All others are unequal");
        for (int i = 0; i < menu.length; i++)
        {
            System.out.printf("menu[%d] == menu[%d] is %b%n", 0, i, menu[0].equals(menu[i]));
        }

        System.out.println("\n Store test\n");
        for (int i = 0; i < stores.length; i++)
        {
            System.out.printf("stores[%d] == stores[%d] is %b%n", 0, i, stores[0].equals(stores[i]));
        }
    }

    public static void displayMenu(MenuItem... menu)
    {
        for (int i = 0; i < menu.length; i++)
        {
            if (menu[i] != null)
            {
                System.out.printf("menu[%d] is %s%n", i, menu[i].toString());
            }
            else
            {
                System.out.printf("menu[%d] is null%n", i);
            }
        }
        System.out.println();
    }

    public static void displayStores(Store... stores)
    {
        for (int i = 0; i < stores.length; i++)
        {
            if (stores[i] != null)
            {
                System.out.printf("stores[%d] is %s%n", i, stores[i].toString());
            }
            else
            {
                System.out.printf("stores[%d] is null", i);
            }
        }
        System.out.println();
    }
}
