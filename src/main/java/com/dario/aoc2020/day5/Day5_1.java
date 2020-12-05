package com.dario.aoc2020.day5;

import com.dario.aoc2020.utils.FileReader;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day5/input.txt");
        List<Integer> rows = IntStream.rangeClosed(0, 127).boxed().collect(Collectors.toList());
        List<Integer> columns = IntStream.rangeClosed(0, 7).boxed().collect(Collectors.toList());
        int multiplier = 8;
        int max = 0;

        for (String line: input) {
            final String rowPart = line.substring(0, 7);
            final String columnPart = line.substring(7);
            int row = row(rowPart, rows, 0);
            int column = column(columnPart, columns, 0);
            int id = row * multiplier + column;
            if (id > max) {
                max = id;
            }
        }
        System.out.println(max);
    }

    private static int row(String input, List<Integer> list, int pos) {
        final char direction = input.charAt(pos);
        int half = list.size() / 2;
        if (list.size() == 2) {
            switch (direction) {
                case 'F': return list.get(0);
                case 'B': return list.get(1);
                default: throw new RuntimeException();
            }
        }
        switch (direction) {
            case 'F':
                return row(input, list.subList(0, half), pos + 1);
            case 'B':
                return row(input, list.subList(half, list.size()), pos + 1);
            default: throw new RuntimeException();
        }
    }

    private static int column(String input, List<Integer> list, int pos) {
        final char direction = input.charAt(pos);
        int half = list.size() / 2;
        if (list.size() == 2) {
            switch (direction) {
                case 'L': return list.get(0);
                case 'R': return list.get(1);
                default: throw new RuntimeException();
            }
        }
        switch (direction) {
            case 'L':
                return column(input, list.subList(0, half), pos + 1);
            case 'R':
                return column(input, list.subList(half, list.size()), pos + 1);
            default: throw new RuntimeException();
        }
    }
}