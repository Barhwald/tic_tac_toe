package com.kodilla;

import com.kodilla.game.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TicTacToeTestSuite {

    private Game game;
    private Player player1;
    private Board board;
    private final int loopLimit = 2;
    private final int rowSize = 2;
    private String victory = "";

    @Nested
    @DisplayName("Tests for wins with 'O'")
    class TestOPlayerWins {

        @BeforeEach
        void setData() {
            game = new Game();
            player1 = new humanPlayer("Player1");
            Board.setBoardSize(3);
            board = new Board();
            game.setPlayer1(player1);
            game.getPlayer1().setPlayerSymbol('O');
            game.setBoard(board);
            game.setTurnCount(6);
        }

        @Test
        void testFirstPlayerWithOWins1Row() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateY() == 1) {
                    field.setValue('O');
                }
            }
            //When
            game.checkIfWonHorizontal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithOWins2Row() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateY() == 2) {
                    field.setValue('O');
                }
            }
            //When
            game.checkIfWonHorizontal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithOWins3Row() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateY() == 3) {
                    field.setValue('O');
                }
            }
            //When
            game.checkIfWonHorizontal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithOWins1Col() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() == 1) {
                    field.setValue('O');
                }
            }
            //When
            game.checkIfWonVertical(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithOWins2Col() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() == 2) {
                    field.setValue('O');
                }
            }
            //When
            game.checkIfWonVertical(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithOWins3Col() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() == 3) {
                    field.setValue('O');
                }
            }
            //When
            game.checkIfWonVertical(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithOWinsDiagonalRight() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() + field.getCoordinateY() == 4) {
                    field.setValue('O');
                }
            }
            //When
            game.checkIfWonDiagonal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithOWinsDiagonalLeft() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() == field.getCoordinateY()) {
                    field.setValue('O');
                }
            }
            //When
            game.checkIfWonDiagonal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

    }

    @Nested
    @DisplayName("Tests for wins with 'X'")
    class TestXPlayerWins {

        @BeforeEach
        void setData() {
            game = new Game();
            player1 = new humanPlayer("Player1");
            Board.setBoardSize(3);
            board = new Board();
            game.setPlayer1(player1);
            game.getPlayer1().setPlayerSymbol('X');
            game.setBoard(board);
            game.setTurnCount(6);
        }

        @Test
        void testFirstPlayerWithXWins1Row() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateY() == 1) {
                    field.setValue('X');
                }
            }
            //When
            game.checkIfWonHorizontal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithXWins2Row() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateY() == 2) {
                    field.setValue('X');
                }
            }
            //When
            game.checkIfWonHorizontal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithXWins3Row() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateY() == 3) {
                    field.setValue('X');
                }
            }
            //When
            game.checkIfWonHorizontal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithXWins1Col() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() == 1) {
                    field.setValue('X');
                }
            }
            //When
            game.checkIfWonVertical(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithXWins2Col() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() == 2) {
                    field.setValue('X');
                }
            }
            //When
            game.checkIfWonVertical(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithXWins3Col() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() == 3) {
                    field.setValue('X');
                }
            }
            //When
            game.checkIfWonVertical(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithXWinsDiagonalRight() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() + field.getCoordinateY() == 4) {
                    field.setValue('X');
                }
            }
            //When
            game.checkIfWonDiagonal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

        @Test
        void testFirstPlayerWithXWinsDiagonalLeft() {
            //Given
            for (BoardField field : board.getFieldList()) {
                if (field.getCoordinateX() + field.getCoordinateY() == 4) {
                    field.setValue('X');
                }
            }
            //When
            game.checkIfWonDiagonal(loopLimit, rowSize, victory);
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWon(player1));
        }

    }


    @DisplayName("Test for a tie")
    @Test
    void testPlayersTied() {
        //Given
        game = new Game();
        Game spyGame = spy(game);
        Player player1 = new humanPlayer("Player1");
        Board board = new Board();
        Board.setBoardSize(3);
        spyGame.setPlayer1(player1);
        spyGame.setBoard(board);
        // When
        Mockito.when(spyGame.checkIfWon(player1)).thenReturn(false);
        boolean tie = spyGame.checkIfTied(9, player1);
        //Then
        assertTrue(tie);

    }

    public static int setCoordinate() throws NumberFormatException {
        int num;
        String FieldNumber = "e";
        if (Integer.parseInt(FieldNumber) > 0 && Integer.parseInt(FieldNumber) <= Board.getBoardSize()) {
            num = Integer.parseInt(FieldNumber);
        } else {
            throw new RuntimeException();
        }
        return num;
    }

    @DisplayName("Test for a wrong input")
    @Test
    void testExceptionThrownWrongCoordinate() {
        //Given
        game = new Game();
        //When & Then
        assertThrows(RuntimeException.class, TicTacToeTestSuite::setCoordinate);

    }

    public static int setBoardSize() throws RuntimeException {
        int size;
        String boardSize = "4";
        if (Integer.parseInt(boardSize) == 3 || Integer.parseInt(boardSize) == 10) {
            size = Integer.parseInt(boardSize);
        } else {
            throw new RuntimeException();
        }
        return size;
    }

    @DisplayName("Test for a wrong board size: 4")
    @Test
    void testExceptionThrownWrongBoardSize() {
        //Given
        game = new Game();
        //When & Then
        assertThrows(RuntimeException.class, TicTacToeTestSuite::setBoardSize);
    }

    @DisplayName("Test for an occupied field")
    @Test
    void testOccupiedField() {
        //Given
        game = new Game();
        player1 = new humanPlayer("Player1");
        Player player2 = new humanPlayer("Player2");
        Board.setBoardSize(3);
        board = new Board();
        game.setPlayer1(player1);
        game.getPlayer1().setPlayerSymbol('O');
        game.setPlayer2(player2);
        game.getPlayer2().setPlayerSymbol('X');
        game.setBoard(board);
        //When
        BoardField field = board.getFieldList().stream()
                .filter(obj -> obj.getCoordinateX() == 1)
                .filter(obj -> obj.getCoordinateY() == 1)
                .findFirst()
                .orElse(null);
        field.setValue(player1.getPlayerSymbol());
        field.setEmpty(false);

        game.interactWithFieldHuman(player2, field);
        //Then
        assertNotEquals(player2.getPlayerSymbol(), field.getValue());
    }

}
