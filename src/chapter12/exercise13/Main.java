package chapter12.exercise13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * (Count characters, words, and lines in a file) Write a program that will count
 * the number of characters, words, and lines in a file. Words are separated by
 * whitespace characters. The file name should be passed as a command-line
 * argument
 * */

public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("invalid number of arguments");
      System.exit(-1);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println("file was not found.");
      System.exit(-1);
    }

    int charCount = 0;
    int wordCount = 0;
    int lineCount = 0;

    try (
      BufferedReader in = new BufferedReader(new FileReader(file));
    ) {
      String line;
      while ((line = in.readLine()) != null) {
        lineCount++;
        String[] tokens = line.split(" ");
        wordCount += tokens.length;
        for (String token : tokens)
          charCount += token.length();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("File " + args[0] + " has");
    System.out.println(charCount + " characters");
    System.out.println(wordCount + " words");
    System.out.println(lineCount + " lines");

  }
}
