package chapter17.exercise17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.io.*;

public class Exercise17_17 {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/chapter17/Exercise17_17.dat");
    try (
      BitOutputStream out = new BitOutputStream(file);
    ) {
      out.writeBit("010000100100001001101");
    } catch (IOException e) {
      // ignored
    }

    // now read what we have written
    Scanner in = new Scanner(file);
    System.out.println(in.next());
  }
}
