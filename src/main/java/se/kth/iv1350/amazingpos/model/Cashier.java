
package se.kth.iv1350.amazingpos.model;


public class Cashier {
    private double registerAmount;

    public Cashier() {
        this.registerAmount = 0;
    }

    public void increaseRegisterAmount(double amount) {
        this.registerAmount += amount;
    }

    public double getRegisterAmount() {
        return registerAmount;
    }
}
