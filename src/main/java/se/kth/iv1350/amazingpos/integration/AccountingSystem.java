
package se.kth.iv1350.amazingpos.integration;


import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.amazingpos.model.Sale;

public class AccountingSystem {
    public static void logSale(Sale sale) {
        // Log sale in accounting system
        System.out.println("Sale logged in accounting system: " + sale);
    }
}
