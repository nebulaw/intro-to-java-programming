package chapter20.exercise14;

import java.util.Stack;

public class Exercise20_14 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java expression");
      System.exit(1);
    }

    Stack<Double> stack = new Stack<>();
    String[] expr = args[0].split(" ");
    double result = 0.0;

    for (String token : expr) {
      if (isNumber(token))
        stack.push(Double.parseDouble(token));
      else if (stack.size() < 2) {
        System.out.println("syntax error");
        System.exit(1);
      } else {
        switch (token) {
          case "+" -> stack.push(stack.pop() + stack.pop());
          case "-" -> stack.push(-stack.pop() + stack.pop());
          case "*" -> stack.push(stack.pop() * stack.pop());
          case "/" -> stack.push(1/stack.pop() * stack.pop());
          default -> {
            System.out.println("invalid token: " + token);
            System.exit(1);
          }
        }
      }
    }

    System.out.println("result: " + stack.pop());

  }

  public static boolean isNumber(String token) {
    try {
      double number = Double.parseDouble(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
