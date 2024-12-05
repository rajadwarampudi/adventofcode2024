package com.practice.day5;

import java.util.*;

public class Day5_Challenge {


    /**
     * Goes through the given page order rules and apply them on list of page updates.
     * and sums the middle page number of all valid pageUpdates
     * @param pageOrderRules
     * @param pageUpdates
     * @return sum of middle page number of alla valid page updates
     */
    public int getSumOfMiddlePageNumbersFromValidPageUpdates(List<int[]> pageOrderRules,
                                                             List<List<Integer>> pageUpdates) {
        int result = 0;
        Map<Integer, Set<Integer>> pageOrderMap = new HashMap<>();

        for (int[] rule : pageOrderRules) {
            pageOrderMap.computeIfAbsent(rule[1], k -> new HashSet<>()).add(rule[0]);
        }

        for (List<Integer> pageUpdate : pageUpdates) {
            if (isValidPageUpdate(pageUpdate, pageOrderMap)) {
                result += getMiddlePageNumber(pageUpdate);
            }
        }

        return result;
    }

    /**
     * Goes through the given page order rules and apply them on list of page updates.
     * and fixes the all invalid page-update lists and sums the middle page number of them.
     * @param pageOrderRules
     * @param pageUpdates
     * @return sum of middle page number of fixed invalid page updates
     */
    public int getSumOfMiddlePageNumbersFromInvalidPageUpdatesAfterFixing(List<int[]> pageOrderRules,
                                                             List<List<Integer>> pageUpdates) {
        int result = 0;
        Map<Integer, Set<Integer>> pageOrderMap = new HashMap<>();

        for (int[] rule : pageOrderRules) {
            pageOrderMap.computeIfAbsent(rule[1], k -> new HashSet<>()).add(rule[0]);
        }

        for (List<Integer> pageUpdate : pageUpdates) {
            result += getMiddlePageNumberFromInvalidPageUpdates(pageUpdate, pageOrderMap);
        }

        return result;
    }

    private int getMiddlePageNumber(List<Integer> pageOrderList) {
        int midIndex = ( pageOrderList.size() / 2 );
        return pageOrderList.get(midIndex);
    }

    private boolean isValidPageUpdate(List<Integer> pageUpdate, Map<Integer, Set<Integer>> pageOrderMap) {
        for (int i = 0; i < pageUpdate.size() - 1; i++) {
            Set<Integer> previousPages = pageOrderMap.get(pageUpdate.get(i));
            if(previousPages == null ||previousPages.isEmpty()) continue;
            for(int j = i + 1; j < pageUpdate.size(); j++) {
                if (previousPages.contains(pageUpdate.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getMiddlePageNumberFromInvalidPageUpdates(List<Integer> pageUpdate, Map<Integer, Set<Integer>> pageOrderMap) {
        List<Integer> pageUpdateCopy = new ArrayList<>(pageUpdate);
        int middlePage;
        boolean isInvalidPageUpdate = false;
        int i = 0;
        while (i < pageUpdateCopy.size() - 1) {
            Set<Integer> previousPages = pageOrderMap.get(pageUpdateCopy.get(i));
            if (previousPages == null ||previousPages.isEmpty()) {
                i++;
                continue;
            }

            int j = i + 1;
            boolean isReplaced = false;
            while (j < pageUpdateCopy.size()) {
                if (previousPages.contains(pageUpdateCopy.get(j))) {
                    isInvalidPageUpdate = true;
                    pageUpdateCopy.add(i, pageUpdateCopy.remove(j));
                    isReplaced = true;
                    break;
                }
                j++;
            }
            if (!isReplaced) i++;
        }
        middlePage = isInvalidPageUpdate ? getMiddlePageNumber(pageUpdateCopy) : 0;
        return middlePage;
    }
}
