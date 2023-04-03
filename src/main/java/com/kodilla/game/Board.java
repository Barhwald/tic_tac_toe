package com.kodilla.game;

import java.util.List;

public class Board {

    private List<BoardField> fieldList;

    private BoardField field1 = new BoardField(1,1, ' ', true);
    private BoardField field2 = new BoardField(1,2, ' ', true);
    private BoardField field3 = new BoardField(1,3, ' ', true);
    private BoardField field4 = new BoardField(2,1, ' ', true);
    private BoardField field5 = new BoardField(2,2, ' ', true);
    private BoardField field6 = new BoardField(2,3, ' ', true);
    private BoardField field7 = new BoardField(3,1, ' ', true);
    private BoardField field8 = new BoardField(3,2, ' ', true);
    private BoardField field9 = new BoardField(3,3, ' ', true);

    public Board() {
        this.fieldList = List.of(
                field1, field2, field3,
                field4, field5, field6,
                field7, field8, field9
        );
    }

    public List<BoardField> getFieldList() {
        return fieldList;
    }

    public BoardField getField1() {
        return field1;
    }

    public BoardField getField2() {
        return field2;
    }

    public BoardField getField3() {
        return field3;
    }

    public BoardField getField4() {
        return field4;
    }

    public BoardField getField5() {
        return field5;
    }

    public BoardField getField6() {
        return field6;
    }

    public BoardField getField7() {
        return field7;
    }

    public BoardField getField8() {
        return field8;
    }

    public BoardField getField9() {
        return field9;
    }

}