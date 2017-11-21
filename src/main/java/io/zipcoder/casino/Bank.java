package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank<T extends Player> {

    private Map<Player, Integer> playerWagers = new HashMap<Player, Integer>();

    public Bank(ArrayList<T> players) {
        setPlayerWagers(players);
    }

    public Integer takeBet(T player) {
        Integer bet;
        if (player.isPerson()) {
            bet = Console.getIntegerInput("Place your bet");
            playerBet(player, bet);
        } else bet = CompPlay.makeBet(player);

        return bet;
    }

    public void playerBet(T player, Integer amount) {
        playerWagers.put(player, amount);
    }

    public void payOut(ArrayList<T> winners) {
        for (T person : winners) {
                addWinnings(person, 2);
        }
    }

    public void resetBets(ArrayList<T> players) {
        setPlayerWagers(players);
    }

    public void setPlayerWagers(ArrayList<T> players) {
        for (T player :players)
            playerWagers.put(player, 0);
    }

    public void addWinnings(T player, Integer multiplier) {
        Integer winnings = playerWagers.get(player) * multiplier;
        System.out.println(player.getName() + " Winnings: " + winnings);
        //player.addChips(winnings);
    }




    }

}
