package Payment;

public class ValidateCardAndPay {


    public boolean validateCard(String id, String name, String cardNum, String cardExp, int cvv){
        // can implement here some algorithm that checks if the card is valid.
        System.out.println("Credit card is Valid! :)");
        return true;
    }

    public String payWithCard(double price, String cardNum, String cardExp, int cvv){
        // can implement here algorithm to check if the payment went through.
        return "Payment of "+price+" NIS received successfully!\nThank you.";
    }
}
