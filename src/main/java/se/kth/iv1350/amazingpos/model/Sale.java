package se.kth.iv1350.amazingpos.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import se.kth.iv1350.amazingpos.integration.DiscountDatabase;
import se.kth.iv1350.amazingpos.integration.InventorySystem;

public class Sale {
    private List<Item> saleItems;
    private double totalAmount;
    private double paymentAmount;
    private double changeAmount;
    private boolean isDiscounted;
    private String customerIdentification;

    public Sale(String customerIdentification) {
        this.saleItems = new ArrayList<>();
        this.totalAmount = 0;
        this.paymentAmount = 0;
        this.changeAmount = 0;
        this.isDiscounted = false;
        this.customerIdentification = customerIdentification;
    }

    public void addItem(String itemIdentifier, int quantity) {
        // Retrieve item details from inventory system
        Item item = InventorySystem.getItemDetails(itemIdentifier);
        if (item == null) {
            System.out.println("Invalid item identifier: " + itemIdentifier);
            return;
        }
    
        // Check if item is in stock
        int currentStock = InventorySystem.getCurrentStockLevel(itemIdentifier);
        if (currentStock < quantity) {
            System.out.println("Item not in stock: " + item.getItemName());
            return;
        }
    
        // Check if item is already added to sale
        Item existingItem = this.saleItems.stream()
                .filter(i -> i.getItemIdentifier().equals(itemIdentifier))
                .findFirst()
                .orElse(null);
        if (existingItem != null) {
            existingItem.setSoldQuantity(existingItem.getSoldQuantity() + quantity);
        } else {
            item.setSoldQuantity(quantity);
            this.saleItems.add(item);
        }
    
        // Calculate total amount
        this.calculateTotalAmount();
    }
    
    void calculateTotalAmount() {
        double total = 0;
        for (Item item : this.saleItems) {
            double itemTotal = item.getPrice() * item.getSoldQuantity();
            double vatAmount = itemTotal * item.getVatRate();
            total += itemTotal + vatAmount;
        }
        this.totalAmount = total;
    }

    public void applyDiscount(double discountAmount) {
        // Apply discount to total amount
        this.totalAmount -= discountAmount;
        this.isDiscounted = true;
    }

    public void calculateChangeAmount() {
        this.changeAmount = this.paymentAmount - this.totalAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public List<Item> getSaleItems() {
        return saleItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public double getChangeAmount() {
        return changeAmount;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public String getCustomerIdentification() {
        return customerIdentification;
    }
    
    public double getDiscountAmount() {
        double discountAmount = DiscountDatabase.getDiscount(this.getCustomerIdentification());
        if (discountAmount > 0) {
            return (this.totalAmount * discountAmount) / 100;
        }
        return 0;
    }

    public void addItemToSale(String string, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}