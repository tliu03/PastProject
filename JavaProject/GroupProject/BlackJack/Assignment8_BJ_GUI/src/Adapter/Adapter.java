package Adapter;

import Controller.*;
import View.*;
import java.awt.event.*;

public class Adapter implements ActionListener{
    private Controller c;
    private View v;

    public Adapter(Controller c, View v){
        this.c = c;
        this.v = v;
    }

    public void actionPerformed(ActionEvent e) {
        if(v.isReset(e))
            c.setRequest();
        else if (v.isHit(e)){
            c.setHitCard();
        } else if (v.isStand(e)) {
            c.setStand();
        }
    }

}
