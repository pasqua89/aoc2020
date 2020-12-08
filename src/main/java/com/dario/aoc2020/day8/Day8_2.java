package com.dario.aoc2020.day8;

import com.dario.aoc2020.utils.Engine;
import com.dario.aoc2020.utils.FileReader;
import com.dario.aoc2020.utils.Op;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

public class Day8_2 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day8/input.txt");
        List<Op> ops = input.stream()
                .map(line -> new Op(line.split(" ")[0], Integer.parseInt(line.split(" ")[1])))
                .collect(Collectors.toList());

        for (Op opToChange: ops) {
            List<Op> newOps = new ArrayList<>();
            newOps.addAll(ops);

            switch (opToChange.getInstr()) {
                case "nop":
                    newOps.set(ops.indexOf(opToChange), new Op("jmp", opToChange.getArg()));
                    break;
                case "jmp":
                    newOps.set(ops.indexOf(opToChange), new Op("nop", opToChange.getArg()));
                    break;
                case "acc":
                    continue;
                default: throw new IllegalArgumentException();
            }

            Engine engine = new Engine(newOps);
            Integer res = engine.execute();
            if (engine.isSuccess()) {
                System.out.println(res);
                break;
            }

        }
    }
}