package com.practice.day15;

import com.practice.Index;
import com.practice.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day15_InputReader {
    private final char[][] warehouseMap;

    private final List<Character> moves;

    private final Index startingPosition;
    public Day15_InputReader(String fileName) {
        List<String> lineList = InputReader.getLineStreams(fileName).toList();
        int warehouseWidth = lineList.getFirst().length();
        int warehouseHeight = lineList.indexOf("");
        Index tempStartingPosition = null;
        warehouseMap = new char[lineList.getFirst().length()][warehouseHeight];

        for (int i = 0; i < warehouseHeight; i++) {
            for (int j = 0; j < warehouseWidth; j++)
            {
                if (lineList.get(i).charAt(j) == '@') {
                    tempStartingPosition = new Index(i, j);
                    warehouseMap[i][j] = '.';
                } else  {
                    warehouseMap[i][j] = lineList.get(i).charAt(j);
                }
            }
        }
        startingPosition = tempStartingPosition;


        moves = new ArrayList<>();
        for (int i = warehouseHeight + 1; i < lineList.size(); i++) {
            moves.addAll(lineList.get(i).chars().mapToObj(c -> (char) c).toList());
        }
    }

    public char[][] getWarehouseMap() {
        return warehouseMap;
    }

    public List<Character> getMoves() {
        return moves;
    }

    public Index getStartingPosition() {
        return startingPosition;
    }
}
