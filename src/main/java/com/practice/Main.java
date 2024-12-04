package com.practice;

import com.practice.day1.Day1_Challenge;
import com.practice.day1.Day1_InputReader;
import com.practice.day2.Day2_Challenge;
import com.practice.day2.Day2_InputReader;
import com.practice.day3.Day3_Challenge;
import com.practice.day3.Day3_InputReader;
import com.practice.day4.Day4_Challenge;
import com.practice.day4.Day4_InputReader;

public class Main {
    public static void main(String[] args) {

        //day4
        executeDay4Challenge();

        //day3
        executeDay3Challenge();

        //day2
        executeDay2Challenge();

        //day1
        executeDay1Challenge();
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