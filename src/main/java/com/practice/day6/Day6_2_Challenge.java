package com.practice.day6;

import java.util.ArrayList;
import java.util.List;

public class Day6_2_Challenge {


    private static final char OBSTRUCTION = '#';
    private static final char NEW_OBSTRUCTION = 'O';


    public int getNumberOfNewObstructionsToMakeInfiniteLoops(char[][] map, int[] startIndex) {
        int newObstructionCount = 0;
        List<int[]> visitedObstructionsList = new ArrayList<>();
        int currentRow = startIndex[0];
        int currentCol = startIndex[1];

        newObstructionCount += traverseUpwards(map, currentRow, currentCol, visitedObstructionsList);

        return newObstructionCount;
    }

    private int traverseUpwards(char[][] map, int currentRow, int currentCol, List<int[]> visitedObstructionsList) {
        int newObstructionCount = 0;
        while (currentRow >= 0 && map[currentRow][currentCol] != OBSTRUCTION) {
            if (doesAnyVisitedObstructionExistsInSameRowWhileGoingUpwards(visitedObstructionsList, currentRow, currentCol)) {
                if (currentRow != 0) {
                     if (map[currentRow - 1][currentCol] != NEW_OBSTRUCTION && map[currentRow - 1][currentCol] != OBSTRUCTION) {
                         map[currentRow - 1][currentCol] = NEW_OBSTRUCTION;
                         newObstructionCount += 1;
                     }
                } else if (map[currentRow][currentCol] != NEW_OBSTRUCTION && map[currentRow][currentCol] != OBSTRUCTION){
                    newObstructionCount += 1;
                }
            }
            currentRow--;
        }

        if (currentRow < 0) {
            return newObstructionCount;
        } else {
            visitedObstructionsList.add(new int[]{currentRow, currentCol});
            return newObstructionCount + traverseRight(map, currentRow + 1, currentCol, visitedObstructionsList);
        }
    }

    boolean doesAnyVisitedObstructionExistsInSameRowWhileGoingUpwards(List<int[]> visitedObstructionsList, int currentRow, int currentCol) {
        for (int i = 0; i < visitedObstructionsList.size() - 2 ; i++) {
            if (visitedObstructionsList.get(i)[0] == currentRow && visitedObstructionsList.get(i)[1] > currentCol) return true;
        }
        return false;
    }



    private int traverseRight(char[][] map, int currentRow, int currentCol, List<int[]> visitedObstructionsList) {
        int newObstructionCount = 0;
        while (currentCol < map[currentRow].length && map[currentRow][currentCol] != OBSTRUCTION) {
            if (doesAnyVisitedObstructionExistsInSameColumnWhileGoingRight(visitedObstructionsList, currentRow, currentCol)) {
                if (currentCol < map[currentRow].length - 1) {
                    if (map[currentRow][currentCol + 1] != NEW_OBSTRUCTION && map[currentRow][currentCol + 1] != OBSTRUCTION) {
                        map[currentRow][currentCol + 1] = NEW_OBSTRUCTION;
                        newObstructionCount += 1;
                    }
                } else if (map[currentRow][currentCol] != NEW_OBSTRUCTION && map[currentRow][currentCol] != OBSTRUCTION){
                    newObstructionCount += 1;
                }
            }
            currentCol++;
        }

        if (currentCol == map[currentRow].length) {
            return newObstructionCount;
        } else {
            visitedObstructionsList.add(new int[]{currentRow, currentCol});
            return newObstructionCount + traverseDownwards(map, currentRow, currentCol - 1, visitedObstructionsList);
        }
    }

    boolean doesAnyVisitedObstructionExistsInSameColumnWhileGoingRight(List<int[]> visitedObstructionsList, int currentRow, int currentColumn) {
        for (int i = 0; i < visitedObstructionsList.size() - 2 ; i++) {
            if (visitedObstructionsList.get(i)[1] == currentColumn && visitedObstructionsList.get(i)[0] > currentRow) return true;
        }
        return false;
    }

    private int traverseDownwards(char[][] map, int currentRow, int currentCol, List<int[]> visitedObstructionsList) {
        int newObstructionCount = 0;
        while (currentRow < map.length && map[currentRow][currentCol] != OBSTRUCTION) {
            if (doesAnyVisitedObstructionExistsInSameRowWhileGoingDownwards(visitedObstructionsList, currentRow, currentCol)) {
                if (currentRow < map.length - 1) {
                    if (map[currentRow + 1][currentCol] != NEW_OBSTRUCTION && map[currentRow + 1][currentCol] != OBSTRUCTION) {
                        map[currentRow + 1][currentCol] = NEW_OBSTRUCTION;
                        newObstructionCount += 1;
                    }
                } else if (map[currentRow][currentCol] != NEW_OBSTRUCTION && map[currentRow][currentCol] != OBSTRUCTION){
                    newObstructionCount += 1;
                }

            }
            currentRow++;
        }

        if (currentRow == map.length) {
            return newObstructionCount;
        } else {
            visitedObstructionsList.add(new int[]{currentRow, currentCol});
            return newObstructionCount + traverseLeft(map, currentRow - 1, currentCol, visitedObstructionsList);
        }
    }

    boolean doesAnyVisitedObstructionExistsInSameRowWhileGoingDownwards(List<int[]> visitedObstructionsList, int currentRow, int currentColumn) {
        for (int i = 0; i < visitedObstructionsList.size() - 2 ; i++) {
            if (visitedObstructionsList.get(i)[0] == currentRow && visitedObstructionsList.get(i)[1] < currentColumn) return true;
        }
        return false;
    }

    private int traverseLeft(char[][] map, int currentRow, int currentCol, List<int[]> visitedObstructionsList) {
        int newObstructionCount = 0;
        while (currentCol >= 0 && map[currentRow][currentCol] != OBSTRUCTION) {
            if (doesAnyVisitedObstructionExistsInSameColumnWhileGoingLeft(visitedObstructionsList, currentRow, currentCol)) {
                if (currentCol != 0) {
                    if (map[currentRow][currentCol - 1] != NEW_OBSTRUCTION && map[currentRow][currentCol - 1] != OBSTRUCTION) {
                        map[currentRow][currentCol - 1] = NEW_OBSTRUCTION;
                        newObstructionCount += 1;
                    }
                } else if (map[currentRow][currentCol] != NEW_OBSTRUCTION && map[currentRow][currentCol] != OBSTRUCTION){
                    newObstructionCount += 1;
                }

            }
            currentCol--;
        }

        if (currentCol < 0) {
            return newObstructionCount;
        } else {
            visitedObstructionsList.add(new int[]{currentRow, currentCol});
            return newObstructionCount + traverseUpwards(map, currentRow, currentCol + 1, visitedObstructionsList);
        }
    }

    boolean doesAnyVisitedObstructionExistsInSameColumnWhileGoingLeft(List<int[]> visitedObstructionsList, int currentRow, int currentColumn) {
        for (int i = 0; i < visitedObstructionsList.size() - 2 ; i++) {
            if (visitedObstructionsList.get(i)[1] == currentColumn && visitedObstructionsList.get(i)[0] < currentRow) return true;
        }
        return false;
    }
}
