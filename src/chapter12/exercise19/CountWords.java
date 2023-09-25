package chapter12.exercise19;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class CountWords {

  public static void main(String[] args) {
    URI uri = URI.create("https://raw.githubusercontent.com/itsfoss/text-files/master/agatha.txt");
    int count = 0;
    try {
      Scanner scanner = new Scanner(uri.toURL().openStream());
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        count += words.length;
      }
      System.out.println(count + " words have been counted so far.");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
