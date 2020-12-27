package Pizza.PizzaDecorator;

import Pizza.PizzaBase;

public class Olives extends VegetableDecorator {
    public Olives(PizzaBase pizza){
        this.pizza = pizza;
    }

    @Override
    public double price() {
        return this.toppingPrice + pizza.price();
    }

    @Override
    public String getToppingName() {
        return pizza.getToppingName() + ", Olives";
    }
}
