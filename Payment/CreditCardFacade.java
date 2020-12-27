package Payment;

public class CreditCardFacade {
    ValidateUser validateUser;
    ValidateCardAndPay validateCardAndPay;

    public CreditCardFacade(){
        validateUser = new ValidateUser();
        validateCardAndPay = new ValidateCardAndPay();
    }

    // using the first sub-system of the facade- ValidateUser
    public void checkUserValidation(String id, String name){
        validateUser.validateUser(id, name);
    }

    // using the second sub-system of the facade- ValidateCardAndPay
    public String pay(double price, String id, String name, String cardNum, String cardExp, int cvv){
        validateCardAndPay.validateCard(id, name, cardNum, cardExp, cvv);
        return validateCardAndPay.payWithCard(price, cardNum, cardExp, cvv);
    }
}





