package com.practice.day11;

import com.practice.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day11_InputReader {
    private final List<String> stoneList;

    public Day11_InputReader(String fileName) {
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        List<String> lineList = lineStreams.toList();
        stoneList = Arrays.stream(lineList.getFirst().split(" ")).toList();
    }

    public List<String> getStoneList() {
        return stoneList;
    }

}
