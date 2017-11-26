package io.zipcoder.casino;

import java.util.ArrayList;

public interface Gamble<T> {
    public Integer takeBet(T player);
//    public void payoutWinnings(T player, double multiplier);
//    public void checkForWinners();
    public void resetBets();


}
