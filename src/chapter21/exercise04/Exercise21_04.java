package chapter21.exercise04;

import util.Pair;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * count consonants and vowels in a file
 * */

public class Exercise21_04 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("provide source file");
      System.exit(-1);
    }

    File file = new File(args[0]);
    if (!file.exists()) {
      System.out.println(file + " not found.");
      System.exit(-1);
    }
    if (file.isDirectory()) {
      System.out.println(file + " is a directory");
      System.exit(-1);
    }

    int[] counts = countLetters(file);

    System.out.println("Vowels: " + counts[0]);
    System.out.println("Consonants: " + counts[1]);
  }

  public static int[] countLetters(File file) {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    int vowelCount = 0, consCount = 0;

    try (FileReader reader = new FileReader(file)) {
      int ch = 0;
      while ((ch = reader.read()) != -1)
        if (Character.isAlphabetic((char)ch))
          if (vowels.contains((char)ch)) vowelCount++;
          else consCount++;
    } catch (IOException e) {
      System.out.println("error while reading");
    }
    return new int[] { vowelCount, consCount };
  }
}
