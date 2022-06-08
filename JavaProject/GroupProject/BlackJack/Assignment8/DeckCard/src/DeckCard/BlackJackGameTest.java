package DeckCard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the Junit test for BlackJackGame Class
 */
class BlackJackGameTest {
    BlackJackGame bj = new BlackJackGame();
    Hand hand = new Hand();
    Deck deck = new Deck();
    Card card = new Card(Card.Suit.CLUB, 10);
    Ace aceCard = new Ace(Card.Suit.HEART);

    @Test
    void dealCard() {
        card = bj.deck.getDeck().get(0);
        bj.dealCard(hand);
        assertEquals(hand.getDeck().get(0), card);
    }

    @Test
    void countPoint(){
        hand.addCard(aceCard);
        hand.addCard(aceCard);
        hand.addCard(card);
        hand.addCard(aceCard);
        assertEquals(13, bj.countPoint(hand));
    }

    @Test
    void countPointBestAcePoint(){
        card = new Card(Card.Suit.CLUB, 4);
        hand.addCard(aceCard);
        hand.addCard(aceCard);
        hand.addCard(card);
        hand.addCard(aceCard);
        assertEquals(17, bj.countPoint(hand));
    }


    @Test
    void isBlackJack() {
        hand.addCard(aceCard);
        hand.addCard(card);
        assertTrue(bj.isBlackJack(hand));
    }

    @Test
    void isNotBlackJack() {
        hand.addCard(aceCard);
        hand.addCard(aceCard);
        assertFalse(bj.isBlackJack(hand));
    }

    @Test
    void isHighPoint() {
        Hand hand = new Hand();
        Hand hand2 = new Hand();
        hand.addCard(aceCard);
        hand2.addCard(card);
        assertEquals(hand, bj.isHighPoint(hand, hand2));
    }
    @Test
    void equalPoint() {
        Hand hand = new Hand();
        Hand hand2 = new Hand();
        assertNull(bj.isHighPoint(hand, hand2));
    }

    @Test
    void isTie() {
        Hand hand = new Hand();
        Hand hand2 = new Hand();
        assertTrue(bj.isTie(hand, hand2));
    }

    @Test
    void isNotTie() {
        Hand hand = new Hand();
        Hand hand2 = new Hand();
        hand.addCard(aceCard);
        hand2.addCard(card);
        assertFalse(bj.isTie(hand, hand2));
    }

    @Test
    void isBust() {
        bj.dealer.addCard(card);
        bj.dealer.addCard(card);
        bj.dealer.addCard(card);
        assertTrue(bj.gameIsOver());
    }

    @Test
    void isNotBust() {
        bj.player.emptyDeck();
        bj.player.addCard(card);
        bj.player.addCard(card);
        assertFalse(bj.gameIsOver());
    }

}