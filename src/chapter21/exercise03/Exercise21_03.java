package chapter21.exercise03;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * counting keywords in a java source file
 * */

public class Exercise21_03 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("usage: java sourceFile");
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

    System.out.println("Keywords: " + countKeywordsInFile(file));
  }

  public static int countKeywordsInFile(File file) {
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
    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;
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
        while (lineScanner.hasNext())
          if (keywordSet.contains(lineScanner.next()))
            count++;
      }
    } catch (IOException e) {
      System.out.println("error while reading file");
    }
    return count;
  }
}
