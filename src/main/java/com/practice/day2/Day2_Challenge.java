package com.practice.day2;

import java.util.ArrayList;
import java.util.List;

public class Day2_Challenge {
    /**
     * The function takes list of reports and counts the number of safe reports among them
     * A safe report must satisfy the following conditions
     * - The levels are either all increasing or all decreasing.
     * - Any two adjacent levels differ by at least one and at most three.
     * @param reportList
     * @return number of safe reports in the given list
     */
    public int getNumberOfSafeReports(List<List<Integer>> reportList) {
        int safeReportCount = 0;
        for (List<Integer> report : reportList) {
            if (isSafeReport(report)) {
                safeReportCount++;
            }
        }

        return safeReportCount;
    }

    private boolean isSafeReport(List<Integer> report) {
        boolean isDescendingOrder = true;
        boolean isAscendingOrder = true;
        for (int i = 1; i < report.size() && (isDescendingOrder || isAscendingOrder) ; i++) {
            int diff = Math.abs(report.get(i) - report.get(i - 1));
            if (diff < 1 || diff > 3) return false;
            if(report.get(i) < report.get(i - 1)) {
                isAscendingOrder = false;
            }
            if(report.get(i) > report.get(i - 1)) {
                isDescendingOrder = false;
            }
        }

        return isDescendingOrder || isAscendingOrder;
    }

    /**
     * The function takes list of reports and counts the number of safe reports among them
     * after the consideration of problem dampener
     * A safe report must satisfy the following conditions
     * - The levels are either all increasing or all decreasing.
     * - Any two adjacent levels differ by at least one and at most three.
     * Problem dampening means ignoring at most one level in a report to make it safe.
     * @param reportList
     * @return number of safe reports after problem dampening in the given list
     */
    public int getNumberOfSafeReportsWithProblemDampener(List<List<Integer>> reportList) {
        int safeReportCountWithProblemDampener = 0;
        for (List<Integer> report : reportList) {
            if (isSafeReportWithProblemDampener(report)) {
                safeReportCountWithProblemDampener++;
            }
        }

        return safeReportCountWithProblemDampener;
    }

    private boolean isSafeReportWithProblemDampener(List<Integer> report) {
        for(int j = 0; j < report.size(); j++) {
            List<Integer> tempReport = new ArrayList<>(report);
            int removedLevel = tempReport.remove(j);

            boolean tempSafeReportStatus = isSafeReport(tempReport);
            if (tempSafeReportStatus) return true;
        }

        return false;

    }
}
