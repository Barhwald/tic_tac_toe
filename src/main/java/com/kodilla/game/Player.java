package com.kodilla.game;

public class Player {

    static int playerNumber = 1;
    private String name;
    private char playerSymbol;

    private int wins;
    private int loses;
    private int ties;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getTies() {
        return ties;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }
}
