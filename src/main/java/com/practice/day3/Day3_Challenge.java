package com.practice.day3;

import java.util.List;

public class Day3_Challenge {
    public int getSumOfMultiplicationsFromCorruptedMemory(List<String> lineList) {
        int result = 0;
        for (String line : lineList) {
            result += getSumOfMultiplicationsFromCorruptedMemory(line);
        }

        return result;
    }

    public int getSumOfMultiplicationsFromCorruptedMemoryWithInstructions(List<String> lineList) {
        StringBuilder totalLines = new StringBuilder();
        for (String line : lineList) {
            totalLines.append(line);
        }

        return getSumOfMultiplicationsFromCorruptedMemoryWithInstructions(totalLines.toString());
    }

    private int getSumOfMultiplicationsFromCorruptedMemory(String line) {
        int result = 0;
        int mulStartIndex = line.indexOf("mul(");
        int mulEndIndex = line.indexOf(')', mulStartIndex);
        while (mulStartIndex != -1 && mulEndIndex != -1) {
            if (isValidMulEndIndex(mulStartIndex, mulEndIndex)) {
                result += processMul(line, mulStartIndex, mulEndIndex);
            }

            mulStartIndex = line.indexOf("mul(", mulStartIndex + 4);
            mulEndIndex = line.indexOf(')', mulStartIndex);
        }

        return result;
    }

    private int getSumOfMultiplicationsFromCorruptedMemoryWithInstructions(String line) {
        int result = 0;
        int mulStartIndex = line.indexOf("mul(");
        int mulEndIndex = line.indexOf(')', mulStartIndex);
        while (mulStartIndex != -1 && mulEndIndex != -1) {
            if (isValidMulEndIndex(mulStartIndex, mulEndIndex) &&
                    isAllowedByInstruction(line, mulStartIndex)) {
                result += processMul(line, mulStartIndex, mulEndIndex);
            }

            mulStartIndex = line.indexOf("mul(", mulStartIndex + 4);
            mulEndIndex = line.indexOf(')', mulStartIndex);
        }

        return result;
    }

    private boolean isAllowedByInstruction(String line, int mulStartIndex) {
        int doInstructionIndex = line.lastIndexOf("do()", mulStartIndex);
        int dontInstructionIndex = line.lastIndexOf("don't()", mulStartIndex);

        return dontInstructionIndex == -1 || doInstructionIndex >= dontInstructionIndex;
    }

    private int processMul(String line, int mulStartIndex, int mulEndIndex) {
        int result = 0;
        String parametersString = line.substring(mulStartIndex + 4, mulEndIndex);
        String[] parameters = parametersString.split(",");
        if (parameters.length == 2) {
            if (isValidParameter(parameters[0]) && isValidParameter(parameters[1])) {
                result += Integer.parseInt(parameters[0]) * Integer.parseInt(parameters[1]);
            }
        }

        return result;
    }

    private boolean isValidParameter(String parameter) {
        try {
            int parameterValue = Integer.parseInt(parameter);
            if (parameterValue < 1 || parameterValue > 999) return false;
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    private boolean isValidMulEndIndex(int mulStartIndex, int mulEndIndex) {
        if (mulEndIndex == -1) return false;
        int mulExpLength = (mulEndIndex - mulStartIndex) + 1;
        // valid expression's length is in between 8 and 12 because the digits in each parameter is 1 to 3
        return mulExpLength >= 8 && mulExpLength <= 12;
    }
}
