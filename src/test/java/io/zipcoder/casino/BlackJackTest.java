package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BlackJackTest {


    @Test
    public void isBustTest() throws Exception {
        player.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADE));
        player.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
        player.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMOND));

        System.out.println(player.getHandTotal());
        boolean expected = false;
        boolean actual = blackJack.isBust(player);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isBustTest2() throws Exception {
        player.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADE));
        player.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
        player.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMOND));

        System.out.println(player.getHandTotal());
        boolean expected = true;
        boolean actual = blackJack.isBust(player);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resetHandsTest() throws Exception {
    }

    @Test
    public void playerBetTest() throws Exception {
    }

    Player player1=new Player("Samwise", 10000, false);
    BlackJackGambler player=new BlackJackGambler(player1,1000);
    BlackJack blackJack=new BlackJack();
    ArrayList<Player> players=new ArrayList<Player>();


    @Test
    public void addWinningsTest() throws Exception {
    }



    @Test
    public void takeBetTest() throws Exception {
        Integer expected=25;
        Integer chipsBefore=player.getChipCount();

        Integer actual=blackJack.takeBet(player);
        Integer chipsAfter=player.getChipCount();

        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(chipsBefore, chipsAfter);
    }

    @Test
    public void hitOrStayTest() throws Exception {
        blackJack.loadDecks(1);
        player.addCardToHand(new Card(Card.Rank.TWO, Card.Suit.SPADE));
        player.addCardToHand(new Card(Card.Rank.THREE, Card.Suit.DIAMOND));

        System.out.println(player.getHandTotal());
        int expected = player.getHand().size()+1;
        blackJack.hitOrStay(player);
        int actual = player.getHand().size();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void payOutTest() throws Exception {

    }

    @Test
    public void calculateWinningsTest() throws Exception {
    }

    @Test
    public void findWinnersTest() throws Exception {
    }

}