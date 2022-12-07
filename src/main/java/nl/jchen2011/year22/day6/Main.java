package nl.jchen2011.year22.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static String text = "";
    private static final int PART1_SIZE = 4;
    private static final int PART2_SIZE = 14;

    public static void main(String[] args) {
        readFile("input.txt");
        part1(PART1_SIZE);
        part2(PART2_SIZE);
    }



    private static void part1(int length) {
        System.out.println("First part: " + getFirstMarker(length));
    }

    private static void part2(int length) {
        System.out.println("Second part: " + getFirstMarker(length));
    }

    private static int getFirstMarker(int length) {
        int index = 0;
        for (int i = 0; i < text.length() - length - 1; i++) {
            String temp = createTempString(i, length);
            if (checkUniqueString(temp)) {
                index = i + temp.length();
                break;
            }
        }
        return index;
    }

    private static boolean checkUniqueString(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String createTempString(int index, int length) {
        StringBuilder temp = new StringBuilder();
        for (int i = index; i < length + index; i++) {
            temp.append(text.charAt(i));
        }
        return temp.toString();
    }

    public static void readFile(String file) {
        try {
            File myObj = new File("src/main/java/nl/jchen2011/year22/day6/" + file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                text = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
