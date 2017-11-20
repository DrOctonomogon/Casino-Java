package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardGames implements Games {
    private ArrayList<Player> players=new ArrayList<Player>();
    private Deck deck;


    public void dealCards(int cardsToDeal) {
        while (cardsToDeal > 0) {

            for (Player player : players) {
                Card card = deck.getCard();
                player.addCardToHand(card);
            }
            cardsToDeal--;
        }
    }

    public void addAIPlayers(int playersToAdd) {
        for (int i = 1; i <= playersToAdd; i++)
            players.add(new Player("Computer" + i, 1000, false));
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void loadDecks(int numberOfDecks) {
        deck = new Deck(numberOfDecks);
        deck.shuffleDeck();
    }

    public int getRemainingCards(){
        return deck.getRemainingCards();
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Card getCard(){
        return deck.getCard();
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

}
