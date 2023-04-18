package com.kodilla.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataPrinter {

    public void printWelcomeMessage() {
        System.out.print("""
                                
                ---------------------Welcome to the tic-tac-toe game!---------------------
                                
                """);
    }

    public void printBoard(Board board) {
        StringBuilder str = new StringBuilder();
        for (int i = Board.getBoardSize(); i >= 1; i--) {
            if (i < 10) {
                str.append(i + "  ");
            } else {
                str.append(i + " ");
            }
            for (int j = 1; j <= Board.getBoardSize(); j++) {
                int finalI = i;
                int finalJ = j;
                BoardField field = board.getFieldList().stream()
                        .filter(obj -> obj.getCoordinateY() == finalI)
                        .filter(obj -> obj.getCoordinateX() == finalJ)
                        .findFirst()
                        .orElse(null);
                str.append("|" + field.getValue());
            }
            if (i > 1) {
                str.append("|\n");
            } else {
                str.append("|");
            }
        }
        System.out.println(str);
        StringBuilder xAxis = new StringBuilder("   ");
        for (int k = 1; k <= Board.getBoardSize(); k++) {
            xAxis.append(" " + k);
        }
        xAxis.append("\n");
        System.out.println(xAxis);
    }

    public void printStartInfo(int gameNumber, Board board) {
        System.out.printf("\n\n--- Round %d ---\n\n", gameNumber);
        System.out.println("-".repeat(50));
        printBoard(board);
    }

    public void printBoardSizeInfo() {
        System.out.print("""
                What board size would you like to play?
                3 or 10 allowed:\s""");
    }

    public void printPlayersOptions(Player player1, Player player2) {
        System.out.println(player1.getName() + " will use " + player1.getPlayerSymbol() +
                " and " + player2.getName() + " will use " + player2.getPlayerSymbol());
    }

    public void printCoordinateXInfo() {
        System.out.println("Type X: ");
    }

    public void printCoordinateYInfo() {
        System.out.println("Type Y: ");
    }

    public void printWhoseTurnIsIt(int turnCount, Player currentPlayer) {
        System.out.println("-".repeat(50));
        System.out.printf("Turn %d. %s is moving\n", turnCount, currentPlayer.getName());
    }

    public void printWinResult(int turnCount, Player player) {
        if (player instanceof humanPlayer) {
            System.out.printf("""
                    The game lasted %d turns
                    %s won! Congratulations!
                    
                    """, turnCount, player.getName());
        } else {
            System.out.printf("""
                    The game lasted %d turns
                    %s won!
                    
                    """, turnCount, player.getName());
        }
    }

    public void printTieResult() {
        System.out.println("It's a tie!");
    }

    public void printTotalScoreInfo(Player player1, Player player2) {
        System.out.printf("""
                        %s won %d, lost %d, tied %d.
                        %s won %d, lost %d, tied %d.
                                               \s
                        """, player1.getName(), player1.getWins(), player1.getLoses(), player1.getTies(),
                player2.getName(), player2.getWins(), player2.getLoses(), player2.getTies());
    }

    public void printRanking() {
        List<String> sortableList = null;
        Path file = Paths.get("src/main/java/com/kodilla/game/scores.txt");

        try (Stream<String> lines = Files.lines(file)) {
            sortableList = new ArrayList<>(lines.toList());
        } catch (IOException e) {
            System.out.println("Failed to load file: " + e);
        }

        assert sortableList != null;
        sortableList.sort(String.CASE_INSENSITIVE_ORDER);

        System.out.println("\n --- HIGH SCORES --- \n");

        for (String line : sortableList) {
            System.out.println(line);
        }
    }

}
