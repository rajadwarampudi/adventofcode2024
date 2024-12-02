package com.practice.day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1ChallengeTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> provideListsToCalculateTotalDistance() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(1L, 1L, 1L),
                        Arrays.asList(1L, 1L, 1L),
                        0L),
                org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(1L, 1L, 1L),
                        Arrays.asList(0L, 0L, 0L),
                        3L),
                org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Long.MAX_VALUE, Long.MAX_VALUE),
                        Arrays.asList(Long.MAX_VALUE, 0L),
                        Long.MAX_VALUE),
                org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(10000L, 1L, 100000L),
                        Arrays.asList(1000L, 9000L, 200000L),
                        101999L));
    }

    @ParameterizedTest
    @MethodSource("provideListsToCalculateTotalDistance")
    void testGetTotalDistanceBetweenLists(List<Long> firstList, List<Long> secondList, long expectedResult) {
        Day1_Challenge day1Challenge = new Day1_Challenge();
        assertEquals(expectedResult, day1Challenge.getTotalDistanceBetweenLists(firstList, secondList));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> provideListsToCalculateSimilarityScore() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(1L, 1L, 1L),
                        Arrays.asList(1L, 1L, 1L),
                        9L),
                org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(1L, 1L, 1L),
                        Arrays.asList(0L, 0L, 0L),
                        0L),
                org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Long.MAX_VALUE, 10L),
                        Arrays.asList(Long.MAX_VALUE, 0L),
                        Long.MAX_VALUE),
                org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(10000L, 1L, 100000L),
                        Arrays.asList(1000L, 9000L, 200000L),
                        0L));
    }

    @ParameterizedTest
    @MethodSource("provideListsToCalculateSimilarityScore")
    void testSimilarityScoreCalculation(List<Long> firstList, List<Long> secondList, long expectedResult) {
        Day1_Challenge day1Challenge = new Day1_Challenge();
        assertEquals(expectedResult, day1Challenge.getSimilarityScore(firstList, secondList));
    }
}
