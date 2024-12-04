package com.practice.day4;

import com.practice.InputReader;

import java.util.List;
import java.util.stream.Stream;

public class Day4_InputReader {
    private final List<String> inputList;
    public Day4_InputReader(String fileName) {
        // The assumption is that the length of all lines are same
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        inputList = lineStreams.toList();
    }

    public List<String> getInputList() {
        return inputList;
    }
}
