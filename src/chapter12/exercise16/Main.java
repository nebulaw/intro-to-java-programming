package chapter12.exercise16;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Usage: java sourceFile oldString newString");
      System.exit(-1);
    }

    File sourceFile = new File(args[0]);
    if(!sourceFile.exists()) {
      System.out.println("source file was not found.");
      System.exit(-1);
    }

    ArrayList<String> lines = new ArrayList<>();

    try (
      Scanner in = new Scanner(sourceFile);
    ) {
      while (in.hasNext()) {
        String line = in.nextLine();
        String filteredLine = line.replaceAll(args[1], args[2]);
        lines.add(filteredLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (
      PrintWriter out = new PrintWriter(sourceFile);
    ) {
      for (String line : lines)
        out.println(line);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
