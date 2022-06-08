package View;


import Controller.Controller;
import Adapter.Adapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import Model.BlackJackModel;


public class View {
    private Adapter adapter;
    private JFrame gui;
    private JButton hit;
    private JButton stand;
    private JButton reset;
    private JTextArea announcer;
    private JTextArea dealerCard;
    private JTextArea playerCard;
    private BlackJackModel m;

    public View(BlackJackModel m){
        this.gui = new JFrame("Black Jack");
        this.hit = new JButton("Hit");
        this.stand = new JButton("Stand");
        this.reset = new JButton("reset");
        this.announcer = new JTextArea();
        this.dealerCard = new JTextArea();
        this.playerCard = new JTextArea();
        this.m = m;
        initialize();
    }



    public void setActionListener(Controller c) {
        this.adapter = new Adapter(c, this);
        hit.addActionListener(adapter);
        stand.addActionListener(adapter);
        reset.addActionListener(adapter);

    }

    public void initialize(){
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(600, 350));
        gui.setResizable(true);
        //Player's panel
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BorderLayout());
        //hit button in player's panel
        JPanel hitButton = new JPanel(new GridLayout());
        hitButton.add(hit);
        playerPanel.add(hitButton, "West");
        //stand button in player's panel
        JPanel standButton = new JPanel(new GridLayout());
        standButton.add(stand);
        playerPanel.add(standButton, "East");
        //player label
        JLabel playerName = new JLabel();
        playerName.setText("Player");
        playerPanel.add(playerName, "North");
        playerName.setHorizontalAlignment(JLabel.CENTER);

        playerPanel.add(playerCard, "Center");

        this.gui.getContentPane().add(playerPanel, "Center");
        //reset button
        JPanel resetButton = new JPanel(new FlowLayout());
        playerPanel.add(resetButton, "South");
        resetButton.add(reset);
        //Dealer's Panel
        JPanel dealerPanel = new JPanel();
        dealerPanel.setLayout(new BorderLayout());
        JLabel dealerName = new JLabel();
        dealerName.setText("Dealer");
        dealerPanel.add(dealerName, "North");
        dealerName.setHorizontalAlignment(JLabel.CENTER);

        dealerPanel.add(dealerCard, "Center");


        dealerPanel.setPreferredSize(new Dimension(600, 100));
        this.gui.getContentPane().add(dealerPanel, "North");
        //Announcer
        JPanel messages = new JPanel(new FlowLayout());
        this.gui.getContentPane().add(messages,"South");
        messages.add(announcer);
        announcer.setText("Hit or Stand?");

        //show cards
        initialDealerCard();
        showPlayerCard();

        gui.setVisible(true);
    }


    public void initialDealerCard() {
        dealerCard.setText( m.showDealerHand() + " " + "Unknown" );
    }

    public void showDealerCard(String card) {
        dealerCard.setText(card);
    }

    public void showPlayerCard() {
        playerCard.setText(m.getPlayer().toString());
    }

    public void showPlayerCard(String cards) {
        playerCard.setText(cards);
    }

    public boolean isReset(ActionEvent e) {
        return e.getSource() == reset;
    }

    public boolean isHit(ActionEvent e) {
        return e.getSource() == hit;
    }

    public void endGame(String message) {
        hit.setEnabled(false);
        stand.setEnabled(false);
        announcer.setText(message);
        dealerCard.setText(m.getDealer().toString());
    }

    public boolean isStand(ActionEvent e) {
        if(e.getSource() == stand)
            hit.setEnabled(false);
            stand.setEnabled(false);
        return e.getSource() == stand;
    }

    public void resetGame() {
        hit.setEnabled(true);
        stand.setEnabled(true);
        initialDealerCard();
        showPlayerCard();
        announcer.setText("Hit or Stand?");
    }


}
