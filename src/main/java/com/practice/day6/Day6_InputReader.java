package com.practice.day6;

import com.practice.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day6_InputReader {

    private final char[][] map;
    private final int[] startIndex = new int[2];
    public Day6_InputReader(String fileName) {
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        List<String> lines = lineStreams.toList();
         int columns = lines.size();
         int rows = lines.getFirst().length();
         map = new char[rows][columns];
         for (int i = 0; i < rows; i++) {
             String line = lines.get(i);
             for (int j = 0; j < columns; j++) {
                 map[i][j] = line.charAt(j);
                 if (map[i][j] == '^') {
                     startIndex[0] = i;
                     startIndex[1] = j;
                 }
             }
         }
    }

    public char[][] getMap() {
        return map;
    }

    public int[] getStartIndex() {
        return startIndex;
    }
}
