package com.kodilla.game;

public class humanPlayer implements Player {

    static int playerNumber = 1;
    private String name;
    private char playerSymbol;
    private int wins;
    private int loses;
    private int ties;


    public humanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getPlayerSymbol() {
        return playerSymbol;
    }

    @Override
    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public int getLoses() {
        return loses;
    }

    @Override
    public int getTies() {
        return ties;
    }

    @Override
    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public void setLoses(int loses) {
        this.loses = loses;
    }

    @Override
    public void setTies(int ties) {
        this.ties = ties;
    }

    public static void incrementPlayerNumber() {
        playerNumber++;
    }
}
