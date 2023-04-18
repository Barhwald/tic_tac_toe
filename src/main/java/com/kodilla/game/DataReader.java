package com.kodilla.game;

import java.util.Scanner;

public class DataReader {

    private static final Scanner myScanner = new Scanner(System.in);

    public String readPlayerName() {
        System.out.print("Player " + humanPlayer.playerNumber + ". Type your name: ");
        humanPlayer.incrementPlayerNumber();
        return myScanner.nextLine();
    }

    public char readUserSymbol(Player player) {
        boolean isInputValid = true;
        char input;
        do {
            System.out.print("Which symbol do you want to play " + player.getName() + "? Type X or O: ");
            input = myScanner.nextLine().toUpperCase().charAt(0);
            if (input == 'X' || input == 'O') {
                isInputValid = false;
            } else {
                System.out.println("Invalid input. Try again");
            }
        } while (isInputValid);
        return input;
    }

    public int readBoardSize() {
        boolean isInputValid = true;
        int size = 0;
        do {
            try {
                String boardSize = myScanner.nextLine();
                if (Integer.parseInt(boardSize) == 3 || Integer.parseInt(boardSize) == 10) {
                    size = Integer.parseInt(boardSize);
                    isInputValid = false;
                } else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("Wrong input. Type 3 or 10.");
            }

        } while (isInputValid);
        return size;
    }

    public int readCoordinate() {
        boolean isInputValid = true;
        int num = 0;
        do {
            try {
                String FieldNumber = myScanner.nextLine();
                if (Integer.parseInt(FieldNumber) > 0 && Integer.parseInt(FieldNumber) <= Board.getBoardSize()) {
                    num = Integer.parseInt(FieldNumber);
                    isInputValid = false;
                } else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("Invalid input. You must type a number between 1-" + Board.getBoardSize());
            }

        } while (isInputValid);
        return num;
    }

    public boolean playAgain() {
        System.out.print("Wanna play again? Type y to replay or any other key to close: \n");
        String input = myScanner.nextLine();
        return (input.equals("y"));
    }

    public boolean playWithAi() {
        System.out.print("""
                Do you want to play with AI? Or fancy playing a hot-seat game with a friend?\s
                Type y for a singleplayer or any other key to play with a friend: \s
                """);
        String input = myScanner.nextLine();
        return (input.equals("y"));
    }

    public boolean doPrintRanking() {
        System.out.print("Do you want to see High Scores? Type y to print them or any other key to close: ");
        String input = myScanner.nextLine();
        return (input.equals("y"));
    }

}

