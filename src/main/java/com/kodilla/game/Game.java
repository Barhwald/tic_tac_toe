package com.kodilla.game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Game {

    private DataPrinter dataPrinter;
    private DataReader dataReader;
    private Board board;
    private Player player1;
    private Player player2;
    private int turnCount;
    private int gameCount;
    private Random random;
    private Ranking ranking;

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setGame() {
        dataPrinter = new DataPrinter();
        dataReader = new DataReader();
        random = new Random();
        ranking = new Ranking();
        dataPrinter.printWelcomeMessage();
        createPlayers();
        setPlayersOptions();
        dataPrinter.printPlayersOptions(player1, player2);
        setGameCount(0);
    }

    public void createPlayers() {
        if (dataReader.playWithAi()) {
            player1 = new HumanPlayer(dataReader.readPlayerName());
            player2 = new AiPlayer("Computer");
        } else {
            player1 = new HumanPlayer(dataReader.readPlayerName());
            player2 = new HumanPlayer(dataReader.readPlayerName());
        }
    }

    public void setPlayersOptions() {
        player1.setPlayerSymbol(dataReader.readUserSymbol(player1));
        if (player1.getPlayerSymbol() == 'X') {
            player2.setPlayerSymbol('O');
        } else {
            player2.setPlayerSymbol('X');
        }
    }

    public void playGame(Player player1, Player player2) {

        Player currentPlayer;

        do {
            setGameCount(getGameCount() + 1);
            dataPrinter.printBoardSizeInfo();
            Board.setBoardSize(dataReader.readBoardSize());
            board = new Board();
            dataPrinter.printStartInfo(getGameCount(), board);
            turnCount = 0;
            boolean keepPlaying = true;

            while (keepPlaying) {

                turnCount++;
                currentPlayer = whoseTurnIsNow();
                dataPrinter.printWhoseTurnIsIt(turnCount, currentPlayer);

                if (currentPlayer instanceof HumanPlayer) {
                    BoardField chosenField = getFieldChosenByHuman();
                    interactWithFieldHuman(currentPlayer, chosenField);

                } else {
                    interactWithFieldAi(currentPlayer);
                }

                dataPrinter.printBoard(board);

                if (checkIfWon(currentPlayer)) {
                    dataPrinter.printWinResult(turnCount, currentPlayer);
                    currentPlayer.setWins(currentPlayer.getWins() + 1);
                    currentPlayer.setScore(currentPlayer.getScore() + 10);
                    if (currentPlayer == player1) {
                        player2.setLoses(player2.getLoses() + 1);
                    } else {
                        player1.setLoses(player1.getLoses() + 1);
                    }
                    keepPlaying = false;
                }

                if (checkIfTied(turnCount, currentPlayer)) {
                    currentPlayer.setScore(currentPlayer.getScore() + 5);
                    player1.setTies(player1.getTies() + 1);
                    player2.setTies(player2.getTies() + 1);
                    dataPrinter.printTieResult();
                    keepPlaying = false;
                }
            }
        } while (dataReader.playAgain());

        dataPrinter.printTotalScoreInfo(player1, player2);
        saveScore(player1);

        if (player2 instanceof HumanPlayer) {
            saveScore(player2);
        }

        if (dataReader.doPrintRanking()) {
            ranking.setScoresList();
            dataPrinter.printRanking(ranking);
        }
    }

    public Player whoseTurnIsNow() {
        return (turnCount % 2 != 0) ? player1 : player2;
    }

    public BoardField getFieldChosenByHuman() {
        dataPrinter.printCoordinateXInfo();
        int x = dataReader.readCoordinate();
        dataPrinter.printCoordinateYInfo();
        int y = dataReader.readCoordinate();
        return board.getFieldList().stream()
                .filter(obj -> obj.getCoordinateX() == x)
                .filter(obj -> obj.getCoordinateY() == y)
                .findFirst()
                .orElse(null);
    }

    public void interactWithFieldHuman(Player player, BoardField field) {
        if (field.isEmpty()) {
            field.setValue(player.getPlayerSymbol());
            field.setEmpty(false);
        } else {
            System.out.println("Field already taken!");
            turnCount--;
        }
    }

    public void interactWithFieldAi(Player player) {
        List<BoardField> emptyFields = board.getFieldList().stream().
                filter(BoardField::isEmpty)
                .toList();
        int randomFieldIndex = random.nextInt(emptyFields.size());
        emptyFields.get(randomFieldIndex).setValue(player.getPlayerSymbol());
        emptyFields.get(randomFieldIndex).setEmpty(false);
    }

    public boolean checkIfTied(int count, Player player) {
        if (Board.getBoardSize() == 3) {
            return count == 9 && !checkIfWon(player);
        } else {
            return count == 100 && !checkIfWon(player);
        }
    }

    public boolean checkIfWon(Player player) {
        if (turnCount < 5) return false;
        boolean playerWon;
        String victory;
        int loopLimit;         // how many times to iterate through one row
        int rowSize;                // how many symbols to check for victory + 1
        int symbolsNeeded;

        if (Board.getBoardSize() == 3) {
            loopLimit = 2;
            rowSize = 2;
            symbolsNeeded = 3;
        } else {
            loopLimit = 7;
            rowSize = 4;
            symbolsNeeded = 5;
        }

        if (player.getPlayerSymbol() == 'X') {
            victory = "X".repeat(symbolsNeeded);
        } else {
            victory = "O".repeat(symbolsNeeded);
        }

        playerWon = checkIfWonHorizontal(loopLimit, rowSize, victory) || checkIfWonVertical(loopLimit, rowSize, victory)
                || checkIfWonDiagonal(loopLimit, rowSize, victory);
        return playerWon;
    }

    public boolean checkIfWonHorizontal(int loopLimit, int rowSize, String victory) {
        boolean playerWon = false;

        outerLoop:
        for (int i = 1; i <= Board.getBoardSize(); i++) {
            for (int j = 1; j < loopLimit; j++) {
                int finalI = i;
                int finalJ = j;
                List<BoardField> checkedList = board.getFieldList().stream()
                        .filter(obj -> obj.getCoordinateY() == finalI)
                        .filter(obj -> obj.getCoordinateX() >= finalJ && obj.getCoordinateX() <= finalJ + rowSize)
                        .toList();
                StringBuilder checkedInput = new StringBuilder();
                for (BoardField field : checkedList) {
                    checkedInput.append(field.getValue());
                }
                if (checkedInput.toString().equals(victory)) {
                    playerWon = true;
                    break outerLoop;
                }
            }
        }
        return playerWon;
    }

    public boolean checkIfWonVertical(int loopLimit, int rowSize, String victory) {
        boolean playerWon = false;

        outerLoop:
        for (int i = 1; i < loopLimit; i++) {
            for (int j = 1; j <= Board.getBoardSize(); j++) {
                int finalI = i;
                int finalJ = j;
                List<BoardField> checkedList = board.getFieldList().stream()
                        .filter(obj -> obj.getCoordinateY() >= finalI && obj.getCoordinateY() <= finalI + rowSize)
                        .filter(obj -> obj.getCoordinateX() == finalJ)
                        .toList();
                StringBuilder checkedInput = new StringBuilder();
                for (BoardField field : checkedList) {
                    checkedInput.append(field.getValue());
                }
                if (checkedInput.toString().equals(victory)) {
                    playerWon = true;
                    break outerLoop;
                }
            }
        }
        return playerWon;
    }

    public boolean checkIfWonDiagonal(int loopLimit, int rowSize, String victory) {
        boolean playerWon = false;

        outerLoop:
        for (int i = 1; i < loopLimit; i++) {
            for (int j = 1; j < loopLimit; j++) {
                int finalI = i;
                int finalJ = j;
                List<BoardField> checkedList = board.getFieldList().stream()
                        .filter(obj -> obj.getCoordinateY() >= finalI && obj.getCoordinateY() <= finalI + rowSize)
                        .filter(obj -> obj.getCoordinateX() >= finalJ && obj.getCoordinateX() <= finalJ + rowSize)
                        .toList();
                StringBuilder checkedInputUp = new StringBuilder();
                StringBuilder checkedInputDown = new StringBuilder();
                int difference = finalJ - finalI;
                int sum = finalJ + finalI + rowSize;
                for (BoardField field : checkedList) {
                    if (field.getCoordinateX() - field.getCoordinateY() == difference) {
                        checkedInputUp.append(field.getValue());
                    }
                    if (field.getCoordinateX() + field.getCoordinateY() == sum) {
                        checkedInputDown.append(field.getValue());
                    }
                }
                if (checkedInputUp.toString().equals(victory) || checkedInputDown.toString().equals(victory)) {
                    playerWon = true;
                    break outerLoop;
                }
            }
        }
        return playerWon;
    }

    public void saveScore(Player player) {

        String FILE_NAME = "scores.txt";

        try {
            URI source = this.getClass().getResource("/").toURI();
            File file = new File(new File(source),FILE_NAME);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            FileWriter filewriter = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(filewriter);
            writer.write(player.getName() + " ".repeat(14 - player.getName().length()) + player.getScore() +
                    " ".repeat(15 - String.valueOf(player.getScore()).length()) + dtf.format(now) + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error emerged: " + e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    public void runApp() {
        setGame();
        playGame(player1, player2);
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }
}
