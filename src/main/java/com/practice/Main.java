package com.practice;

import com.practice.day1.Day1_Challenge;
import com.practice.day1.Day1_InputReader;

public class Main {
    public static void main(String[] args) {
        executeDay1Challenge();
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