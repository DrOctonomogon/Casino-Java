package io.zipcoder.casino;


public class Card {

    enum Rank {

        JOKER, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        public int getValue() {
            return ordinal()+1;
        }
    }

    enum Suit {
        CLUB, SPADE, HEART, DIAMOND;
    }


    private Rank rank;
    private Suit suit;

    public Card(Rank v, Suit s) {
        this.rank = v;
        this.suit = s;
    }

    public int getValue() {
        return rank.getValue();
    }
    public String getRank(){return rank.toString();}

    public Suit getSuit() {
        return suit;
    }

    public String toString(){
        return rank+" of "+suit;
    }
}
