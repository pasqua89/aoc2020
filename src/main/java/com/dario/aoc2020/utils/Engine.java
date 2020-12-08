package com.dario.aoc2020.utils;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class Engine {
    private List<Op> ops;
    private boolean success = false;
    public Engine(List<Op> input) {
        this.ops = input;
    }

    public Integer execute() {
        Set<Integer> executed = new HashSet<>();
        int acc = 0;
        int index = 0;
        while(true) {
            if (executed.contains(index)) {
                System.out.println("Non terminating " + acc);
                return acc;
            }
            executed.add(index);

            if (index >= this.ops.size()) {
                System.out.println("COMPLETED! ACC: " + acc);
                this.success = true;
                return acc;
            }

            Op op = this.ops.get(index);
            switch (op.getInstr()) {
                case "nop":
                    index++;
                    break;
                case "jmp":
                    index+=op.getArg();
                    break;
                case "acc":
                    acc+=op.getArg();
                    index++;
                    break;
                default: throw new IllegalArgumentException();
            }
        }
    }
}
