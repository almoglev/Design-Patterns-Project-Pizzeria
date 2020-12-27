package Drinks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HotChocolate extends HotDrink {
    double price = 16;

    @Override
    public double price() {
        return price;
    }

    @Override
    public void addCondiment() {
        System.out.println("Cream added.");
    }

    //hook
    @Override
    public boolean isWithCondiment(){
        String answer = getUserAnswer();

        if(answer.toLowerCase().startsWith("y")){
            price = price + 2;
            return true;
        }
        else
            return false;
    }

    private String getUserAnswer(){
        String answer = null;
        System.out.println("Would you like cream on top? --- 2 NIS (y/n)");

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

