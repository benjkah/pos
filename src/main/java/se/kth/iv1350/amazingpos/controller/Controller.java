
// Controller class in the controller package
package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.AccountingSystem;
import se.kth.iv1350.amazingpos.integration.DiscountDatabase;
import se.kth.iv1350.amazingpos.integration.InventorySystem;
import se.kth.iv1350.amazingpos.model.Cashier;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.view.View;

public class Controller {
    private final Sale sale;
    private final Cashier cashier;
    private final InventorySystem inventorySystem;
    private final DiscountDatabase discountDatabase;
    private final AccountingSystem accountingSystem;
    private final View view;

    public Controller(Sale sale, Cashier cashier, InventorySystem inventorySystem, DiscountDatabase discountDatabase,
            AccountingSystem accountingSystem, View view) {
        this.sale = sale;
        this.cashier = cashier;
        this.inventorySystem = inventorySystem;
        this.discountDatabase = discountDatabase;
        this.accountingSystem = accountingSystem;
        this.view = view;
    }

    public void addItemToSale(String itemIdentifier, int quantity) {
        sale.addItem(itemIdentifier, quantity);
    }

    public void setPaymentAmount(double paymentAmount) {
        sale.setPaymentAmount(paymentAmount);
    }

    public void applyDiscount() {
        double discountAmount = discountDatabase.getDiscount(sale.getCustomerIdentification());
        if (discountAmount > 0) {
            sale.applyDiscount(discountAmount);
        }
    }

    public void calculateChangeAmount() {
        sale.calculateChangeAmount();
    }

    public void logSale() {
        accountingSystem.logSale(sale);
    }

    public void updateRegisterAmount() {
        cashier.increaseRegisterAmount(sale.getPaymentAmount());
    }

    public void printReceipt() {
        view.printReceipt(sale);
    }

    public void updateInventory() {
        inventorySystem.updateInventory(sale.getSaleItems());
    }
}
