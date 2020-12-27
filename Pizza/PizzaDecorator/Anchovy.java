package Pizza.PizzaDecorator;

import Pizza.PizzaBase;

public class Anchovy extends FishDecorator {
    public Anchovy(PizzaBase pizza){
        this.pizza = pizza;
    }

    @Override
    public double price() {
        return this.toppingPrice + pizza.price();
    }

    @Override
    public String getToppingName() {
        return pizza.getToppingName() + ", Anchovy";
    }
}
