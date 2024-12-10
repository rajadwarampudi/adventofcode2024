package com.practice.day9;

import com.practice.InputReader;

import java.util.List;
import java.util.stream.Stream;

public class Day9_InputReader {
    private final String inputLine;

    public Day9_InputReader(String fileName) {
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        List<String> lineList = lineStreams.toList();
        inputLine = lineList.getFirst();
    }

    public String getInputLine() {
        return inputLine;
    }

}
