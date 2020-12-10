package com.dario.aoc2020.day10;

import com.dario.aoc2020.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class Day10_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Integer> input = FileReader.read("day10/input.txt")
                .stream()
                .map(Integer::parseInt)
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());

        int start = 0;
        int jolts1Count = 0;
        int jolts3Count = 0;

        for (Integer adapter: input) {
            if (adapter - start == 3) {
                jolts3Count++;
                start = adapter;
                continue;
            }
            if (adapter - start == 1) {
                jolts1Count++;
                start = adapter;
                continue;
            }
            start = adapter;
        }
        jolts3Count++;
        System.out.println("j1: " + jolts1Count);
        System.out.println("j3: " + jolts3Count);
        System.out.println(jolts1Count * jolts3Count);
    }
}