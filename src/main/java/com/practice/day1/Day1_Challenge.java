package com.practice.day1;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1_Challenge {

    /**
     * This method calculated the total distance between two equal sized Long Lists.
     * The total distance between the two list is the sum of
     * the difference between the numbers in two lists at every index.
     * @param firstList
     * @param secondList
     * @return result of totalDistance between lists.
     */
    public long getTotalDistanceBetweenLists(List<Long> firstList, List<Long> secondList) {
        Collections.sort(firstList);
        Collections.sort(secondList);
        long result = 0L;
        if( firstList.size() != secondList.size() ) {
            System.out.println("List sizes are not same");
            return result;
        }

        for(int i = 0; i < firstList.size(); i++) {
            result += Math.abs(firstList.get(i) - secondList.get(i));
        }
        return result;
    }

    /**
     * This method take two equal sized Lists of type Long and calculated the similarity score.
     * Similarity score can be obtained by adding up each number in the firstList
     * after multiplying it by the number of times that number appears in the right list.
     * @param firstList
     * @param secondList
     * @return similarityScore
     */
    public long getSimilarityScore(List<Long> firstList, List<Long> secondList) {
        Map<Long, Integer> secondValuesCountMap = new HashMap<>();
        secondList.forEach(num -> secondValuesCountMap.put(num, secondValuesCountMap.getOrDefault(num, 0) + 1));

        long result = 0L;

        for( long num : firstList ) {
            result += num * secondValuesCountMap.getOrDefault(num, 0);
        }
        return result;
    }
}
