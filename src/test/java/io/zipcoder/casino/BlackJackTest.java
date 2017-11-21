package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackJackTest {

    BlackJackGambler player=new BlackJackGambler(player1,1000);  
    Player p1;
    Player p2;
    Player p3;
    BlackJack blackJack;
    ArrayList<Player> players;

    @Before
    public void setup() {
        blackJack = new BlackJack();
        players = new ArrayList<Player>();

        p1 = new Player("Samwise", 10000, false);
        p2 = new Player("Frodo", 10000, false);
        p3 = new Player("Smeagol", 10, false);

        players.add(p1);
        players.add(p2);
        players.add(p3);

        blackJack.gameSetUp(players.get(0));
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
    public void payOutTest() throws Exception {

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

        for (Player p : players) {
            actual.put(p, p.getHand().size());
        }

        Assert.assertEquals(expected, actual);
//        int expected = 3;
//        int actual = players.size();
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addWinningsTest() throws Exception {

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
        Integer expected = 25;
        Integer chipsBefore = p1.getChipCount();

        Integer actual = blackJack.takeBet(p1);
        Integer chipsAfter = p1.getChipCount();

        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(chipsBefore, chipsAfter);
    }

    @Test
    public void hitOrStayTest() throws Exception {
        blackJack.loadDecks(1);
        p1.addCardToHand(new Card(Card.Rank.TWO, Card.Suit.SPADE));
        p1.addCardToHand(new Card(Card.Rank.THREE, Card.Suit.DIAMOND));

        System.out.println(p1.getHandTotal());
        int expected = p1.getHand().size() + 1;
        blackJack.hitOrStay(p1);
        int actual = p1.getHand().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWinnersTest() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.KING, Card.Suit.SPADE));
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMOND));
        p1.addCardToHand(new Card(Card.Rank.KING, Card.Suit.DIAMOND));


        p2.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMOND));
        p2.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.DIAMOND));
        p2.addCardToHand(new Card(Card.Rank.KING, Card.Suit.DIAMOND));

        p3.addCardToHand(new Card(Card.Rank.KING, Card.Suit.SPADE));
        p3.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMOND));
        p3.addCardToHand(new Card(Card.Rank.KING, Card.Suit.DIAMOND));

        int expected = 2;

        int actual = blackJack.findWinners().size();

        Assert.assertEquals(expected, actual);
    }

}