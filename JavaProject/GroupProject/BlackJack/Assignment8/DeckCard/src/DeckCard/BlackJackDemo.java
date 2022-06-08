package DeckCard;

public class BlackJackDemo {
    /**
     * BlackJack game demo
     */
    public static void main(String[] args) {
        BlackJackGame bj = new BlackJackGame();
        bj.showDealerHand();
        bj.showPlayerHard();

        if (!bj.gameIsOver()) {
            boolean playerPlaying = true;
                do{
                    try {
                        playerPlaying = bj.playerHit();
                        if (playerPlaying) {
                            bj.dealCard(bj.player);
                            if (bj.isBust(bj.player) || bj.isBlackJack(bj.player))
                                break;
                            bj.player.printDeck();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid Input!");
                    }
                } while(playerPlaying);

            if (bj.isBlackJack(bj.player)) {
                bj.printWinner(bj.player);
                bj.gameOver();
                System.exit(0);
            } else if (bj.isBust(bj.player)) {
                bj.printWinner(bj.dealer);
                bj.gameOver();
                System.exit(0);
            }
            bj.dealerPlay();
        }

        if(bj.isBlackJack(bj.player) && bj.isBlackJack(bj.dealer))
            bj.printWinner();
        else {
            if (bj.isBlackJack(bj.dealer)) {
                bj.printWinner(bj.dealer);
            } else if (bj.isBust(bj.dealer)) {
                bj.printWinner(bj.player);
            } else if (bj.isBlackJack(bj.player)) {
                bj.printWinner(bj.player);
            } else if (bj.isTie(bj.player,bj.dealer)){
                bj.printWinner();
            } else {
                bj.printWinner(bj.isHighPoint(bj.player, bj.dealer));
            }
            bj.gameOver();
        }
    }
}
