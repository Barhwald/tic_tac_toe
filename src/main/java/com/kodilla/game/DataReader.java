package com.kodilla.game;

import java.util.Scanner;

public class DataReader {

    private static final Scanner myScanner = new Scanner(System.in);

    public String readPlayerName() {
        System.out.print("Player " + Player.playerNumber + ". Type your name: ");
        incrementPlayerNumber();
        return myScanner.nextLine();
    }

    public void incrementPlayerNumber() {
        Player.playerNumber++;
    }

    public char readUserSymbol(Player player) {
        System.out.print("Which symbol do you want to play " + player.getName() + " ? ");
        return myScanner.nextLine().toUpperCase().charAt(0);
    }

    public int readChosenField() throws NumberFormatException {
        String FieldNumber = myScanner.nextLine();
        int chosenField = 0;
        if (Integer.parseInt(FieldNumber) > 0 && Integer.parseInt(FieldNumber) < 10) {
            chosenField = Integer.parseInt(FieldNumber);
        } else {
            throw new NumberFormatException();
        }
        return chosenField;
    }

    public boolean playAgain() {
        System.out.print("Wanna play again? Type y to replay and any other key to close: ");
        String input = myScanner.nextLine();
        return (input.equals("y"));
    }

}

