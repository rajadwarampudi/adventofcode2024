package com.practice.day14;

import com.practice.Index;

import java.util.Arrays;
import java.util.List;

public class Day14_Challenge {

    public static final int SECONDS = 100;

    private enum Quarter { Q1, Q2, Q3, Q4, IGNORED}

    public int calculateSafetyFactor(List<RobotInfo> robotInfoList, int rows, int columns) {
        int q1Total = 0, q2Total = 0, q3Total = 0, q4Total = 0;
        for (RobotInfo robotInfo : robotInfoList) {
            Index newPosition =  newRobotPositionAfterGivenTime(robotInfo, rows, columns, SECONDS);
            Quarter quarter = getQuarter(newPosition, rows, columns);
            switch (quarter) {
                case Quarter.Q1 -> q1Total++;
                case Quarter.Q2 -> q2Total++;
                case Quarter.Q3 -> q3Total++;
                case Quarter.Q4 -> q4Total++;
                case IGNORED -> System.out.println("robot at: " + robotInfo.position().x() + ", " + robotInfo.position().y() +
                        "moved to: " + newPosition.x() + ", " + newPosition.y() + " ignored.");
            }
        }
        return q1Total * q2Total * q3Total * q4Total;
    }

    public void printRobotPositionsForEverySecond(List<RobotInfo> robotInfoList, int rows, int columns, int seconds) {
        List<RobotInfo> robotInfoCopyList = new java.util.ArrayList<>(robotInfoList);
        char[][] bathroom = new char[columns][rows];
        for (char[] row : bathroom) {
            Arrays.fill(row, '.');
        }
        System.out.println("##################################### second: " + 0 + " ##################################");
        for (RobotInfo info : robotInfoCopyList) {
            bathroom[info.position().x()][info.position().y()] = '#';
        }
        printRobotPositionsInBathroom(bathroom, rows, columns, 0);
        for (int i = 1; i <= seconds; i++) {
            for (int n = 0; n < robotInfoCopyList.size(); n++) {
                RobotInfo robotInfo = robotInfoCopyList.get(n);
                Index newPosition =  newRobotPositionAfterGivenTime(robotInfo, rows, columns, 1);
                RobotInfo updatedRobotInfo = new RobotInfo(new Index(newPosition.x(), newPosition.y()), robotInfo.columnChange(), robotInfo.rowChange());
                robotInfoCopyList.set(n, updatedRobotInfo);
                bathroom[newPosition.x()][newPosition.y()] = '#';
            }
            printRobotPositionsInBathroom(bathroom, rows, columns, i);
            for (char[] row : bathroom) {
                Arrays.fill(row, '.');
            }

        }
    }

    private static void sleepSomeTime() {
        try {
            Thread.sleep(1000); // Delay in milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printRobotPositionsInBathroom(char[][] bathroom, int rows, int columns, int currentSecond) {
        boolean isPossibleEasterEgg = false;
        for (int i = 0; i < rows; i++) {
            int borderFenceCount = 0;
            for (int j = 0; j < columns; j++) {
                if (bathroom[j][i] == '#') {
                    borderFenceCount++;
                }
            }
            if (borderFenceCount >= 30) {
                isPossibleEasterEgg = true;
            }
        }
        if (isPossibleEasterEgg) {
            System.out.println("##################################### second: " + currentSecond + " ##################################");
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    if (bathroom[i][j] == '#') {
                        System.out.print("\033[32m");
                    }
                    System.out.print(bathroom[i][j]);
                    System.out.print("\033[0m");
                }
                System.out.println();
            }
            sleepSomeTime();
        }

    }

    private Index newRobotPositionAfterGivenTime(RobotInfo robotInfo, int rows, int columns, int seconds) {
        int currentXCoordinate = robotInfo.position().x();
        int currentYCoordinate = robotInfo.position().y();

        int newXCoordinate = getNewCoordinate(currentXCoordinate, robotInfo.columnChange(), columns, seconds);
        int newYCoordinate = getNewCoordinate(currentYCoordinate, robotInfo.rowChange(), rows, seconds);
        return new Index(newXCoordinate, newYCoordinate);
    }

    private int getNewCoordinate(int currentCoordinate, int velocity, int upperLimit, int seconds) {
        for (int i = 0; i < seconds; i++) {
            currentCoordinate = currentCoordinate + velocity;
            if (currentCoordinate < 0) {
                currentCoordinate = upperLimit + currentCoordinate;
            } else if (currentCoordinate >= upperLimit) {
                currentCoordinate -= upperLimit;
            }
        }

        return currentCoordinate;
    }

    /**
     * This works with an assumption that rows and columns are odd numbered
     * @param position
     * @param rows
     * @param columns
     * @return
     */
    private Quarter getQuarter(Index position, int rows, int columns) {
        int midColumn = columns / 2;
        int midRow = rows / 2;
        if (position.x() < midColumn && position.y() < midRow) {
            return Quarter.Q1;
        } else if (position.x() < midColumn && position.y() > midRow) {
            return Quarter.Q3;
        } else if (position.x() > midColumn && position.y() < midRow) {
            return Quarter.Q2;
        } else if (position.x() > midColumn && position.y() > midRow) {
            return Quarter.Q4;
        } else {
            return Quarter.IGNORED;
        }
    }
}
