package io.zipcoder.casino;

public class main {


    public static void main(String[] args) {
        Player player=new Player("koz", 10000, true);
        BlackJack blackJack=new BlackJack();
        blackJack.play(player);
    }
}
