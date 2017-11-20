package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJackGambler extends CardPlayer {
    private Player plauer;
    private Integer chipCount;

    public BlackJackGambler(Player player, Integer chipCount) {
        super(player);
        this.chipCount=chipCount;
    }

    public Integer getChipCount() {
        return chipCount;
    }

    public void addChips(Integer amount) {
        chipCount += amount;
    }

    public Integer placeBet(Integer amount) {
        if (wagerAvailable(amount))
            chipCount -= amount;
        else amount = 0;

        return amount;
    }

    private boolean wagerAvailable(Integer bet) {
        if (bet > chipCount)
            return false;
        else return true;
    }

    public int getHandTotal() {
        int total = 0;
        String card;
        int aces = 0;
        for (Card c : getHand()) {
            card = c.getRank();
            if ("JACK".equals(card) || "QUEEN".equals(card) || "KING".equals(card))
                total += 10;
            else if ("ACE".equals(card)) {
                total += 11;
                aces++;
            } else total += c.getValue();
        }
        while (total > 21 && aces != 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

//    public ArrayList<Card> getHand() {
//        return hand.getHand();
//    }
//    public void clearHand() {
//        hand = new Hand();
//    }

}
