package Pizza.PizzaDecorator;

import Pizza.PizzaBase;

public class FetaCheese extends CheeseDecorator {
    public FetaCheese(PizzaBase pizza){
        this.pizza = pizza;
    }

    @Override
    public double price() {
        return this.toppingPrice + pizza.price();
    }

    @Override
    public String getToppingName() {
        return pizza.getToppingName() + ", Feta Cheese";
    }
}
