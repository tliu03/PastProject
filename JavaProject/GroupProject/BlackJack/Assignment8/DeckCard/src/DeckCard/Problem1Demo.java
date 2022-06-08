package DeckCard;

public class Problem1Demo {
    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffleDeck();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        for(int i=0;i<5;i++) {
            hand1.addCard(deck.removeCard());
            hand2.addCard(deck.removeCard());
        }
        System.out.println("Hand1 has: ");
        hand1.printDeck();
        System.out.println("Hand2 has: ");
        hand2.printDeck();

        System.out.println("Hand1 after sort");
        hand1.sortCard();
        hand1.printDeck();

        System.out.println("Hand2 after sort");
        hand2.sortCard();
        hand2.printDeck();

        System.out.println("DeckCard.Deck Before Sort:");
        deck.printDeck();
        System.out.println("DeckCard.Deck After Sort");
        deck.sortCard();
        deck.printDeck();
        for(int i=0;i<5;i++) {
            deck.addCard(hand1.removeCard());
            deck.addCard(hand2.removeCard());
        }
        System.out.println("DeckCard.Deck after returned both hands and sorted");
        deck.sortCard();
        deck.printDeck();





    }


}
