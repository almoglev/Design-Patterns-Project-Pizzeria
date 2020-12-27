package Drinks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class ColdDrink implements Drink {
    public abstract double price();

    @Override
    public void makeDrink() {
        if(isWithIce()) {
            System.out.println("Ice added.");
        }
    }

    public boolean isWithIce(){
        String answer = getUserAnswer();

        if(answer.toLowerCase().startsWith("y")){
            return true;
        }
        else
            return false;
    }

    private String getUserAnswer(){
        String answer = null;
        System.out.println("Would you like some ice? (y/n)");

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
