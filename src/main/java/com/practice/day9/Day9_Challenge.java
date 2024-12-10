package com.practice.day8;

import java.util.*;

public class Day8_Challenge {

    public int getNumberOfAntiNodes(char[][] map) {
        Map<Character, List<Index>> antennaIndexMap = getAntennaIndexMap(map);

        return getAntiNodeCount(antennaIndexMap, map.length, map[0].length);

    }

    public int getNumberOfAntiNodesIncludingAntiNodesAsAntennas(char[][] map) {
        Map<Character, List<Index>> antennaIndexMap = getAntennaIndexMap(map);
        Set<Index> antiNodeIndexSet = getAntiNodeIndexSet(antennaIndexMap, map.length, map[0].length);

        List<Index> antiNodeIndexList = new ArrayList<>(antiNodeIndexSet);

        for (int i = 0; i < antiNodeIndexList.size() - 1; i++) {
            for (int j = i + 1; j < antiNodeIndexList.size(); j++) {
                Set<Index> antiNodeIndexsubSet = getAntiNodeIndexSet(antiNodeIndexList.get(i),
                        antiNodeIndexList.get(j), map.length, map[0].length);
                for (Index newAntiNodeIndex : antiNodeIndexsubSet) {
                    if (antiNodeIndexSet.add(newAntiNodeIndex)) {
                        antiNodeIndexList.add(newAntiNodeIndex);
                    }
                }
            }
        }

        return antiNodeIndexSet.size();
    }

    private static int getAntiNodeCount(Map<Character, List<Index>> antennaIndexMap, int rows, int columns) {
        Set<Index> antiNodeIndexSet = getAntiNodeIndexSet(antennaIndexMap, rows, columns);
        return antiNodeIndexSet.size();
    }

    private static Set<Index> getAntiNodeIndexSet(Map<Character, List<Index>> antennaIndexMap, int rows, int columns) {
        Set<Index> antiNodeIndexSet = new HashSet<>();

        for (List<Index> antennaCoordinates : antennaIndexMap.values()) {
            antiNodeIndexSet.addAll(getAntiNodeIndexSet(antennaCoordinates, rows, columns));
        }
        return antiNodeIndexSet;
    }

    private static Set<Index> getAntiNodeIndexSet(List<Index> antennaCoordinates, int rows, int columns) {
        Set<Index> antiNodeIndexAtUniqueAntennaLevelSet = new HashSet<>();
        for (int i = 0; i < antennaCoordinates.size() - 1; i++) {
            Index firstIndex = antennaCoordinates.get(i);
            for (int j  = i + 1; j < antennaCoordinates.size(); j++) {
                Index secondIndex = antennaCoordinates.get(j);
                antiNodeIndexAtUniqueAntennaLevelSet.addAll(getAntiNodeIndexSet(firstIndex, secondIndex, rows, columns));
            }
        }

        return antiNodeIndexAtUniqueAntennaLevelSet;
    }

    private static Set<Index> getAntiNodeIndexSet(Index firstIndex, Index secondIndex, int rows, int columns) {

        Index oneAntiNodeIndex = getAntennaIndexMap(firstIndex, secondIndex);
        Index secondAntiNodeIndex = getAntennaIndexMap(secondIndex, firstIndex);

        return new HashSet<>(getValidAntiNodesSet(rows, columns, oneAntiNodeIndex, secondAntiNodeIndex));
    }

    private static Set<Index> getValidAntiNodesSet(int rows, int columns, Index... antiNodeIndices) {
        Set<Index> antiNodeIndexSet = new HashSet<>();
        for (Index antiNodeIndex : antiNodeIndices) {
            if (isValidIndex(antiNodeIndex, rows, columns)) {
                antiNodeIndexSet.add(antiNodeIndex);
            }
        }
        return antiNodeIndexSet;
    }

    private static boolean isValidIndex(Index antiNodeIndex, int rows, int columns) {
        return (antiNodeIndex.x() >= 0 && antiNodeIndex.x() < rows) && (antiNodeIndex.y() >= 0 && antiNodeIndex.y() < columns);
    }

    private static Index getAntennaIndexMap(Index currentIndex, Index referenceIndex) {
        return new Index(currentIndex.x() + (currentIndex.x() - referenceIndex.x()),
                currentIndex.y() + (currentIndex.y() - referenceIndex.y()));
    }


    private static Map<Character, List<Index>> getAntennaIndexMap(char[][] map) {
        Map<Character, List<Index>> antennaIndexMap = new HashMap<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                char ch = map[i][j];
                if (Character.isLowerCase(ch) || Character.isUpperCase(ch) || Character.isDigit(ch)) {
                    antennaIndexMap.computeIfAbsent(map[i][j], k -> new ArrayList<>()).add(new Index(i , j));
                }
            }
        }

        return antennaIndexMap;
    }


}
