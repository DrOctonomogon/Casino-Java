package io.zipcoder.casino;

import java.util.ArrayList;

public interface Gamble<T> {
    public Integer takeBet(T player);
    public void resetBets();


}
