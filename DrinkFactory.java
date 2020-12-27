import Drinks.*;

public class DrinkFactory {

    public Drink makeDrink(String drinkOption) {
        switch(drinkOption) {
            case "Tea":
                return new Tea();
            case "Coffee":
                return new Coffee();
            case "Hot Chocolate":
                return new HotChocolate();
            case "Cola":
                return new Cola();
            case "Fanta":
                return new Fanta();
            case "Sprite":
                return new Sprite();
            case "Fuze Tea":
                return new FuzeTea();
            default:
                return null;
        }
    }
}


