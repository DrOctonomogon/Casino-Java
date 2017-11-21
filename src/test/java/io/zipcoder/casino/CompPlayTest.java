package io.zipcoder.casino;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompPlayTest {

        GoFishPlayer goFishPlayer = new GoFishPlayer(new Player("joe", 100, false));
        GoFishPlayer goFishPlayer2 = new GoFishPlayer(new Player("james", 100, false));

    @Test
    public void addRankToPlayer() throws Exception {
        CompPlay.setUpPlayerCards(goFishPlayer);
        CompPlay.setUpPlayerCards(goFishPlayer2);
        CompPlay.showplayerCards();
        CompPlay.addRankToPlayer(goFishPlayer, Card.Rank.THREE);
        CompPlay.addRankToPlayer(goFishPlayer2, Card.Rank.FIVE);
        CompPlay.addRankToPlayer(goFishPlayer, Card.Rank.FIVE);
        CompPlay.showplayerCards();
        CompPlay.removeRankFromPlayer(goFishPlayer, Card.Rank.THREE);
        CompPlay.showplayerCards();

    }

    @Test
    public void setUpPlayerCards() throws Exception {
        CompPlay.setUpPlayerCards(goFishPlayer);
        CompPlay.showplayerCards();
    }

    @Test
    public void removeRankFromPlayer() throws Exception {

    }

    @Test
    public void chooseRank() throws Exception {
    }

    @Test
    public void choosePlayer() throws Exception {
    }

}