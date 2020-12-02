package com.dario.aoc2020.day2;

import com.dario.aoc2020.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day2_2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day2/input.txt");
        int cont = 0;
        for (String line: input) {
            String[] tokens = line.split(" ");
            String times = tokens[0];
            int pos1 = Integer.parseInt(times.split("-")[0]) - 1;
            int pos2 = Integer.parseInt(times.split("-")[1]) - 1;
            String letter = tokens[1].replace(":", "");
            String password = tokens[2];
            boolean contains1 = password.charAt(pos1) == letter.charAt(0);
            boolean contains2 = password.charAt(pos2) == letter.charAt(0);

            if (contains1 ^ contains2) {
                cont++;
            }
        }
        System.out.println(cont);
    }
}
