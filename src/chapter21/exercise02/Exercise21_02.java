package chapter21.exercise02;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Exercise21_02 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java source-file");
      System.exit(-1);
    }

    File file = new File(args[0]);
    if (!file.exists()) {
      System.out.println(file + " not found.");
      System.exit(-1);
    }
    if (file.isDirectory()) {
      System.out.println(file + " is a directory.");
      System.exit(-1);
    }

    Set<String> words = new HashSet<>();
    try (Scanner in = new Scanner(file)) {
      while (in.hasNext())
        words.add(in.next());
    } catch (IOException e) {
      System.out.println("error while reading file");
      System.exit(-1);
    }

    words.stream()
        .sorted()
        .filter(Objects::nonNull)
        .forEach(s -> System.out.print(s + " "));
  }

}
