package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Map;


import io.zipcoder.casino.Card.*;


public class GoFishPlayer extends CardPlayer{

    Map<String, Integer> pairCheck;
    public GoFishPlayer(Player player) {
        super(player);
    }

    public ArrayList<Card> pullCards(Rank rank){
        ArrayList<Card> matching=new ArrayList<>();
        for (Card card:getHand())
            if(rank.toString().equalsIgnoreCase(card.getRank()))
                matching.add(card);
        getHand().removeAll(matching);
        return matching;
       }

    public ArrayList<Card> findPair(){
        for(Card card:getHand()){
            Integer val=pairCheck.getOrDefault();
            pairCheck.put(card.getRank(),val);
        }
        return null;
    }


}
