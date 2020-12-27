import Drinks.Drink;
import Pizza.PizzaBase;
import Pizza.PizzaDecorator.*;

import java.util.ArrayList;

// Invoker
public class Bill {
    private Command command;
    public static String pizzaType ="";
    public static String drinkType ="";
    public ArrayList<String> cheeseList;
    public ArrayList<String> vegetableList;
    public ArrayList<String> fishList;
    private PizzaBase pizza;
    private Drink drink;
    private PizzaFactory pizzaFactory =  new PizzaFactory();
    private DrinkFactory drinkFactory = new DrinkFactory();

    private double calculateDrink() {
        drink = drinkFactory.makeDrink(drinkType);
        drink.makeDrink();

        System.out.println("Drink's price: " + drink.price() + " NIS");
        return drink.price();
    }

    private double calculatePizza(){
        pizza = pizzaFactory.makePizza(pizzaType);
        pizza = decorate(cheeseList, vegetableList, fishList);

        System.out.println("You ordered: "+pizza.getToppingName());
        System.out.println("For the price of: " + pizza.price() + " NIS");
        return pizza.price();
    }

    // sending the command in order to execute the specific desired behavior.
    public double sendCommand(Command cmd){
        command = cmd;
        return command.executeCommand();
    }

    // calculating order's price
    public double getOrder(String factoryType){
        switch (factoryType){
            case "Pizza": return calculatePizza();
            case "Drinks": return calculateDrink();
        }
        System.out.println();
        return 0;
    }

    // decorating the toppings on the pizza
    public PizzaBase decorate(ArrayList<String> cheeseList, ArrayList<String> vegetableList, ArrayList<String> fishList){
        decorateWithCheese(cheeseList);
        decorateWithVegetables(vegetableList);
        decorateWithFish(fishList);
        return pizza;
    }

    private void decorateWithCheese(ArrayList<String> cheeseList){
        for (String cheese : cheeseList) {
            switch (cheese) {
                case "Mozzarella Cheese" -> pizza = new MozzarellaCheese(pizza);
                case "Feta Cheese" -> pizza = new FetaCheese(pizza);
                case "Bulgarian Cheese" -> pizza = new BulgarianCheese(pizza);
            }
        }
    }

    private void decorateWithVegetables(ArrayList<String> vegetableList) {
        for (String vegetable : vegetableList) {
            switch (vegetable) {
                case "Olives" -> pizza = new Olives(pizza);
                case "Mushrooms" -> pizza = new Mushrooms(pizza);
                case "Corn" -> pizza = new Corn(pizza);
                case "Onions" -> pizza = new Onions(pizza);
            }
        }
    }

    private void decorateWithFish(ArrayList<String> fishList) {
        for (String fish : fishList) {
            switch (fish) {
                case "Anchovy" -> pizza = new Anchovy(pizza);
                case "Tuna" -> pizza = new Tuna(pizza);
            }
        }
    }
}
