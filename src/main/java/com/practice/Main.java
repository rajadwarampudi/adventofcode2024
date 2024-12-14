package com.practice;

import com.practice.day1.Day1_Challenge;
import com.practice.day1.Day1_InputReader;
import com.practice.day10.Day10_Challenge;
import com.practice.day10.Day10_InputReader;
import com.practice.day11.Day11_Challenge;
import com.practice.day11.Day11_InputReader;
import com.practice.day13.Day13_Challenge;
import com.practice.day13.Day13_InputReader;
import com.practice.day2.Day2_Challenge;
import com.practice.day2.Day2_InputReader;
import com.practice.day3.Day3_Challenge;
import com.practice.day3.Day3_InputReader;
import com.practice.day4.Day4_Challenge;
import com.practice.day4.Day4_InputReader;
import com.practice.day5.Day5_Challenge;
import com.practice.day5.Day5_InputReader;
import com.practice.day6.Day6_2_Challenge;
import com.practice.day6.Day6_Challenge;
import com.practice.day6.Day6_InputReader;
import com.practice.day7.Day7_Challenge;
import com.practice.day7.Day7_InputReader;
import com.practice.day8.Day8_Challenge;
import com.practice.day8.Day8_InputReader;
import com.practice.day9.Day9_Challenge;
import com.practice.day9.Day9_InputReader;

public class Main {
    public static void main(String[] args) {

        // day 13
        executeDay13Challenge();

        // day 11
        //executeDay11Challenge();

        //day10
        //executeDay10Challenge();

        //day9
        //executeDay9Challenge();

        //day8
        //executeDay8Challenge();

        //day7
        //executeDay7Challenge();

        //day6
        //executeDay6Challenge();

        //day5
        //executeDay5Challenge();

        //day4
        //executeDay4Challenge();

        //day3
        //executeDay3Challenge();

        //day2
        //executeDay2Challenge();

        //day1
        //executeDay1Challenge();
    }

    private static void executeDay13Challenge() {
        try {
            Day13_InputReader day13InputReader = new Day13_InputReader("day13Input.txt");
            Day13_Challenge day13Challenge = new Day13_Challenge();

            long day_13_1_output = day13Challenge.countFewestTokensForAllPossiblePrizes(day13InputReader.getMachineInfoList(), 0L);
            long day_13_2_output = day13Challenge.countFewestTokensForAllPossiblePrizes(day13InputReader.getMachineInfoList(), 10000000000000L);
            System.out.println("Output of day13:");
            System.out.println("day13_1 output: " + day_13_1_output);
            System.out.println("day13_2 output: " + day_13_2_output);
            System.out.println("Output of day13 completed:");

        } catch (Exception ex) {
            System.out.println("Exception occurred for day 13 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay11Challenge() {
        try {
            Day11_InputReader day11InputReader = new Day11_InputReader("day11Input.txt");
            Day11_Challenge day10Challenge = new Day11_Challenge();

            //int day_11_1_output = day10Challenge.getNumberOfStonesAfterGivenBlinks(day11InputReader.getStoneList(), 25);
            long day_11_2_output = day10Challenge.getNumberOfStonesAfterGivenBlinks(day11InputReader.getStoneList(), 75);

            System.out.println("Output of day11:");
            //System.out.println("day11_1 output: " + day_11_1_output);
            System.out.println("day11_1 output: " + day_11_2_output);
            System.out.println("Output of day11 completed:");

        } catch (Exception ex) {
            System.out.println("Exception occurred for day 11 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay10Challenge() {
        try {
            Day10_InputReader day10InputReader = new Day10_InputReader("day10Input.txt");
            Day10_Challenge day10Challenge = new Day10_Challenge();

            int day_10_1_output = day10Challenge.getTotalTrailheadScoreWithUniqueDestinations(day10InputReader.getTopographicMap());

            System.out.println("Output of day10:");
            System.out.println("day10_1 output: " + day_10_1_output);
            System.out.println("Output of day10 completed:");

        } catch (Exception ex) {
            System.out.println("Exception occurred for day 10 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay9Challenge() {
        try {
            Day9_InputReader day9InputReader = new Day9_InputReader("day9Input.txt");
            Day9_Challenge day9Challenge = new Day9_Challenge();

            long day_9_1_output = day9Challenge.getFileSystemChecksum(day9InputReader.getInputLine());
            long day_9_2_output = day9Challenge.getFileSystemChecksumWithSameIdFileMovementAtOnce(day9InputReader.getInputLine());

            System.out.println("Output of day9:");
            System.out.println("day9_1 output: " + day_9_1_output);
            System.out.println("day9_2 output: " + day_9_2_output);
            System.out.println("Output of day9 completed:");

        } catch (Exception ex) {
            System.out.println("Exception occurred for day 9 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay8Challenge() {
        try {
            Day8_InputReader day8InputReader = new Day8_InputReader("day8Input.txt");
            Day8_Challenge day8Challenge = new Day8_Challenge();

            int day_8_1_output = day8Challenge.getNumberOfAntiNodes(day8InputReader.getMap());

            System.out.println("Output of day8:");
            System.out.println("day8_1 output: " + day_8_1_output);
            System.out.println("Output of day8 completed:");

        } catch (Exception ex) {
            System.out.println("Exception occurred for day 8 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay7Challenge() {
        try {
            Day7_InputReader day7InputReader = new Day7_InputReader("day7Input.txt");
            Day7_Challenge day7Challenge = new Day7_Challenge();

            long day_7_1_output = day7Challenge.getTotalCalibrationResult(day7InputReader.getInputList());
            long day_7_2_output = day7Challenge.getTotalCalibrationResultIncludingConcatenationOperator(day7InputReader.getInputList());

            System.out.println("Output of day7:");
            System.out.println("day7_1 output: " + day_7_1_output);
            System.out.println("day7_2 output: " + day_7_2_output);
            System.out.println("Output of day7 completed:");

        } catch (Exception ex) {
            System.out.println("Exception occurred for day 7 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay6Challenge() {
        try {
            Day6_InputReader day6InputReader = new Day6_InputReader("day6Input.txt");
            Day6_Challenge day6Challenge = new Day6_Challenge();
            Day6_2_Challenge day6_2_challenge = new Day6_2_Challenge();

            int day_6_1_output = day6Challenge.getNumberOfDistinctPositionsVisited(day6InputReader.getMap(),
                    day6InputReader.getStartIndex());

            int day_6_2_output = day6_2_challenge.getNumberOfNewObstructionsToMakeInfiniteLoops(day6InputReader.getMap(),
                    day6InputReader.getStartIndex());

            System.out.println("Output of day6:");
            System.out.println("day6_1 output: " + day_6_1_output);
            System.out.println("day6_2 output: " + day_6_2_output);
            System.out.println("Output of day6 completed:");
        } catch (Exception ex) {
            System.out.println("Exception occurred for day 6 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay5Challenge() {
        try {
            Day5_InputReader day5InputReader = new Day5_InputReader("day5Input.txt");
            Day5_Challenge day5Challenge = new Day5_Challenge();

            int day_5_1_output = day5Challenge.getSumOfMiddlePageNumbersFromValidPageUpdates(
                    day5InputReader.getPageOrderRules(), day5InputReader.getPageUpdates());

            int day_5_2_output = day5Challenge.getSumOfMiddlePageNumbersFromInvalidPageUpdatesAfterFixing(
                    day5InputReader.getPageOrderRules(), day5InputReader.getPageUpdates());

            System.out.println("Output of day5:");
            System.out.println("day5_1 output: " + day_5_1_output);
            System.out.println("day5_2 output: " + day_5_2_output);
            System.out.println("Output of day5 completed:");

        } catch (Exception ex) {
            System.out.println("Exception occurred for day 5 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay4Challenge() {
        try {
            Day4_InputReader day4InputReader = new Day4_InputReader("day4Input.txt");
            Day4_Challenge day4Challenge = new Day4_Challenge();

            int day_4_1_output = day4Challenge.getNumberOfXMASWords(day4InputReader.getInputList());
            int day_4_2_output = day4Challenge.getNumberOfXMASShapes(day4InputReader.getInputList());

            System.out.println("Output of day4:");
            System.out.println("day4_1 output: " + day_4_1_output);
            System.out.println("day4_2 output: " + day_4_2_output);
            System.out.println("Output of day4 completed:");
        } catch (Exception ex) {
            System.out.println("Exception occurred for day 4 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay3Challenge() {
        try {
            Day3_InputReader day3InputReader = new Day3_InputReader("day3Input.txt");
            Day3_Challenge day3Challenge = new Day3_Challenge();

            int day_3_1_output = day3Challenge.getSumOfMultiplicationsFromCorruptedMemory(
                    day3InputReader.getLineList());

            int day_3_2_output = day3Challenge.getSumOfMultiplicationsFromCorruptedMemoryWithInstructions(
                    day3InputReader.getLineList());

            System.out.println("Output of day3:");
            System.out.println("day3_1 output: " + day_3_1_output);
            System.out.println("day3_2 output: " + day_3_2_output);
            System.out.println("Output of day3 completed:");

        } catch (Exception ex) {
            System.out.println("Exception occurred for day 3 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay2Challenge() {
        try {
            Day2_InputReader day2InputReader = new Day2_InputReader("day2Input.txt");
            Day2_Challenge day2Challenge = new Day2_Challenge();

            int day_2_1_output = day2Challenge.getNumberOfSafeReports(day2InputReader.getReportList());
            int day_2_2_output = day2Challenge.getNumberOfSafeReportsWithProblemDampener(
                    day2InputReader.getReportList());

            System.out.println("Output of day2:");
            System.out.println("day2_1 output: " + day_2_1_output);
            System.out.println("day2_2 output: " + day_2_2_output);
            System.out.println("Output of day2 completed:");
        } catch (Exception ex) {
            System.out.println("Exception occurred for day 2 challenge: " + ex.getMessage());
        }
    }

    private static void executeDay1Challenge() {
        try {
            Day1_InputReader day1InputReader = new Day1_InputReader("day1Input.txt");
            Day1_Challenge day1Challenge = new Day1_Challenge();

            long day1_1Output = day1Challenge.getTotalDistanceBetweenLists(day1InputReader.getFirstList(),
                    day1InputReader.getSecondList());

            long day1_2Output = day1Challenge.getSimilarityScore(day1InputReader.getFirstList(),
                    day1InputReader.getSecondList());

            System.out.println("Output of day1:");
            System.out.println("day1_1 output: " + day1_1Output);
            System.out.println("day1_2 output: " + day1_2Output);
            System.out.println("Output of day1 completed:");
        } catch (Exception ex) {
            System.out.println("Exception occurred for day 1 challenge: " + ex.getMessage());
        }
    }
}