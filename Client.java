import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import Payment.*;

public class Client {
    private PayingStrategy payingStrategy;
    private ArrayList<String> cheeseList;
    private ArrayList<String> vegetableList;
    private ArrayList<String> fishList;

    private String chooseDrink() {
        String drinkOption = "";
        Scanner scanDrink = new Scanner(System.in);
        int drink = scanDrink.nextInt();

        switch (drink) {
            case 1 -> drinkOption = "Tea";
            case 2 -> drinkOption = "Coffee";
            case 3 -> drinkOption = "Hot Chocolate";
            case 4 -> drinkOption = "Cola";
            case 5 -> drinkOption = "Fuze Tea";
            case 6 -> drinkOption = "Fanta";
            case 7 -> drinkOption = "Sprite";
        }
        System.out.println("*** " + drinkOption + " is chosen.");
        return drinkOption;
    }
    private String choosePizzaBase() {
        String answer = "0";
        // Stay in loop until a base is chosen (1 or 2)
        do {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            try {
                answer = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (answer) {
                case "1":
                    return "White Flour Pizza";
                case "2":
                    return "Gluten Free Pizza";
                default:
                    break;
            }
        } while (true);
    }

    private void addToppings() {
        cheeseList = new ArrayList<>();
        vegetableList = new ArrayList<>();
        fishList = new ArrayList<>();

        Scanner toppingType = new Scanner(System.in);
        do {
            int value = toppingType.nextInt();
            if (value == 1) {
                cheeseList.add("Bulgarian Cheese");
            } else if (value == 2) {
                cheeseList.add("Feta Cheese");
            } else if (value == 3) {
                cheeseList.add("Mozzarella Cheese");
            } else if (value == 4) {
                vegetableList.add("Olives");
            } else if (value == 5) {
                vegetableList.add("Corn");
            } else if (value == 6) {
                vegetableList.add("Mushrooms");
            } else if (value == 7) {
                vegetableList.add("Onions");
            } else if (value == 8) {
                fishList.add("Anchovy");
            } else if (value == 9) {
                fishList.add("Tuna");
            } else break;
        } while (true);
    }

    private PizzaOrder fullPizzaOrder(Bill bill, MenuComponent mainMenu) {
        // Display menu of pizza base
        MenuComponent pizzaBaseMenu = new Menu("-------------------- PIZZA BASE --------------------");
        MenuComponent baseTypeMenu = new MenuItem("Which pizza do you want?\n(1) White Flour Pizza --- 35 NIS\n(2) Gluten Free Pizza --- 40 NIS");
        mainMenu.add(pizzaBaseMenu);
        pizzaBaseMenu.add(baseTypeMenu);
        pizzaBaseMenu.displayMenu();

        // Choose pizza base
        String pizzaOption = choosePizzaBase();
        System.out.println("*** " + pizzaOption + " is chosen.");
        System.out.println();

        // Display toppings menu
        MenuComponent pizzaToppingsMenu = new Menu("-------------------- TOPPINGS --------------------");
        pizzaBaseMenu.add(pizzaToppingsMenu);
        MenuComponent cheeseMenu = new MenuItem( "-------------------- Cheese Types --------------------\n(1) Bulgarian Cheese --- 2.5 NIS\n(2) Feta Cheese --- 2.5 NIS\n(3) Mozzarella Cheese --- 2.5 NIS\n");
        MenuComponent vegetablesMenu = new MenuItem("-------------------- Vegetable Types --------------------\n(4) Olives --- 2 NIS\n(5) Corn --- 2 NIS\n(6) Mushrooms --- 2 NIS\n(7) Onions --- 2 NIS\n");
        MenuComponent fishMenu = new MenuItem( "-------------------- Fish Types --------------------\n(8) Anchovy --- 3 NIS\n(9) Tuna --- 3 NIS\n(Other) I finished choosing toppings.");
        pizzaToppingsMenu.add(cheeseMenu);
        pizzaToppingsMenu.add(vegetablesMenu);
        pizzaToppingsMenu.add(fishMenu);
        pizzaToppingsMenu.displayMenu();

        addToppings();
        // Create the full pizza order
        return new PizzaOrder(bill, pizzaOption, cheeseList, vegetableList, fishList);
    }

    private DrinkOrder fullDrinkOrder(Bill bill, MenuComponent mainMenu) {
        // Display drinks menu
        MenuComponent drinksMenu = new Menu( "-------------------- DRINKS --------------------");
        MenuComponent hotDrinksMenu = new MenuItem("-------------------- Hot Drinks --------------------\n(1) Tea --- 12 NIS\n(2) Coffee --- 12 NIS\n(3) Hot Chocolate --- 16 NIS\n");
        MenuComponent coldDrinksMenu = new MenuItem( "-------------------- Cold Drinks --------------------\n(4) Cola --- 13 NIS\n(5) Fuze Tea --- 13 NIS\n(6) Fanta --- 10 NIS\n(7) Sprite --- 10 NIS\n(Other) I finished the drink selection.");
        mainMenu.add(drinksMenu);
        drinksMenu.add(hotDrinksMenu);
        drinksMenu.add(coldDrinksMenu);
        drinksMenu.displayMenu();

        // Create the full drink order
        String drinkOption = chooseDrink();
        return new DrinkOrder(bill, drinkOption);
    }

    private ArrayList<String> getCardDetails(){
        ArrayList<String> details = new ArrayList<>();

        for (int i=0;i<5;i++){
            switch (i){
                case 0 -> System.out.println("Please insert ID");
                case 1 -> System.out.println("Please insert name on card");
                case 2 -> System.out.println("Please insert card number ****-****-****-****");
                case 3 -> System.out.println("Please insert expiry date MM/YY");
                case 4 -> System.out.println("Please insert CVV");
            }
            Scanner detailInput = new Scanner(System.in);
            details.add(detailInput.nextLine());
        }
        return details;
    }

    // runs the pizzeria system.
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start() {
        Bill bill = new Bill();
        double total=0;

        Scanner drinkOrPizza = new Scanner(System.in);
        while (true) {
            // Display main menu
            MenuComponent mainMenu = new Menu("What do you want to order?\n(1) Pizza\n(2) Drink\n(Other) I have finished ordering.");
            mainMenu.displayMenu();

            int option = drinkOrPizza.nextInt();
            if (option == 1) { // Pizza
                PizzaOrder pizzaOrder = fullPizzaOrder(bill, mainMenu);
                // send pizzaOrder as command to the kitchen & calculate price.
                total+=bill.sendCommand(pizzaOrder);
            } else if (option == 2) { // Drink
                DrinkOrder drinkOrder = fullDrinkOrder(bill, mainMenu);
                // send drinkOrder as command to the kitchen & calculate price.
                total+=bill.sendCommand(drinkOrder);
            } else {
                System.out.println("\nTotal price: "+total);
                System.out.println("How would you like to pay? \n(1) Cash\n(2) Credit card\n(Other) Cancel order");
                Scanner payInput = new Scanner(System.in);
                int payOption = payInput.nextInt();
                // pay by cash
                if (payOption==1){
                    System.out.println("Please insert cash amount");
                    Scanner cashInput = new Scanner(System.in);
                    double cash = cashInput.nextDouble();
                    this.payingStrategy = new PayByCash(cash);
                    this.payingStrategy.pay(total);
                }
                // pay by card
                else if (payOption==2){
                    ArrayList<String> cardDetails = getCardDetails();
                    this.payingStrategy = new PayByCard(cardDetails.get(0), cardDetails.get(1), cardDetails.get(2),
                            cardDetails.get(3), Integer.parseInt(cardDetails.get(4)));
                    this.payingStrategy.pay(total);
                }

                System.out.println("----------------------------------------------------");
                System.out.println("Thank you and we hope to see you again!");
                break;
            }
        }
    }
}
