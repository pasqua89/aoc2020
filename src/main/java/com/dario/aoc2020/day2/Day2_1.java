//package com.dario.aoc2020.day2;
//
//import com.dario.aoc2020.utils.FileReader;
//import org.apache.commons.lang3.StringUtils;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.List;
//
//public class Day2_1 {
//
//    public static void main(String[] args) throws IOException, URISyntaxException {
//        List<String> input = FileReader.read("day2/input.txt");
//        int cont = 0;
//        for (String line: input) {
//            String[] tokens = line.split(" ");
//            String times = tokens[0];
//            int min = Integer.parseInt(times.split("-")[0]);
//            int max = Integer.parseInt(times.split("-")[1]);
//            String letter = tokens[1].replace(":", "");
//            String password = tokens[2];
//            int occurrences = StringUtils.countMatches(password, letter);
//            if (occurrences >= min && occurrences <= max) {
//                cont++;
//            }
//        }
//        System.out.println(cont);
//    }
//}