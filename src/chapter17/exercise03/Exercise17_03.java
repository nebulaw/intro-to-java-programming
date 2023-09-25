package chapter17.exercise03;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Exercise17_03 {
  public static void main(String[] args) {
    int sum = 0;
    final String filepath = "data/chapter17/Exercise17_02.dat";

    try (
      DataInputStream in = new DataInputStream(new FileInputStream(filepath))
    ) {
      while (true)
        sum += in.readInt();
    } catch (EOFException e) {
      // do nothing
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("sum is " + sum);
  }
}
