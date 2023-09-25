package chapter21.exercise10;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * counting keywords in a java source file
 * */

public class Exercise21_10 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("enter a file: ");
    String filePath = in.next();

    displayKeywordCount(new File(filePath));
  }

  public static void displayKeywordCount(File file) {

    String[] keywordString = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static",
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};
    Map<String, Integer> keywords = new HashMap<>();
    for (String keyword : keywordString)
      keywords.put(keyword, 0);
    boolean multiLineComment = false;

    try (Scanner in = new Scanner(file)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        // handle comments
        Matcher matcherOneLine = Pattern.compile("^//.*").matcher(line);
        Matcher matcherMultiLineStart = Pattern.compile(".*/\\*+.*").matcher(line);
        Matcher matcherMultiLineEnd = Pattern.compile(".*\\*/.*").matcher(line);
        if (matcherOneLine.find()) continue;
        if (matcherMultiLineStart.find()) multiLineComment = true;
        if (matcherMultiLineEnd.find()) multiLineComment = false;
        if (multiLineComment) continue;
        Scanner lineScanner = new Scanner(line);
        while (lineScanner.hasNext()) {
          String keyword  = lineScanner.next();
          if (keywords.containsKey(keyword))
            keywords.put(keyword, keywords.get(keyword) + 1);
        }
      }
    } catch (IOException e) {
      System.out.println("error while reading file");
    }

    keywords.keySet().stream()
        .sorted(Comparator.comparingInt(keywords::get))
        .forEach(x -> System.out.printf("%-12s:\t%d\n", x, keywords.get(x)));
  }
}
