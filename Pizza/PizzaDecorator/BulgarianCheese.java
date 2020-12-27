package Pizza.PizzaDecorator;

import Pizza.PizzaBase;

public class BulgarianCheese extends CheeseDecorator {
    public BulgarianCheese(PizzaBase pizza){
        this.pizza = pizza;
    }

    @Override
    public double price() {
        return this.toppingPrice + pizza.price();
    }

    @Override
    public String getToppingName() {
        return pizza.getToppingName() + ", Bulgarian Cheese";
    }
}
