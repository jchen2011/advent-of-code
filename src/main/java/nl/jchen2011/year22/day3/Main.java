package nl.jchen2011.year22.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static final ArrayList<String> contents = new ArrayList<>();
    private static final int AMOUNT_OF_LINES_IN_GROUP = 3;
    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        readFile("input.txt");
        part1();
        part2();
    }


    private static void part1() {
        System.out.println("Points: " + calculateSumOfItemTypes());
    }
    private static void part2() {
        System.out.println("Points part 2: " + calculateSumOfPrioritiesItemTypes());
    }

    private static ArrayList<String> getGroupOfThreeItems(int index) {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = index; i < index + AMOUNT_OF_LINES_IN_GROUP; i++) {
            newList.add(contents.get(i));
        }
        Collections.sort(newList, Comparator.comparingInt(String::length));
        return newList;
    }
    private static int calculateSumOfPrioritiesItemTypes() {
        int points = 0;
        int tempIndex = 0;
        for (int i = 0; i < contents.size() / AMOUNT_OF_LINES_IN_GROUP; i++) {
            ArrayList<String> group = getGroupOfThreeItems(tempIndex);
            tempIndex += 3;

            for (int j = 0; j < group.get(2).length(); j++) {
                if (group.get(1).contains(String.valueOf(group.get(2).charAt(j))) && group.get(0).contains(String.valueOf(group.get(2).charAt(j)))) {
                    points += calculateAmountOfPoints(String.valueOf(group.get(2).charAt(j)));
                    break;
                }
            }
        }
        return points;
    }
    private static int calculateSumOfItemTypes() {
        int points = 0;
        for (String content : contents) {
            String firstHalf = content.substring(0, content.length() / 2);
            String secondHalf = content.substring(content.length() / 2, content.length());

            for (int i = 0; i < firstHalf.length(); i++) {
                if (firstHalf.contains(String.valueOf(secondHalf.charAt(i)))) {
                    points += calculateAmountOfPoints(String.valueOf(secondHalf.charAt(i)));
                    break;
                }
            }
        }
        return points;
    }


    private static int calculateAmountOfPoints(String s) {
       String lowercase = "abcdefghijklmnopqrstuvwxyz";
       String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

       int points = 0;

       for (int i = 0; i < lowercase.length(); i++) {
           if (String.valueOf(lowercase.charAt(i)).equals(s)) {
               points = i + 1;
           } else if (String.valueOf(uppercase.charAt(i)).equals(s)) {
               points = ALPHABET_SIZE + i + 1;
           }
       }
       return points;
    }

    public static void readFile(String file) {
        try {
            File myObj = new File("src/main/java/nl/jchen2011/year22/day3/" + file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                contents.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
