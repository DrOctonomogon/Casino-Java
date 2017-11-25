package io.zipcoder.casino;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BlackJack extends CardGames<BlackJackGambler> implements Gamble<BlackJackGambler> {
    private Dealer dealer;
    private String playAgain = "";
    private Map<BlackJackGambler, Integer> playerWagers = new HashMap<BlackJackGambler, Integer>();

    public void play(BlackJackGambler user) {
        gameSetUp(user);
        do {
            System.out.println("Cards Left: " + getRemainingCards());
            if (getRemainingCards() / getPlayers().size() < 52)
                loadDecks(8);
            for (BlackJackGambler player : getPlayers()) {
                System.out.println(player.getName() + " chips: " + player.getChipCount());
                Integer bet = takeBet(player);
                playerBet(player, bet);
            }

            addPlayer(dealer);
            dealCards(2);
            removePlayer(dealer);

            System.out.println(dealer.showOneCard());
            for (BlackJackGambler player : getPlayers())
                player.getHand();

            for (BlackJackGambler player : getPlayers())
                hitOrStay(player);

            dealer.getHand();
            hitOrStay(dealer);


            for (BlackJackGambler player : getPlayers()) {
                int multiplier = 0;
                if (!isBust(dealer))
                    multiplier = playerVsDealerPayout(player);
                else if (!isBust(player))
                    multiplier = 2;
                addWinnings(player, multiplier);
            }

            playAgain = Console.getStringInput("Play again?");
            resetHands();
            resetBets();
        } while ("yes".equalsIgnoreCase(playAgain));

    }

    public void gameSetUp(BlackJackGambler user) {
        dealer = new Dealer();
        addPlayer(user);
        loadDecks(8);
        int numberOfPlayers = new Random().nextInt(6) + 1;
        addAIPlayers(numberOfPlayers);
        resetBets();
    }

    public void hitOrStay(BlackJackGambler player) {
        String userChoice = "";

        while (!userChoice.equalsIgnoreCase("Stay") && !isBust(player)) {
            if (player.isPerson())
                userChoice = Console.getStringInput("Hit or Stay?");
            else userChoice = CompPlay.hitOrStay(player);

            if (userChoice.equalsIgnoreCase("Hit")) {
                System.out.println(player.getName() + ": Hit");
                Card card = getCard();
                player.addCardToHand(card);
                player.getHand();
            } else if (userChoice.equalsIgnoreCase("Stay"))
                System.out.println(player.getName() + ": Stay");
        }

        if (isBust(player))
            System.out.println(player.getName() + " went over: " + player.getHand());
    }

    public void addAIPlayers(int playersToAdd) {
        for (int i = 1; i <= playersToAdd; i++)
            getPlayers().add(new BlackJackGambler(new Player("Computer" + i, 0, false), 5000));
    }

    public boolean isBust(BlackJackGambler player) {
        if (player.getHandTotal() > 21) {
            return true;
        }
        return false;
    }

    public void resetHands() {
        for (BlackJackGambler player : getPlayers())
            player.clearHand();
        dealer.resetHand();
    }

    public Integer takeBet(BlackJackGambler player) {
        Integer bet;
        if (player.isPerson()) {
            bet = Console.getIntegerInput("Place your bet");
            player.placeBet(bet);
        } else bet = CompPlay.makeBet(player);

        return bet;
    }

    public void resetBets() {
        for (BlackJackGambler player : getPlayers())
            playerWagers.put(player, 0);
    }

    public int playerVsDealerPayout(BlackJackGambler player) {
        if (player.getHandTotal() > dealer.getHandTotal()) {
            System.out.println(player.getHandTotal() + " " + dealer.getHandTotal());
            return 2;
        } else if (player.getHandTotal() == dealer.getHandTotal())
            return 1;
        return 0;
    }

    public boolean checkForBlackJack(BlackJackGambler player) {
        if (player.getHandTotal() == 21 && player.getHand().size() == 2)
            return true;
        return false;
    }

    public void addWinnings(BlackJackGambler player, double multiplier) {
        if (checkForBlackJack(player))
            multiplier += 0.5;
        Integer winnings = (int) (playerWagers.get(player).doubleValue() * multiplier);
        System.out.println(player.getName() + " Winnings: " + winnings);
        player.addChips(winnings);
    }

    public void playerBet(BlackJackGambler player, Integer amount) {
        playerWagers.put(player, amount);
    }

//    public void payOut(ArrayList<BlackJackGambler> winners) {
//        for (BlackJackGambler player : winners) {
//            addWinnings(player, 2);
//        }
//    }
//
//    public ArrayList<BlackJackGambler> findWinners() {
//        ArrayList<BlackJackGambler> winners = new ArrayList<BlackJackGambler>();
//        for (BlackJackGambler player : getPlayers())
//            if (!isBust(player)&&player.getHandTotal() > dealer.getHandTotal()) {
//                winners.add(player);
//            }
//
//        return winners;
//    }
}
