package com.practice.day1;

import com.practice.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day1_InputReader {

    private final List<Long> firstList;
    private final List<Long> secondList;

    public Day1_InputReader(String fileName) {
        firstList = new ArrayList<>();
        secondList = new ArrayList<>();
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        lineStreams.forEach(line -> {
            String[] numbers = line.split(" {3}");
            if(numbers.length != 2) {
                throw new IllegalArgumentException("The input format is wrong at: " + line);
            }
            firstList.add(Long.parseLong(numbers[0]));
            long secondNumber = Long.parseLong(numbers[1]);
            secondList.add(secondNumber);
        });
    }

    public List<Long> getFirstList() {
        return firstList;
    }

    public List<Long> getSecondList() {
        return secondList;
    }
}
