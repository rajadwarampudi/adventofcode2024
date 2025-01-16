package com.practice.day13;

import java.util.List;

public class Day13_Challenge {

    /**
     * This method counts the fewest Tokens for all possible prizes
     * The claw machines here are a little unusual. Instead of a joystick or directional buttons to control the claw,
     * these machines have two buttons labeled A and B. Worse, you can't just put in a token and play;
     * it costs 3 tokens to push the A button and 1 token to push the B button.
     *
     * With a little experimentation, you figure out that each machine's buttons are configured to move the claw
     * a specific amount to the right (along the X axis) and a specific amount forward (along the Y axis) each time that button is pressed.
     *
     * Each machine contains one prize; to win the prize,
     * the claw must be positioned exactly above the prize on both the X and Y axes.
     *
     * You wonder: what is the smallest number of tokens you would have to spend to win as many prizes as possible?
     * You assemble a list of every machine's button behavior and prize location (your puzzle input). For example:
     *
     * Button A: X+94, Y+34
     * Button B: X+22, Y+67
     * Prize: X=8400, Y=5400
     *
     * Button A: X+26, Y+66
     * Button B: X+67, Y+21
     * Prize: X=12748, Y=12176
     *
     * Button A: X+17, Y+86
     * Button B: X+84, Y+37
     * Prize: X=7870, Y=6450
     *
     * Button A: X+69, Y+23
     * Button B: X+27, Y+71
     * Prize: X=18641, Y=10279
     * This list describes the button configuration and prize location of four different claw machines.
     *
     * For now, consider just the first claw machine in the list:
     *
     * Pushing the machine's A button would move the claw 94 units along the X axis and 34 units along the Y axis.
     * Pushing the B button would move the claw 22 units along the X axis and 67 units along the Y axis.
     * The prize is located at X=8400, Y=5400; this means that from the claw's initial position,
     * it would need to move exactly 8400 units along the X axis and exactly 5400 units along the Y axis to be perfectly aligned with the prize in this machine.
     * The cheapest way to win the prize is by pushing the A button 80 times and the B button 40 times.
     * This would line up the claw along the X axis (because 80*94 + 40*22 = 8400) and along the Y axis (because 80*34 + 40*67 = 5400).
     * Doing this would cost 80*3 tokens for the A presses and 40*1 for the B presses, a total of 280 tokens.
     * @param machineInfoList
     * @param unitConversionError
     * @return fewest possible token for all possible prizes
     */
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
            if (buttonAPressCount >= 0 && (buttonAPressCount * axChange) + (bxChange * buttonBPressCount) == prizeXPosition) {
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
