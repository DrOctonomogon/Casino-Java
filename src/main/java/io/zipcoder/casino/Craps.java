package io.zipcoder.casino;

import java.util.ArrayList;

public class Craps implements Games, Gamble {

    private String playAgain = "";

    Die d1 = new Die();
    Die d2 = new Die();

    private void rollDice() {
        d1.rollDie();
        d2.rollDie();
    }

    public Integer takeBet(Player player) {
        return null;
    }

    public void payOut(ArrayList<Player> winners) {

    }

    public ArrayList<Player> findWinners() {
        return null;
    }

    public void resetBets() {

    }

    public void addWinnings(Player player, Integer multiplier) {

    }

    public void play(Player user) {

        do {
            Die d1 = new Die();
            Die d2 = new Die();
            int pointValue;
            int rollValue;
            int bet4or10 = 0;
            int bet5or9 = 0;
            int bet6or8 = 0;

            Integer pot = takeBet(user);

            rollDice();

            rollValue = d1.getValue() + d2.getValue();

            if(rollValue == 7 || rollValue == 11) {
                // Win
                // return pot * multiplier
                // player is prompted to take winnings or play again with current winnings
            }
            else if(rollValue == 2 || rollValue == 3 || rollValue == 12) {
                // Lose
                // player loses pot
                // player is prompted to play again
            }
            else {

                do {
                    pointValue = rollValue;

                    // prompt for bets on next roll group (4 & 10, 5 & 9, or 6 & 8)

                    rollDice();
                    rollValue = d1.getValue() + d2.getValue();

                    switch(rollValue) {

                        case 4:
                            if(pointValue == 4) {
                                // Win
                                // return pot + side bets
                            }
                            else if(pointValue == 10 && bet4or10 < 0) {
                                // Win side bets in bet4or10
                                //continue
                            }
                            else {
                                continue;
                            }
                            break;
                        case 5:
                            if(pointValue == 5) {
                                // Win
                                // return pot + side bets
                            }
                            else if(pointValue == 9 && bet5or9 < 0) {
                                // Win side bet
                                continue;
                            }
                            else {
                                continue;
                            }
                            break;
                        case 6:
                            if(pointValue == 6) {
                                // Win
                            }
                            else if(pointValue == 8 && bet6or8 < 0) {
                                // Win side bet
                                //continue
                            }
                            else {
                                continue;
                            }
                            break;
                        case 7:
                            // Lose
                            // player loses pot and any side bets
                            // player is prompted to play again
                            break;
                        case 8:
                            if(pointValue == 8) {
                                // Win
                            }
                            else if(pointValue == 6 && bet6or8 < 0) {
                                // Win side bet
                                //continue
                            }
                            else {
                                continue;
                            }
                            break;
                        case 9:
                            if(pointValue == 9) {
                                // Win
                            }
                            else if(pointValue == 5 && bet5or9 < 0) {
                                // Win side bet
                                //continue
                            }
                            else {
                                continue;
                            }
                            break;
                        case 10:
                            if(pointValue == 10) {
                                // Win
                            }
                            else if(pointValue == 4 && bet4or10 < 0) {
                                // Win side bet
                                //continue
                            }
                            else {
                                continue;
                            }
                            break;
                    }

                }
                while(rollValue != pointValue || rollValue != 7);

                if(rollValue == pointValue) {
                    // Win
                    // player loses initial bet
                    // player is prompted to play again
                }
                else if(rollValue == 7) {
                    // Lose
                    // player loses initial bet
                    // player is prompted to play again
                }

            }

            playAgain = Console.getStringInput("play again");

        } while("yes".equalsIgnoreCase(playAgain));

    }

    private void winningRoll() {

    }

}
