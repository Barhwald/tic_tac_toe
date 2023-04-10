package com.kodilla.game;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static int boardSize;

    private final List<BoardField> fieldList = new ArrayList<>();

    public Board() {
        for (int i = boardSize; i >= 1; i--) {
            for (int j = 1; j <= boardSize; j++) {
                BoardField field = new BoardField(j, i, ' ', true);
                fieldList.add(field);
            }
        }
    }

    public List<BoardField> getFieldList() {
        return fieldList;
    }

    public static int getBoardSize() {
        return boardSize;
    }

    public static void setBoardSize(int boardSize) {
        Board.boardSize = boardSize;
    }

}