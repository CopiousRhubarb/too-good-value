public class TooGood
{
    public static void main(String[] args)
    {
        //Caitlin - Intro content
        System.out.println("Too Good to Go");
        System.out.println("Congradulations! You bought 1 surprise bag from Blackmarket Bakery in Oceanside.");
        System.out.println("Your order was $5.99.");
        System.out.println("Let's figure out how much money you saved.");
        System.out.println("Below is a list of items on the menu. Please select the item number for each item in your surpise bag.");

        //Caitlin - an array of the baked goods you might get in a surprise bag and  an array of their prices
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
        double[] prices = {
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
        final double COST_OF_TGTG = 5.99;
        double amount_saved;

        // Ryan - User input and calculation loop
        do
        {
            for (int i = 0; i < bakedGoods.length; i++)
            {
                System.out.println(i + ". " + bakedGoods[i]);
            }
            choice = UtilityBelt.readInt(
                    "Choose the number corresponding to the baked good you received, or -1 if done: ",
                    -1, 9);
            if (choice >= 0)
            {
                totalValue += prices[choice];
            }
        } while (choice != -1);

        amount_saved = totalValue - COST_OF_TGTG;
        System.out.printf("Too Good To Go costs $%.2f%n", COST_OF_TGTG);
        System.out.printf("You received baked goods with a total value of $%.2f%n", totalValue);
        System.out.printf("You saved $%.2f while preventing unnecessary food waste!", amount_saved);
    }
}
