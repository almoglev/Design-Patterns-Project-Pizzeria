package Pizza.PizzaDecorator;

import Pizza.PizzaBase;

public class Corn extends VegetableDecorator {
    public Corn(PizzaBase pizza){
        this.pizza = pizza;
    }

    @Override
    public double price() {
        return this.toppingPrice + pizza.price();
    }

    @Override
    public String getToppingName() {
        return pizza.getToppingName() + ", Corn";
    }
}
