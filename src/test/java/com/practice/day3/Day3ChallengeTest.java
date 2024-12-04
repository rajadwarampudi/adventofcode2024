package com.practice.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3ChallengeTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> provideCorruptedMemoryWithMulExpressions() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(List.of(
                        "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"), 161),
                org.junit.jupiter.params.provider.Arguments.of(List.of(
                        "mul(100,100)mul()mul(200,1)mul(mul(1,1)mul(90,56))mul(37,37)mul)mul(111,222"), 16610),
                org.junit.jupiter.params.provider.Arguments.of(List.of(
                        "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))",
                        "mul(100,100)mul()mul(200,1)mul(mul(1,1)mul(90,56))mul(37,37)mul)mul(111,222"), 161 + 16610));
    }

    @ParameterizedTest
    @MethodSource("provideCorruptedMemoryWithMulExpressions")
    void testSumOfMulInstructions(List<String> memoryLines, int expectedTotalSumOfMulInstructions) {
        Day3_Challenge day3Challenge = new Day3_Challenge();
        assertEquals(expectedTotalSumOfMulInstructions,
                day3Challenge.getSumOfMultiplicationsFromCorruptedMemory(memoryLines));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> provideCorruptedMemoryWithMulExpressionsAndInstructions() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(List.of(
                        "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"), 48),
                org.junit.jupiter.params.provider.Arguments.of(List.of(
                        "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(200,999))"), 8 + (200 * 999)),
                org.junit.jupiter.params.provider.Arguments.of(List.of(
                        "xmul(2,4)&mul[3,7]!^don't()do()_mul(5,5)+mul(32,64](mul(11,8)undo)?mul(200,999))"), (2 * 4) + (5 * 5) + (11 * 8) + (200 * 999)),
                org.junit.jupiter.params.provider.Arguments.of(List.of(
                        "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))don't()",
                        "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))don't()"), 88),
                org.junit.jupiter.params.provider.Arguments.of(List.of(
                        "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))don't()",
                        "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))mul(22,99))"), 2266));
    }

    @ParameterizedTest
    @MethodSource("provideCorruptedMemoryWithMulExpressionsAndInstructions")
    void testSumOfMulInstructionsWithInstructions(List<String> memoryLines, int expectedTotalSumOfMulInstructions) {
        Day3_Challenge day3Challenge = new Day3_Challenge();
        assertEquals(expectedTotalSumOfMulInstructions,
                day3Challenge.getSumOfMultiplicationsFromCorruptedMemoryWithInstructions(memoryLines));
    }

}
