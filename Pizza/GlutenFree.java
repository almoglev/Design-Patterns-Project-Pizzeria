package Pizza;

public class GlutenFree extends PizzaBase {
    public GlutenFree(){
        description = "Gluten Free Pizza";
    }

    @Override
    public double price() {
        return 40;
    }
}
