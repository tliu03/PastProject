package DeckCard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is the test file for Card Class
 */
public class CardTest {
    private Card cardSpade, cardHeart, cardClub, cardDiamond;

    @Before
    public void setUp(){
        cardSpade = new Card(Card.Suit.SPADE, 3);
        cardClub = new Card(Card.Suit.CLUB, 7);
        cardHeart = new Card(Card.Suit.HEART, 9);
        cardDiamond = new Card(Card.Suit.DIAMOND, 2);
    }

    @Test
    public void getSuit() {
        assertEquals(Card.Suit.SPADE, cardSpade.getSuit());
        assertEquals(Card.Suit.CLUB, cardClub.getSuit());
        assertEquals(Card.Suit.HEART, cardHeart.getSuit());
        assertEquals(Card.Suit.DIAMOND, cardDiamond.getSuit());
    }

    @Test
    public void setRank() {
        cardSpade.setRank(3);
        cardClub.setRank(7);
        cardHeart.setRank(9);
        cardDiamond.setRank(2);
        assertEquals(2, cardDiamond.getRank());
        assertEquals(3, cardSpade.getRank());
        assertEquals(7, cardClub.getRank());
        assertEquals(9, cardHeart.getRank());
    }

    @Test
    public void getRank() {
        cardClub.setRank(3);
        cardHeart.setRank(4);
        assertEquals(3, cardClub.getRank());
        assertEquals(4, cardHeart.getRank());
    }

    @Test
    public void getPoint() {
        assertEquals(3, cardSpade.getPoint());
        assertEquals(7, cardClub.getPoint());
        assertEquals(9, cardHeart.getPoint());
        assertEquals(2, cardDiamond.getPoint());
    }

    @Test
    public void testToString() {
        cardSpade.setRank(3);
        String cardSpadeRank = "(SPADE, Rank: 3)";
        assertEquals(cardSpadeRank, cardSpade.toString());
    }

    @Test
    public void compareTo() {
    }
}