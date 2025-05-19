public class TooGood
{
    static final double COST_OF_TGTG = 5.99;

    public static void main(String[] args)
    {
        // DECLARATION + INITIALIZATION

        //Caitlin - an array of the baked goods you might get in a surprise bag and an array of their prices
        String[] bakedGoods = {
                "Croissant",
                "Almond Croissant",
                "Ham and Swiss Croissant",
                "Tomato Provolone Croissant",
                "Scone",
                "Almond Cherry Bar",
                "Cinnamon Sweet Roll",
                "Muffin",
                "Cookie",
                "Loaf of Bread"
        };
        double[] prices = { // Parallel array to bakedGoods, e.g., price of Scone is $4.80
                4.5,
                6.5,
                7.0,
                5.5,
                4.8,
                5.8,
                6.0,
                4.3,
                4.5,
                7.0
        };
        int choice;
        double totalValue = 0.0;
        //CW: moved constant to be static
        //CW: moved amountSaved since only used inside one method, put it there

        //Caitlin - Intro content
        printIntro();

        // INPUT + CALCULATION
        // Ryan - User input and calculation loop
        do
        {
            printMenu(bakedGoods);

            choice = 0;
            // TODO: Refactor the below to use Scanner class directly
//            choice = UtilityBelt.readInt(
//                    "Choose the number corresponding to the baked good you received, or -1 if done: ",
//                    -1, 9);
            if (choice >= 0)
            {
                totalValue += prices[choice];
            }
        } while (choice != -1);


        // OUTPUT
        printSavings(totalValue);
    }

    public static void printSavings(double totalValue) //CW: removed excess variables
    {
        double amountSaved = totalValue - COST_OF_TGTG;
        System.out.println();
        System.out.printf("Too Good To Go costs $%.2f%n", COST_OF_TGTG);
        System.out.printf("You received baked goods with a total value of $%.2f%n", totalValue);
        System.out.printf("You saved $%.2f while preventing unnecessary food waste!", amountSaved);
    }

    public static void printIntro() //CW: removed parameter since now a static variable
    {
        System.out.println("Too Good to Go");
        System.out.println("Congratulations! You bought 1 surprise bag from Blackmarket Bakery in Oceanside.");
        System.out.printf("Your order was $%.2f.%n", COST_OF_TGTG);
        System.out.println("Let's figure out how much money you saved.");
        System.out.println("Below is a list of items on the menu. Please select the item number for each item in your surpise bag.");
        System.out.println();
    }

    public static void printMenu(String[] bakedGoods)
    {
        String topBorder = String.format("╔%36s╗", " ").replace(" ", "═"); // Pad with whitespace then replace with border
        String bottomBorder = String.format("╚%36s╝", " ").replace(" ", "═");

        System.out.println(topBorder);
        for (int i = 0; i < bakedGoods.length; i++)
        {
            //System.out.printf("║%-36s║%n", " " + i + ". " + bakedGoods[i]);
            //CW: could replace concatenation above with the line below
            System.out.printf("║ %d. %-32s║%n", i, bakedGoods[i]);
        }
        System.out.println(bottomBorder);
    }

}