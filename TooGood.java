import java.util.Scanner;

public class TooGood
{
    static final double COST_OF_TGTG = 5.99;

    public static void main(String[] args)
    {
        // DECLARATION + INITIALIZATION

        Store[] stores = new Store[3];
        stores[0] = new Store("Bound Coffee Company",
                new MenuItem[]{
                        new MenuItem("Plain Bagel", 5.0, "Bagel"),
                        new MenuItem("Everything Bagel", 5.0, "Bagel"),
                        new MenuItem("Cheddar Everything Bagel", 5.0, "Bagel"),
                        new MenuItem("Cheddar Jalapeno Bagel", 5.0, "Bagel"),
                        new MenuItem("Chocolate Chip Cookie", 3.0, "Cookie"),
                        new MenuItem("Strawberry Lemon Scone", 5.25, "Scone")
                }, 4.99, 15.0);
        stores[1] = new Store("Rose Cafe",
                new MenuItem[]{
                        new MenuItem("Plain Croissant", 5.0, "Croissant"),
                        new MenuItem("Vanilla Bean Stuffed Croissant", 7.25, "Croissant"),
                        new MenuItem("Passion Guava Cream Cheese Stuffed Croissant", 7.25, "Croissant"),
                        new MenuItem("Pistachio Blood Orange Cake", 6.0, "Cake"),
                        new MenuItem("Lemon Tart", 4.0, "Tart"),
                        new MenuItem("Cocoa Quinoa Cookie", 3.5, "Cookie"),
                        new MenuItem("Gluten Free Banana Chocolate Chip Muffin", 5.5, "Muffin"),
                        new MenuItem("Raspberry Shorbread Cookie", 2.0, "Cookie"),
                        new MenuItem("Dirty Chocolate Chip Cookie", 3.5, "Cookie")
                }, 5.99, 18.0);
        stores[2] = new Store("Blackmarket Bakery Oceanside",
                new MenuItem[]{
                        new MenuItem("Plain Croissant", 4.5, "Croissant"),
                        new MenuItem("Almond Croissant", 6.5, "Croissant"),
                        new MenuItem("Ham and Swiss Croissant", 7.0, "Croissant"),
                        new MenuItem("Tomato Provolone Croissant", 5.5, "Croissant"),
                        new MenuItem("Blueberry Scone", 4.8, "Scone"),
                        new MenuItem("Almond Cherry Bar", 5.8, "Bar"),
                        new MenuItem("Cinnamon Sweet Roll", 6.0, "Cinnamon Roll"),
                        new MenuItem("Banana Nut Muffin", 4.3, "Muffin"),
                        new MenuItem("Chocolate Chip Cookie", 4.5, "Cookie"),
                        new MenuItem("Loaf of Bread", 7.0, "Bread")
                }, 5.99, 18);
        Scanner keyboard = new Scanner(System.in);
        int choice;
        Store storeChoice;
        MenuItem[] bag = new MenuItem[10]; // partially filled array
        int bagSize = 0;
        double actualBagValue;

        printIntro();


        System.out.println(formatStores(stores));
        choice = promptStore(stores, keyboard);
        storeChoice = stores[choice];

        do
        {
            System.out.println(storeChoice.formatMenu());
            choice = promptMenu(storeChoice, keyboard);
            if (choice >= 0)
            {
                bag[bagSize] = storeChoice.getMenu()[choice];
                bagSize++;
            }
        } while (choice != -1);

       /* TODO: Calculate category frequency
        Once the bag is complete:

        for each category in MenuItem.ALLOWED_CATEGORIES:
            count = 0
            for each item in bag:
                if item name is equal to category:
                    count++
            print "[category]: [count]"
        */

        System.out.println();
        System.out.println(formatCategoryCount(bag, bagSize));
        System.out.println();

        actualBagValue = calculateActualBagValue(bag, bagSize);
        System.out.printf("The total value of the items you received in the bag: $%.2f%n", actualBagValue);
        System.out.printf("Alleged value of any given surprise bag from %s: $%.2f%n", storeChoice.getName(),
                storeChoice.getAllegedBagValue());

        if (actualBagValue > storeChoice.getAllegedBagValue())
        {
            System.out.printf("What a deal! Your bag was worth $%.2f more than the alleged value listed by %s%n",
                    actualBagValue - storeChoice.getAllegedBagValue(), storeChoice.getName());
        }
        else if (actualBagValue < storeChoice.getAllegedBagValue())
        {
            System.out.printf("Oops! Your bag was actually worth $%.2f less than the alleged value listed by %s%n",
                    storeChoice.getAllegedBagValue() - actualBagValue, storeChoice.getName());
        }
        else
        {
            System.out.printf("Wow! Your bag exactly matches the alleged value listed by %s. What are the chances?!%n",
                    storeChoice.getName());
        }
    }
    public static void printIntro() //CW: removed parameter since now a static variable
    {
        System.out.println();
        System.out.println("Too Good to Go");
        System.out.println();
        System.out.println("Congratulations! You bought a surprise bag! Buying surprise bags helps reduce food waste AND provide you with tasty treats.");
        System.out.println("This app helps you figure out how much money you saved by comparing what you get from the bakery to how much it would cost to buy it all at full price.");
        System.out.println("To begin, please choose which bag you bought today.");
        System.out.println();
   }

//
//        //Caitlin - an array of the baked goods you might get in a surprise bag and an array of their prices
//        String[] bakedGoods = {
//                "Croissant",
//                "Almond Croissant",
//                "Ham and Swiss Croissant",
//                "Tomato Provolone Croissant",
//                "Scone",
//                "Almond Cherry Bar",
//                "Cinnamon Sweet Roll",
//                "Muffin",
//                "Cookie",
//                "Loaf of Bread"
//        };
//        double[] prices = { // Parallel array to bakedGoods, e.g., price of Scone is $4.80
//                4.5,
//                6.5,
//                7.0,
//                5.5,
//                4.8,
//                5.8,
//                6.0,
//                4.3,
//                4.5,
//                7.0
//        };
//        int choice;
//        double totalValue = 0.0;
//        //CW: moved constant to be static
//        //CW: moved amountSaved since only used inside one method, put it there
//
//        //Caitlin - Intro content
//        printIntro();
//
//        // INPUT + CALCULATION
//        // Ryan - User input and calculation loop
//        do
//        {
//            printMenu(bakedGoods);
//
//            choice = 0;
//            // TODO: Refactor the below to use Scanner class directly
////            choice = UtilityBelt.readInt(
////                    "Choose the number corresponding to the baked good you received, or -1 if done: ",
////                    -1, 9);
//            if (choice >= 0)
//            {
//                totalValue += prices[choice];
//            }
//        } while (choice != -1);
//
//
//        // OUTPUT
//        printSavings(totalValue);
//    }
//
//    public static void printSavings(double totalValue) //CW: removed excess variables
//    {
//        double amountSaved = totalValue - COST_OF_TGTG;
//        System.out.println();
//        System.out.printf("Too Good To Go costs $%.2f%n", COST_OF_TGTG);
//        System.out.printf("You received baked goods with a total value of $%.2f%n", totalValue);
//        System.out.printf("You saved $%.2f while preventing unnecessary food waste!", amountSaved);
//    }
// //
//     public static void printIntro() //CW: removed parameter since now a static variable
//     {
//        System.out.println("Too Good to Go");
//        System.out.println("Congratulations! You bought 1 surprise bag from Blackmarket Bakery in Oceanside.");
//        System.out.printf("Your order was $%.2f.%n", COST_OF_TGTG);
//        System.out.println("Let's figure out how much money you saved.");
//        System.out.println("Below is a list of items on the menu. Please select the item number for each item in your surpise bag.");
//        System.out.println();
//    }
// //
//    public static void printMenu(String[] bakedGoods)
//    {
//        String topBorder = String.format("╔%36s╗", " ").replace(" ", "═"); // Pad with whitespace then replace with border
//        String bottomBorder = String.format("╚%36s╝", " ").replace(" ", "═");
//
//        System.out.println(topBorder);
//        for (int i = 0; i < bakedGoods.length; i++)
//        {
//            //System.out.printf("║%-36s║%n", " " + i + ". " + bakedGoods[i]);
//            //CW: could replace concatenation above with the line below
//            System.out.printf("║ %d. %-32s║%n", i, bakedGoods[i]);
//        }
//        System.out.println(bottomBorder);
  //  }

    public static String formatStores(Store[] stores)
    {
        String result = "╔" + "═".repeat(36) + "╗\n";
        for (int i = 0; i < stores.length; i++)
        {
            result += String.format("║%2d │ %-31s║%n", i, stores[i].getName());
        }
        result += "╚" + "═".repeat(36) + "╝\n";
        return result;
    }

    public static int promptStore(Store[] stores, Scanner keyboard)
    {
        int result;

        do
        {
            System.out.print("Please pick a store number: ");
            result = Integer.parseInt(keyboard.nextLine());
        } while (!(result >= 0 && result <= stores.length));

        return result;
    }

    public static int promptMenu(Store store, Scanner keyboard)
    {
        int result;

        do
        {
            System.out.print("Please pick an item number or -1 to finish: ");
            result = Integer.parseInt(keyboard.nextLine());
        } while (!(result >= -1 && result <= store.getMenu().length));

        return result;
    }

    public static String formatCategoryCount(MenuItem[] bag, int bagSize)
    {
        int categoryCount;
        String result = "";

        for (String category : MenuItem.ALLOWED_CATEGORIES)
        {
            categoryCount = 0;
            for (int i = 0; i < bagSize; i++)
            {
                if (bag[i].getCategory().equals(category))
                {
                    categoryCount++;
                }
            }

            if (categoryCount > 0)
            {
                result += String.format("%-15s: %d%n", category, categoryCount);
            }

        }

        return result;
    }

    public static double calculateActualBagValue(MenuItem[] bag, int bagSize)
    {
        double cost = 0.0;

        for (int i = 0; i < bagSize; i++)
        {
            cost += bag[i].getPrice();
        }

        return cost;
    }

}