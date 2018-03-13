import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Checkout {

    /**
     * Calculates the cost for a given cart
     * @param SKUs SKUs of the items scanned
     * @param prices A HashMap with the prices of the items with key the SKU and value the Price
     * @return The total cost of the bought items
     */
    public static double calculateCost(ArrayList<String> SKUs, HashMap<String, Price> prices) {
        // We use a HashMap to count the amount of each bought item
        HashMap<String, Integer> boughtItems = new HashMap<String, Integer>();

        for(String SKU : SKUs) {
            boughtItems.put(SKU, boughtItems.getOrDefault(SKU, 0)+1);
        }

        double cost = 0;

        // We calculate the total cost
        for(Map.Entry<String, Integer> item : boughtItems.entrySet()) {
            Price p = prices.get(item.getKey());
            if(p.getSpecialPrice()>0) {
                cost += (item.getValue() / p.getSpecialPriceNumber()) * p.getSpecialPrice() +
                        (item.getValue() % p.getSpecialPriceNumber()) * p.getPrice();
            }
            else {
                cost += item.getValue() * p.getPrice();
            }
        }

        return cost;
    }
}
