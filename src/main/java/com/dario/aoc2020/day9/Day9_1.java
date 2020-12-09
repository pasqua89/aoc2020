package com.dario.aoc2020.day9;

import com.dario.aoc2020.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class Day9_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Long> input = FileReader.read("day9/input.txt").stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

        int offset = 25;
        for (int i = offset; i < input.size(); i++) {
            long target = input.get(i);
            boolean isValid = isValid(target, input.subList(i - offset, i));
            if (!isValid) {
                System.out.println("FOUND: " + target);
                System.exit(0);
            }
        }
    }

    private static boolean isValid(Long target, List<Long> subList) {
        for (int i = 0; i < subList.size(); i++) {
            for (int j = 0; j < subList.size(); j++) {
                if (i == j) {
                    continue;
                }
                long sum = subList.get(i) + subList.get(j);
                if (sum == target) {
                    return true;
                }
            }
        }
        return false;
    }
}