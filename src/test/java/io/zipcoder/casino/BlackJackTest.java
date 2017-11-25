package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackJackTest {

    //BlackJackGambler player=new BlackJackGambler(player1,1000);
    BlackJackGambler p1;
    BlackJackGambler p2;
    BlackJackGambler p3;
    BlackJack blackJack;
    Dealer dealer;
    ArrayList<BlackJackGambler> players;

    @Before
    public void setup() {
        blackJack = new BlackJack();
        players = new ArrayList<BlackJackGambler>();

        p1 = new BlackJackGambler(new Player("Samwise", 10000, false),1000 );
        p2 = new BlackJackGambler(new Player("Frodo", 10000, false),1000 );
        p3 = new BlackJackGambler(new Player("Smeagol", 10, false),1000 );
        dealer= new Dealer();
        blackJack.addPlayer(p1);
        blackJack.addPlayer(p2);
        blackJack.addPlayer(p3);

        blackJack.gameSetUp(p2);
//        blackJack.gameSetUp(p3);
    }

    @Test
    public void isBustTest() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADE));
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMOND));

        System.out.println(p1.getHandTotal());
        boolean expected = false;
        boolean actual = blackJack.isBust(p1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isBustTest2() throws Exception {
//        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADE));
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.KING, Card.Suit.SPADE));

        System.out.println(p1.getHandTotal());
        boolean expected = true;
        boolean actual = blackJack.isBust(p1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resetHandsTest() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMOND));
        p2.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
        p2.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMOND));
        p3.addCardToHand(new Card(Card.Rank.KING, Card.Suit.SPADE));
        p3.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));

        HashMap<Player, Integer> expected = new HashMap<Player, Integer>();
        HashMap<Player, Integer> actual = new HashMap<Player, Integer>();

        for (Player p : players) {
            expected.put(p, 0);
        }


        blackJack.resetHands();

        for (BlackJackGambler p : players) {
            actual.put(p, p.getHand().size());
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addWinningsTest1() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMOND));
        blackJack.gameSetUp(p1);
        blackJack.playerBet(p1, 250);

        Integer expected = p1.getChipCount()+500;
        blackJack.addWinnings(p1,2);
        Integer actual = p1.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addWinningsTest2() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.DIAMOND));
        blackJack.gameSetUp(p1);
        blackJack.playerBet(p1, 250);

        Integer expected = p1.getChipCount();
        blackJack.addWinnings(p1,0);
        Integer actual = p1.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addWinningsTest3() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMOND));
        blackJack.gameSetUp(p1);
        blackJack.playerBet(p1, 250);

        Integer expected = p1.getChipCount()+625;
        blackJack.addWinnings(p1,2);
        Integer actual = p1.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerBetTest() throws Exception {

        int bet = 5;

        blackJack.playerBet(p3, bet);

        int expected = p3.getChipCount() + bet;

        blackJack.addWinnings(p3, 1);

        int actual = p3.getChipCount();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void takeBetTest() throws Exception {
        Integer expected = 250;
        Integer chipsBefore = p1.getChipCount()-250;

        Integer actual = blackJack.takeBet(p1);
        Integer chipsAfter = p1.getChipCount();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(chipsBefore, chipsAfter);
    }

    @Test
    public void checkForBlackJackTest() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADE));
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));

        boolean expected=true;
        boolean actual =blackJack.checkForBlackJack(p1);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAIPlayers() throws Exception {
        int  expected=blackJack.getPlayers().size()+3;
        blackJack.addAIPlayers(3);
        int actual = blackJack.getPlayers().size();

        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void findWinnersTest() throws Exception {
//        p1.addCardToHand(new Card(Card.Rank.KING, Card.Suit.SPADE));
//        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMOND));
//        p1.addCardToHand(new Card(Card.Rank.KING, Card.Suit.DIAMOND));
//
//
//        p2.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
//        p2.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.DIAMOND));
//        p2.addCardToHand(new Card(Card.Rank.KING, Card.Suit.DIAMOND));
//
//        p3.addCardToHand(new Card(Card.Rank.KING, Card.Suit.SPADE));
//        p3.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMOND));
//        p3.addCardToHand(new Card(Card.Rank.KING, Card.Suit.DIAMOND));
//
//        int expected = 2;
//
//        int actual = blackJack.findWinners().size();
//
//        Assert.assertEquals(expected, actual);
//    }


//    @Test
//    public void playerVsDealerPayoutTest() throws Exception {
//
//        System.out.println(p1.getHand()+" "+p1.getHandTotal());
//
//        int expected =1;
//        int actual =blackJack.playerVsDealerPayout(p1);
//
//        Assert.assertEquals(expected, actual);
//    }


}