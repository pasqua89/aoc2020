package com.dario.aoc2020.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Op {
    private String instr;
    private int arg;
}