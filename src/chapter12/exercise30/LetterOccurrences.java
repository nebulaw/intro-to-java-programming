package chapter12.exercise30;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LetterOccurrences {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("provide 1 argument only bro");
      System.exit(-1);
    }

    File file = new File(args[0]);
    if (!file.exists()) {
      System.out.println(file.getName() + " does not exist.");
      System.exit(-1);
    }

    int[] occurrences = new int[256];
    try (Scanner in = new Scanner(file);) {
      // count occurrences;
      while (in.hasNextLine()) {
        String line = in.nextLine();
        for (char c : line.toCharArray())
          occurrences[c]++;
      }
      // display
      for (int i = 0; i < occurrences.length; i++)
        if (Character.isLetter((char)i) && occurrences[i] > 0)
          System.out.printf("Number of %c's: %d\n", (char)i, occurrences[i]);
    } catch (IOException e) {
      // ignored
    }

  }
}
