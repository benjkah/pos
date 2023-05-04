package se.kth.iv1350.amazingpos.view;

import java.util.Scanner;

import se.kth.iv1350.amazingpos.controller.Controller;




import java.util.List;
import se.kth.iv1350.amazingpos.integration.DiscountDatabase;

import se.kth.iv1350.amazingpos.model.Item;
import se.kth.iv1350.amazingpos.model.Sale;



import java.util.List;



public class View {

    public static void printReceipt(Sale sale) {
        System.out.println("---------- Receipt ----------");
        for (Item item : sale.getSaleItems()) {
            System.out.println(item.getItemName() + "\t" + item.getPrice() + "\t" + item.getSoldQuantity());
        }
        System.out.println("-----------------------------");
        System.out.println("Total\t" + sale.getTotalAmount());
        if (sale.isDiscounted()) {
            System.out.println("Discount (" + DiscountDatabase.getDiscount(sale.getCustomerIdentification()) + "%)\t" + sale.getDiscountAmount());
        }
        System.out.println("Paid\t" + sale.getPaymentAmount());
        System.out.println("Change\t" + sale.getChangeAmount());
    }
}
