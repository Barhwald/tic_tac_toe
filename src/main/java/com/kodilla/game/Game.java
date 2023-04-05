package com.kodilla.game;

public class Game {

    private DataPrinter dataPrinter;
    private DataReader dataReader;
    private Board board;
    private Player player1;
    private Player player2;
    private int turnCount;
    private int gameCount;

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

    public void setGame() {
        dataPrinter = new DataPrinter();
        dataReader = new DataReader();
        createPlayers();
        setPlayersOptions();
        dataPrinter.printPlayersOptions(player1, player2);
        setGameCount(1);
    }

    public void createPlayers() {
        player1 = new Player(dataReader.readPlayerName());
        player2 = new Player(dataReader.readPlayerName());
    }

    public void setPlayersOptions() {
        player1.setPlayerSymbol(dataReader.readUserSymbol(player1));
        player2.setPlayerSymbol(dataReader.readUserSymbol(player2));
    }


    public void playGame(Player player1, Player player2) {

        Player currentPlayer;

        do {
            dataPrinter.printStartInfo(getGameCount());
            setGameCount(getGameCount() + 1);
            board = new Board();
            turnCount = 0;
            boolean keepPlaying = true;

            while (keepPlaying) {
                turnCount++;
                currentPlayer = whoseTurnIsNow();
                dataPrinter.printWhoseTurnIsIt(turnCount, currentPlayer);

                int chosenField = 0;
                try {
                    chosenField = dataReader.readChosenField();
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }

                switch (chosenField) {
                    case 1 -> interactWithField(currentPlayer, board.getField1());
                    case 2 -> interactWithField(currentPlayer, board.getField2());
                    case 3 -> interactWithField(currentPlayer, board.getField3());
                    case 4 -> interactWithField(currentPlayer, board.getField4());
                    case 5 -> interactWithField(currentPlayer, board.getField5());
                    case 6 -> interactWithField(currentPlayer, board.getField6());
                    case 7 -> interactWithField(currentPlayer, board.getField7());
                    case 8 -> interactWithField(currentPlayer, board.getField8());
                    case 9 -> interactWithField(currentPlayer, board.getField9());
                    default -> {
                        System.out.println("Invalid value. Try again");
                        turnCount--;
                    }
                }

                dataPrinter.printBoard(board);

                if (checkIfWon(currentPlayer)) {
                    dataPrinter.printWinResult(turnCount, currentPlayer);
                    currentPlayer.setWins(currentPlayer.getWins() + 1);
                    if (currentPlayer == player1) {
                        player2.setLoses(player2.getLoses() + 1);
                    } else {
                        player1.setLoses(player1.getLoses() + 1);
                    }
                    keepPlaying = false;
                }

                if (checkIfTied(turnCount)) {
                    player1.setTies(player1.getTies() + 1);
                    player2.setTies(player2.getTies() + 1);
                    dataPrinter.printTieResult();
                    keepPlaying = false;
                }
            }
        } while (dataReader.playAgain());

        showResults();

    }

    public Player whoseTurnIsNow() {
        return (turnCount % 2 != 0) ? player1 : player2;
    }

    public void interactWithField(Player player, BoardField field) {
        if (field.isEmpty()) {
            field.setValue(player.getPlayerSymbol());
            field.setEmpty(false);
        } else {
            System.out.println("Field already taken!");
            turnCount--;
        }
    }

    public boolean checkIfTied(int count) {
        return count == 9;
    }

    public boolean checkIfWon(Player player) {
        boolean playerWon;

        if (turnCount < 5) return false;

        playerWon = checkIfWonHorizontalAndVertical(player) || checkIfWonDiagonal(player);
        return playerWon;
    }

    public boolean checkIfWonHorizontalAndVertical(Player player) {
        boolean playerWon = false;
        char playerSymbol = player.getPlayerSymbol();
        for (int i = 0; i < 3; i++) {
            playerWon = board.getFieldList().get(3 * i).getValue() == playerSymbol && board.getFieldList().get(1 + 3 * i).getValue() == playerSymbol && board.getFieldList().get(2 + 3 * i).getValue() == playerSymbol
                    || board.getFieldList().get(i).getValue() == playerSymbol && board.getFieldList().get(3 + i).getValue() == playerSymbol && board.getFieldList().get(6 + i).getValue() == playerSymbol;
            if (playerWon) {
                break;
            }
        }
        return playerWon;

    }

    public boolean checkIfWonDiagonal(Player player) {
        char playerSymbol = player.getPlayerSymbol();
        return board.getFieldList().get(0).getValue() == playerSymbol && board.getFieldList().get(4).getValue() == playerSymbol && board.getFieldList().get(8).getValue() == playerSymbol
                || board.getFieldList().get(2).getValue() == playerSymbol && board.getFieldList().get(4).getValue() == playerSymbol && board.getFieldList().get(6).getValue() == playerSymbol;
    }


    public void runApp() {
        setGame();
        playGame(player1, player2);
    }

    public void showResults() {
        dataPrinter.printTotalScoreInfo(player1, player2);
    }

}
