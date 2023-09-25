package chapter12.exercise06_10;

import java.util.ArrayList;

public class OutOfMemory {
  public static void main(String[] args) {
    ArrayList<String> strs = new ArrayList<>();
    try {
      while (true) {
        for (int i = 0; i < 100; i++)
          strs.add("CAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAT");
      }
    } catch (OutOfMemoryError e) {
      System.out.println("jvm can't handle out of memory error, but i do");
    }

  }
}
