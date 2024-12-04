package com.practice.day4;

import java.util.List;

public class Day4_Challenge {
    /**
     * Counts the number of XMAS words in the given list of equal sized Strings
     * This word search allows words to be
     * horizontal, vertical, diagonal, written backwards, or even overlapping other words.
     * @param inputList
     * @return the number of XMAS words
     */
    public int getNumberOfXMASWords(List<String> inputList) {
        int result = 0;

        char[][] input = getInputArray(inputList);
        int rows = input.length;
        int columns = input[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (input[i][j] == 'X') {
                    result += countXMASWords(input, i, j);
                }
            }
        }
        return result;
    }

    /**
     * Counts the number of X shaped "MAS" word appearances in the given list of equal sized Strings
     * The MAS can be in any direction diagonally. for example as the X-MAS's shown below
     * M . S  -   S . M
     * . A .      . A .
     * M . S  -   S . M
     * @param inputList
     * @return the number of XMAS words
     */
    public int getNumberOfXMASShapes(List<String> inputList) {
        int result = 0;

        char[][] input = getInputArray(inputList);
        int rows = input.length;
        int columns = input[0].length;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (input[i][j] == 'A') {
                    result += countXMASShapes(input, i, j);
                }
            }
        }
        return result;
    }

    private static char[][] getInputArray(List<String> inputList) {
        char[][] input = new char[inputList.size()][inputList.getFirst().length()];
        int i = 0;
        for (String line : inputList) {
            input[i++] = line.toCharArray();
        }
        return input;
    }

    private int countXMASWords(char[][] input, int rowIdx, int colIdx) {
        int count = 0;
        count += countHorizontalXMASWords(input, rowIdx, colIdx);
        count += countVerticalXMASWords(input, rowIdx, colIdx);
        count += countDiagonalXMASWords(input, rowIdx, colIdx);

        return count;
    }

    private int countHorizontalXMASWords(char[][] input, int rowIdx, int colIdx) {
        int count = 0;
        int columns = input[0].length;

        if (colIdx + 3 < columns) {
            if (input[rowIdx][colIdx + 1] == 'M' &&
                    input[rowIdx][colIdx + 2] == 'A' &&
                    input[rowIdx][colIdx + 3] == 'S') count++;
        }
        if (colIdx - 3 >= 0) {
            if (input[rowIdx][colIdx - 1] == 'M' &&
                    input[rowIdx][colIdx - 2] == 'A' &&
                    input[rowIdx][colIdx - 3] == 'S') count++;
        }

        return count;
    }

    private int countVerticalXMASWords(char[][] input, int rowIdx, int colIdx) {
        int count = 0;
        int rows = input.length;

        if (rowIdx + 3 < rows) {
            if (input[rowIdx + 1][colIdx] == 'M' &&
                    input[rowIdx + 2][colIdx] == 'A' &&
                    input[rowIdx + 3][colIdx] == 'S') count++;
        }
        if (rowIdx - 3 >= 0) {
            if (input[rowIdx - 1][colIdx] == 'M' &&
                    input[rowIdx - 2][colIdx] == 'A' &&
                    input[rowIdx - 3][colIdx] == 'S') count++;
        }

        return count;
    }

    private int countDiagonalXMASWords(char[][] input, int rowIdx, int colIdx) {
        int rows = input.length;
        int columns = input[0].length;
        int count = 0;

        if (rowIdx + 3 < rows) {
            if (colIdx + 3 < columns) {
                if (input[rowIdx + 1][colIdx + 1] == 'M' &&
                        input[rowIdx + 2][colIdx + 2] == 'A' &&
                        input[rowIdx + 3][colIdx + 3] == 'S') count++;
            }
            if (colIdx - 3 >= 0) {
                if (input[rowIdx + 1][colIdx - 1] == 'M' &&
                        input[rowIdx + 2][colIdx - 2] == 'A' &&
                        input[rowIdx + 3][colIdx - 3] == 'S') count++;
            }
        }
        if (rowIdx - 3 >= 0) {
            if (colIdx + 3 < columns) {
                if (input[rowIdx - 1][colIdx + 1] == 'M' &&
                        input[rowIdx - 2][colIdx + 2] == 'A' &&
                        input[rowIdx - 3][colIdx + 3] == 'S') count++;
            }
            if (colIdx - 3 >= 0) {
                if (input[rowIdx - 1][colIdx - 1] == 'M' &&
                        input[rowIdx - 2][colIdx - 2] == 'A' &&
                        input[rowIdx - 3][colIdx - 3] == 'S') count++;
            }
        }

        return count;

    }

    private int countXMASShapes(char[][] input, int rowIdx, int colIdx) {
        char topLeft = input[rowIdx - 1][colIdx - 1];
        char topRight = input[rowIdx - 1][colIdx + 1];
        char bottomLeft = input[rowIdx + 1][colIdx - 1];
        char bottomRight = input[rowIdx + 1][colIdx + 1];
        return (((topLeft == 'M' && bottomRight == 'S') || (topLeft == 'S' && bottomRight == 'M')) &&
                ((bottomLeft == 'M' && topRight == 'S') || (bottomLeft == 'S' && topRight == 'M'))) ? 1 : 0;
    }
}
