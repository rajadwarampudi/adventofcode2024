package com.practice.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11ChallengeTest {

    @Test
    public void testGetNumberOfStonesAfterGivenBlinksBasic() {
        Day11_InputReader day11InputReader = new Day11_InputReader("day11testcase.txt");
        Day11_Challenge day11_challenge = new Day11_Challenge();
        long day_11_1_output = day11_challenge.getNumberOfStonesAfterGivenBlinks(List.of("0", "1"), 3);
        assertEquals(55312L, day_11_1_output);
    }

    @Test
    public void testGetNumberOfStonesAfterGivenBlinks() {
        Day11_InputReader day11InputReader = new Day11_InputReader("day11testcase.txt");
        Day11_Challenge day11_challenge = new Day11_Challenge();
        long day_11_1_output = day11_challenge.getNumberOfStonesAfterGivenBlinks(day11InputReader.getStoneList(), 25);
        assertEquals(55312L, day_11_1_output);
    }

    @Test
    public void testGetNumberOfStonesAfterALotOfBlinks() {
        Day11_InputReader day11InputReader = new Day11_InputReader("day11testcase.txt");
        Day11_Challenge day11_challenge = new Day11_Challenge();
        long day_11_1_output = day11_challenge.getNumberOfStonesAfterGivenBlinks(day11InputReader.getStoneList(), 75);
        assertEquals(55312L, day_11_1_output);
    }


}
