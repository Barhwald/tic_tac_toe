package com.kodilla;

import com.kodilla.game.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TicTacToeTestSuite {

    @Nested
    @DisplayName("Tests for wins with 'O' put horizontally")
    class TestHorizontalWins {

        @BeforeEach
        void setData() {
            Game game = new Game();
            Player player1 = new Player("Player1");
            game.setPlayer1(player1);
            game.getPlayer1().setPlayerSymbol('O');
            Board board = new Board();
            game.setBoard(board);
        }

        @Test
        void testFirstPlayerWithOWins1Row() {
            //Given
            Game game = new Game();
            Player player1 = new Player("Player1");
            game.setPlayer1(player1);
            game.getPlayer1().setPlayerSymbol('O');
            Board board = new Board();
            game.setBoard(board);
            //When
            for (int i = 0; i < 3; i++) {
                board.getFieldList().get(i).setValue(player1.getPlayerSymbol());
            }
            game.checkIfWonHorizontalAndVertical(game.getPlayer1());
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWonHorizontalAndVertical(player1));
        }

        @Test
        void testFirstPlayerWithOWins2Row() {
            //Given
            Game game = new Game();
            Player player1 = new Player("Player1");
            game.setPlayer1(player1);
            game.getPlayer1().setPlayerSymbol('O');
            Board board = new Board();
            game.setBoard(board);
            //When
            for (int i = 3; i < 6; i++) {
                board.getFieldList().get(i).setValue(player1.getPlayerSymbol());
            }
            game.checkIfWonHorizontalAndVertical(game.getPlayer1());
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWonHorizontalAndVertical(player1));
        }

        @Test
        void testFirstPlayerWithOWins3Row() {
            //Given
            Game game = new Game();
            Player player1 = new Player("Player1");
            game.setPlayer1(player1);
            game.getPlayer1().setPlayerSymbol('O');
            Board board = new Board();
            game.setBoard(board);
            //When
            for (int i = 6; i < 9; i++) {
                board.getFieldList().get(i).setValue(player1.getPlayerSymbol());
            }
            game.checkIfWonHorizontalAndVertical(game.getPlayer1());
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWonHorizontalAndVertical(player1));
        }
    }

    @Nested
    @DisplayName("Tests for wins with 'O' put vertically")
    class TestVerticalWins {

        @Test
        void testFirstPlayerWithOWins1Col() {
            //Given
            Game game = new Game();
            Player player1 = new Player("Player1");
            game.setPlayer1(player1);
            game.getPlayer1().setPlayerSymbol('O');
            Board board = new Board();
            game.setBoard(board);
            //When
            for (int i = 0; i < 3; i++) {
                board.getFieldList().get(i * 3).setValue(player1.getPlayerSymbol());
            }
            game.checkIfWonHorizontalAndVertical(game.getPlayer1());
            //Then
            boolean expected = true;
            assertEquals(expected, game.checkIfWonHorizontalAndVertical(player1));
        }

    }
}
