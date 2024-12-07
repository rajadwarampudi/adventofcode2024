package com.practice.day7;

import com.practice.InputReader;

import java.util.*;
import java.util.stream.Stream;

public class Day7_InputReader {
    public List<String> getInputList() {
        return inputList;
    }

    private final List<String> inputList;
    public Day7_InputReader(String fileName) {
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        inputList = lineStreams.toList();
    }

}
