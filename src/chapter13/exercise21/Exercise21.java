package chapter13.exercise21;

import chapter13.exercise14.Rational;

import java.util.Scanner;

/**
 * (Algebra: vertex form equations) The equation of a parabola can be expressed
 * in either standard form (y = ax2 + bx + c) or vertex form (y = a(x - h)2 + k).
 * Write a program that prompts the user to enter a, b, and c as integers in standard
 * form and displays h and k in the vertex form.
 * */

public class Exercise21 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter a, b, c: ");
    Rational a = new Rational(in.nextLong(), 1);
    Rational b = new Rational(in.nextLong(), 1);
    Rational c = new Rational(in.nextLong(), 1);

    Rational h = new Rational(-b.getNumerator(), 2 * a.getNumerator());
    Rational k = a.multiply(h.multiply(h)).add(b.multiply(h)).add(c);

    System.out.println("h is " + h + " and k is " + k);
  }
}
