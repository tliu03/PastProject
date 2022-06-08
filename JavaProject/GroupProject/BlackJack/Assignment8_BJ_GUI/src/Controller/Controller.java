package Controller;

import Model.BlackJackModel;
import Model.Hand;

public class Controller {
    private BlackJackModel m;

    public void setModel(BlackJackModel m) {
        this.m = m;
        m.checkBustAndBJ();
    }

    public void setHitCard(){
        m.playerPlay();
    }

    public void setStand() {
        m.dealerPlay();
        m.checkWinnerByHighPoint();
    }

    public void setRequest() {
        m.resetModel();
        m.checkBustAndBJ();
    }
}
