import org.junit.Test;
import org.junit.Test.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    @Test
    public void calculateCost() throws Exception {
        HashMap<String, Price> prices = new HashMap<String, Price>();

        prices.put("A", new Price(50, 130, 3));
        prices.put("B", new Price(30, 45, 2));
        prices.put("C", new Price(20, 0, 0));
        prices.put("D", new Price(15, 0, 0));

        ArrayList<String> SKUs = new ArrayList<String>(); // Cart: {}

        double cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(0, cost, 0.001);
        System.out.println(cost);

        SKUs.add("A"); // Cart : {A}
        cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(50, cost, 0.001);
        System.out.println(cost);

        SKUs.add("B"); // Cart: {A, B}
        cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(80, cost, 0.001);
        System.out.println(cost);

        SKUs.add("A");
        SKUs.add("A"); // Cart: {A, B, A, A}
        cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(160, cost, 0.001);
        System.out.println(cost);

        SKUs.add("B"); // Cart: {A, B, A, A, B}
        cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(175, cost, 0.001);
        System.out.println(cost);
    }
}