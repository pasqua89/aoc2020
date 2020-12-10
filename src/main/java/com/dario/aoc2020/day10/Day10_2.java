package com.dario.aoc2020.day10;

import com.dario.aoc2020.utils.FileReader;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day10_2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Integer> input = FileReader.read("day10/input.txt")
                .stream()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        Graph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
        input.add(input.get(input.size() - 1) + 3);
        for (int i = 0; i < input.size(); i++) {
            Integer first = input.get(i);
            g.addVertex(first + "");
            for (int j = i + 1; j < input.size(); j++) {
                Integer second = input.get(j);
                g.addVertex(second + "");
                if (second - first >= 1 && second - first <= 3) {
                    g.addEdge(first + "", second + "");
                }
            }
        }
        AllDirectedPaths alg = new AllDirectedPaths(g);
        List<GraphPath> paths1 = alg.getAllPaths("0", "73", true, Integer.MAX_VALUE);
        List<GraphPath> paths2 = alg.getAllPaths("73", "116", true, Integer.MAX_VALUE);
        List<GraphPath> paths3 = alg.getAllPaths("116", "149", true, Integer.MAX_VALUE);
        System.out.println(BigInteger.valueOf(paths1.size()).multiply(BigInteger.valueOf(paths2.size())).multiply(BigInteger.valueOf(paths3.size())));
    }
}