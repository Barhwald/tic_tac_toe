package com.kodilla.game;

public class RankingRecord implements Comparable<RankingRecord>{

    private final String text;
    private final int score;

    public RankingRecord(String text, int score) {
        this.text = text;
        this.score = score;
    }

    @Override
    public int compareTo(RankingRecord o) {
        return o.score - this.score;
    }

    public String getText() {
        return text;
    }

}
