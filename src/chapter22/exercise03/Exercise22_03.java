package chapter22.exercise03;

import java.util.Scanner;

public class Exercise22_03 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter two words: ");
    String w1 = in.next();
    String w2 = in.next();

    System.out.println("They match at " + match(w1, w2));
  }

  public static int match(String s1, String s2) {
    for (int i = 0; i < s1.length(); i++)
      if (s1.charAt(i) == s2.charAt(0)) {
        String substring = s1.substring(i, i + s2.length());
        if (substring.equals(s2))
          return i;
      }
    return -1;
  }
}
