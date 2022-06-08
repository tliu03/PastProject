package DeckCard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This it the JUnit test for Class NumberCard
 */
public class NumberCardTest {
    private NumberCard cardSpade, cardHeart, cardClub, cardDiamond,
            cardInvalidNeg, cardInvalidOver;

    @Before
    public void setUp() throws Exception {
        cardSpade = new NumberCard(Card.Suit.SPADE, 3);
        cardClub = new NumberCard(Card.Suit.CLUB, 7);
        cardHeart = new NumberCard(Card.Suit.HEART, 9);
        cardDiamond = new NumberCard(Card.Suit.DIAMOND, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setupException() {
        cardInvalidNeg = new NumberCard(Card.Suit.DIAMOND, -3);
        cardInvalidOver = new NumberCard(Card.Suit.SPADE, 11);

    }

    @Test
    public void testGetRank(){
        assertEquals(3, cardSpade.getRank());
        assertEquals(9, cardHeart.getRank());
    }

    @Test
    public void testPionts(){
        assertEquals(3, cardSpade.getPoint());
        assertEquals(7, cardClub.getPoint());
        assertEquals(9, cardHeart.getPoint());
        assertEquals(2, cardDiamond.getPoint());
    }

    @Test
    public void testToString() {
        String cardSpadeString = "(SPADE, 3)";
        String cardCludString = "(CLUB, 7)";
        String cardHeartString = "(HEART, 9)";
        String cardDiamondString = "(DIAMOND, 2)";
        assertEquals(cardSpadeString, cardSpade.toString());
        assertEquals(cardCludString, cardClub.toString());
        assertEquals(cardHeartString, cardHeart.toString());
        assertEquals(cardDiamondString, cardDiamond.toString());
    }
}