package com.dario.aoc2020.day7;

import com.dario.aoc2020.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.graph.*;

public class Day7_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day7/input.txt");
        Graph<String, DefaultWeightedEdge> g = new DefaultDirectedGraph<>(DefaultWeightedEdge.class);

        for (String line: input) {
            String[] tokens = line.split(" contain ");
            String source = tokens[0].replace(" bags", "");
            g.addVertex(source);
            String dests = tokens[1].trim();
            if (!dests.equals("no other bags.")) {
                List<String> destTokens = Arrays.asList(dests.split(","));
                for (String d: destTokens) {
                    String cleanDest = d.replace(".", "")
                            .replace("bags", "")
                            .replace("bag", "")
                            .trim();
                    int weight = Integer.parseInt(cleanDest.charAt(0) + "");
                    String vertex = cleanDest.substring(2);
                    g.addVertex(vertex);
                    g.addEdge(source, vertex, new WEdge(weight));
                }
            }
        }
        Set<String> sources = new HashSet<>();
        sources.addAll(g.vertexSet());
        sources.remove("shiny gold");
        Set<String> dests = Collections.singleton("shiny gold");
        AllDirectedPaths alg = new AllDirectedPaths(g);
        Set<String> result = new HashSet<>();
        List<GraphPath> paths = alg.getAllPaths(sources, dests, true, Integer.MAX_VALUE);

        paths.forEach(path -> {
            result.add((String) path.getStartVertex());
        });
        System.out.println(result.size());
    }

    private static class WEdge extends DefaultWeightedEdge {
        private int w;
        public WEdge(int w) {
            this.w = w;
        }

        @Override
        protected double getWeight() {
            return this.w;
        }
    }
}