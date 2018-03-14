import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutTest {

    private HashMap<String, Price> prices;

    @BeforeEach
    void init() throws Exception {
        prices = new HashMap<>();
        prices.put("A", new Price(50, 130, 3));
        prices.put("B", new Price(30, 45, 2));
        prices.put("C", new Price(20, 0, 0));
    }

    @Test
    void emptyCart() throws Exception {
        ArrayList<String> SKUs = new ArrayList<>();
        double cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(0, cost, 0.001);
    }

    @Test
    void oneItem() throws Exception {
        ArrayList<String> SKUs = new ArrayList<>();
        SKUs.add("A");
        double cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(50, cost, 0.001);
    }

    @Test
    void twoItems() throws Exception {
        ArrayList<String> SKUs = new ArrayList<>();
        SKUs.add("A");
        SKUs.add("B");
        double cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(80, cost, 0.001);
    }

    @Test
    void specialPrices() throws Exception {
        ArrayList<String> SKUs = new ArrayList<>();
        SKUs.add("A");
        SKUs.add("B");
        SKUs.add("A");
        SKUs.add("A");
        SKUs.add("B");
        SKUs.add("C");
        double cost = Checkout.calculateCost(SKUs, prices);
        assertEquals(195, cost, 0.001);
    }

    @Test
    void noRuleFound() {
        ArrayList<String> SKUs = new ArrayList<>();
        SKUs.add("A");
        SKUs.add("B");
        SKUs.add("D");
        assertThrows(Exception.class, ()->{Checkout.calculateCost(SKUs, prices);});
    }
}