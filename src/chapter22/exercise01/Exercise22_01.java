package chapter22.exercise01;

import java.util.Scanner;

/**
 * maximum consecutive increasingly ordered substring
 */
public class Exercise22_01 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter the word: ");
    String word = in.next();

    System.out.println(maxIncSubstring(word));
  }

  public static String maxIncSubstring(String word) {
    String maxSubstring = "";
    int j = 0;
    for (int i = 1; i < word.length(); i++) {
      String nextSubstring =  word.substring(j, i);
      if (isOrderedString(nextSubstring)) {
        if (maxSubstring.length() < nextSubstring.length())
          maxSubstring = nextSubstring;
      } else j++;
    }
    return maxSubstring;
  }

  private static boolean isOrderedString(String nextSubstring) {
    char[] chars = nextSubstring.toCharArray();
    for (int i = chars.length - 1; i > 0; i--)
      if (chars[i] < chars[i-1]) return false;
    return true;
  }
}
