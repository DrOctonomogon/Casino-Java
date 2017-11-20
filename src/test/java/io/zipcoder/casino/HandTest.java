package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandTest {
    Hand hand=new Hand();
    Card card=new Card(Card.Rank.FIVE, Card.Suit.HEART);
    Card card2=new Card(Card.Rank.THREE, Card.Suit.CLUB);


    Card cardOther=new Card(Card.Rank.NINE, Card.Suit.SPADE);
    Card cardOther2=new Card(Card.Rank.TWO, Card.Suit.DIAMOND);
    Card cardOther3=new Card(Card.Rank.QUEEN, Card.Suit.HEART);
    @Test
    public void addCardTest() throws Exception {
        String expected="FIVE of HEART\nTHREE OF CLUB";
        hand.addCard(card);
        hand.addCard(card2);
        String actual=hand.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCard1Test() throws Exception {
        ArrayList<Card> cards=new ArrayList<Card>();

        String expected="FIVE of HEART\nTHREE of CLUB\nNINE of SPADE\nTWO of DIAMOND\nQUEEN of HEART";

        hand.addCard(card);
        hand.addCard(card2);

        cards.add(cardOther);
        cards.add(cardOther2);
        cards.add(cardOther3);

        hand.addCard(cards);

        String actual=hand.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearHandTest() throws Exception {
        String expected="";

        hand.addCard(card);
        hand.addCard(card2);

        hand.clearHand();
        String actual=hand.toString();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void removeCardTest() throws Exception {
        ArrayList<Card> cards=new ArrayList<Card>();

        String expected="FIVE of HEART\nTHREE of CLUB\nNINE of SPADE\nTWO of DIAMOND\nQUEEN of HEART";

        hand.addCard(card);
        hand.addCard(card2);

        hand.addCard(cardOther);
        cards.add(cardOther2);
        cards.add(cardOther3);

        hand.addCard(cards);

        String actual=hand.toString();

        Assert.assertEquals(expected, actual);

    }


}