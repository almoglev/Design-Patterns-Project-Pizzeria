package Payment;

public class PayByCash implements PayingStrategy {
    private double cash;

    public PayByCash(double newCash){
        this.cash=newCash;
    }

    public void pay(double price){
        double change = cash-price;
        System.out.println("Payment received successfully!\nYour change is: "+change+" NIS.\nThank you.");
    }
}
