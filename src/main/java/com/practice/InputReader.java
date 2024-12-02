package com.practice;

import com.practice.day1.Day1_InputReader;

import java.io.*;
import java.util.stream.Stream;

public class InputReader {
    public static Stream<String> getLineStreams(String fileName) {
        InputStream inputStream = Day1_InputReader.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found!");
            }

            return new BufferedReader(new InputStreamReader(inputStream)).lines();
    }
}
