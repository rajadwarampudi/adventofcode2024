package com.practice.day11;

import java.util.*;

public class Day11_Challenge {

    public long getNumberOfStonesAfterGivenBlinks(List<String> stoneList, int numberOfBlinks) {
        long numberOfEvolvedStones = 0L;

        List<Long> inputStoneList = new ArrayList<>(stoneList.stream().map(Long::parseLong).toList());
        Map<StoneBlinkInfo, List<Long>> stoneEvolutionMap = new HashMap<>();
        stoneEvolutionMap.put(new StoneBlinkInfo(0L, 1), List.of(1L));

        for (long stone : inputStoneList) {
            System.out.println("current number: " + stone);
            numberOfEvolvedStones += evolveStoneAfterGivenBlinks(stone, stoneEvolutionMap, numberOfBlinks).size();
        }

        return numberOfEvolvedStones;
    }

    private List<Long> evolveStoneAfterGivenBlinks(long currentStoneNum, Map<StoneBlinkInfo, List<Long>> stoneEvolutionMap, int numberOfBlinksLeft) {
        int previousClosestBlinkOnStone  = numberOfBlinksLeft;
        while (previousClosestBlinkOnStone != 0 && !stoneEvolutionMap.containsKey(new StoneBlinkInfo(currentStoneNum, previousClosestBlinkOnStone))) {
            previousClosestBlinkOnStone--;
        }
        if (stoneEvolutionMap.containsKey(new StoneBlinkInfo(currentStoneNum, previousClosestBlinkOnStone))) {
            List<Long> evolvedStonesAfterPreviousBlink = stoneEvolutionMap.get(new StoneBlinkInfo(currentStoneNum, previousClosestBlinkOnStone));
            if (previousClosestBlinkOnStone == numberOfBlinksLeft) {
                return evolvedStonesAfterPreviousBlink;
            } else {
                List<Long> evolvedStonesAfterAllBlinks = new ArrayList<>();
                for (Long evolvedStone : evolvedStonesAfterPreviousBlink) {
                    evolvedStonesAfterAllBlinks.addAll(
                            evolveStoneAfterGivenBlinks(evolvedStone, stoneEvolutionMap,
                                    numberOfBlinksLeft - previousClosestBlinkOnStone));
                }
                stoneEvolutionMap.put(new StoneBlinkInfo(currentStoneNum, numberOfBlinksLeft), evolvedStonesAfterAllBlinks);
                return evolvedStonesAfterAllBlinks;
            }

        } else {
            List<Long> evolvedListForGivenStoneAfterOneBlink = getEvolvedListForGivenStoneAfterOneBlink(currentStoneNum);
            for (Long evolvedStone : evolvedListForGivenStoneAfterOneBlink) {
                stoneEvolutionMap.put(new StoneBlinkInfo(currentStoneNum, numberOfBlinksLeft),
                        evolveStoneAfterGivenBlinks(evolvedStone, stoneEvolutionMap, numberOfBlinksLeft - 1));
            }
            return evolveStoneAfterGivenBlinks(currentStoneNum, stoneEvolutionMap, numberOfBlinksLeft);
        }
    }

    private static List<Long> getEvolvedListForGivenStoneAfterOneBlink(long currentStoneNum) {
        List<Long> evolvedListForGivenStoneAfterOneBlink = new ArrayList<>();
        int stoneNumberLength = (int) Math.log10(Math.abs(currentStoneNum)) + 1;
        if (stoneNumberLength % 2 == 0) {
            long divisor = (long) Math.pow(10, (double) stoneNumberLength / 2);
            long secondHalf = currentStoneNum % divisor;
            long firstHalf = currentStoneNum / divisor;

            evolvedListForGivenStoneAfterOneBlink.add(firstHalf);
            evolvedListForGivenStoneAfterOneBlink.add(secondHalf);

        } else {
            long newStoneNumber = currentStoneNum * 2024;
            evolvedListForGivenStoneAfterOneBlink.add(newStoneNumber);
        }
        return evolvedListForGivenStoneAfterOneBlink;
    }
}
