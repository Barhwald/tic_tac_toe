package com.kodilla.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ranking {

    private List<RankingRecord> scoresList;

    public void setScoresList() {
        List<String> sortableList = null;
        Path file = Paths.get("src/main/java/com/kodilla/game/scores.txt");

        try (Stream<String> lines = Files.lines(file)) {
            sortableList = new ArrayList<>(lines.toList());
        } catch (IOException e) {
            System.out.println("Failed to load file: " + e);
        }

        scoresList = new ArrayList<>();

        assert sortableList != null;
        for (String line : sortableList) {
            int points = Integer.parseInt(line.substring(14, 17).trim());
            RankingRecord record = new RankingRecord(line, points);
            scoresList.add(record);
        }

        Collections.sort(scoresList);

    }

    public List<RankingRecord> getScoresList() {
        return scoresList;
    }

}
