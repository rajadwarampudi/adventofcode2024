package com.practice.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14ChallengeTest {

    @Test
    public void testCalculateSafetyFactor() {
        Day14_InputReader day14InputReader = new Day14_InputReader("day14testcase.txt");
        Day14_Challenge day14_challenge = new Day14_Challenge();
        int day_14_1_output = day14_challenge.calculateSafetyFactor(day14InputReader.getRobotInfoList(), 7, 11);
        assertEquals(12, day_14_1_output);
    }

}
