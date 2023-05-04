
package se.kth.iv1350.amazingpos.model;
import java.util.HashMap;
import java.util.Map;

public class Item {
    private String itemIdentifier;
    private String itemName;
    private double price;
    private double vatRate;
    private int soldQuantity;

    public Item(String itemIdentifier, String itemName, double price, double vatRate) {
        this.itemIdentifier = itemIdentifier;
        this.itemName = itemName;
        this.price = price;
        this.vatRate = vatRate;
        this.soldQuantity = 0;
    }

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public double getVatRate() {
        return vatRate;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}

