package io.zipcoder.casino;

import java.util.ArrayList;

public class Craps implements Gamble<CrapsPlayer>, Games<CrapsPlayer> {

    private String playAgain = "yes";

    int pot;

    Die d1 = new Die();
    Die d2 = new Die();

    int bet4or10 = 0;
    int bet5or9 = 0;
    int bet6or8 = 0;

    private void rollDice() {
        d1.rollDie();
        d2.rollDie();
    }

    @Override
    public void play(CrapsPlayer player) {

        do {
            Die d1 = new Die();
            Die d2 = new Die();
            int pointValue;
            int rollValue;


            pot = takeBet(player);

            rollDice();

            rollValue = d1.getValue() + d2.getValue();

            if (rollValue == 7 || rollValue == 11) {
                // Win
                payOut(player, pot, 2);
                playAgain = Console.getStringInput("play again");

            } else if (rollValue == 2 || rollValue == 3 || rollValue == 12) {
                // Lose
                continue;
            } else {
                pointValue = rollValue;
                do {
                    // prompt for bets on next roll group (4 & 10, 5 & 9, or 6 & 8)
                    placeSideBet(player);

                    rollDice();
                    rollValue = d1.getValue() + d2.getValue();

                    switch (rollValue) {

                        case 4:
                            if (pointValue == 4) {
                                int total = pot + bet4or10;
                                payOut(player, total, 2);
                                pot = 0;
                                clearSideBets();
                            } else if (pointValue == 10 && bet4or10 < 0) {
                                payOut(player, bet4or10, 1);
                                clearSideBets();
                            } else {
                                clearSideBets();
                            }
                            break;
                        case 5:
                            if (pointValue == 5) {
                                int total = pot + bet4or10;
                                payOut(player, total, 2);
                                pot = 0;
                                clearSideBets();
                            } else if (pointValue == 9 && bet5or9 < 0) {
                                payOut(player, bet5or9, 1);
                                clearSideBets();
                            } else {
                                clearSideBets();
                            }
                            break;
                        case 6:
                            if (pointValue == 6) {
                                int total = pot + bet6or8;
                                payOut(player, total, 2);
                                pot = 0;
                                clearSideBets();
                            } else if (pointValue == 8 && bet6or8 < 0) {
                                payOut(player, bet6or8, 1);
                                clearSideBets();
                            } else {
                                clearSideBets();
                            }
                            break;
                        case 7:
                            // Lose
                            clearSideBets();
                            break;
                        case 8:
                            if (pointValue == 8) {
                                int total = pot + bet6or8;
                                payOut(player, total, 2);
                                pot = 0;
                                clearSideBets();
                            } else if (pointValue == 6 && bet6or8 < 0) {
                                payOut(player, bet6or8, 1);
                                clearSideBets();
                            } else {
                                clearSideBets();
                            }
                            break;
                        case 9:
                            if (pointValue == 9) {
                                int total = pot + bet4or10;
                                payOut(player, total, 2);
                                pot = 0;
                                clearSideBets();
                            } else if (pointValue == 5 && bet5or9 < 0) {
                                payOut(player, bet5or9, 1);
                                clearSideBets();
                            } else {
                                clearSideBets();
                            }
                            break;
                        case 10:
                            if (pointValue == 10) {
                                int total = pot + bet4or10;
                                payOut(player, total, 2);
                                pot = 0;
                                clearSideBets();
                            } else if (pointValue == 4 && bet4or10 < 0) {
                                payOut(player, bet4or10, 1);
                                clearSideBets();
                            } else {
                                clearSideBets();
                                continue;
                            }
                            break;
                        default:
                            break;
                    }

                }
                while (rollValue != pointValue || rollValue != 7);

                resetBets();
//                if (rollValue == pointValue) {
//                    // Win
//                    // player loses initial bet
//                    // player is prompted to play again
//                } else if (rollValue == 7) {
//                    // Lose
//                    // player loses initial bet
//                    // player is prompted to play again
//                }
            }

            playAgain = Console.getStringInput("play again");

        } while ("yes".equalsIgnoreCase(playAgain));
    }

    @Override
    public Integer takeBet(CrapsPlayer player) {
        Integer bet;
        bet = Console.getIntegerInput("Place your bet");
        player.placeBet(bet);

        return bet;
    }

    private int placeSideBet(CrapsPlayer player) {
        boolean isValidInput = false;
        int retValue = -1;

        while (isValidInput == false) {
            String group = Console.getStringInput("Which group would you like to bet on?\n" +
                    "[4 & 10]\t[5 & 9]\t[6 & 8]\tNONE");
            if (group.equals("4 & 10") || group.equals("4&10") || group.equals("4") || group.equals("10")) {
                bet4or10 = takeBet(player);
                isValidInput = true;
            } else if (group.equals("5 & 9") || group.equals("5&9") || group.equals("5") || group.equals("9")) {
                bet5or9 = takeBet(player);
                isValidInput = true;
            } else if (group.equals("6 & 8") || group.equals("6&8") || group.equals("6") || group.equals("8")) {
                bet6or8 = takeBet(player);
                isValidInput = true;
            } else if (group.equalsIgnoreCase("NONE")) {
                retValue = 0;
                isValidInput = true;
            } else {
                System.out.println("Invalid input. Try again");
            }
        }
        return retValue;

    }
    
    @Override
    public void resetBets() {
        pot = 0;
        clearSideBets();
    }

    private void clearSideBets() {
        bet4or10 = 0;
        bet5or9 = 0;
        bet6or8 = 0;
    }

    public void payOut(CrapsPlayer player, int value, int multiplier) {
        player.addChips(value * multiplier);
    }

//    public void resetBets() {
//        resetPlayerWagers();
//    }
//
//    public void payoutWinnings(CrapsPlayer player, Integer multiplier) {
//        Integer winnings = (pot * multiplier) + sideBets;
//        System.out.println(player.getName() + " Winnings: " + winnings);
//        player.addChips(winnings);
//    }
//
//    public void addAIPlayers(int playersToAdd) {
//        for (int i = 1; i <= playersToAdd; i++)
//            getPlayers().add(new CrapsPlayer(new Player ("Computer" + i, 0, false),5000));
//    }
//
//    public void playerBet(BlackJackGambler player, Integer amount) {
//        playerWagers.put(player, amount);
//    }
//
//    public ArrayList<CrapsPlayer> getPlayers() {
//        return players;
//    }
//
//    public void resetPlayerWagers() {
//
//        for (CrapsPlayer player : getPlayers())
//            playerWagers.put(player, 0);
//    }


}