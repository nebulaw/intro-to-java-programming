package chapter21.exercise15;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise21_15 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int lhs = 1 + (int)(Math.random() * 10);
    int rhs = 1 + (int)(Math.random() * 10);
    int res = lhs + rhs;

    System.out.print("What is " + lhs + " + " + rhs + "? ");
    int answer = scanner.nextInt();

    Set<Integer> answers = new HashSet<>();
    answers.add(answer);

    while (answer != res) {
      System.out.print("Wrong answer. Try again. What is " + lhs + " + " + rhs + "? ");
      answer = scanner.nextInt();

      if (!answers.contains(answer))
        answers.add(answer);
      else
        System.out.println("you already have entered " + answer);
    }

    System.out.println("You got it!");

  }

}
