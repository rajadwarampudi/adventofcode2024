package com.practice.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8ChallengeTest {

    @Test
    public void getNumberOfAntiNodes() {
        Day8_InputReader day8InputReader = new Day8_InputReader("day8testcase.txt");
        Day8_Challenge day8_challenge = new Day8_Challenge();
        int day_8_1_output = day8_challenge.getNumberOfAntiNodes(day8InputReader.getMap());
        assertEquals(14, day_8_1_output);
    }

    @Test
    public void getNumberOfAntiNodesIncludingAntiNodesAsAntennas() {
        Day8_InputReader day8InputReader = new Day8_InputReader("day8testcase.txt");
        Day8_Challenge day8_challenge = new Day8_Challenge();
        int day_8_1_output = day8_challenge.getNumberOfAntiNodesIncludingAntiNodesAsAntennas(day8InputReader.getMap());
        assertEquals(144, day_8_1_output);
    }

    @Test
    public void getNumberOfAntiNodesIncludingAntiNodesAsAntennasBasicScenarios() {
        Day8_InputReader day8InputReader = new Day8_InputReader("day8_2_1_testcase.txt");
        Day8_Challenge day8_challenge = new Day8_Challenge();
        int day_8_1_output = day8_challenge.getNumberOfAntiNodesIncludingAntiNodesAsAntennas(day8InputReader.getMap());
        assertEquals(6, day_8_1_output);
    }

}
