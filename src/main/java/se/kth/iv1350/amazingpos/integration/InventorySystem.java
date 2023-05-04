
package se.kth.iv1350.amazingpos.integration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.kth.iv1350.amazingpos.model.Item;


public class InventorySystem {
    private static Map<String, Integer> stock = new HashMap<>();
    private static Map<String, Item> items = new HashMap<>();

    static {
        // Add items to the inventory system
        items.put("124", new Item("124", "Item 1", 10.0, 0.2));
        items.put("456", new Item("456", "Item 2", 20.0, 0.2));

        // Set the initial stock levels for the items
        stock.put("124", 50);
        stock.put("456", 30);
    }

    public static Item getItemDetails(String itemIdentifier) {
        // Retrieve item details from inventory system
        Item item = items.get(itemIdentifier);
        if (item == null) {
            System.out.println("Invalid item identifier: " + itemIdentifier);
            return null;
        }
        return new Item(item.getItemIdentifier(), item.getItemName(), item.getPrice(), item.getVatRate());
    }

    public static void updateInventory(List<Item> saleItems) {
        for (Item item : saleItems) {
            int currentStock = stock.getOrDefault(item.getItemIdentifier(), 0);
            stock.put(item.getItemIdentifier(), currentStock - item.getSoldQuantity());
        }
    }

    public static int getCurrentStockLevel(String itemIdentifier) {
        return stock.getOrDefault(itemIdentifier, 0);
    }
}
