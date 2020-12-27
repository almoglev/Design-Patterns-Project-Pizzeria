package Pizza.PizzaDecorator;

import Pizza.PizzaBase;

public class Tuna extends FishDecorator {
    public Tuna(PizzaBase pizza){
        this.pizza = pizza;
    }

    @Override
    public double price() {
        return this.toppingPrice + pizza.price();
    }

    @Override
    public String getToppingName() {
        return pizza.getToppingName() + ", Tuna";
    }
}
