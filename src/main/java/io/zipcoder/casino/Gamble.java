package io.zipcoder.casino;

import java.util.ArrayList;

public interface Gamble<T> {
    public Integer takeBet(T player);
//    public void payOut(ArrayList<T> winners);
//    public ArrayList<T> findWinners();
    public void resetBets();
//    public void addWinnings(T player, Integer multiplier);

}
