package nl.jchen2011.year22.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<String> LETTERS = new ArrayList<>();
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    private static final int LOSE = 0;
    private static final int DRAW = 3;
    private static final int WIN = 6;

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part2() {
        System.out.println(getTotalScore("part2"));
    }

    private static void part1() {
        readFile("input.txt");
        System.out.println(getTotalScore("part1"));
    }

    private static int getTotalScore(String part) {
        int score = 0;
        for (String s : LETTERS) {
            String[] parts = s.split("");
            String firstLetter = parts[0];
            String secondLetter = parts[2];

            score += part.equals("part1") ? calculateTotalScore(firstLetter, secondLetter) : calculatePartTwoTotalScore(firstLetter, secondLetter);
        }
        return score;
    }

    private static int calculateTotalScore(String firstLetter, String secondLetter) {
        int totalScore = 0;

        switch(secondLetter) {
            case "X":
                if (firstLetter.equalsIgnoreCase("a")) {
                    totalScore += ROCK + DRAW;
                } else if (firstLetter.equalsIgnoreCase("b")) {
                    totalScore += ROCK + LOSE;
                } else {
                    totalScore += ROCK + WIN;
                }
                break;
            case "Y":
                if (firstLetter.equalsIgnoreCase("a")) {
                    totalScore += PAPER + WIN;
                } else if (firstLetter.equalsIgnoreCase("b")) {
                    totalScore += PAPER + DRAW;
                } else {
                    totalScore += PAPER + LOSE;
                }
                break;
            case "Z":
                if (firstLetter.equalsIgnoreCase("a")) {
                    totalScore += SCISSORS + LOSE;
                } else if (firstLetter.equalsIgnoreCase("b")) {
                    totalScore += SCISSORS + WIN;
                } else {
                    totalScore += SCISSORS + DRAW;
                }
                break;
        }
        return totalScore;
    }

    private static int calculatePartTwoTotalScore(String firstLetter, String secondLetter) {
        int totalScore = 0;

        switch(secondLetter) {
            case "X":
                if (firstLetter.equalsIgnoreCase("a")) {
                    totalScore += SCISSORS + LOSE;
                } else if (firstLetter.equalsIgnoreCase("b")) {
                    totalScore += ROCK + LOSE;
                } else {
                    totalScore += PAPER + LOSE;
                }
                break;
            case "Y":
                if (firstLetter.equalsIgnoreCase("a")) {
                    totalScore += ROCK + DRAW;
                } else if (firstLetter.equalsIgnoreCase("b")) {
                    totalScore += PAPER + DRAW;
                } else {
                    totalScore += SCISSORS + DRAW;
                }
                break;
            case "Z":
                if (firstLetter.equalsIgnoreCase("a")) {
                    totalScore += PAPER + WIN;
                } else if (firstLetter.equalsIgnoreCase("b")) {
                    totalScore += SCISSORS + WIN;
                } else {
                    totalScore += ROCK + WIN;
                }
                break;
        }
        return totalScore;
    }


    public static void readFile(String file) {
        try {
            File myObj = new File("src/main/java/nl/jchen2011/year22/day2/" + file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                LETTERS.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
