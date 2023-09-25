package chapter11.exercise16;

import chapter10.util.Stack;

import java.util.Scanner;

public class RepeatAddition {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int lhs = 1 + (int)(Math.random() * 10);
    int rhs = 1 + (int)(Math.random() * 10);
    int res = lhs + rhs;

    System.out.print("What is " + lhs + " + " + rhs + "? ");
    int answer = scanner.nextInt();

    Stack answers = new Stack();
    answers.push(answer);

    while (answer != res) {
      System.out.print("Wrong answer. Try again. What is " + lhs + " + " + rhs + "? ");
      answer = scanner.nextInt();

      if (!answers.contains(answer))
        answers.push(answer);
      else
        System.out.println("you already have entered " + answer);
    }

    System.out.println("You got it!");

  }

}