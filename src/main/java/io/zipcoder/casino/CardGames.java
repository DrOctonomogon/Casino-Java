package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardGames<T extends CardPlayer> implements Games<T> {
    private ArrayList<T> players=new ArrayList<T>();
    private Deck deck;


    public void dealCards(int cardsToDeal) {
        while (cardsToDeal > 0) {

            for (T player : players) {
                Card card = deck.getCard();
                player.addCardToHand(card);
            }
            cardsToDeal--;
        }
    }

    public void addPlayer(T player) {
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

    public ArrayList<T> getPlayers() {
        return players;
    }

    public Card getCard(){
        return deck.getCard();
    }

    public void removePlayer(T player){
        players.remove(player);
    }

}
