package Model;

/**
 * This class represent a card.
 * A card can be one of four suit, and 13 different values.
 */
public class Card implements Comparable<Card> {
    /**
     * Suit of cards.
     */
    public enum Suit {SPADE, HEART, CLUB, DIAMOND}
    private final Suit suit;
    private int point;
    private int rank;

    /**
     * Constructor to set the card suit and rank
     * @param suit suit of the card
     * @param point point of the card
     */
    public Card(Suit suit, int point) {
        this.suit = suit;
        this.point = point;
    }

    /**
     * Constructor to set the card suit only.
     * @param suit suit of the card.
     */
    public Card(Suit suit) {
        this.suit = suit;
    }



    //Getters and Setters
    public Suit getSuit() {
        return suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public int getPoint() {return point;}
    /**
     * toString method to print the card
     * @return a string to print the card
     */
    @Override
    public String toString() {
        return "(" + this.getSuit() + ", " + "Rank: " + getRank() + ")";
    }

    /**
     * compare method
     * @param other other card
     * @return 1 if this > other, -1 if other < this, 0 if same
     */
    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getRank(), other.getRank());
    }
}
