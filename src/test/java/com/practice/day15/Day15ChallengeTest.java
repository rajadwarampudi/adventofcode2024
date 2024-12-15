package com.practice.day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day15ChallengeTest {

    @Test
    public void testGetGPSCoordinatesSum() {
        Day15_InputReader day15InputReader = new Day15_InputReader("day15testcase.txt");
        Day15_Challenge day15_challenge = new Day15_Challenge();
        int day_15_1_output = day15_challenge.getGPSCoordinatesSum(day15InputReader.getWarehouseMap(), day15InputReader.getStartingPosition(), day15InputReader.getMoves());
        assertEquals(2028, day_15_1_output);
    }

    @Test
    public void testGetGPSCoordinatesSumWithSlightlyLargerData() {
        Day15_InputReader day15InputReader = new Day15_InputReader("day15testcase_2.txt");
        Day15_Challenge day15_challenge = new Day15_Challenge();
        int day_15_1_output = day15_challenge.getGPSCoordinatesSum(day15InputReader.getWarehouseMap(), day15InputReader.getStartingPosition(), day15InputReader.getMoves());
        assertEquals(10092, day_15_1_output);
    }

}
