package com.dario.aoc2020.day1;

import com.dario.aoc2020.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class Day1_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        final List<String> lines = FileReader.read("day1/input.txt");
        final int target = 2020;
        final List<Integer> ints = lines.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < ints.size(); i++) {
            for (int j = 0; j < ints.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (ints.get(i) + ints.get(j) == target) {
                    System.out.println(ints.get(i) * ints.get(j));
                    System.exit(0);
                }
            }
        }

    }
}