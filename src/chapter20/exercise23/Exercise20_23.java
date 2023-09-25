package chapter20.exercise23;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Exercise20_23 {
    public static void main(String[] args) {
        System.out.print("Tokens:");
        System.out.println(infixToPostfix("4.5 % 3 ^ 1 * 7 + 90"));
    }

    public static String infixToPostfix(String expression) {
        ArrayList<String> tokens = tokenize(expression);
        ArrayList<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (!isOp(token)) {
                postfix.add(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("("))
                    postfix.add(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek()))
                    postfix.add(stack.pop());
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) {
                System.out.println("invalid syntax");
                System.exit(-1);
            }
            postfix.add(stack.pop());
        }

        return postfix.stream().filter(Objects::nonNull).reduce("", (rest, tok) -> rest + " " + tok);
    }

    public static int precedence(String op) {
        return switch (op) {
            case "^" -> 4;
            case "%", "/", "*" -> 3;
            case "+", "-" -> 2;
            default -> 1;
        };
    }

    public static boolean isOp(String str) {
        if (str.isEmpty())
            return false;
        return str.length() == 1 && isOp(str.charAt(0));
    }

    public static boolean isOp(char ch) {
        return ch == '+' || ch == '*' || ch == '/' || ch == '-' || ch == '%' || ch == '^';
    }

    public static ArrayList<String> tokenize(String expression) {
        ArrayList<String> tokens = new ArrayList<>();
        int l = expression.length();
        char[] expr = expression.toCharArray();
        for (int i = 0; i < l;)
            if (isOp(expr[i])) {
                tokens.add("" + expr[i++]);
            } else if (expr[i] == ' ') {
                i++;
            } else if (Character.isDigit(expr[i])) {
                String num = "";
                while (i < l && Character.isDigit(expr[i])) num += expr[i++];
                if (i == l) {
                    tokens.add(num);
                    continue;
                }
                if (expression.charAt(i) == '.')
                    num += expression.charAt(i++);
                while (i < l && Character.isDigit(expr[i])) num += expr[i++];
                tokens.add(num);
            } else if (expr[i] == '(' || expr[i] == ')') {
                tokens.add("" + expr[i++]);
            } else {
                System.out.println("invalid token: " + expr[i]);
                System.exit(-1);
            }
        return tokens;
    }
}
