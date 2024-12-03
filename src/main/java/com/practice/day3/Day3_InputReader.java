package com.practice.day3;

import com.practice.InputReader;

import java.util.List;
import java.util.stream.Stream;

public class Day3_InputReader {
    private final List<String> lineList;
    public Day3_InputReader(String fileName) {
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        lineList = lineStreams.toList();
    }

    public List<String> getLineList() {
        return lineList;
    }
}
