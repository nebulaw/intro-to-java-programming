package chapter12.exercise26;

import java.io.File;
import java.util.Scanner;

public class MkDirs {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter directory name: ");
    String userDir = scanner.next();

    File dir = new File(userDir);
    if (dir.exists()) {
      System.out.println(dir.getName() + " already exists.");
      System.exit(0);
    }
    if (dir.mkdirs()) {
      System.out.println(dir.getName() + " was created");
    } else {
      System.out.println(dir.getName() + " was not created");
    }

  }
}
