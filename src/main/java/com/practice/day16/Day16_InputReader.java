package com.practice.day16;

import com.practice.Index;
import com.practice.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day16_InputReader {
    private final char[][] mazeMap;

    public Day16_InputReader(String fileName) {
        List<String> lineList = InputReader.getLineStreams(fileName).toList();
        int mazeWidth = lineList.getFirst().length();
        int mazeHeight = lineList.size();
        mazeMap = new char[mazeHeight][mazeWidth];

        for (int i = 0; i < lineList.size(); i++) {
            mazeMap[i] = lineList.get(i).toCharArray();
        }

    }

    public char[][] getMazeMap() {
        return mazeMap;
    }
}
