package com.dario.aoc2020.day1;

import com.dario.aoc2020.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class Day1_2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final int target = 2020;
        final List<String> lines = FileReader.read("day1/input.txt");
        final List<Integer> ints = lines.stream()
                .map(in -> Integer.parseInt(in))
                .collect(Collectors.toList());

        for (int i = 0; i < ints.size(); i++) {
            for (int j = 0; j < ints.size(); j++) {
                for (int z = 0; z < ints.size(); z++) {
                    if (i == j || i == z || j == z) {
                        continue;
                    }
                    if (ints.get(i) + ints.get(j) + ints.get(z) == target) {
                        System.out.println(ints.get(i) * ints.get(j) * +ints.get(z));
                        System.exit(0);
                    }
                }
            }
        }
    }
}
