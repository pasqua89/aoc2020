package com.dario.aoc2020.day6;

import com.dario.aoc2020.utils.FileReader;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day6_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day6/input.txt");
        List<Integer> counts = new ArrayList<>();
        Set<Character> answers = new HashSet<>();
        for (String line: input) {
            if (line.equals("")) {
                counts.add(answers.size());
                answers = new HashSet<>();
                continue;
            }
            answers.addAll(line.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        }
        System.out.println(counts.stream().reduce(Integer::sum).get());
    }
}