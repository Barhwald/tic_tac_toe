package com.kodilla.game;

public class DataPrinter {

    public void printBoard(Board board) {
        System.out.printf("""
						|%s|%s|%s|
						|%s|%s|%s|
						|%s|%s|%s|\n""",
                board.getField1().getValue(), board.getField2().getValue(), board.getField3().getValue(),
                board.getField4().getValue(), board.getField5().getValue(), board.getField6().getValue(),
                board.getField7().getValue(), board.getField8().getValue(), board.getField9().getValue()
        );
    }

    public void printStartInfo(int gamenumber) {
        System.out.printf("\n\n--- Round %d ---\n\n", gamenumber);
        System.out.println("-".repeat(50));
        System.out.printf("""
				Fill the board using numbers as shown on this board:\s
						|%s|%s|%s|
						|%s|%s|%s|
						|%s|%s|%s|\n""",1,2,3,4,5,6,7,8,9
        );
    }

    public void printPlayersOptions(Player player1, Player player2) {
        System.out.println(player1.getName() + " will use " + player1.getPlayerSymbol() +
                " and " + player2.getName() + " will use " + player2.getPlayerSymbol());
    }

    public void printWhoseTurnIsIt(int turnCount, Player currentPlayer) {
        System.out.println("-".repeat(50));
        System.out.printf("Turn %d. %s is moving\n", turnCount, currentPlayer.getName());
    }

    public void printWinResult(int turnCount, Player player) {
        System.out.printf("""
                The game lasted %d turns
                %s won! Congratulations!\n""", turnCount, player.getName());
    }

    public void printTieResult() {
        System.out.println("It's a tie!");
    }

    public void printTotalScoreInfo(Player player1, Player player2) {
        System.out.printf("""
                %s won %d, lost %d, tied %d.
                %s won %d, lost %d, tied %d.
                """, player1.getName(), player1.getWins(), player1.getLoses(), player1.getTies(),
                player2.getName(), player2.getWins(), player2.getLoses(), player2.getTies());
    }

}
