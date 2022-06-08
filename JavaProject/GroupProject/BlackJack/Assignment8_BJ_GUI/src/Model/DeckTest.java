package Model;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Deck d1 = new Deck();
    Card c1 = new Card(Card.Suit.DIAMOND, 5);
    Card c2 = new Card(Card.Suit.CLUB);

    @org.junit.jupiter.api.Test
    void addCard() {
        d1.emptyDeck();
        d1.addCard(c1);
        assertEquals(c1, d1.getDeck().get(0));
    }

    @org.junit.jupiter.api.Test
    void removeCard() {
        d1.emptyDeck();
        d1.addCard(c1);
        d1.addCard(c2);
        d1.removeCard();
        assertEquals(c2, d1.getDeck().get(0));
    }



}