package Payment;

public class PayByCard implements PayingStrategy {
    // facade.
    private CreditCardFacade facade;

    // user & credit card details.
    private String clientID; // *********
    private String clientName;
    private String cardNumber; // ****-****-****-****
    private String cardExpiryDate; // MM/YY
    private int cvv; // ***

    public PayByCard(String newID, String newName, String newCardNum, String newCardExp, int newCvv) {
        this.facade = new CreditCardFacade();

        this.clientID = newID;
        this.clientName = newName;
        this.cardNumber = newCardNum;
        this.cardExpiryDate = newCardExp;
        this.cvv = newCvv;
    }

    public void pay(double price) {
        // behind the scenes checkUserValidation calls validateUser.validateUser(id, name);
        facade.checkUserValidation(clientID, clientName);

        // behind the scenes pay calls validateCardAndPay.validateCard(...)
        //                             validateCardAndPay.payWithCard(...);
        String res = facade.pay(price, clientID, clientName, cardNumber, cardExpiryDate,cvv);
        System.out.println(res);
    }


}
