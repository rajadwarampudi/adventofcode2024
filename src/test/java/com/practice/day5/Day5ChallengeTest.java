package com.practice.day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5ChallengeTest {

    public static final List<int[]> PAGE_ORDERS = List.of(
            new int[]{1, 3},
            new int[]{1, 5},
            new int[]{1, 6},
            new int[]{2, 3},
            new int[]{2, 5},
            new int[]{2, 5},
            new int[]{2, 6},
            new int[]{3, 5},
            new int[]{3, 6});

    static Stream<org.junit.jupiter.params.provider.Arguments> providePagerOrderRulesAndPageUpdatesAgainstExpectedSumOfValidPageUpdates() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(PAGE_ORDERS, List.of(List.of(1, 2, 3, 4, 5)), 3),
                org.junit.jupiter.params.provider.Arguments.of(PAGE_ORDERS, List.of(List.of(3, 2, 1, 4, 5)), 0));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> providePagerOrderRulesAndPageUpdatesAgainstExpectedSumOfInvalidPageUpdates() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(PAGE_ORDERS, List.of(List.of(1, 2, 3, 4, 5)), 0),
                org.junit.jupiter.params.provider.Arguments.of(PAGE_ORDERS, List.of(List.of(3, 2, 1, 4, 5)), 3));
    }

    @ParameterizedTest
    @MethodSource("providePagerOrderRulesAndPageUpdatesAgainstExpectedSumOfValidPageUpdates")
    void testGetSumOfMiddlePageNumbersFromValidPageUpdates(List<int[]> pageOrderRules,
                                                           List<List<Integer>> pageUpdates, int expectedSumOfMiddlePages) {
        Day5_Challenge day5Challenge = new Day5_Challenge();
        assertEquals(expectedSumOfMiddlePages,
                day5Challenge.getSumOfMiddlePageNumbersFromValidPageUpdates(pageOrderRules, pageUpdates));
    }

    @ParameterizedTest
    @MethodSource("providePagerOrderRulesAndPageUpdatesAgainstExpectedSumOfInvalidPageUpdates")
    void testGetSumOfMiddlePageNumbersFromInvalidPageUpdates(List<int[]> pageOrderRules,
                                                           List<List<Integer>> pageUpdates, int expectedSumOfMiddlePages) {
        Day5_Challenge day5Challenge = new Day5_Challenge();
        assertEquals(expectedSumOfMiddlePages,
                day5Challenge.getSumOfMiddlePageNumbersFromInvalidPageUpdatesAfterFixing(pageOrderRules, pageUpdates));
    }
}
