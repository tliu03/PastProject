package bankaccountapp;

public class Checking extends Account{
    // List properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPin;

    // Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber="2"+accountNumber;
//        System.out.println("ACCOUNT # saving: "+accountNumber);
//        System.out.println("New checking account ");

        setDebitCard();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() *0.15;
    }


    // List any methods specific to the checking account
    private void setDebitCard(){
        debitCardNumber = (int)(Math.random() * Math.pow(10, 12));
        debitCardPin = (int)(Math.random() * Math.pow(10, 4));
//        System.out.println(debitCardNumber +" " +debitCardPin);
    }

    public void showInfo() {
        //This call the showInfo method in the superclass, otherwise it will override
        super.showInfo();
        System.out.println(" Your Checking Account Features: "  +
                "\n Debit Card Number: "  + debitCardNumber +
                "\n Debit Card Pin: " + debitCardPin);
    }
}
