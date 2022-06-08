import Model.*;
import View.*;
import Controller.*;

public class BlackJack {

    public static void main(String[] args) {
        // Create the components

        Controller c = new Controller();
        BlackJackModel m = new BlackJackModel();
        View v = new View(m);

        // Use aggregation to put the components together
        m.registerView(v);
        c.setModel(m);
        v.setActionListener(c);
    }
}