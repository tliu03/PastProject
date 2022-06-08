package DeckCard;

/**
 * This class represent numbered card. DeckCard.Card be has value from 2 to 10.
 */
public class NumberCard extends Card {
    private int cardNumber;
    final int MIN_CARD_NUMBER = 2;
    final int MAX_CARD_NUMBER = 10;
    /**
     * Constructor for the number card. number card has rank of 2 to 10
     *
     * @param suit suit of the card
     * @param number int, number of the card
     */
    public NumberCard(Suit suit, int number) {
        super(suit, number);
        setSpotCard(number);
    }

    /**
     * setter for the card number, card can be from 2 to 10.
     * @param number int, the number of the card.
     * @throws IllegalArgumentException if the number is not between 2 and 10.
     */
    private void setSpotCard(int number) throws IllegalArgumentException {
        if (number < MIN_CARD_NUMBER || number > MAX_CARD_NUMBER) {
            throw new IllegalArgumentException("Invalid card number");
        }
        this.cardNumber = number;
        super.setRank(number);
    }

    /**
     * toString method to print the card
     * @return a string to print the card
     */
    @Override
    public String toString() {
        return "(" + this.getSuit() + ", " + this.cardNumber + ")";
    }

}