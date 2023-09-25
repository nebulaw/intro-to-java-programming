package chapter12.exercise21;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * (Replace text) Revise Programming Exercise 12.16 to replace a string in a file
 * with a new string for all files in the specified directory using the command:
 * java Exercise12_22 dir oldString newString
 * */

public class ReplaceInDir {
  public static void replace(File file, String oldString, String newString) {
    ArrayList<String> lines = new ArrayList<>();

    try (
      Scanner in = new Scanner(file);
    ) {
      while (in.hasNext()) {
        String line = in.nextLine();
        String filteredLine = line.replaceAll(oldString, newString);
        lines.add(filteredLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (
      PrintWriter out = new PrintWriter(file);
    ) {
      for (String line : lines)
        out.println(line);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void replaceDir(File dir, String oldString, String newString) {
    File[] files = dir.listFiles();
    if (files == null) return;

    for (File file : files)
      if (file.isDirectory())
        replaceDir(file, oldString, newString);
      else
        replace(file, oldString, newString);
  }

  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Usage: java sourceDir oldString newString");
      System.exit(-1);
    }

    File sourceDir = new File(args[0]);
    if(!sourceDir.exists()) {
      System.out.println(sourceDir.getName() + " was not found.");
      System.exit(-1);
    }
    if (!sourceDir.isDirectory()) {
      System.out.println(sourceDir.getName() + " is not directory.");
      System.exit(-1);
    }

    replaceDir(sourceDir, args[1], args[2]);

  }
}
