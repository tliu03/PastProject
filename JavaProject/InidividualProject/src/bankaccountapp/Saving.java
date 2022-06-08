package bankaccountapp;

public class Saving extends Account{
    // List properties specific to the savings account
    private int safetyDepositBoxID;
    private int SafetyDepositBoxKey;

    // Constructor to initialize settings for Saving properties
    public Saving(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber="1"+accountNumber;
//        System.out.println("ACCOUNT # checking: "+accountNumber);
//        System.out.println("NEW SAVING Account");
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    // List methods specific to the savings account
    public void setSafetyDepositBox(){
        safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
        SafetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
    }


    public void showInfo() {
        super.showInfo();
        System.out.println(" Your Savings Account Features: " +
                "\n Safety Deposit Box ID: "  + safetyDepositBoxID +
                "\n Safety Deposit Boxy Key: " + SafetyDepositBoxKey);
    }
}
