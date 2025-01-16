package com.practice.day7;

import java.util.Arrays;
import java.util.List;

public class Day7_Challenge {

    /**
     * This method calculates the total sum of calibration values which can be obtained by the given equation input
     * and the available two operators + and *
     * @param inputLines
     * @return sum of calibration values that can be possible with given equation
     */
    public long getTotalCalibrationResult(List<String> inputLines) {
        long result = 0L;

        for (String line : inputLines) {
            String[] equation = line.split(":");
            long testValue = Long.parseLong(equation[0]);
            List<Integer> numberList = Arrays.stream(equation[1].trim().split(" ")).map(Integer::valueOf).toList();

            if (numberList.size() == 1) {
                if (testValue == numberList.getFirst()) {
                    result += testValue;
                }
            } else  {
                int firstNum = numberList.getFirst();
                int secondNum = numberList.get(1);
                if (isTestValuePossible(numberList, 2, (long) firstNum * secondNum, testValue) ||
                        isTestValuePossible(numberList, 2, (long) firstNum + secondNum, testValue)) {
                    result += testValue;
                }
            }
        }

        return result;
    }

    private boolean isTestValuePossible(List<Integer> numberList, int currentIndex, long currentTestValue, long testValue) {
        if (currentIndex == numberList.size()) {
            return currentTestValue == testValue;
        } else {
            return isTestValuePossible(numberList, currentIndex + 1, currentTestValue + numberList.get(currentIndex), testValue) ||
                    isTestValuePossible(numberList, currentIndex + 1, currentTestValue * numberList.get(currentIndex), testValue);
        }
    }

    /**
     * This method calculates the total sum of calibration values which can be obtained by the given equation input
     * and the available three operators + and * and concatenation
     * @param inputLines
     * @return sum of calibration values that can be possible with given equation and three available operators
     */
    public long getTotalCalibrationResultIncludingConcatenationOperator(List<String> inputLines) {
        long result = 0L;

        for (String line : inputLines) {
            String[] equation = line.split(":");
            long testValue = Long.parseLong(equation[0]);
            List<Integer> numberList = Arrays.stream(equation[1].trim().split(" ")).map(Integer::valueOf).toList();

            if (numberList.size() == 1) {
                if (testValue == numberList.getFirst()) {
                    result += testValue;
                }
            } else  {
                int firstNum = numberList.getFirst();
                int secondNum = numberList.get(1);
                if (isTestValuePossibleIncludingConcatenation(numberList, 2, (long) firstNum * secondNum, testValue) ||
                        isTestValuePossibleIncludingConcatenation(numberList, 2, (long) firstNum + secondNum, testValue) ||
                        isTestValuePossibleIncludingConcatenation(numberList, 2, Long.parseLong(firstNum + "" + secondNum), testValue)) {
                    result += testValue;
                }
            }
        }

        return result;
    }

    private boolean isTestValuePossibleIncludingConcatenation(List<Integer> numberList, int currentIndex, long currentTestValue, long testValue) {
        if (currentIndex == numberList.size()) {
            return currentTestValue == testValue;
        } else {
            return isTestValuePossibleIncludingConcatenation(numberList, currentIndex + 1, currentTestValue + numberList.get(currentIndex), testValue) ||
                    isTestValuePossibleIncludingConcatenation(numberList, currentIndex + 1, currentTestValue * numberList.get(currentIndex), testValue) ||
                    isTestValuePossibleIncludingConcatenation(numberList, currentIndex + 1, Long.parseLong(currentTestValue + "" + numberList.get(currentIndex)), testValue);
        }
    }
}
