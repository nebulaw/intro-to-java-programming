package chapter17.exercise02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_02 {
  public static void main(String[] args) {
    final String filepath = "data/chapter17/Exercise17_02.dat";

    try (
      DataOutputStream out = new DataOutputStream(
        new FileOutputStream(filepath, true));
    ) {
      for (int i = 0; i < 100; i++)
        out.writeInt((int)(Math.random() * 100));
    } catch (IOException e) {
      // ignored
    }
  }
}
