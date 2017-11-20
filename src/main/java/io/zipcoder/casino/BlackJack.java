package io.zipcoder.casino;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BlackJack extends CardGames implements Gamble {
    private Dealer dealer;
    private String playAgain = "";
    private Map<Player, Integer> playerWagers = new HashMap<Player, Integer>();

    public void play(Player user) {
        gameSetUp(user);
        do {
            System.out.println("Cards Left: " + getRemainingCards());
            if (getRemainingCards() / getPlayers().size() < 52)
                loadDecks(8);
            for (Player player : getPlayers()) {
                System.out.println(player.getName() + " chips: " + player.getChipCount());
                Integer bet = takeBet(player);
                playerBet(player, bet);
            }

            addPlayer(dealer);
            dealCards(2);
            removePlayer(dealer);

            System.out.println(dealer.showOneCard());
            for (Player player : getPlayers())
                printPlayerHand(player);

            for (Player player : getPlayers()) {
                hitOrStay(player);
            }

            printPlayerHand(dealer);
            hitOrStay(dealer);

            if (!isBust(dealer)) {
                ArrayList<Player> winners = findWinners();
                payOut(winners);
            } else payOut(getPlayers());

            playAgain = Console.getStringInput("play again");
            resetHands();
            resetBets();
        } while ("yes".equalsIgnoreCase(playAgain));

    }

    public void gameSetUp(Player user) {
        dealer = new Dealer();
        addPlayer(user);
        loadDecks(8);
        int numberOfPlayers = new Random().nextInt(6) + 1;
        addAIPlayers(numberOfPlayers);
        setPlayerWagers();
    }

    public void hitOrStay(Player player) {
        String userChoice = "";

        while (!userChoice.equalsIgnoreCase("Stay") && !isBust(player)) {
            if (player.isPerson())
                userChoice = Console.getStringInput("Hit or Stay?");
            else userChoice = CompPlay.hitOrStay(player);

            if (userChoice.equalsIgnoreCase("Hit")) {
                System.out.println(player.getName() + ": Hit");
                Card card = getCard();
                player.addCardToHand(card);
                printPlayerHand(player);
            } else System.out.println(player.getName() + ": Stay");
        }

    }

    public boolean isBust(Player player) {
        if (player.getHandTotal() > 21) {
            System.out.print("Busted ");
            printPlayerHand(player);

            return true;
        }
        return false;
    }

    public void resetHands() {
        for (Player player : getPlayers())
            player.clearHand();
        dealer.resetHand();
    }

    public Integer takeBet(Player player) {
        Integer bet;
        if (player.isPerson()) {
            bet = Console.getIntegerInput("Place your bet");
            player.placeBet(bet);
        } else bet = CompPlay.makeBet(player);

        return bet;
    }

    public void payOut(ArrayList<Player> winners) {
        for (Player player : winners) {
            addWinnings(player, 2);
        }
    }

    public void resetBets() {
        setPlayerWagers();
    }

    public ArrayList<Player> findWinners() {
        ArrayList<Player> winners = new ArrayList<Player>();
        for (Player player : getPlayers())
            if (/*!isBust(player) &&*/ player.getHandTotal() > dealer.getHandTotal()) {
                winners.add(player);
            }

        return winners;
    }

    public void printPlayerHand(Player player) {
        System.out.println(player.getName() + " " + player.getHand() + " " + player.getHandTotal());
    }

    public void addWinnings(Player player, Integer multiplier) {
        Integer winnings = playerWagers.get(player) * multiplier;
        System.out.println(player.getName() + " Winnings: " + winnings);
        player.addChips(winnings);
    }

    public void playerBet(Player player, Integer amount) {
        playerWagers.put(player, amount);
    }

    public void setPlayerWagers() {

        for (Player player : getPlayers())
            playerWagers.put(player, 0);
    }
}
