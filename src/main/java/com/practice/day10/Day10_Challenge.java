package com.practice.day10;

import com.practice.Index;

import java.util.HashSet;
import java.util.Set;

public class Day10_Challenge {

    /**
     * This method calculates the total trailhead score in a given topgraphicMap
     * A trailhead is any position that starts one or more hiking trails - here,
     * these positions will always have height 0. Assembling more fragments of pages,
     * you establish that a trailhead's score is the number of 9-height positions reachable from that trailhead via a hiking trail.
     *
     * This trailhead has a score of 2:
     *
     * ...0...
     * ...1...
     * ...2...
     * 6543456
     * 7.....7
     * 8.....8
     * 9.....9
     * @param topographicMap
     * @return total TrailHeadScore
     */
    public int getTotalTrailheadScoreWithUniqueDestinations(int[][] topographicMap) {
        int totalTrailheadScore = 0;
        int rows = topographicMap.length;
        int columns = topographicMap[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (topographicMap[i][j] == 0) {
                    Set<Index> visitedHighestPositions = new HashSet<>();
                    totalTrailheadScore += countNumberOfTrailheadsWithUniqueDestinations(topographicMap, i, j, visitedHighestPositions);
                }
            }
        }

        return totalTrailheadScore;
    }

    /**
     * This method calculates the total trailhead score in a given topgraphicMap with unique trail paths.
     * A trailhead is any position that starts one or more hiking trails - here,
     * these positions will always have height 0. Assembling more fragments of pages,
     * you establish that a trailhead's score is the number of 9-height positions reachable from that trailhead via a hiking trail.
     *
     * This trailhead has a score of 2:
     *
     * ...0...
     * ...1...
     * ...2...
     * 6543456
     * 7.....7
     * 8.....8
     * 9.....9
     * @param topographicMap
     * @return total TrailHeadScore
     */

    public int getTotalTrailheadScoreWithUniqueTrailPaths(int[][] topographicMap) {
        int totalTrailheadScore = 0;
        int rows = topographicMap.length;
        int columns = topographicMap[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (topographicMap[i][j] == 0) {
                    totalTrailheadScore += countNumberOfTrailheadsWithUniqueTrailPaths(topographicMap, i, j);
                }
            }
        }

        return totalTrailheadScore;
    }


    private int countNumberOfTrailheadsWithUniqueDestinations(int[][] topographicMap, int row, int column, Set<Index> visitedHighestPositions) {
        int rows = topographicMap.length;
        int columns = topographicMap[0].length;

        int numberOfTrailheads = 0;

        if (topographicMap[row][column] == 9) {
            Index destinationIndex = new Index(row, column);
            if (visitedHighestPositions.contains(destinationIndex)) {
                return 0;
            } else {
                visitedHighestPositions.add(destinationIndex);
                return 1;
            }

        }

        // up
        if (row > 0 && topographicMap[row][column] == topographicMap[row - 1][column] - 1) {
            numberOfTrailheads += countNumberOfTrailheadsWithUniqueDestinations(topographicMap, row - 1, column, visitedHighestPositions);
        }
        // down
        if (row < rows - 1 && topographicMap[row][column] == topographicMap[row + 1][column] - 1) {
            numberOfTrailheads += countNumberOfTrailheadsWithUniqueDestinations(topographicMap, row + 1, column, visitedHighestPositions);
        }
        // left
        if (column > 0 && topographicMap[row][column] == topographicMap[row][column - 1] - 1) {
            numberOfTrailheads += countNumberOfTrailheadsWithUniqueDestinations(topographicMap, row, column - 1, visitedHighestPositions);
        }
        // right
        if (column < columns - 1 && topographicMap[row][column] == topographicMap[row][column + 1] - 1) {
            numberOfTrailheads += countNumberOfTrailheadsWithUniqueDestinations(topographicMap, row, column + 1, visitedHighestPositions);
        }

        return  numberOfTrailheads;
    }


    private int countNumberOfTrailheadsWithUniqueTrailPaths(int[][] topographicMap, int row, int column) {
        int rows = topographicMap.length;
        int columns = topographicMap[0].length;

        int numberOfTrailheads = 0;

        if (topographicMap[row][column] == 9) {
            return 1;
        }

        // up
        if (row > 0 && topographicMap[row][column] == topographicMap[row - 1][column] - 1) {
            numberOfTrailheads += countNumberOfTrailheadsWithUniqueTrailPaths(topographicMap, row - 1, column);
        }
        // down
        if (row < rows - 1 && topographicMap[row][column] == topographicMap[row + 1][column] - 1) {
            numberOfTrailheads += countNumberOfTrailheadsWithUniqueTrailPaths(topographicMap, row + 1, column);
        }
        // left
        if (column > 0 && topographicMap[row][column] == topographicMap[row][column - 1] - 1) {
            numberOfTrailheads += countNumberOfTrailheadsWithUniqueTrailPaths(topographicMap, row, column - 1);
        }
        // right
        if (column < columns - 1 && topographicMap[row][column] == topographicMap[row][column + 1] - 1) {
            numberOfTrailheads += countNumberOfTrailheadsWithUniqueTrailPaths(topographicMap, row, column + 1);
        }

        return  numberOfTrailheads;
    }
}
