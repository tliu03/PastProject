package DeckCard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is the JUnit Test for FaceCard Class
 */
public class FaceCardTest {
    private FaceCard cardSpade, cardHeart, cardClub, cardDiamond;

    @Before
    public void setUp() throws Exception {
        cardSpade = new FaceCard(Card.Suit.SPADE, FaceCard.Face.JACK);
        cardClub = new FaceCard(Card.Suit.CLUB, FaceCard.Face.KING);
        cardHeart = new FaceCard(Card.Suit.HEART, FaceCard.Face.QUEEN);
        cardDiamond = new FaceCard(Card.Suit.DIAMOND, FaceCard.Face.JACK);
    }

    @Test
    public void testGetRank(){
        assertEquals(11, cardSpade.getRank());
        assertEquals(12, cardHeart.getRank());
        assertEquals(13, cardClub.getRank());
    }

    @Test
    public void testGetPoints(){
        assertEquals(10, cardSpade.getPoint());
        assertEquals(10, cardClub.getPoint());
        assertEquals(10, cardHeart.getPoint());
        assertEquals(10, cardDiamond.getPoint());
    }

    @Test
    public void testToString() {
        String cardSpadeString = "(SPADE, JACK)";
        String cardClubString = "(CLUB, KING)";
        String cardHeartString = "(HEART, QUEEN)";
        String cardDiamondString = "(DIAMOND, JACK)";
        assertEquals(cardSpadeString, cardSpade.toString());
        assertEquals(cardClubString, cardClub.toString());
        assertEquals(cardHeartString, cardHeart.toString());
        assertEquals(cardDiamondString, cardDiamondString.toString());
    }
}