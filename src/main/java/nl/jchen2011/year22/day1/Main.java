package nl.jchen2011.year22.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private final static ArrayList<String> ALL_NUMBERS_IN_FILE = new ArrayList<>();
    private final static ArrayList<Integer> MAX_NUMBERS = new ArrayList<>();
    public static void main(String[] args) {
        readFile("input.txt");
        calculateAllMaxNumbers();
        System.out.println(getMaxAndThreeElvesCalorie());
    }

    public static void readFile(String file) {
        try {
            File myObj = new File("src/main/java/nl/jchen2011/year22/day1/" + file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                addNumber(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void addNumber(String data) {
        ALL_NUMBERS_IN_FILE.add(data);
    }

    public static void calculateAllMaxNumbers() {
        int total = 0;
        for (String number : ALL_NUMBERS_IN_FILE) {
            if (number.isEmpty()) {
                MAX_NUMBERS.add(total);
                total = 0;
            } else {
                total += Integer.valueOf(number);
            }
        }
    }

    public static int getMaxCalorie() {
        return MAX_NUMBERS.stream().max(Integer::compare).get();
    }

    public static int getTotalCalorieThreeElves() {
        Collections.sort(MAX_NUMBERS, Collections.reverseOrder());
        int total = 0;
        for (int i = 0 ; i < 3; i++) {
            total += MAX_NUMBERS.get(i);
        }
        return total;
    }

    public static String getMaxAndThreeElvesCalorie() {
        return "Part 1: " + getMaxCalorie() + ", Part 2: " + getTotalCalorieThreeElves();
    }
}
