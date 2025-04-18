public class TooGood
{
    public static void main(String[] args)
    {
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

        do
        {
            for (int i = 0; i < bakedGoods.length; i++)
            {
                System.out.println(i + ". " + bakedGoods[i]);
            }
            choice = UtilityBelt.readInt(
                    "Choose the number corresponding to the baked good you received, or -1 if done: ",
                    -1, 9);
            totalValue += prices[choice];
        } while (choice != -1);

        System.out.printf("$%.2f",totalValue);
    }
}
