package com.kodilla.game;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
        File file;

        try {
            String FILE_NAME = "scores.txt";
            URI source = this.getClass().getResource("/").toURI();
            file = new File(new File(source), FILE_NAME);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        Path path = file.toPath();
        List<String> sortableList = null;

        try (Stream<String> lines = Files.lines(path)) {
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
