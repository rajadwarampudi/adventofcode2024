package com.practice.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10ChallengeTest {

    @Test
    public void testGetNumberOfTrailheadsGivenExample1() {
        Day10_InputReader day10InputReader = new Day10_InputReader("day10testcase_basic.txt");
        Day10_Challenge day10_challenge = new Day10_Challenge();
        int day_10_1_output = day10_challenge.getTotalTrailheadScoreWithUniqueDestinations(day10InputReader.getTopographicMap());
        assertEquals(2, day_10_1_output);
    }

    @Test
    public void testGetNumberOfTrailheadsGivenExample2() {
        Day10_InputReader day10InputReader = new Day10_InputReader("day10testcase_basic2.txt");
        Day10_Challenge day10_challenge = new Day10_Challenge();
        int day_10_1_output = day10_challenge.getTotalTrailheadScoreWithUniqueDestinations(day10InputReader.getTopographicMap());
        assertEquals(4, day_10_1_output);
    }

    @Test
    public void testGetNumberOfTrailheadsWithUniqueTrailPathsGivenExample2() {
        Day10_InputReader day10InputReader = new Day10_InputReader("day10testcase_basic2.txt");
        Day10_Challenge day10_challenge = new Day10_Challenge();
        int day_10_1_output = day10_challenge.getTotalTrailheadScoreWithUniqueTrailPaths(day10InputReader.getTopographicMap());
        assertEquals(13, day_10_1_output);
    }
}
