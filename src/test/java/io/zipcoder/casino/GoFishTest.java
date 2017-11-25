package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishTest {
    GoFish goFish=new GoFish();
    GoFishPlayer jj=new GoFishPlayer(new Player("jj",10, false));

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
    public void addAIPlayers() throws Exception {
        String expected="Computer 1 Computer 2 ";
        String actual="";
        goFish.addAIPlayers(2);
        for (GoFishPlayer player:goFish.getPlayers())
            actual+=player.getName()+" ";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printPlayers() throws Exception {
    }

}