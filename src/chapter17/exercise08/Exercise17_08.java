package chapter17.exercise08;

import java.io.*;

public class Exercise17_08 {
  public static void main(String[] args) {

    int times = 0;
    // read to assure
    try (
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/chapter17/Exercise17_08.dat"));
    ) {
      times = in.readInt();
    } catch (IOException ignored) {
      System.exit(-1);
    }

    try (
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/chapter17/Exercise17_08.dat"));
    ) {
      out.writeInt(times + 1);
    } catch (IOException ignored) {}


    System.out.println("executed " + (times + 1) + " times");
  }
}
