
package se.kth.iv1350.amazingpos.integration;

import java.util.HashMap;
import java.util.Map;


public class DiscountDatabase {
    private static Map<String, Double> discounts = new HashMap<>();

    static {
        discounts.put("12346", 4.0);
        discounts.put("67890", 5.0);
    }

    public static double getDiscount(String customerIdentification) {
        // Retrieve discount from discount database
        // This is just a stub method and would need to be implemented with real functionality
        return discounts.getOrDefault(customerIdentification, 0.0);
    }
}
