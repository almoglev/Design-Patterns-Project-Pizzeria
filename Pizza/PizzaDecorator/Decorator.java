package Pizza.PizzaDecorator;
import Pizza.PizzaBase;

public abstract class Decorator extends PizzaBase{
    PizzaBase pizza;

    public abstract String getToppingName();
}
