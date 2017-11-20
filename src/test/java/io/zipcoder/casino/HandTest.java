package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandTest {
    Hand hand;
    Card card;
    Card card2;

    Card cardOther;
    Card cardOther2;
    Card cardOther3;

    @Before
    public void setup() {
        hand = new Hand();
        card = new Card(Card.Rank.FIVE, Card.Suit.HEART);
        card2 = new Card(Card.Rank.THREE, Card.Suit.CLUB);

        cardOther = new Card(Card.Rank.NINE, Card.Suit.SPADE);
        cardOther2 = new Card(Card.Rank.TWO, Card.Suit.DIAMOND);
        cardOther3 = new Card(Card.Rank.QUEEN, Card.Suit.HEART);
    }

    @Test
    public void addCardTest() throws Exception {
        String expected = "FIVE of HEART\nTHREE of CLUB";
        hand.addCard(card);
        hand.addCard(card2);
        String actual = hand.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCard1Test() throws Exception {
        ArrayList<Card> cards = new ArrayList<Card>();

        String expected = "FIVE of HEART\nTHREE of CLUB\nNINE of SPADE\nTWO of DIAMOND\nQUEEN of HEART";

        hand.addCard(card);
        hand.addCard(card2);

        cards.add(cardOther);
        cards.add(cardOther2);
        cards.add(cardOther3);

        hand.addCard(cards);

        String actual = hand.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearHandTest() throws Exception {
        String expected = "Hand is Empty.";

        hand.addCard(card);
        hand.addCard(card2);

        hand.clearHand();
        String actual = hand.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeCardTest() throws Exception {
        ArrayList<Card> cards = new ArrayList<Card>();

        String expected = "FIVE of HEART\nTHREE of CLUB\nNINE of SPADE\nTWO of DIAMOND\nQUEEN of HEART";

        hand.addCard(card);
        hand.addCard(card2);

        hand.addCard(cardOther);
        cards.add(cardOther2);
        cards.add(cardOther3);

        hand.addCard(cards);

        String actual = hand.toString();

        Assert.assertEquals(expected, actual);

    }


}