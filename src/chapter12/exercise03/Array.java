package chapter12.exercise03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Array {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] numbers = new int[100];

    for (int i = 0; i < 100; i++)
      numbers[i] = (int)(Math.random() * 100);

    try {
      int n = scanner.nextInt();
      System.out.println("You reached " + numbers[n]);
    } catch (InputMismatchException e) {
      System.out.println("invalid value ");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("invalid index ");
    }


  }
}
