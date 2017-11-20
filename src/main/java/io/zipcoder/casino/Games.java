package io.zipcoder.casino;

public interface Games<T> {
    public void play(T user);
    public void addAIPlayers(int playersToAdd);


}
