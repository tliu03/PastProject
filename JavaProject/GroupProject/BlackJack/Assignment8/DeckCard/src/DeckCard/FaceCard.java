package DeckCard;

/**
 * This class represent face cards
 */

public class FaceCard extends Card {
    static final int POINT = 10;
    final Face face;
    final int KING_RANK = 13;
    final int QUEEN_RANK = 12;
    final int JACK_RANK = 11;

    /**
     * Type of face cards
     */
    public enum Face {KING, QUEEN, JACK}

    /**
     * Constructor for the three face card. Has rank of 10.
     * @param suit suit of the card
     * @param faceCard type of face card
     */
    public FaceCard(Suit suit, Face faceCard) {
        super(suit, POINT);
        this.face = faceCard;

        switch(faceCard) {
            case JACK -> super.setRank(JACK_RANK);
            case QUEEN -> super.setRank(QUEEN_RANK);
            case KING -> super.setRank(KING_RANK);
        }
    }

    /**
     * toString method to print the card
     * @return a string to print the card
     */
    @Override
    public String toString() {
        return "(" + this.getSuit() + ", " + this.face + ")";
    }
}