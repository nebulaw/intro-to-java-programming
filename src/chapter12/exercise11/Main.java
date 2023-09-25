package chapter12.exercise11;

import java.io.*;
import java.util.ArrayList;

/**
 * (Remove text) Write a program that removes all the occurrences of a specified
 * string from a text file. For example, invoking
 * java Exercise12_11 John filename
 *
 *
 * For example you can run:
 *  java nebula data/chapter12/exercise11/Exercise12_11.txt
 * */

public class Main {
  public static void main(String[] args) {
    if (args.length < 1 || args.length > 2) {
      System.out.println("error: invalid number of arguments.");
      System.exit(-1);
    }

    String stringToRemove = args[0];
    ArrayList<String> lines = new ArrayList<>();

    try (
      BufferedReader in = new BufferedReader(new FileReader(args[1]));
    ) {
      String line;
      int count = 0;

      while ((line = in.readLine()) != null) {
        String filteredLine = line.replace(stringToRemove + " ", "")
          .replace(stringToRemove, "");
        if (!filteredLine.equals(line))
          count++;
        lines.add(filteredLine);
      }
      if (count == 0)
        System.out.println(stringToRemove + " was not found.");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (
      PrintWriter out = new PrintWriter(new FileOutputStream(args[1]), true);
    ) {
      for (String line : lines)
        out.println(line);
    } catch (IOException e) {
      System.out.println("error while writing file");
    }

  }
}
