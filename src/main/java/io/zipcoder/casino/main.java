package io.zipcoder.casino;

public class main {


    public static void main(String[] args) {
        Player player1=new Player("koz", 1000, false);

//      BlackJackGambler player=new BlackJackGambler(player1,10000);
//      BlackJack blackJack=new BlackJack();
//      blackJack.play(player);

        GoFishPlayer player=new GoFishPlayer(player1);
        GoFish goFish=new GoFish();
        goFish.play(player);

    }
}
