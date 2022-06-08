package Model; /**
 * This class is the model of the black jack game
 * Contains all of the method related to the Black Jack Game.
 */
import View.*;
public class BlackJackModel {
    private View v;
    final int BLACKJACK = 21;
    final int DEALER_STOPPING_POINT = 17;
    final int ACE_HIGH_POINT = 11;
    Hand player;
    Hand dealer;
    Deck deck;

    /**
     * default constructor to create the Black Jack Game
     */
    public BlackJackModel(){
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
     * get player
     * @return
     */
    public Hand getPlayer() {
        return player;
    }

    /**
     * get dealer
     * @return dealer
     */
    public Hand getDealer() {
        return dealer;
    }

    /**
     * set view
     * @param v view
     */
    public void registerView(View v) { this.v = v;}

    /**
     * Dealing card to the person
     * @param person the person who gets the card from the deck.
     */
    public void dealCard(Hand person){
        person.addCard(deck.removeCard());
    }

    /**
     * player's action when hit the card
     */
    public void playerPlay() {
        player.addCard(deck.removeCard());
        v.showPlayerCard(player.toString());
        checkBustAndBJ();
    }

    /**
     * Helper method to calculate the current point
     * @param hand hand to count
     * @return int, the total point of the hand
     */
    private int countPoint(Hand hand){
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
    public String showDealerHand(){
        return (dealer.getDeck().get(0).toString());
    }

    /**
     * Check if the hand has 21 points
     * @param hand the hand to be checked
     * @return true if it is a black jack
     */
    private boolean isBlackJack(Hand hand) {
        return countPoint(hand) == BLACKJACK;
    }

    /**
     * Check which hand has more point
     * @param hand1 the hand to compare with other
     * @param hand2 the hand to compare with other
     * @return the higher hand
     */
    private Hand isHighPoint(Hand hand1, Hand hand2){

        if(countPoint(hand1) > countPoint(hand2)){
            return hand1;
        } else if (countPoint(hand1) < countPoint(hand2)){
            return hand2;
        } else {
            return null;
        }
    }

    /**
     * check who has higher point
     */
    public void checkWinnerByHighPoint(){
        if(!bjOrBust()) {
            if(isHighPoint(player,dealer) == null){
                v.endGame(printWinner());
            }else {
                v.endGame(printWinner(isHighPoint(player, dealer)));
            }
        }
    }

    /**
     * return black jack or bust
     * @return true if the player bust or has a black jack.
     */
    public boolean bjOrBust(){
        return isBust(player) || isBust(dealer) ||isBlackJack(player)|| isBlackJack(dealer);
    }

    /**
     * check if the hand is busted (more than 21 points)
     * @param hand the hand to be check
     * @return true if the hand is busted
     */
    private boolean isBust(Hand hand){
        return countPoint(hand) > BLACKJACK;
    }

    /**
     * the dealer's move
     */
    public void dealerPlay(){
        if(!bjOrBust()) {
            while (countPoint(dealer) < DEALER_STOPPING_POINT) {
                dealCard(dealer);
            }
            v.showDealerCard(dealer.toString());
        }
        checkBustAndBJ();
    }

    /**
     * check bust or black jack and end game
     */
    public void checkBustAndBJ() {
        if(isBlackJack(player)){
            v.endGame(printBJWinner(player));
        }
        if(isBust(player)) {
            v.endGame(printWinnerByBust(dealer));
        }
        if(isBlackJack(dealer)){
            v.endGame(printBJWinner(dealer));
        }
        if(isBust(dealer)){
            v.endGame(printWinnerByBust(player));
        }
    }

    /**
     * return the hands as the winner
     * @param hand the winner
     * @return hand
     */
    private String printWinner(Hand hand) {
        if(hand.equals(player))
            return "Player win!";
        else
            return "Dealer win!";
    }

    /**
     * return no winner
     */
    private String printWinner() {
        return "Tie! No Winner";

    }

    /**
     * return the winner with black jack
     * @param hand the winner
     * @return string, player or dealer win
     */
    private String printBJWinner(Hand hand){
        if(hand.equals(player))
            return ("Black Jack! Player win!");
        else
            return ("Black Jack! Dealer win!");
    }

    /**
     * print the winner without bust
     * @param loserHand the winner
     * @return string with the winner
     */
    private String printWinnerByBust(Hand loserHand) {
        if(loserHand.equals(dealer))
            return ("Player Bust! Dealer win!");
        else
            return ("Dealer Bust! Player win!");
    }

    /**
     * reset the game
     */
    public void resetModel() {
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();
        deck.shuffleDeck();
        for(int i=0; i<2;i++){
            dealCard(player);
            dealCard(dealer);
        }
        v.resetGame();
    }
}
