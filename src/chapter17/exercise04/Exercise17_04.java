package chapter17.exercise04;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise17_04 {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java source target");
      System.exit(-1);
    }

    File source = new File(args[0]);
    File target = new File(args[1]);
    if (!source.exists()) {
      System.out.println(source + " not found.");
      System.exit(-1);
    }
    if (target.exists()) {
      System.out.println(target + " exists");
      System.exit(-1);
    }

    try (
      Scanner in = new Scanner(source);
      DataOutputStream out = new DataOutputStream(new FileOutputStream(target));
    ) {
      // read text
      while (in.hasNextLine()) {
        String line = in.nextLine();
        out.writeUTF(line + "\n");
      }
      System.out.println("success");
    } catch (IOException e) {
      // ignored
    }

  }
}
