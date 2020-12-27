package Drinks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coffee extends HotDrink {
    double price = 12;

    @Override
    public double price() {
        return price;
    }

    @Override
    public void addCondiment() {
        System.out.println("Milk added");
    }

    //hook
    @Override
    public boolean isWithCondiment(){
        String answer = getUserAnswer();

        if(answer.toLowerCase().startsWith("y")){
            price = price + 1.5;
            return true;
        }
        else
            return false;
    }

    private String getUserAnswer(){
        String answer = null;
        System.out.println("Would you like milk? --- 1.5 NIS (y/n)");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(answer == null){
            answer = "no";
        }

        return answer;
    }
}
