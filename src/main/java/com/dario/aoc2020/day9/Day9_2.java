package com.dario.aoc2020.day9;

import com.dario.aoc2020.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day9_2 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Long> input = FileReader.read("day9/input.txt").stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

        int offset = 25;
        Long invalidNum = null;
        for (int i = offset; i <input.size(); i++) {
            long target = input.get(i);
            boolean isValid = isValid(target, input.subList(i-offset, i));
            if (!isValid) {
                System.out.println("FOUND: " + target);
                invalidNum = target;
            }
        }

        for (int i = 0; i < input.size(); i++) {
            long acc = input.get(i);
            for (int j = i + 1; j < input.size(); j++) {
                acc+=input.get(j);
                if (acc == invalidNum) {
                    Long max = getMax(input, i, j);
                    Long min = getMin(input, i, j);
                    System.out.println("Found " + max + " " + min);
                    System.out.println(max + min);
                    System.exit(0);
                }
                if (acc > invalidNum) {
                    break;
                }
            }
        }
    }

    private static Long getMax(List<Long> input, int i, int j) {
        return input.subList(i, j + 1).stream()
                .max(Long::compareTo)
                .orElse(0L);
    }

    private static Long getMin(List<Long> input, int i, int j) {
        return input.subList(i, j + 1).stream()
                .min(Long::compareTo)
                .orElse(0L);
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