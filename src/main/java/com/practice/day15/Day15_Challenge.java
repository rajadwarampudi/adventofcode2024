package com.practice.day15;

import com.practice.Index;

import java.util.List;

public class Day15_Challenge {

    public static final char WALL = '#';
    public static final char BOX = 'O';
    public static final char EMPTY_SPACE = '.';

    /**
     * This method gets the GPS Coordinates sum as desribed in day 15 of 2024 AoC Challenge
     * @param warehouseMap
     * @param startingPosition
     * @param moves
     * @return
     */
    public int getGPSCoordinatesSum(char[][] warehouseMap, Index startingPosition, List<Character> moves) {

        applyMoves(warehouseMap, moves, startingPosition);

        return getGPSCoordinatesSumAfterAllMoves(warehouseMap);
    }

    private int getGPSCoordinatesSumAfterAllMoves(char[][] warehouseMap) {
        int rows = warehouseMap.length;
        int columns = warehouseMap[0].length;
        int gpsCoordinateSum = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (warehouseMap[i][j] == BOX) {
                    gpsCoordinateSum += (i * 100) + (j);
                }
            }
        }
        return gpsCoordinateSum;
    }

    private void applyMoves(char[][] warehouseMap, List<Character> moves, Index currentPosition) {
        for (Character move : moves) {
            if (move == '<') { // move one position left
                currentPosition = moveLeft(warehouseMap, currentPosition);
            } else if (move == '^') { // move one position up
                currentPosition = moveUp(warehouseMap, currentPosition);
            } else if (move == '>') { //move one position right
                currentPosition = moveRight(warehouseMap, currentPosition);
            } else { // move one position down
                currentPosition = moveDown(warehouseMap, currentPosition);
            }
        }
    }

    private Index moveDown(char[][] warehouseMap, Index currentPosition) {
        int currentRow = currentPosition.x();
        int currentColumn = currentPosition.y();
        int rowAhead = currentRow + 1;

        if (warehouseMap[rowAhead][currentColumn] == WALL) {
            return currentPosition;
        } else if(warehouseMap[rowAhead][currentColumn] == EMPTY_SPACE) {
            return new Index(rowAhead, currentColumn);
        }

        while (warehouseMap[rowAhead][currentColumn] == BOX) {
            rowAhead = rowAhead + 1;
        }
        if (warehouseMap[rowAhead][currentColumn] == EMPTY_SPACE) {
            warehouseMap[rowAhead][currentColumn] = BOX;
            warehouseMap[currentRow + 1][currentColumn] = EMPTY_SPACE;
            return new Index(currentRow + 1, currentColumn);
        } else {
            return currentPosition;
        }
    }

    private Index moveUp(char[][] warehouseMap, Index currentPosition) {
        int currentRow = currentPosition.x();
        int currentColumn = currentPosition.y();
        int rowAhead = currentRow - 1;

        if (warehouseMap[rowAhead][currentColumn] == WALL) {
            return currentPosition;
        } else if(warehouseMap[rowAhead][currentColumn] == EMPTY_SPACE) {
            return new Index(rowAhead, currentColumn);
        }

        while (warehouseMap[rowAhead][currentColumn] == BOX) {
            rowAhead = rowAhead - 1;
        }
        if (warehouseMap[rowAhead][currentColumn] == EMPTY_SPACE) {
            warehouseMap[rowAhead][currentColumn] = BOX;
            warehouseMap[currentRow -1][currentColumn] = EMPTY_SPACE;
            return new Index(currentRow - 1, currentColumn);
        } else {
            return currentPosition;
        }
    }

    private Index moveRight(char[][] warehouseMap, Index currentPosition) {
        int currentRow = currentPosition.x();
        int currentColumn = currentPosition.y();
        int columnAhead = currentColumn + 1;

        if (warehouseMap[currentRow][columnAhead] == WALL) {
            return currentPosition;
        } else if(warehouseMap[currentRow][columnAhead] == EMPTY_SPACE) {
            return new Index(currentRow, columnAhead);
        }

        while (warehouseMap[currentRow][columnAhead] == BOX) {
            columnAhead = columnAhead + 1;
        }
        if (warehouseMap[currentRow][columnAhead] == EMPTY_SPACE) {
            warehouseMap[currentRow][columnAhead] = BOX;
            warehouseMap[currentRow][currentColumn + 1] = EMPTY_SPACE;
            return new Index(currentRow, currentColumn + 1);
        } else {
            return currentPosition;
        }
    }

    private Index moveLeft(char[][] warehouseMap, Index currentPosition) {
        int currentRow = currentPosition.x();
        int currentColumn = currentPosition.y();
        int columnAhead = currentColumn - 1;

        if (warehouseMap[currentRow][columnAhead] == WALL) {
            return currentPosition;
        } else if(warehouseMap[currentRow][columnAhead] == EMPTY_SPACE) {
            return new Index(currentRow, columnAhead);
        }

        while (warehouseMap[currentRow][columnAhead] == BOX) {
            columnAhead = columnAhead - 1;
        }
        if (warehouseMap[currentRow][columnAhead] == EMPTY_SPACE) {
            warehouseMap[currentRow][columnAhead] = BOX;
            warehouseMap[currentRow][currentColumn - 1] = EMPTY_SPACE;
            return new Index(currentRow, currentColumn - 1);
        } else {
            return currentPosition;
        }
    }
}
