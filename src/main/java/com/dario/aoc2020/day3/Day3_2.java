package com.dario.aoc2020.day3;

import com.dario.aoc2020.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day3_2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day3/input.txt");
        int reps = 100;
        String[][] grid  = new String[323][31 * reps];
        for (int t=0;t<reps;t++) {
            for (int i = 0; i < input.size(); i++) {
                for (int j = 0; j < input.get(0).length(); j++) {
                    grid[i][j + (t * 31)] = input.get(i).charAt(j) + "";
                }
            }
        }

        int trees = getTrees(grid, 1, 1) * getTrees(grid, 1, 3)* getTrees(grid, 1, 5)* getTrees(grid, 1, 7)* getTrees(grid, 2, 1);
        System.out.println(trees);
    }

    private static int getTrees(String[][] grid, int jumpi, int jumpj) {
        int posi = 0;
        int posj = 0;
        int cont = 0;
        while (posi < 323) {
            String s = grid[posi][posj];
            if (s.equals("#")) {
                cont++;
            }
            posi+=jumpi;
            posj+=jumpj;
        }

        return cont;
    }
}
