package com.dario.aoc2020.day3;

import com.dario.aoc2020.utils.FileReader;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day3_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day3/input.txt");
        int reps = 50;
        String[][] grid  = new String[323][31 * reps];
        for (int t=0;t<reps;t++) {
            for (int i = 0; i < input.size(); i++) {
                for (int j = 0; j < input.get(0).length(); j++) {
                    grid[i][j + (t * 31)] = input.get(i).charAt(j) + "";
                }
            }
        }

        int cont = 0;
        int posi = 0;
        int posj = 0;
        while (posi < 323) {
            System.out.println(posi);
            String s = grid[posi][posj];
            if (s.equals("#")) {
                cont++;
            }
            posi+=1;
            posj+=3;
        }

        System.out.println(cont);
    }
}