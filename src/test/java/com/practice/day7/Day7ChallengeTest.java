package com.practice.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7ChallengeTest {

    @Test
    public void testGetNumberOfNewObstructionsToMakeInfiniteLoops() {
        Day7_InputReader day7InputReader = new Day7_InputReader("day7testcase.txt");
        Day7_Challenge day7_challenge = new Day7_Challenge();
        long day_7_1_output = day7_challenge.getTotalCalibrationResult(day7InputReader.getInputList());
        assertEquals(3749L, day_7_1_output);

        long day_7_2_output = day7_challenge.getTotalCalibrationResultIncludingConcatenationOperator(day7InputReader.getInputList());
        assertEquals(11387L, day_7_2_output);
    }

}
