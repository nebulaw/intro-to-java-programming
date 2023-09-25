package chapter17.exercise12;

import java.io.*;
import java.util.Scanner;

public class Exercise17_12 {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: java source1 source2 ... target");
      System.exit(-1);
    }

    File[] sources = new File[args.length - 1];
    for (int i = 0; i < sources.length; i++)
      sources[i] = new File(args[i]);
    File target = new File(args[args.length - 1]);

    // validate source files
    for (File file : sources)
      if (!file.exists()) {
        System.out.println(file.getName() + " was not found");
        System.exit(-1);
      }

    try (
      FileOutputStream out = new FileOutputStream(target);
    ) {
      for (File file : sources) {
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        try {
          out.write(in.readAllBytes());
        } catch (EOFException ignored) {}
        in.close();
      }
    } catch (IOException e) {
      System.out.println("errorrrrr");
    }

    // see what we have written
    try {
      Scanner in = new Scanner(target);
      while (in.hasNextLine())
        System.out.println(in.nextLine());
      in.close();
    } catch (IOException ignored) {}

  }
}
