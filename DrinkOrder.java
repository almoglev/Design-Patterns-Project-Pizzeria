
public class DrinkOrder implements Command{
    Bill bill;
    String order;

    public DrinkOrder(Bill bill, String order){
        this.bill = bill;
        this.order= order;
    }

    @Override
    public double executeCommand(){
        // calculate drink order price
        bill.drinkType = order;
        double orderPrice = bill.getOrder("Drinks");

        // send drink order to kitchen
        kitchen.addOrder(this);
        System.out.println("Drink order is sent to the kitchen.\n");

        return orderPrice;
    }
}














