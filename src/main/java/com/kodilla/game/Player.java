package com.kodilla.game;

public interface Player {

    String getName();
    char getPlayerSymbol();

    default int getScore() {
        return 0;
    }

    default void setScore(int score) {

    }

    void setPlayerSymbol(char playerSymbol);
    int getWins();
    int getLoses();
    int getTies();
    void setWins(int wins);
    void setLoses(int loses);
    void setTies(int ties);

}
