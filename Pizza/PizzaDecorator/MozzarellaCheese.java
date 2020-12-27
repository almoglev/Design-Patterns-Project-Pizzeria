package Pizza.PizzaDecorator;


import Pizza.PizzaBase;

public class MozzarellaCheese extends CheeseDecorator {
    public MozzarellaCheese(PizzaBase pizza){
        this.pizza = pizza;
    }

    @Override
    public double price() {
        return this.toppingPrice + pizza.price();
    }

    @Override
    public String getToppingName() {
        return pizza.getToppingName() + ", Mozzarella Cheese";
    }
}
