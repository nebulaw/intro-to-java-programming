package chapter10.exercise25;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static String[] split(String s, String regex) {
    ArrayList<String> tokens = new ArrayList<>();
    // regex approach is fine
    Matcher matcher = Pattern.compile(regex).matcher(s);

    int i = 0;
    // loop until s satisfies regex condition
    while (matcher.find()) {
      int j = matcher.end();
      // if first and last index does not overlap then add tokens
      if (i < j) {
        String tok = s.substring(i, j - 1);
        if (tok != "") tokens.add(tok);
      }
      i = j;
    }
    // add last token
    if (i < s.length()) tokens.add(s.substring(i));
    return tokens.toArray(new String[0]);
  }

  public static void main(String[] args) {
    String[] tokens = split("Karlo/,24,2004", "[/,]");
    for (String token : tokens)
      System.out.print(token + " ");
    System.out.println();
  }

}
