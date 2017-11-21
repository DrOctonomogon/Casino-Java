package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import io.zipcoder.casino.Card.*;


public class GoFishPlayer extends CardPlayer {

    private ArrayList<Rank> completedSets = new ArrayList<>();
    private int sets = 0;
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

    public void removeQuads() {
        for (Rank rank : cardMap.keySet())
            if (cardMap.get(rank) == 4) {
                addCompletedQuads(rank);
                giveCards(rank);
                sets++;
            }
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
        return sets;
    }

    private void addCompletedQuads(Rank rank) {
        completedSets.add(rank);
    }

    public void printCompetedQuads() {
        String complete = "";
        for (Rank rank : completedSets)
            complete += " {" + rank + "} ";
        System.out.println(complete);
    }

    @Override
    public void addCardToHand(Card card) {
        mapNewCard(card);
        super.addCardToHand(card);
    }

}
