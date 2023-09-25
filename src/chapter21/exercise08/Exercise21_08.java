package chapter21.exercise08;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Exercise21_08 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter a file: ");
    String filePath = in.next();

    displayCountsIgnoreCase(new File(filePath));
  }

  public static void displayCountsIgnoreCase(File file) {
    Map<String, Integer> words = new HashMap<>();
    try (Scanner in = new Scanner(file)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        String[] wordTokens = line.split("[\n\t\r.,:;!?'\"(){}\\[\\]]");
        for (String word : wordTokens)
          if (!containsKeyIgnoreCase(words.keySet(), word.toLowerCase()))
            words.put(word.toLowerCase(), 1);
          else
            words.put(word.toLowerCase(), words.get(word.toLowerCase()) + 1);
      }
    } catch (IOException e) {
      System.out.println("error while reading");
    }

    words.keySet().stream()
        .filter(word -> words.get(word) != null)
        .sorted(Comparator.comparingInt(words::get))
        .forEach(x -> System.out.println(x + ": "+ words.get(x)));
  }

  public static boolean containsKeyIgnoreCase(Set<String> set, String key) {
    for (String k : set)
      if (key.equalsIgnoreCase(k))
        return true;
    return false;
  }
}
