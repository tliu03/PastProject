package DeckCard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AceTest {
    private Ace aceCard;

    @Before
    public void setUp() throws Exception {
        aceCard = new Ace(Card.Suit.HEART);
    }

    @Test
    public void testGetRank(){
       assertEquals(14, aceCard.getRank());
    }

    @Test
    public void testToString() {
        String aceCardString = "(HEART, DeckCard.Ace)";
        assertEquals(aceCardString, aceCard.toString());
    }
}