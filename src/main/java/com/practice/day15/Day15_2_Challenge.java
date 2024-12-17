package com.practice.day15;

import com.practice.Index;

import java.util.*;

public class Day15_2_Challenge {

    public static final char WALL = '#';
    public static final char BOX_OPENING = '[';
    public static final char BOX_CLOSING = ']';
    public static final char EMPTY_SPACE = '.';

    public long getGPSCoordinatesSum(char[][] warehouseMap, Index startingPosition, List<Character> moves) {

        applyMoves(warehouseMap, moves, startingPosition);

        return getGPSCoordinatesSumAfterAllMoves(warehouseMap);
    }

    private long getGPSCoordinatesSumAfterAllMoves(char[][] warehouseMap) {
        int rows = warehouseMap.length;
        int columns = warehouseMap[0].length;
        long gpsCoordinateSum = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (warehouseMap[i][j] == BOX_OPENING) {
                    gpsCoordinateSum += (i * 100L) + (j);
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

        List<Box> movableBoxList = new ArrayList<>();
        if (warehouseMap[rowAhead][currentColumn] == BOX_OPENING) {
            movableBoxList.add(new Box(new Index(rowAhead, currentColumn), new Index(rowAhead, currentColumn + 1)));
        } else {
            movableBoxList.add(new Box(new Index(rowAhead, currentColumn - 1), new Index(rowAhead, currentColumn)));
        }

        boolean isMovementPossible = true;
        for (int i = 0; i < movableBoxList.size(); i++) {
            Box box = movableBoxList.get(i);
            int rowBelowBox = box.open().x() + 1;
            int boxColumn = box.open().y();

            if (warehouseMap[rowBelowBox][boxColumn] == WALL || warehouseMap[rowBelowBox][boxColumn + 1] == WALL) {
                isMovementPossible = false;
                break;
            }
            if (warehouseMap[rowBelowBox][boxColumn] == BOX_OPENING) {
                movableBoxList.add(new Box(new Index(rowBelowBox, boxColumn), new Index(rowBelowBox, boxColumn + 1)));
            } else if (warehouseMap[rowBelowBox][boxColumn] == BOX_CLOSING) {
                movableBoxList.add(new Box(new Index(rowBelowBox, boxColumn - 1), new Index(rowBelowBox, boxColumn)));
            }
            if (warehouseMap[rowBelowBox][boxColumn + 1] == BOX_OPENING) {
                movableBoxList.add(new Box(new Index(rowBelowBox, boxColumn + 1), new Index(rowBelowBox, boxColumn + 2)));
            }

        }
        if (isMovementPossible) {
            for (int i = movableBoxList.size() - 1; i >= 0; i--) {
                Box box = movableBoxList.get(i);
                warehouseMap[box.open().x() + 1][box.open().y()] = warehouseMap[box.open().x()][box.open().y()];
                warehouseMap[box.close().x() + 1][box.close().y()] = warehouseMap[box.close().x()][box.close().y()];
                warehouseMap[box.open().x()][box.open().y()] = EMPTY_SPACE;
                warehouseMap[box.close().x()][box.close().y()] = EMPTY_SPACE;
            }
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

        List<Box> movableBoxList = new ArrayList<>();
        if (warehouseMap[rowAhead][currentColumn] == BOX_OPENING) {
            movableBoxList.add(new Box(new Index(rowAhead, currentColumn), new Index(rowAhead, currentColumn + 1)));
        } else {
            movableBoxList.add(new Box(new Index(rowAhead, currentColumn - 1), new Index(rowAhead, currentColumn)));
        }

        boolean isMovementPossible = true;
        for (int i = 0; i < movableBoxList.size(); i++) {
            Box box = movableBoxList.get(i);
            int rowAboveBox = box.open().x() - 1;
            int boxColumn = box.open().y();

            if (warehouseMap[rowAboveBox][boxColumn] == WALL || warehouseMap[rowAboveBox][boxColumn + 1] == WALL) {
                isMovementPossible = false;
                break;
            }
            if (warehouseMap[rowAboveBox][boxColumn] == BOX_OPENING) {
                movableBoxList.add(new Box(new Index(rowAboveBox, boxColumn), new Index(rowAboveBox, boxColumn + 1)));
            } else if (warehouseMap[rowAboveBox][boxColumn] == BOX_CLOSING) {
                movableBoxList.add(new Box(new Index(rowAboveBox, boxColumn - 1), new Index(rowAboveBox, boxColumn)));
            }
            if (warehouseMap[rowAboveBox][boxColumn + 1] == BOX_OPENING) {
                movableBoxList.add(new Box(new Index(rowAboveBox, boxColumn + 1), new Index(rowAboveBox, boxColumn + 2)));
            }

        }

        if (isMovementPossible) {
            for (int i = movableBoxList.size() - 1; i >= 0; i--) {
                Box box = movableBoxList.get(i);
                warehouseMap[box.open().x() - 1][box.open().y()] = warehouseMap[box.open().x()][box.open().y()];
                warehouseMap[box.close().x() - 1][box.close().y()] = warehouseMap[box.close().x()][box.close().y()];
                warehouseMap[box.open().x()][box.open().y()] = EMPTY_SPACE;
                warehouseMap[box.close().x()][box.close().y()] = EMPTY_SPACE;
            }
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

        while (warehouseMap[currentRow][columnAhead] != WALL && warehouseMap[currentRow][columnAhead] != EMPTY_SPACE) {
            columnAhead = columnAhead + 1;
        }
        if (warehouseMap[currentRow][columnAhead] == EMPTY_SPACE) {
            for (int i = columnAhead; i > currentColumn; i--) {
                warehouseMap[currentRow][i] = warehouseMap[currentRow][i - 1];
            }
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

        while (warehouseMap[currentRow][columnAhead] != WALL && warehouseMap[currentRow][columnAhead] != EMPTY_SPACE) {
            columnAhead = columnAhead - 1;
        }
        if (warehouseMap[currentRow][columnAhead] == EMPTY_SPACE) {
            for (int i = columnAhead; i < currentColumn; i++) {
                warehouseMap[currentRow][i] = warehouseMap[currentRow][i + 1];
            }
            return new Index(currentRow, currentColumn - 1);
        } else {
            return currentPosition;
        }
    }
}
