package com.dario.aoc2020.day6;

import com.dario.aoc2020.utils.FileReader;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day6_2 {
    static Map<Character, Integer> answers = new HashMap<>();

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day6/input.txt");
        List<Integer> counts = new ArrayList<>();
        int passengers = 0;
        for (String line: input) {
            if (line.equals("")) {
                int tot = 0;
                for (Map.Entry<Character, Integer> e: answers.entrySet()) {
                    if (e.getValue() == passengers) {
                        tot++;
                    }
                }

                counts.add(tot);
                answers = new HashMap<>();
                passengers = 0;
                continue;
            }
            passengers++;
            line.chars()
                    .mapToObj(c -> (char) c)
                    .forEach(answer -> add(answers, answer));

        }
        System.out.println(counts.stream().reduce(Integer::sum).get());
    }

    private static void add(Map<Character, Integer> answers, Character a) {
        if (!answers.containsKey(a)) {
            answers.put(a, 0);
        }
        answers.put(a, answers.get(a) + 1);
    }
}