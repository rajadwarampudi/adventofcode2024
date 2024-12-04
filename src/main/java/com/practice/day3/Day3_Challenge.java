package com.practice.day3;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            totalLines.append(line).append("-");
        }

        return getSumOfMultiplicationsFromCorruptedMemoryWithInstructions(totalLines.toString());
    }

    private int getSumOfMultiplicationsFromCorruptedMemory(String line) {
        int result = 0;
        Matcher matcher = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)").matcher(line);

        while (matcher.find()) {
            result += processMulExpression(matcher.group());
        }

        return result;
    }

    private int processMulExpression(String expression) {
        String parametersString = expression.substring(4, expression.length() - 1);
        String[] parameters = parametersString.split(",");
        return Integer.parseInt(parameters[0]) * Integer.parseInt(parameters[1]);
    }

    private int getSumOfMultiplicationsFromCorruptedMemoryWithInstructions(String line) {
        int result = 0;
        boolean isMulExpressionAllowed = true;
        int idx = 0;
        while (idx < line.length() - 8) {
            if ("do()".equals(line.substring(idx, idx + 4))) {
                isMulExpressionAllowed = true;
                idx = idx + 4;
                continue;
            } else if ("don't()".equals(line.substring(idx, idx + 7))) {
                isMulExpressionAllowed = false;
                idx = idx + 7;
                continue;
            } else if (isMulExpressionAllowed && line.charAt(idx) == 'm') {
                Matcher mulExpMatcher = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)").matcher(line);
                int endIdx = Math.min(idx + 12, line.length() - 1);
                mulExpMatcher.region(idx, endIdx);
                if (mulExpMatcher.find()) {
                    result += processMulExpression(mulExpMatcher.group());
                    idx = mulExpMatcher.end();
                } else {
                    idx++;
                }
                continue;
            }
            idx++;
        }

        return result;
    }

}
