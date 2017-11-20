package io.zipcoder.casino;

import java.util.ArrayList;

public interface Gamble {
    public Integer takeBet(Player player);
    public void payOut(ArrayList<Player> winners);
    public ArrayList<Player> findWinners();
    public void resetBets();
    public void addWinnings(Player player, Integer multiplier);

}
