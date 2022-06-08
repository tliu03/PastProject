package DeckCard;

/**
 * This class represent current cards on hand
 */
public class Hand extends Deck{

    /**
     * default constructor create an empty set of card.
     */
    public Hand(){emptyDeck();}

    /**
     * copy constructor for hand
     * @param hand the hand to be copy from
     */
    public Hand(Hand hand) {
        super(hand);
    }
}
