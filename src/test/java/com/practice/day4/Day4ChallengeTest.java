package com.practice.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4ChallengeTest {

    public static final List<String> TEST_CASE_SCENARIO_1 = List.of("MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX");
    public static final List<String> TEST_CASE_SCENARIO_2 = List.of("AMXSXMA",
            "MXSASXM",
            "XSAMASX",
            "SAMXMAS",
            "XASMASX",
            "MXSASXM",
            "AMXSXMA");

    static Stream<org.junit.jupiter.params.provider.Arguments> provideInputListForCountingXMASWords() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(TEST_CASE_SCENARIO_1, 18),
                org.junit.jupiter.params.provider.Arguments.of(TEST_CASE_SCENARIO_2, 4));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> provideInputListForCountingXMASShapes() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(TEST_CASE_SCENARIO_1, 9),
                org.junit.jupiter.params.provider.Arguments.of(TEST_CASE_SCENARIO_2, 0));
    }

    @ParameterizedTest
    @MethodSource("provideInputListForCountingXMASWords")
    void testGetNumberOfXMASWords(List<String> inputList, int expectedNumberOfXMASWords) {
        Day4_Challenge day4Challenge = new Day4_Challenge();
        assertEquals(expectedNumberOfXMASWords,
                day4Challenge.getNumberOfXMASWords(inputList));
    }

    @ParameterizedTest
    @MethodSource("provideInputListForCountingXMASShapes")
    void testGetNumberOfXMASShapes(List<String> inputList, int expectedNumberOfXMASShapes) {
        Day4_Challenge day4Challenge = new Day4_Challenge();
        assertEquals(expectedNumberOfXMASShapes,
                day4Challenge.getNumberOfXMASShapes(inputList));
    }
}
