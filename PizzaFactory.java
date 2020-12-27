import Pizza.*;

public class PizzaFactory {

    public PizzaBase makePizza(String pizzaOption) {
        switch(pizzaOption) {
            case "White Flour Pizza":
                return new WhiteFlour();
            case "Gluten Free Pizza":
                return new GlutenFree();
            default:
                return null;
        }
    }
}












