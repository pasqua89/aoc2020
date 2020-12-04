package com.dario.aoc2020.day4;

import com.dario.aoc2020.utils.FileReader;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4_1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = FileReader.read("day4/input.txt");
        List<String> curr = new ArrayList<>();
        List<List<String>> passports = new ArrayList<>();
        List<Passport> parsed = new ArrayList<>();
        for (int i =0; i < input.size(); i++) {
            if (input.get(i).equals("")) {
                passports.add(curr);
                curr = new ArrayList<>();
            }
            else {
                String[] tokens = input.get(i).split(" ");
                curr.addAll(Arrays.asList(tokens));
            }
        }

        passports.forEach(f -> {
            Passport passport = new Passport();
            f.forEach(field -> {
                final String[] tokens = field.split(":");
                String fieldOne = tokens[0];
                String value = tokens[1];
                switch (fieldOne) {
                    case "byr":
                        passport.setByr(value);
                        break;
                    case "iyr":
                        passport.setIyr(value);
                        break;
                    case "eyr":
                        passport.setEyr(value);
                        break;
                    case "hgt":
                        passport.setHgt(value);
                        break;
                    case "hcl":
                        passport.setHcl(value);
                        break;
                    case "ecl":
                        passport.setEcl(value);
                        break;
                    case "pid":
                        passport.setPid(value);
                        break;
                    case "cid":
                        passport.setCid(value);
                        break;

                }
            });
            parsed.add(passport);
        });
        int cont = 0;

        for (Passport p: parsed) {
            if (p.isValid()) {
                cont++;
            } else {
            }
        }

        System.out.println(cont);
    }

    @Data
    private static class Passport {
        private String byr;
        private String iyr;
        private String eyr;
        private String hgt;
        private String hcl;
        private String ecl;
        private String pid;
        private String cid;

        private boolean isByrValid() {
            return byr != null;
        }

        private boolean isIyrValid() {
            return iyr != null;
        }

        private boolean isEyrValid() {
            return eyr != null;
        }

        private boolean isHgtValid() {
            return hgt != null;
        }


        private boolean isHclValid() {
            return hcl != null;
        }

        private boolean isEclValid() {
            return ecl != null;
        }
        private boolean isPidValid() {
            return pid != null;
        }

        public boolean isValid() {
            return isByrValid() && isEyrValid() && isHclValid() && isHgtValid() && isIyrValid() && isPidValid() && isEclValid();
        }
    }
}