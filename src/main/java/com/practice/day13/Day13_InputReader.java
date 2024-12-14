package com.practice.day13;

import com.practice.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day13_InputReader {
    private final List<MachineInfo> machineInfoList;

    public Day13_InputReader(String fileName) {
        List<String> lineList = InputReader.getLineStreams(fileName).toList();
        machineInfoList = new ArrayList<>();
        int previousMachineInfoIndex = -2;
        for (int i = 0; i < lineList.size(); i++) {
            if (i - previousMachineInfoIndex == 4) {
                Optional<Position> buttonAChange = getButtonChange(lineList.get(i - 2), "A");
                Optional<Position> buttonBChange = getButtonChange(lineList.get(i - 1), "B");
                Optional<Position> prizePosition = getPrizePosition(lineList.get(i));
                if (buttonAChange.isPresent() && buttonBChange.isPresent() && prizePosition.isPresent()) {
                    machineInfoList.add(new MachineInfo(buttonAChange.get().xChange(), buttonAChange.get().yChange(),
                            buttonBChange.get().xChange(), buttonBChange.get().yChange(),
                            prizePosition.get().xChange(), prizePosition.get().yChange()));
                }
                previousMachineInfoIndex = i;
            }
        }

    }

    private Optional<Position> getPrizePosition(String line) {
        String regex = "Prize: X=(\\d+), Y=(\\d+)";
        Matcher matcher = Pattern.compile(regex).matcher(line);

        if (matcher.find()) {
            int xChange = Integer.parseInt(matcher.group(1));
            int yChange = Integer.parseInt(matcher.group(2));
            return Optional.of(new Position(xChange, yChange));
        }
        return Optional.empty();
    }

    private Optional<Position> getButtonChange(String line, String button) {
        String regex = "Button " + button + ": " + "X\\+(\\d+), Y\\+(\\d+)";
        Matcher matcher = Pattern.compile(regex).matcher(line);

        if (matcher.find()) {
            int xChange = Integer.parseInt(matcher.group(1));
            int yChange = Integer.parseInt(matcher.group(2));
            return Optional.of(new Position(xChange, yChange));
        }
        return Optional.empty();
    }

    public List<MachineInfo> getMachineInfoList() {
        return machineInfoList;
    }

}
