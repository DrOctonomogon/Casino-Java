package io.zipcoder.casino;
import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;

public class CardTest {

    Card card1= new Card(EIGHT, HEARTS);

    @Test
    public void getValueTest() throws Exception {
        int expected =8;
        int actual= card1.getValue();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSuitTest() throws Exception {
        Card.Suit expected =HEARTS;
        Card.Suit actual=card1.getSuit();
        Assert.assertEquals(expected, actual);
    }

}