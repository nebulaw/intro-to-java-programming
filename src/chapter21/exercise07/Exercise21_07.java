package chapter21.exercise07;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Exercise21_07 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter a file: ");
    String filePath = in.next();

    displayCounts(new File(filePath));
  }

  public static void displayCounts(File file) {
    Map<String, Integer> words = new HashMap<>();
    try (Scanner in = new Scanner(file)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        String[] wordTokens = line.split("[\n\t\r.,:;!?(){}\\[\\]]");
        for (String word : wordTokens)
          if (!words.containsKey(word))
            words.put(word, 1);
          else
            words.put(word, words.get(word) + 1);
      }
    } catch (IOException e) {
      System.out.println("error while reading");
    }

    words.keySet().stream()
        .sorted(Comparator.comparingInt(words::get))
        .forEach(x -> System.out.println(x + ": "+ words.get(x)));
  }
}
