import java.util.ArrayList;

public class PizzaOrder implements Command{
    private Bill bill;
    private String order;
    private ArrayList<String> cheeseList;
    private ArrayList<String> vegetableList;
    private ArrayList<String> fishList;

    public PizzaOrder(Bill bill, String order, ArrayList<String> cheeseList, ArrayList<String> vegetableList, ArrayList<String> fishList){
        this.bill = bill;
        this.order = order;
        this.cheeseList = cheeseList;
        this.vegetableList = vegetableList;
        this.fishList = fishList;
    }

    public double executeCommand(){
        // calculate pizza order price
        bill.pizzaType = order;
        bill.cheeseList = this.cheeseList;
        bill.vegetableList = this.vegetableList;
        bill.fishList = this.fishList;
        double orderPrice = bill.getOrder("Pizza");

        // send pizza order to kitchen
        kitchen.addOrder(this);
        System.out.println("Pizza order is sent to the kitchen.\n");

        return orderPrice;
    }
}
