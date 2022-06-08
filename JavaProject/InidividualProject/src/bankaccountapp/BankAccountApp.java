package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();
        String filePath = "/Users/sweetpotato/Documents/EmailProject/NewBankAccounts.csv";

        // Read a CSV file then create new accounts based on that data
        List<String[]> newAccountHolders = new utilities.CSV().read(filePath);
        for(String[] accountHolder : newAccountHolders){
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if(accountType.equals("Savings")){
//                System.out.println("Opening a Saving Account");
                accounts.add(new Saving(name, sSN, initDeposit));
            }else if(accountType.equals("Checking")) {
//                System.out.println("Opening a Checking Account");
                accounts.add(new Checking(name, sSN, initDeposit));
            }else{
                System.out.println("Error Reading Account Type");
            }
        }

        // accounts.get(5);  -- getting object at 5th position
        for(Account account:accounts){
            account.showInfo();
            System.out.println("****************************************");
        }


    }
}
        /* Testing calling-code for the program
        Checking chkacc1 = new Checking("fake name","123456789",15000);
        chkacc1.showInfo();
        System.out.println("***********************************");
        Saving savacc1 =  new Saving("Tim Z", "123456789",15000);
        savacc1.showInfo();
        savacc1.compound();
        */
//        savacc1.deposit(500);
//        savacc1.withdraw(100);
//        savacc1.transfer("Home", 500);
