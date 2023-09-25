package chapter20.exercise18;

import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exercise20_18 {
  public static void main(String[] args) {
    String directoryPath = "data/";
    File dir = new File(directoryPath);
    System.out.println("Directory size is " + getSize(dir));
  }

  public static long getSize(File directory) {
    long size = 0L;
    Queue<File> dirs = new PriorityQueue<>();
    dirs.add(directory);
    while (!dirs.isEmpty()) {
      File file = dirs.poll();
      if (file.isFile())
        size += file.length();
      else
        dirs.addAll(Arrays.asList(file.listFiles()));
    }
    return size;
  }

}
