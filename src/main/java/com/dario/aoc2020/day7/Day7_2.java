package com.dario.aoc2020.day7;

import com.dario.aoc2020.utils.FileReader;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Day7_2 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day7/input.txt");
        Map<String, List<NextObject>> g = new HashMap<>();
        for (String line : input) {
            String[] tokens = line.split(" contain ");
            String source = tokens[0].replace(" bags", "");
            addVertex(g, source);
            String dests = tokens[1].trim();
            if (!dests.equals("no other bags.")) {
                List<String> destTokens = Arrays.asList(dests.split(","));
                for (String d : destTokens) {
                    String cleanDest = d.replace(".", "")
                            .replace("bags", "")
                            .replace("bag", "")
                            .trim();
                    int weight = Integer.parseInt(cleanDest.charAt(0) + "");
                    String vertex = cleanDest.substring(2);
                    g.get(source).add(new NextObject(vertex, weight));
                }
            } else {
                g.remove(source);
            }
        }
        System.out.println(g);
        double acc = 0;
        String start = "shiny gold";
        for (NextObject ne: g.get(start)) {
            acc+=ne.getW() + ne.getW() * getWeight(ne.getTarget(), g);
        }
        System.out.println(acc);
    }

    private static int getWeight(String target, Map<String, List<NextObject>> g) {
        if (!g.containsKey(target)) {
            return 0;
        }
        int acc = 0;
        for (NextObject n: g.get(target)) {
            acc+=n.getW() + n.getW()*getWeight(n.getTarget(), g);
        }
        return acc;
    }

    private static void addVertex(Map<String, List<NextObject>> g, String source) {
        if (!g.containsKey(source)) {
            g.put(source, new ArrayList<>());
        }
    }

    @Data
    @AllArgsConstructor
    private static class NextObject {
        private String target;
        private int w;
    }
}