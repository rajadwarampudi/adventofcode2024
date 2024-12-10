package com.practice.day9;

import java.util.*;

public class Day9_Challenge {


    public static final int FREE_SPACE = -1;

    public long getFileSystemChecksum(String inputLine) {
        char[] inputCharArray = inputLine.toCharArray();
        List<Integer> diskMapList = generateDiskMapList(inputCharArray);

        return getFileSystemChecksum(diskMapList);

    }

    public long getFileSystemChecksumWithSameIdFileMovementAtOnce(String inputLine) {
        char[] inputCharArray = inputLine.toCharArray();
        List<Block> blockList = generateBlockList(inputCharArray);
        List<Block> blockListAfterFileMovement = moveFilesInOrderOfDecreasingIDNumber(blockList);

        return getFileSystemChecksumWithSameIdFileMovementAtOnce(blockListAfterFileMovement);

    }

    private List<Block> moveFilesInOrderOfDecreasingIDNumber(List<Block> blockList) {

        List<Block> updatedBlockList = new ArrayList<>(blockList);

        for (int i = blockList.size() - 1; i > 0; i--) {
            Block block = blockList.get(i);
            if (block.value() != FREE_SPACE) {
                boolean isBlockUpdated = false;
                for (int j = 0; j < updatedBlockList.size() - 1; j++) {
                    Block updatingBlock = updatedBlockList.get(j);
                    if (updatingBlock.value() == FREE_SPACE && updatingBlock.count() >= block.count()) {
                        updatedBlockList.set(j, new Block(block.value(), updatingBlock.startIndex(), block.count()));
                        if (updatingBlock.count() > block.count()) {
                            updatedBlockList.add(j + 1, new Block(FREE_SPACE,
                                    updatingBlock.startIndex() + block.count(),
                                    updatingBlock.count() - block.count()));
                        }
                        isBlockUpdated = true;
                        break;
                    }
                }

                if (isBlockUpdated) {
                    for (int j = updatedBlockList.size() - 1; j >= 0; j--) {
                        if (updatedBlockList.get(j).value() == block.value()) {
                            updatedBlockList.set(j, new Block(FREE_SPACE, block.startIndex(), block.count()));
                            break;
                        }
                    }
                }
            }

        }

        return updatedBlockList;

    }

    private long getFileSystemChecksumWithSameIdFileMovementAtOnce(List<Block> blockList) {
        long fileSystemCheckSum = 0L;
        int memoryBlockIndex = 0;

        for (Block block : blockList) {
            for (int i = 0; i < block.count(); i++) {
                if (block.value() != FREE_SPACE) {
                    long value = block.value();
                    fileSystemCheckSum += value * memoryBlockIndex;
                }
                memoryBlockIndex++;
            }
        }

        return fileSystemCheckSum;
    }

    private long getFileSystemChecksum(List<Integer> diskMapList) {
        long fileSystemCheckSum = 0L;
        int i = 0, j = diskMapList.size() - 1;

        while (i <= j) {
            int numAtIndexI = diskMapList.get(i);
            if (numAtIndexI == FREE_SPACE) {
                while (diskMapList.get(j) == FREE_SPACE) {
                    j--;
                }
                if (j > i) {
                    int numAtIndexJ = diskMapList.get(j);
                    fileSystemCheckSum +=  (long) i * numAtIndexJ;
                    j--;
                }
            } else {
                fileSystemCheckSum += (long) i * numAtIndexI;
            }
            i++;
        }

        return fileSystemCheckSum;
    }

    private static List<Integer> generateDiskMapList(char[] inputCharArray) {
        List<Integer> diskMapList = new ArrayList<>();
        for (int i = 0; i < inputCharArray.length; i++) {
            char ch = inputCharArray[i];
            int chDigit = Character.getNumericValue(ch);
            if (i % 2 == 0) {
                int currentIndex = i / 2;
                diskMapList.addAll(Collections.nCopies(chDigit, currentIndex));
            } else {
                diskMapList.addAll(Collections.nCopies(chDigit, FREE_SPACE));
            }
        }

        return diskMapList;
    }

    private static List<Block> generateBlockList(char[] inputCharArray) {
        List<Block> blockList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < inputCharArray.length; i++) {
            char ch = inputCharArray[i];
            int chDigit = Character.getNumericValue(ch);
            if (i % 2 == 0) {
                int currentIndex = i / 2;
                blockList.add(new Block(currentIndex, index, chDigit));
            } else {
                blockList.add(new Block(FREE_SPACE, index, chDigit));
            }
            index += chDigit;
        }

        return blockList;
    }
}
