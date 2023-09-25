package chapter17.exercise19;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Exercise17_19 {
  public static void main(String[] args) {
    File file = new File("data/chapter17/source1.txt");

    try (
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))
    ) {
      int byteValue;
      while ((byteValue = in.read()) != -1) {
        String hexValue = String.format("%X", byteValue);
        System.out.print(hexValue + " ");
      }
    } catch (IOException ignored) {}

  }
}
