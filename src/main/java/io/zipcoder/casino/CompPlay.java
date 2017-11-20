package io.zipcoder.casino;

import java.util.Random;

public class CompPlay {
    public static Integer makeBet(BlackJackGambler player) {
        return player.placeBet(25);
    }

    public static String hitOrStay(BlackJackGambler player) {
        if (player.getClass().getSimpleName().equals("Dealer"))
            return dealerHitOrStay(player);
        else return basicHitOrStay(player);
    }

    private static<T extends CardPlayer> String dealerHitOrStay(BlackJackGambler player) {
        if (player.getHandTotal() >= 17)
            return "Stay";
        else return "Hit";
    }

    private static String basicHitOrStay(BlackJackGambler player) {
        if (player.getHandTotal() < 12){
            return "Hit";}
        if (player.getHandTotal() < 18)
            return "Stay";
        else {
            int rand = new Random().nextInt(10) + 1;
            if (rand < 4)
                return "Hit";
            else return "Stay";
        }
    }
}
