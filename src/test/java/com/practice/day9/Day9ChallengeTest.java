package com.practice.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9ChallengeTest {

    @Test
    public void testGetFileSystemChecksum() {
        Day9_InputReader day9InputReader = new Day9_InputReader("day9testcase.txt");
        Day9_Challenge day9_challenge = new Day9_Challenge();
        long day_9_1_output = day9_challenge.getFileSystemChecksum(day9InputReader.getInputLine());
        assertEquals(60L, day_9_1_output);
    }

    @Test
    public void testGetFileSystemChecksumWithSlightlyLongerText() {
        Day9_InputReader day9InputReader = new Day9_InputReader("day9testcase_2.txt");
        Day9_Challenge day9_challenge = new Day9_Challenge();
        long day_9_1_output = day9_challenge.getFileSystemChecksum(day9InputReader.getInputLine());
        assertEquals(1928L, day_9_1_output);
    }

    @Test
    public void testGetFileSystemChecksumWithSameIDFileMovementWithSlightlyLongerText() {
        Day9_InputReader day9InputReader = new Day9_InputReader("day9testcase_2.txt");
        Day9_Challenge day9_challenge = new Day9_Challenge();
        long day_9_2_output = day9_challenge.getFileSystemChecksumWithSameIdFileMovementAtOnce(day9InputReader.getInputLine());
        assertEquals(2858L, day_9_2_output);
    }

}
