package emailapp;

import java.util.Scanner;

public class Email {
    // *instance* variables
    private String firstName;
    private String lastName;
    private String password;
    private  int defaultPasswordLength =10;
    private String department;
    private String email;
    private int mailBoxCapacity =500;
    private String alternateEmail;
    private String companySuffix = "company.com";
    //encapsulation

    // *Constructor* to receive the first and last name;
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: " + this.firstName + this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        // Call a method to generate a random password;
        this.password = randomPassword(this.defaultPasswordLength);
        System.out.println("Password: " + this.password);

        // Combine elements to general email
        this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
        // System.out.println(email);
    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("Department Code:\n1 for Sales\n2 for Development\n3 for Accounting\n4 for none\nEnter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) return "sales";
        else if (depChoice == 2) return "dev";
        else if (depChoice == 3) return "acct";
        else return "";
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "QWERTYUIOPASDFGHJKLZXCVBNM?!@#$%^&*";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }

    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
        //System.out.println(this.alternateEmail);
    }

    // Change password
    public void ChangePassword(String password){
        this.password=password;
    }

    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return  "DISPLAY NAME: " + firstName+  " "+lastName +"\n" +
                "COMPANY EMAIL: "+email+"\n"+
                "MAILBOX CAPACITY: " +mailBoxCapacity;
    }
}
