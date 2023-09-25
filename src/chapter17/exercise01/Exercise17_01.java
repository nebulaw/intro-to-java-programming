package chapter17.exercise01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise17_01 {
  public static void main(String[] args) {
    final String filepath = "data/chapter17/Exercise17_01.txt";

    try (PrintWriter out = new PrintWriter(new FileOutputStream(filepath, true), true)) {
      for (int i = 0; i < 100; i++)
        out.print((int)(Math.random() * 100) + " ");
    } catch (IOException ignored) {}

  }
}

