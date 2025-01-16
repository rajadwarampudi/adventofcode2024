package com.practice.day11;

import java.util.*;

public class Day11_Challenge {

    /**
     * This method calculates the number of evolved stones after given number of blinks
     * the evolution happens as below
     * The strange part is that every time you blink, the stones change.
     *
     * Sometimes, the number engraved on a stone changes. Other times, a stone might split in two, causing
     * all the other stones to shift over a bit to make room in their perfectly straight line.
     *
     * As you observe them for a while, you find that the stones have a consistent behavior.
     * Every time you blink, the stones each simultaneously change according to the first applicable rule in this list:
     *
     * If the stone is engraved with the number 0, it is replaced by a stone engraved with the number 1.
     * If the stone is engraved with a number that has an even number of digits, it is replaced by two stones.
     * The left half of the digits are engraved on the new left stone,
     * and the right half of the digits are engraved on the new right stone.
     * (The new numbers don't keep extra leading zeroes: 1000 would become stones 10 and 0.)
     * If none of the other rules apply, the stone is replaced by a new stone;
     * the old stone's number multiplied by 2024 is engraved on the new stone.
     * No matter how the stones change, their order is preserved, and they stay on their perfectly straight line.
     * @param stoneList
     * @param numberOfBlinks
     * @return number of evolved stones
     */
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
