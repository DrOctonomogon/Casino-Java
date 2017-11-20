package io.zipcoder.casino;

public class CrapsPlayer extends Player{

    Player player;
    Integer chipCount=0;

    public CrapsPlayer(Player player, Integer chipCount) {
        super(player.getName(), player.getCash(), player.isPerson());
        this.player=player;
    }
}
