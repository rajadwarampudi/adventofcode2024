package com.practice.day13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13ChallengeTest {

    @Test
    public void testGetNumberOfTokensWithNoConversionError() {
        Day13_InputReader day13InputReader = new Day13_InputReader("day13testcase.txt");
        Day13_Challenge day13_challenge = new Day13_Challenge();
        long day_13_1_output = day13_challenge.countFewestTokensForAllPossiblePrizes(day13InputReader.getMachineInfoList(), 0L);
        assertEquals(480L, day_13_1_output);
    }

    @Test
    public void testGetNumberOfTokensWithConversionError() {
        Day13_InputReader day13InputReader = new Day13_InputReader("day13testcase.txt");
        Day13_Challenge day13_challenge = new Day13_Challenge();
        long day_13_2_output = day13_challenge.countFewestTokensForAllPossiblePrizes(day13InputReader.getMachineInfoList(), 10000000000000L);
        assertEquals(875318608908L, day_13_2_output);
    }

}
