package DeckCard;

import org.junit.Before;
import org.junit.Test;

import java.nio.charset.CharacterCodingException;

import static org.junit.Assert.*;

/**
 * This is the JUnit test for Hand Class
 */
public class HandTest {
    private Hand handOne, handTwo;
    private Card cardOne, cardTwo, cardThree;

    @Before
    public void setUp() throws Exception {
        handOne = new Hand();
        cardOne = new NumberCard(Card.Suit.SPADE, 3);
        cardTwo = new FaceCard(Card.Suit.SPADE, FaceCard.Face.JACK);
        cardThree = new Ace(Card.Suit.HEART);
    }

    @Test
    public void testAddandRemoveCard(){
        handOne.addCard(cardOne);
        handOne.addCard(cardTwo);
        handOne.addCard(cardThree);
        assertEquals(cardOne, handOne.removeCard());
        assertEquals(cardTwo, handOne.removeCard());
        assertEquals(cardThree, handOne.removeCard());
    }

}