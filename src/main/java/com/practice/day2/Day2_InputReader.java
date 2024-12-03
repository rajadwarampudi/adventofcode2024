package com.practice.day2;

import com.practice.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2_InputReader {
    private final List<List<Integer>> reportList;

    public Day2_InputReader(String fileName) {
        reportList = new ArrayList<>();
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        lineStreams.forEach(line -> {
            String[] numbers = line.split(" ");
            addReportToTheReportList(numbers);
        });
    }

    private void addReportToTheReportList(String[] numbers) {
        reportList.add(Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public List<List<Integer>> getReportList() {
        return reportList;
    }
}
