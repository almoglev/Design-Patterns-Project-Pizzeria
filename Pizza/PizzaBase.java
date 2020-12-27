package Pizza;

public abstract class PizzaBase {
    String description="";

    public abstract double price();

    public String getToppingName(){
        return description;
    }
}
