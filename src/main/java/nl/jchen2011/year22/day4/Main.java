package nl.jchen2011.year22.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<String> SECTIONS = new ArrayList<>();

    public static void main(String[] args) {
        readFile("input.txt");
        part1();
        part2();
    }

    private static void part1() {
        System.out.println("Points (part 1): " + calculateAmountOfPoints("part1"));
    }
    private static void part2() {
        System.out.println("Points (part 2): " + calculateAmountOfPoints("part2"));
    }

    private static int calculateAmountOfPoints(String part) {
        int points = 0;
        for (String section : SECTIONS) {
            String[] parts = section.split(",");
            String[] firstHalf = parts[0].split("-");
            String[] secondHalf = parts[1].split("-");

            points += part.equals("part1") ? calculateAmountOfOverlap(Integer.parseInt(firstHalf[0]), Integer.parseInt(firstHalf[1]), Integer.parseInt(secondHalf[0]), Integer.parseInt(secondHalf[1])) : calculateAmountOfAllOverlaps(Integer.parseInt(firstHalf[0]), Integer.parseInt(firstHalf[1]), Integer.parseInt(secondHalf[0]), Integer.parseInt(secondHalf[1]));
        }
        return points;
    }

    private static int calculateAmountOfOverlap(int firstLeft, int firstRight, int secondLeft, int secondRight) {
        int amountOfOverlaps = 0;

        if (firstLeft >= secondLeft && firstRight <= secondRight) {
            amountOfOverlaps++;
        } else if (secondLeft >= firstLeft && secondRight <= firstRight) {
            amountOfOverlaps++;
        }
        return amountOfOverlaps;
    }

    private static int calculateAmountOfAllOverlaps(int firstLeft, int firstRight, int secondLeft, int secondRight) {
        int amountOfOverlaps = 0;

        if (firstLeft >= secondLeft && firstRight <= secondRight) {
            amountOfOverlaps++;
        } else if (secondLeft >= firstLeft && secondRight <= firstRight) {
            amountOfOverlaps++;
        } else if (firstLeft >= secondLeft && firstLeft <= secondRight) {
            amountOfOverlaps++;
        } else if (firstRight >= secondLeft && firstRight <= secondRight) {
            amountOfOverlaps++;
        }

        return amountOfOverlaps;
    }

    public static void readFile(String file) {
        try {
            File myObj = new File("src/main/java/nl/jchen2011/year22/day4/" + file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                SECTIONS.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
