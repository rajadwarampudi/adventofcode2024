package com.practice.day6;

public class Day6_Challenge {


    private static final char OBSTRUCTION = '#';
    private static final char VISITED_INDEX = 'X';

    public int getNumberOfDistinctPositionsVisited(char[][] map, int[] startIndex) {
        int count = 0;

        int currentRow = startIndex[0];
        int currentCol = startIndex[1];

        count += traverseUpwards(map, currentRow, currentCol);

        return count;
    }

    private int traverseUpwards(char[][] map, int currentRow, int currentCol) {
        int count = 0;

        while (currentRow >= 0 && map[currentRow][currentCol] != OBSTRUCTION) {
            count += markUnvisitedIndex(map, currentRow, currentCol);
            currentRow--;
        }

        if (currentRow < 0) {
            return count;
        } else {
            return count + traverseRight(map, currentRow + 1, currentCol);
        }

    }

    private int traverseRight(char[][] map, int currentRow, int currentCol) {
        int count = 0;

        while (currentCol < map[currentRow].length && map[currentRow][currentCol] != OBSTRUCTION) {
            count += markUnvisitedIndex(map, currentRow, currentCol);
            currentCol++;
        }

        if (currentCol == map[currentRow].length) {
            return count;
        } else {
            return count + traverseDownwards(map, currentRow, currentCol - 1);
        }
    }

    private int traverseDownwards(char[][] map, int currentRow, int currentCol) {
        int count = 0;

        while (currentRow < map.length && map[currentRow][currentCol] != OBSTRUCTION) {
            count += markUnvisitedIndex(map, currentRow, currentCol);
            currentRow++;
        }

        if (currentRow == map.length) {
            return count;
        } else {
            return count + traverseLeft(map, currentRow - 1, currentCol);
        }
    }

    private int traverseLeft(char[][] map, int currentRow, int currentCol) {
        int count = 0;

        while (currentCol >= 0 && map[currentRow][currentCol] != OBSTRUCTION) {
            count += markUnvisitedIndex(map, currentRow, currentCol);
            currentCol--;
        }

        if (currentCol < 0) {
            return count;
        } else {
            return count + traverseUpwards(map, currentRow, currentCol + 1);
        }

    }

    private static int markUnvisitedIndex(char[][] map, int currentRow, int currentCol) {
        if (map[currentRow][currentCol] != VISITED_INDEX) {
            map[currentRow][currentCol] = VISITED_INDEX;
            return 1;
        }
        return 0;
    }
}
