import java.util.ArrayList;

// the kitchen holds all the orders. The kitchens logic is not our scope.
public class Kitchen {
    public ArrayList<Command> allOrders = new ArrayList<>();

    public void addOrder(Command cmd){
        allOrders.add(cmd);
    }

    public void makeOrder(int i){
        // implementation of making the order in index i.
    }
    public void removeOrder(int i){
        allOrders.remove(i);
    }
}
