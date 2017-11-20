package io.zipcoder.casino;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;

public class Player {
    private String name;
//    private Integer chipCount;
    private Hand hand;
    private boolean isPerson;
    private Integer cash;

    public Player(String name, Integer cash, boolean isPerson) {
        this.name = name;
//        chipCount = startingChips;
        this.isPerson = isPerson;
        this.cash=cash;
//        hand = new Hand();
    }

//    public void addCardToHand(Card card) {
//        hand.addCard(card);
//    }
//
//    public Integer getChipCount() {
//        return chipCount;
//    }
//
//    public void addChips(Integer amount) {
//        chipCount += amount;
//    }
//
//    public Integer placeBet(Integer amount) {
//        if (wagerAvailable(amount))
//            chipCount -= amount;
//        else amount = 0;
//
//        return amount;
//    }
//
//    private boolean wagerAvailable(Integer bet) {
//        if (bet > chipCount)
//            return false;
//        else return true;
//    }

    public String getName() {
        return name;
    }

    public boolean isPerson() {
        return isPerson;
    }

//    public void clearHand() {
//        hand = new Hand();
//    }
//
//    public int getHandTotal() {
//        int total = 0;
//        String card;
//        int aces = 0;
//        for (Card c : hand.getHand()) {
//            card = c.getRank();
//            if ("JACK".equals(card) || "QUEEN".equals(card) || "KING".equals(card))
//                total += 10;
//            else if ("ACE".equals(card)) {
//                total += 11;
//                aces++;
//            } else total += c.getValue();
//        }
//        while (total > 21&&aces!=0) {
//            total -= 10;
//            aces--;
//        }
//        return total;
//    }
//
//    public ArrayList<Card> getHand() {
//        return hand.getHand();
//    }

    public Integer getCash() {
        return cash;
    }
}
