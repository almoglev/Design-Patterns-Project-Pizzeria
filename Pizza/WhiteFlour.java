package Pizza;

public class WhiteFlour extends PizzaBase {
    public WhiteFlour(){
        description = "White Flour Pizza";
    }

    @Override
    public double price() {
        return 35;
    }
}
