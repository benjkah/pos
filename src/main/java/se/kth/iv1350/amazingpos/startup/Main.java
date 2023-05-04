// Main class in the startup package
package se.kth.iv1350.amazingpos.startup;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.AccountingSystem;
import se.kth.iv1350.amazingpos.integration.DiscountDatabase;
import se.kth.iv1350.amazingpos.integration.InventorySystem;
import se.kth.iv1350.amazingpos.model.Cashier;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.view.View;

public class Main {
    public static void main(String[] args) {
        AccountingSystem accountingSystem = new AccountingSystem();
        DiscountDatabase discountDatabase = new DiscountDatabase();
        InventorySystem inventorySystem = new InventorySystem();
        Cashier cashier = new Cashier();
        View view = new View();
        Sale sale = new Sale("12346");
        Controller controller = new Controller(sale, cashier, inventorySystem, discountDatabase, accountingSystem, view);
        controller.addItemToSale("124", 2);
        controller.addItemToSale("456", 1);
        double paymentAmount = 25.0;
        controller.setPaymentAmount(paymentAmount);
        controller.applyDiscount();
        controller.calculateChangeAmount();
        controller.logSale();
        controller.updateRegisterAmount();
        controller.printReceipt();
        controller.updateInventory();
    }
}
