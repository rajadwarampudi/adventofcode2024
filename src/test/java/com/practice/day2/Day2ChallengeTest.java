package com.practice.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2ChallengeTest {

    public static final List<List<Integer>> TEST_CASE_SCENARIO_1 = List.of(
            List.of(7, 6, 4, 2, 1),
            List.of(1, 2, 7, 8, 9),
            List.of(9, 7, 6, 2, 1),
            List.of(1, 3, 2, 4, 5),
            List.of(8, 6, 4, 4, 1),
            List.of(1, 3, 6, 7, 9));
    public static final List<List<Integer>> TEST_CASE_SCENARIO_2 = List.of(
            List.of(7),
            List.of(1),
            List.of(10),
            List.of(7300),
            List.of(8, 8, 8, 8, 8, 8, 8, 8, 8));

    static Stream<org.junit.jupiter.params.provider.Arguments> provideListsToCountSafeReports() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(TEST_CASE_SCENARIO_1, 2),
                org.junit.jupiter.params.provider.Arguments.of(TEST_CASE_SCENARIO_2, 4));
    }

    @ParameterizedTest
    @MethodSource("provideListsToCountSafeReports")
    void testGetSafeReportCount(List<List<Integer>> reportList, long expectedSafeReportCount) {
        Day2_Challenge day2Challenge = new Day2_Challenge();
        assertEquals(expectedSafeReportCount, day2Challenge.getNumberOfSafeReports(reportList));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> provideListsToCountSafeReportsWithProblemDampening() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(TEST_CASE_SCENARIO_1, 4),
                org.junit.jupiter.params.provider.Arguments.of(TEST_CASE_SCENARIO_2, 4));
    }

    @ParameterizedTest
    @MethodSource("provideListsToCountSafeReportsWithProblemDampening")
    void testGetSafeReportCountWithProblemDampening(List<List<Integer>> reportList, long expectedSafeReportCount) {
        Day2_Challenge day2Challenge = new Day2_Challenge();
        assertEquals(expectedSafeReportCount, day2Challenge.getNumberOfSafeReportsWithProblemDampener(reportList));
    }

}
