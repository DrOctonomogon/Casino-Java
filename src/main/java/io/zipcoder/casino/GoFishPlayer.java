package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.zipcoder.casino.Card.*;


public class GoFishPlayer extends CardPlayer {

    private ArrayList<Rank> completedBooks = new ArrayList<>();
    private int books = 0;
    private Map<Rank, Integer> cardMap;

    public GoFishPlayer(Player player) {
        super(player);
        cardMap = new HashMap<>();
    }

    public void mapNewCard(Card card) {
        Integer val = cardMap.getOrDefault(card.getRank(), 0);
        cardMap.put(card.getRank(), val + 1);
    }

    public void mapCardRemoved(Rank rank) {
        Integer val = cardMap.get(rank);
        cardMap.put(rank, val - 1);
    }

    public boolean checkForCard(Rank rank) {
        if (cardMap.getOrDefault(rank, 0) != 0)
            return true;
        return false;
    }

    public boolean removeBooks() {
        for (Rank rank : cardMap.keySet())
            if (cardMap.get(rank) == 4) {
                CompPlay.removeRankFromPlayer(this, rank);
                addCompletedBooks(rank);
                giveCards(rank);
                books++;
                return true;
            }
        return false;
    }


    public ArrayList<Card> giveCards(Rank rank) {

        ArrayList<Card> cards = new ArrayList<>();
        while (checkForCard(rank)) {
            cards.add(removeCard(rank));
            mapCardRemoved(rank);

        }
        return cards;
    }

    public int getSetCount() {
        return books;
    }

    private void addCompletedBooks(Rank rank) {
        completedBooks.add(rank);
    }

    public String getCompletedBooks() {
        String complete = "";
        for (Rank rank : completedBooks)
            complete += " {" + rank + "} ";
        return complete;
    }

    @Override
    public void addCardToHand(Card card) {
        mapNewCard(card);
        super.addCardToHand(card);
    }

}
