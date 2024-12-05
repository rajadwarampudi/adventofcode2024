package com.practice.day5;

import com.practice.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day5_InputReader {

    private final List<List<Integer>> pageUpdates;
    private final List<int[]> pageOrderRules;
    public Day5_InputReader(String fileName) {
        pageUpdates = new ArrayList<>();
        pageOrderRules = new ArrayList<>();
        Stream<String> lineStreams = InputReader.getLineStreams(fileName);
        List<String> lines = lineStreams.toList();
         int i = 0;
         while (!lines.get(i).isEmpty()) {
             String[] numberRules = lines.get(i).split("\\|");
             int firstPage = Integer.parseInt(numberRules[0]);
             int secondPage = Integer.parseInt(numberRules[1]);
             pageOrderRules.add(new int[]{firstPage, secondPage});
             i++;
        }
         i++;
         while (i < lines.size()) {
             List<Integer> pageUpdate = Arrays.stream(lines.get(i).split(",")).map(Integer::parseInt).toList();
             pageUpdates.add(pageUpdate);
             i++;
         }
    }

    public List<int[]> getPageOrderRules() {
        return pageOrderRules;
    }

    public List<List<Integer>> getPageUpdates() {
        return pageUpdates;
    }
}
