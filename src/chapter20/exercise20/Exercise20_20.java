package chapter20.exercise20;

import java.io.File;
import java.util.*;

public class Exercise20_20 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a directory: ");
    System.out.println("Size: " + getSize(new File(in.next())));
  }

  public static long getSize(File directory) {
    long size = 0L;
    Stack<File> dirs = new Stack<>();
    dirs.add(directory);
    while (!dirs.isEmpty()) {
      File f = dirs.pop();
      if (f.isFile())
        size += f.length();
      else
        dirs.addAll(Arrays.asList(f.listFiles()));
    }
    return size;
  }

}
