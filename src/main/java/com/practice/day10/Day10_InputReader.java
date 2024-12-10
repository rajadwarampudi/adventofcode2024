package com.practice.day10;

import com.practice.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day10_InputReader {
    private final int[][] topographicMap;

    public Day10_InputReader(String fileName) {
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        List<String> lineList = lineStreams.toList();
        topographicMap = new int[lineList.size()][lineList.getFirst().length()];
        for (int i = 0; i < lineList.size(); i++) {
            topographicMap[i] = lineList.get(i).chars().map(c -> c - '0').toArray();
        }
    }

    public int[][] getTopographicMap() {
        return topographicMap;
    }

}
