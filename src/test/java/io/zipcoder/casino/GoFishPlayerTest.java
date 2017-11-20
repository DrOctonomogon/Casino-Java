package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GoFishPlayerTest {
    Player joe = new Player("Joe", 1000, false);
    GoFishPlayer player = new GoFishPlayer(joe);


    Card threeHeart = new Card(Card.Rank.THREE, Card.Suit.HEART);
    Card threeClub = new Card(Card.Rank.THREE, Card.Suit.CLUB);
    Card threeSpade = new Card(Card.Rank.THREE, Card.Suit.SPADE);
    Card fiveHeart = new Card(Card.Rank.FIVE, Card.Suit.HEART);
    Card QueenHeart = new Card(Card.Rank.QUEEN, Card.Suit.HEART);

    {
        player.addCardToHand(threeHeart);
        player.addCardToHand(threeClub);
        player.addCardToHand(threeSpade);
        player.addCardToHand(fiveHeart);
        player.addCardToHand(QueenHeart);
    }

    @Test
    public void giveCardsToOther() throws Exception {
        String expected = " " + threeHeart + " " + threeClub + " " + threeSpade;
        String actual = "";

        String remainingExpected = "" + fiveHeart + QueenHeart;
        String remainingActual = "";

        ArrayList<Card> cards = player.giveCardsToOther(Card.Rank.THREE);
        for (Card card : cards)
            actual += " " + card;

        for (Card card : player.getHand())
            remainingActual += card.toString();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(remainingExpected, remainingActual);

    }

    @Test
    public void findCards() throws Exception {
    }

}