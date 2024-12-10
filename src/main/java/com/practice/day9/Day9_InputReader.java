package com.practice.day8;

import com.practice.InputReader;

import java.util.List;
import java.util.stream.Stream;

public class Day8_InputReader {
    public char[][] getMap() {
        return map;
    }

    private final char[][] map;
    public Day8_InputReader(String fileName) {
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        List<String> lineList = lineStreams.toList();
        map = new char[lineList.size()][lineList.getFirst().length()];

        for (int i = 0; i < lineList.size(); i++) {
            map[i] = lineList.get(i).toCharArray();
        }
    }

}
