package com.practice.day9;

import com.practice.day8.Day8_Challenge;
import com.practice.day8.Day8_InputReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8ChallengeTest {

    @Test
    public void getNumberOfAntiNodes() {
        Day8_InputReader day8InputReader = new Day8_InputReader("day9testcase.txt");
        Day8_Challenge day8_challenge = new Day8_Challenge();
        int day_8_1_output = day8_challenge.getNumberOfAntiNodes(day8InputReader.getMap());
        assertEquals(14, day_8_1_output);
    }

}
