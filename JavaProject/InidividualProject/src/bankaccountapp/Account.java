package bankaccountapp;

public abstract class Account implements IRate{
    //abstract class meanning we cannot really
    // create object from the account class
    // parent class to checking and saving

    // List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;
//    double initDeposit;


    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();
//        System.out.println("Account#: " + this.accountNumber);
        setRate();
    }
    // List common methods

    public abstract void setRate();


    // last two digit of SSN, unit 5-digit, random 3-digit
    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int)(Math.random()* Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Interest: "+accruedInterest);
        printBalance();
    }

    //Deposit
    public void deposit(double amount){
        balance = balance+amount;
        System.out.println("Depositing: $"+amount);
        printBalance();
    }

    //Withdraw
    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing: $"+amount);
        printBalance();
    }

    //Transfer
    public void transfer(String towhere, double amount){
        balance = balance - amount;
        System.out.println("Transferring $" +amount+" to " + towhere);
        printBalance();
    }

    //Print balance
    public void printBalance(){
        System.out.println("Your balance is $" + balance);
    }

    //showInfo
    public void showInfo(){
        System.out.println("NAME: " + name+
                "\nACCOUNT Number: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate + "%"
        );
    }


}
