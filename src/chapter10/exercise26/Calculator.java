package chapter10.exercise26;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  private static String[] tokenizeArg(String arg) {
    String[] tokens = new String[3];

    // replace all the chars
    arg = arg.replace(" ", "");
    // use matcher to tokenize
    Matcher matcher = Pattern.compile("[*/+-]").matcher(arg);

    int i = 0;
    if (matcher.find()) {
      int j = matcher.end();
      tokens[0] = arg.substring(i, j - 1);
      i = j;
      tokens[1] = matcher.group();
      tokens[2] = arg.substring(i);
    } else {
      System.out.println("Invalid operation");
    }

    return tokens;
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Error: expression is not provided.");
      return;
    }

    String[] tokens = tokenizeArg(args[0]);

    // we should get 3 tokens
    if (tokens.length != 3) {
      System.out.println("Error: invalid number of arguments.");
      return;
    }

    String invalidOperand = "";

    try {
      invalidOperand = tokens[0];
      int lhs = Integer.parseInt(tokens[0]);
      invalidOperand = tokens[2];
      int rhs = Integer.parseInt(tokens[2]);
      double result;

      switch (tokens[1]) {
        case "+" -> result = lhs + rhs;
        case "*" -> result = lhs * rhs;
        case "-" -> result = lhs - rhs;
        case "/" -> result = (double)lhs / rhs;
        default -> {
          System.out.println("Error: invalid operation '" + tokens[0] + "'.");
          return;
        }
      }
      System.out.println(lhs + " " + tokens[1] + " " + rhs + " = " + result);
    } catch (NumberFormatException e) {
      System.out.println("Error: invalid operand '" + invalidOperand + "'");
    }

  }
}
