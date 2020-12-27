package Drinks;

public abstract class HotDrink implements Drink {
    public abstract double price();

    //template method
    @Override
    public void makeDrink() {
        if(isWithCondiment()) {
            addCondiment();
        }
    }

    public abstract void addCondiment();

    public abstract boolean isWithCondiment();
}
