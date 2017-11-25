package io.zipcoder.casino;

import java.util.*;

import io.zipcoder.casino.Card.*;

public class CompPlay<T> {
    private static Rank rank;

    private static Random rand = new Random();
    private static Map<GoFishPlayer, Set<Rank>> playerCards = new HashMap<>();


    public static Integer makeBet(BlackJackGambler player) {
        return player.placeBet(250);
    }

    public static String hitOrStay(BlackJackGambler player) {
        if (player.getClass().getSimpleName().equals("Dealer"))
            return dealerHitOrStay(player);
        else return basicHitOrStay(player);
    }

    private static String dealerHitOrStay(BlackJackGambler player) {
        if (player.getHandTotal() >= 17)
            return "Stay";
        else return "Hit";
    }

    private static String basicHitOrStay(BlackJackGambler player) {
        if (player.getHandTotal() < 12) {
            return "Hit";
        }
        if (player.getHandTotal() < 18)
            return "Stay";
        else {
            int rand = new Random().nextInt(10) + 1;
            if (rand < 4)
                return "Hit";
            else return "Stay";
        }
    }

    public static String getplayerCards() {
        String cards = "";
        for (GoFishPlayer p : playerCards.keySet()) {
            cards += playerCards.get(p) + "\n";
        }
        return cards;
    }

    public static void setUpPlayerCards(GoFishPlayer player) {
        Set card = new HashSet<Rank>();
        playerCards.put(player, card);
    }

    public static void clearPlayerCards() {
        playerCards.clear();
    }

    public static void addRankToPlayer(GoFishPlayer player, Rank rank) {
        playerCards.get(player).add(rank);
    }


    public static void removeRankFromPlayer(GoFishPlayer player, Rank rank) {
        playerCards.get(player).remove(rank);
    }

    public static Card.Rank chooseRank(GoFishPlayer player) {
        for (Card card : player.getHand()) {
            for (GoFishPlayer fish : playerCards.keySet()) {
                if (playerCards.get(fish).contains(card.getRank())) {
                    rank = card.getRank();
                    return rank;
                }
            }
        }
        rank = player.getHand().get(player.getHand().size() - 1).getRank();
        return rank;
    }

    public static GoFishPlayer choosePlayer(GoFishPlayer player) {
        for (GoFishPlayer p : playerCards.keySet()) {
            if (playerCards.get(p).contains(rank) && !p.equals(player)) {
                return p;
            }
        }
        GoFishPlayer[] arr = playerCards.keySet().stream().toArray(GoFishPlayer[]::new);
        GoFishPlayer other = null;
        do {
            other = arr[rand.nextInt(arr.length)];
        }
        while (other.equals(player));
        return other;
    }


}
