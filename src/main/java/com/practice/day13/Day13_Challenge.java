package com.practice.day13;

import java.util.List;

public class Day13_Challenge {

    public long countFewestTokensForAllPossiblePrizes(List<MachineInfo> machineInfoList, long unitConversionError) {
        long tokenCount = 0;

        for (MachineInfo machineInfo : machineInfoList) {
            tokenCount += countMinimumTokensRequired(machineInfo, unitConversionError);
        }

        return tokenCount;
    }

    private long countMinimumTokensRequired(MachineInfo machineInfo, long unitConversionError) {
        long minimumTokensRequired = 0;

        long axChange = machineInfo.axValue();
        long ayChange = machineInfo.ayValue();

        long bxChange = machineInfo.bxValue();
        long byChange = machineInfo.byValue();

        long prizeXPosition = unitConversionError + machineInfo.prizeXPosition();
        long prizeYPosition = unitConversionError + machineInfo.prizeYPosition();

        long lcm =  (axChange * ayChange) / gcd(axChange, ayChange);

        long numerator = (((lcm / axChange) * prizeXPosition) - ((lcm / ayChange) * prizeYPosition));
        long denominator = (((lcm / axChange) * bxChange) - ((lcm / ayChange) * byChange));
        long tempButtonBCount = numerator / denominator;
        long buttonBPressCount;

        if (tempButtonBCount >= 0 && denominator * tempButtonBCount == numerator) {
            buttonBPressCount = tempButtonBCount;
            long buttonAPressCount = (prizeXPosition - (bxChange * buttonBPressCount)) / axChange;
            if (buttonAPressCount >= 0) {
                minimumTokensRequired = ((3 * buttonAPressCount) + buttonBPressCount);
            }
        }

        return minimumTokensRequired;
    }

    private long gcd(long number1, long number2) {
        if (number1 == 0 || number2 == 0) {
            return number1 + number2;
        } else {
            long absNumber1 = Math.abs(number1);
            long absNumber2 = Math.abs(number2);
            long biggerValue = Math.max(absNumber1, absNumber2);
            long smallerValue = Math.min(absNumber1, absNumber2);
            return gcd(biggerValue % smallerValue, smallerValue);
        }
    }
}
