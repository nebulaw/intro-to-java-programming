package chapter20.exercise11;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Exercise20_11 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java source-file");
      System.exit(1);
    }

    File file = new File(args[0]);
    if (!file.exists()) {
      System.out.println(file + " not found");
      System.exit(1);
    } else if (file.isDirectory()) {
      System.out.println(file + " is a directory");
      System.exit(1);
    }

    Stack<Character> pairs = new Stack<>();

    try (
        FileReader reader = new FileReader(file);
    ) {
      int ch;
      while ((ch = reader.read()) != -1) {
        if (ch == '{' || ch == '[' || ch == '(')
          pairs.add((char) ch);
        else if (ch == '}' || ch == ']' || ch == ')')
          if (!pairs.isEmpty() && pairs.pop() != getMatch((char) ch)) {
            System.out.println("syntax error in source file");
            System.exit(0);
          }
      }
      if (!pairs.isEmpty())
        System.out.println("syntax error in source file");
      else
        System.out.println("source file has no syntax error");
    } catch (IOException e) {
      System.out.println("error while reading file");
      System.exit(-1);
    }
  }

  public static Character getMatch(Character ch) {
    return switch (ch) {
      case '}' -> '{';
      case ']' -> '[';
      case ')' -> '(';
      default -> '\0';
    };
  }
}
