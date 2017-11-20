package io.zipcoder.casino;

public class Dealer extends Player {


    public Dealer() {
        super("Dealer", 1000000000, false);
    }

    public String showOneCard() {
        return "Dealer: " + getHand().get(0);
    }

    public void resetHand() {
        clearHand();
    }

}
