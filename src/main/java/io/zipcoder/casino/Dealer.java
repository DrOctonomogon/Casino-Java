package io.zipcoder.casino;

public class Dealer extends BlackJackGambler{


    public Dealer() {
        super(new Player("Dealer",0, false),1000000000);
    }

//    public boolean bust() {
//        if (getHandTotal()>21)
//            return true;
//        return false;
//    }

    public String showOneCard() {
        return "Dealer: "+getHand().get(0);
    }

    public void resetHand() {
        clearHand();
    }

}
