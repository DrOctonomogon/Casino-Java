package io.zipcoder.casino;

import io.zipcoder.casino.Card.*;

import java.util.ArrayList;

public class GoFish extends CardGames<GoFishPlayer> {

    public void play(GoFishPlayer user) {
        gameSetUp(user);


        while (booksRemaining() > 0){
            System.out.println("Books remaining: " + booksRemaining());
            booksFound();
            System.out.println("Your Hand: " + user.handToString());
            Rank rank = null;
            GoFishPlayer otherPlayer = null;
            for (GoFishPlayer player : getPlayers()) {
                if(player.getHand().size()==0)
                    continue;
                rank = playerCardChoice(player);
                otherPlayer = chooseOtherPlayer(player);
                System.out.println(player.getName() + " asks " + otherPlayer.getName() + " for any " + rank);
                if (goFish(player, otherPlayer, rank) && getRemainingCards() > 0) {
                    Card card = getCard();
                    player.addCardToHand(card);
                }
                if (player.removeBooks()) {
                    System.out.println("Completed Book: " + rank);
                }
            }


        }
        CompPlay.clearPlayerCards();
        System.out.println("game over");
    }

    public boolean goFish(GoFishPlayer player, GoFishPlayer otherPlayer, Rank rank) {
        CompPlay.addRankToPlayer(player, rank);
        if (otherPlayer.checkForCard(rank)) {

            ArrayList<Card> cardsTaken = otherPlayer.giveCards(rank);
            CompPlay.removeRankFromPlayer(otherPlayer, rank);
            for (Card card : cardsTaken)
                player.addCardToHand(card);
            System.out.println("Found " + cardsTaken.size() + " " + rank);


            Console.getStringInput("press enter to continue");
            return false;
        } else
        {
            System.out.println("no matches found");
            Console.getStringInput("press enter to continue");
            return true;
        }

    }

    public GoFishPlayer chooseOtherPlayer(GoFishPlayer player) {
        Integer playerIndex;
        GoFishPlayer chosenPlayer;
        if (player.isPerson()) {
            printPlayers();
            do {
                playerIndex = Console.getIntegerInput("\nWho has your card? ");
                chosenPlayer = getPlayer(playerIndex);
            } while (chosenPlayer == null);
        } else chosenPlayer = CompPlay.choosePlayer(player);
        return chosenPlayer;
    }


    public Rank playerCardChoice(GoFishPlayer player) {
        Rank rank;
        if (player.isPerson()) {
            player.handToString();
            do {
                rank = Console.getRankInput("What card are you looking for?");
            } while (!player.checkForCard(rank));
        } else rank = CompPlay.chooseRank(player);
        return rank;
    }

    public void booksFound() {
        for (GoFishPlayer player : getPlayers())
            System.out.println(player.getName() + " Completed Books: " + player.getCompletedBooks());
    }

    public int booksRemaining() {
        int matchesMade = 0;
        for (GoFishPlayer player : getPlayers())
            matchesMade += player.getSetCount();
        return 13 - matchesMade;
    }

    public void gameSetUp(GoFishPlayer user) {
        addPlayer(user);
        loadDecks(1);

        int numberOfPlayers = Console.getIntegerInput("How many other players would you like to play with? ");
        addAIPlayers(numberOfPlayers);
        for (GoFishPlayer player : getPlayers())
            CompPlay.setUpPlayerCards(player);
        dealCards(5);
    }

    public void addAIPlayers(int playersToAdd) {
        for (int i = 1; i <= playersToAdd; i++)
            addPlayer(new GoFishPlayer(new Player("Computer " + i, 0, false)));
    }

    public void printPlayers() {
        for (int i = 0; i < getPlayers().size(); i++)
            System.out.print(" " + i + ") " + getPlayer(i).getName());
    }

}
