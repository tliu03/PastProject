package Model;

/**
 * The model.Ace card, it has two ranks, 1 and 11.
 */
public class Ace extends Card {
    final int LOW_POINT = 1;
    final int HIGH_POINT = 11;
    final int RANK = 14;

    /**
     * Constructor for the ace card
     * model.Ace card default rank is 11;
     * @param suit the suit of the card
     */
    public Ace(Suit suit) {
        super(suit);
        super.setRank(this.RANK);
    }

    /**
     * toString method to print the card
     * @return a string to print the card
     */
    @Override
    public String toString() {
        return "(" + this.getSuit() + ", " + "model.Ace" + ")";
    }
}