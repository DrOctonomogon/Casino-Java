package io.zipcoder.casino;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishTest {
    GoFish goFish=new GoFish();
    @Test
    public void play() throws Exception {
        goFish.play(new GoFishPlayer(new Player("jj",10, false)));
    }

    @Test
    public void goFish() throws Exception {
    }

    @Test
    public void chooseOtherPlayer() throws Exception {

    }

    @Test
    public void playerCardChoice() throws Exception {
    }

    @Test
    public void booksFound() throws Exception {
    }

    @Test
    public void booksRemaining() throws Exception {
    }

    @Test
    public void gameSetUp() throws Exception {
    }

    @Test
    public void addAIPlayers() throws Exception {
    }

    @Test
    public void printPlayers() throws Exception {
    }

}