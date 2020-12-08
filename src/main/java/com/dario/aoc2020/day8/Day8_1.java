package com.dario.aoc2020.day8;

import com.dario.aoc2020.utils.Engine;
import com.dario.aoc2020.utils.FileReader;
import com.dario.aoc2020.utils.Op;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

public class Day8_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day8/input.txt");
        List<Op> ops = input.stream()
                .map(line -> new Op(line.split(" ")[0], Integer.parseInt(line.split(" ")[1])))
                .collect(Collectors.toList());

        Engine engine = new Engine(ops);

        Integer res = engine.execute();
        System.out.println(res);
    }
}