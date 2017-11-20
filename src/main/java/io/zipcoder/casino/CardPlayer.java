package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardPlayer extends Player {
    private Hand hand;


    public CardPlayer(Player player) {
        super(player.getName(), player.getCash(), player.isPerson());
        hand = new Hand();
    }

    public ArrayList<Card> getHand() {
        return hand.getHand();
    }

    public void clearHand() {
        hand = new Hand();
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public void addCardToHand(ArrayList<Card> card) {
        hand.addCard(card);
    }

    public Card removeCards(Card.Rank rank) {
        return hand.removeCard(rank);
    }

}

