package chapter12.exercise27;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Replace words) Suppose you have a lot of files in a directory that contain
 * words Exercisei_j, where i and j are digits. Write a program that pads a 0
 * before i if i is a single digit and 0 before j if j is a single digit. For example,
 * the word Exercise2_1 in a file will be replaced by Exercise02_01. In Java,
 * when you pass the symbol * from the command line, it refers to all files in
 * the directory (see Supplement III.V). Use the following command to run your
 * program.
 * java Exercise12_27 *
 * */

public class ReplaceWords {

  public static void replace(File file) {
    ArrayList<String> lines = new ArrayList<>();
    String targetRegex = "Exercise(\\d)_(\\d+)";

    // First read if it's requires to add package
    try (
      Scanner in = new Scanner(file);
    ) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        Matcher matcher = Pattern.compile(targetRegex).matcher(line);
        if (matcher.find())
          line = matcher.replaceAll("Exercise0$1_$2");
        lines.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // if program reached there, then we add package statement
    try (
      PrintWriter out = new PrintWriter(new FileOutputStream(file), true);
    ) {
      for (String line : lines)
        out.println(line);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void replaceDir(File srcDir) {
    File[] files = srcDir.listFiles();
    if (files == null) return;

    for (File file : files)
      if (file.isDirectory())
        replaceDir(file);
      else
        replace(file);
  }

  public static void main(String[] args) {
    replaceDir(new File("data/chapter12/regexDir"));
    System.out.println("successfully replaced");
  }
}

