package io.zipcoder.casino;

public class main {


    public static void main(String[] args) {
        Player player1=new Player("koz", 1000, true);
        BlackJackGambler player=new BlackJackGambler(player1,10000);
        BlackJack blackJack=new BlackJack();
        blackJack.play(player);
    }
}
