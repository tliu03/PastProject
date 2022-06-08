package Model;

import java.util.ArrayList;
import java.util.Collections;
/**
 * This class represent a deck of card
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    /**
     * The default constructor, create a deck of 52 playing cards.
     */
    public Deck() {
        createDeck();
    }

    /**
     * Constructor to copy the deck
     * @param deck the deck to be copy from
     */
    public Deck(Deck deck) {
        emptyDeck();
        copyDeck(deck.getDeck());
    }

    /**
     * helper method to add 52 cards into the deck
     */
    private void createDeck() {
        for(Card.Suit suit:Card.Suit.values()) {
            for(FaceCard.Face face: FaceCard.Face.values())
            deck.add(new FaceCard(suit, face));
            for(int i=10; i>1 ;i--) {
                deck.add(new NumberCard(suit,i));
            }
            deck.add(new Ace(suit));
        }
    }

    public void emptyDeck(){
        this.deck = new ArrayList<Card>();
    }

    public void copyDeck(ArrayList<Card> deck){
        this.deck.addAll(deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }


    /**
     * shuffle the deck of card
     */
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /**
     * add a card to the deck
     * @param card the card to be added
     */
    public void addCard(Card card) {
        deck.add(card);
    }

    /**
     * remove the first card from a deck
     * @return the card to be removed
     */
    public Card removeCard() {
        return deck.remove(0);
    }

    /**
     * sort the deck of card.
     */
    public void sortCard() {
        Collections.sort(deck);
    }

    @Override
    public String toString() {
        return ""+ deck;
    }
}
