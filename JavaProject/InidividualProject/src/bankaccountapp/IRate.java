package bankaccountapp;

public interface IRate {
    // fetching from API, not something we
    // are setting in our app

    // Write a method that returns the base rate
    default double getBaseRate(){
        return 2.5;
    }
}
