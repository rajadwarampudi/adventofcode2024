package com.practice.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6ChallengeTest {

    @Test
    public void testGetNumberOfNewObstructionsToMakeInfiniteLoops() {
        Day6_InputReader day6InputReader = new Day6_InputReader("day6testcase.txt");
        Day6_2_Challenge day6_2_challenge = new Day6_2_Challenge();
        int day_6_2_output = day6_2_challenge.getNumberOfNewObstructionsToMakeInfiniteLoops(day6InputReader.getMap(),
                day6InputReader.getStartIndex());
        assertEquals(6, day_6_2_output);
    }

}
