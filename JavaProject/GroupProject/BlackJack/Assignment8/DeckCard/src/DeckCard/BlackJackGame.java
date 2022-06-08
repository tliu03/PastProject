package DeckCard; /**
 * This class is the model of the black jack game
 * Contains all of the method related to the Black Jack Game.
 */

import java.util.Scanner;

public class BlackJackGame {
    final int BLACKJACK = 21;
    final int DEALER_STOPPING_POINT = 17;
    final int ACE_HIGH_POINT = 11;
    Hand player;
    Hand dealer;
    Deck deck;

    /**
     * default constructor to create the Black Jack Game
     */
    public BlackJackGame(){
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();
        deck.shuffleDeck();
        for(int i=0; i<2;i++){
            dealCard(player);
            dealCard(dealer);
        }
    }

    /**
     * Dealing card to the person
     * @param person the person who gets the card from the deck.
     */
    public void dealCard(Hand person){
        person.addCard(deck.removeCard());
    }

    /**
     * Helper method to calculate the current point
     * @param hand hand to count
     * @return int, the total point of the hand
     */
    int countPoint(Hand hand){
        int sum = 0;
        Hand tempHand;
        tempHand = new Hand(hand);
        tempHand.sortCard();

        for (Card card: tempHand.getDeck()) {
            if (card instanceof Ace) {
                int tempSum = sum;
                tempSum += ((Ace) card).HIGH_POINT;
                if (tempSum <= BLACKJACK) {
                    sum = tempSum;
                } else {
                    sum += ((Ace) card).LOW_POINT;
                }
            } else {
                sum += card.getPoint();
            }
        }

        if(sum > BLACKJACK) {
            sum = 0;
            for (Card card: tempHand.getDeck()) {
                if (card instanceof Ace)
                    sum += ((Ace) card).LOW_POINT;
                else
                    sum += card.getPoint();
            }
        }

        return sum;
    }

    /**
     * show the first card of the dealer
     */
    public void showDealerHand(){
        System.out.println("Dealer's DeckCard.Card: ");
        System.out.println(dealer.getDeck().get(0).toString());
    }

    /**
     * show all of the player's card
     */
    public void showPlayerHard(){
        System.out.println("Your card: ");
        player.printDeck();
    }

    /**
     * Check if the hand has 21 points
     * @param hand the hand to be checked
     * @return true if it is a black jack
     */
    public boolean isBlackJack(Hand hand) {
        return countPoint(hand) == BLACKJACK;
    }

    /**
     * Check which hand has more point
     * @param hand1 the hand to compare with other
     * @param hand2 the hand to compare with other
     * @return the higher hand
     */
    public Hand isHighPoint(Hand hand1, Hand hand2){
        if(countPoint(hand1) > BLACKJACK && countPoint(hand2) < BLACKJACK){
            return hand2;
        } else if(countPoint(hand1) < BLACKJACK && countPoint(hand2) > BLACKJACK){
          return hand1;
        }

        if(countPoint(hand1) > countPoint(hand2)){
            return hand1;
        } else if (countPoint(hand1) < countPoint(hand2)){
            return hand2;
        } else {
            return null;
        }
    }

    /**
     * check if both hands have equal amount of points
     * @param hand1 the hand to compare with other
     * @param hand2 the hand to compare with other
     * @return true if the points are tie
     */
    public boolean isTie(Hand hand1, Hand hand2){
        return countPoint(hand1) == countPoint(hand2);
    }

    /**
     * Check if the game is over immediately
     * @return true if the player bust or has a black jack.
     */
    public boolean gameIsOver(){
        return isBust(player) || isBust(dealer) ||isBlackJack(player)|| isBlackJack(dealer);
    }

    /**
     * prints out game over and each player's card
     */
    public void gameOver(){
        System.out.println("Game Over!");
        System.out.println("Your DeckCard.Card: ");
        player.printDeck();
        System.out.println("Dealer's DeckCard.Card");
        dealer.printDeck();
    }

    /**
     * print the hands as the winner
     * @param hand the winner
     */
    public void printWinner(Hand hand){
        if(hand.equals(player))
            System.out.println("Player win!");
        if(hand.equals(dealer))
            System.out.println("Dealer win!");
    }

    /**
     * print no winner
     */
    public void printWinner(){
        System.out.println("Draw! No Winner");
    }

    /**
     * check if the hand is busted (more than 21 points)
     * @param hand the hand to be check
     * @return true if the hand is busted
     */
    public boolean isBust(Hand hand){
        return countPoint(hand) > BLACKJACK;
    }

    /**
     * the dealer's move
     */
    public void dealerPlay(){
        while(countPoint(dealer) < DEALER_STOPPING_POINT){
            dealCard(dealer);
        }
    }

    /**
     * Check if the player is hitting the card
     * @return true if the player wants to hit
     * @throws IllegalArgumentException if the player enter key other than 'h' or 's'
     */
    public boolean playerHit() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        String hit = "h";
        String stand = "s";
        System.out.println("Press H to hit, S to Hold");
        String userInput = scanner.nextLine();
        if(!userInput.equalsIgnoreCase(hit) && !userInput.equalsIgnoreCase(stand))
            throw new IllegalArgumentException("Invalid input!");
        return userInput.equalsIgnoreCase(hit);
    }
}
