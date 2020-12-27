package Pizza.PizzaDecorator;

import Pizza.PizzaBase;

public class Onions extends VegetableDecorator {
    public Onions(PizzaBase pizza){
        this.pizza = pizza;
    }

    @Override
    public double price() {
        return this.toppingPrice + pizza.price();
    }

    @Override
    public String getToppingName() {
        return pizza.getToppingName() + ", Onions";
    }
}
