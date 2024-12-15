package com.practice.day14;

import com.practice.Index;
import com.practice.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day14_InputReader {
    public List<RobotInfo> getRobotInfoList() {
        return robotInfoList;
    }

    private final List<RobotInfo> robotInfoList;

    public Day14_InputReader(String fileName) {
        List<String> lineList = InputReader.getLineStreams(fileName).toList();
        robotInfoList = new ArrayList<>();
        for (String line : lineList) {
            Optional<RobotInfo> robotInfo = getRobotInfo(line);
            robotInfo.ifPresentOrElse(robotInfoList::add, () -> System.out.println("entry not found at line: " + line));
        }
    }

    private Optional<RobotInfo> getRobotInfo(String line) {
        String regex = "p=(\\d+),(\\d+) v=(-?\\d+),(-?\\d+)";
        Matcher matcher = Pattern.compile(regex).matcher(line);

        if (matcher.find()) {
            int xCoordinate = Integer.parseInt(matcher.group(1));
            int yCoordinate = Integer.parseInt(matcher.group(2));
            int columnChange = Integer.parseInt(matcher.group(3));
            int rowChange = Integer.parseInt(matcher.group(4));
            return Optional.of(new RobotInfo(new Index(xCoordinate, yCoordinate), columnChange, rowChange));
        }
        return Optional.empty();

    }

}
