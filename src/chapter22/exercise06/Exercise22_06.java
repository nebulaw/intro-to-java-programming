package chapter22.exercise06;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise22_06 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("        |        40        41        42        43        44        45");
    System.out.println("--------|--------------------------------------------------------------");

    ArrayList<Integer> sequence = fibSequence();

    System.out.print("GCD     |");
    for (int i = 0; i < sequence.size() - 1; i++) {
      long timeStarted = System.currentTimeMillis();
      int gcd = GCD(sequence.get(i), sequence.get(i + 1));
      long timeEnded = System.currentTimeMillis();
      System.out.printf("%8dms", timeEnded - timeStarted);
    }
    System.out.println();

    System.out.print("GCDE    |");
    for (int i = 0; i < sequence.size() - 1; i++) {
      long timeStarted = System.currentTimeMillis();
      int gcd = GCDEuclid(sequence.get(i), sequence.get(i + 1));
      long timeEnded = System.currentTimeMillis();
      System.out.printf("%8dms", timeEnded - timeStarted);
    }
    System.out.println();
  }

  public static ArrayList<Integer> fibSequence() {
    ArrayList<Integer> numbers = new ArrayList<>();
    int f0 = 0, f1 = 1, f2 = 0;
    // skip 40 numbers
    for (int i = 2; i < 40; i++) {
      f2 = f0 + f1;
      f0 = f1;
      f1 = f2;
    }
    for (int i = 0; i < 7; i++) {
      f2 = f0 + f1;
      numbers.add(f2);
      f0 = f1;
      f1 = f2;
    }
    return numbers;
  }

  public static int GCD(int m, int n) {
    int gcd = 1;
    if (m % n == 0) return n;
    for (int k = n / 2; k >= 1; k--)
      if (m % k == 0 && n % k == 0) {
        gcd = k;
        break;
      }
    return gcd;
  }

  public static int GCDEuclid(int m, int n) {
    if (m % n == 0) return n;
    return GCDEuclid(n, m % n);
  }


}
