import java.util.ArrayList;
import java.util.HashMap;

public class Shop {

    public static void main(String[] args) throws Exception {
        HashMap<String, Price> prices = new HashMap<>();

        prices.put("A", new Price(50, 130, 3));
        prices.put("B", new Price(30, 45, 2));
        prices.put("C", new Price(20, 0, 0));
        prices.put("D", new Price(15, 0, 0));

        ArrayList<String> SKUs = new ArrayList<>();

        SKUs.add("A");
        SKUs.add("A");
        SKUs.add("A");
        SKUs.add("B");
        SKUs.add("B");

        double cost = Checkout.calculateCost(SKUs, prices);

        System.out.println(cost);
    }
}
