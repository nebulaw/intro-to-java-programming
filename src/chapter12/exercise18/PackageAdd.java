package chapter12.exercise18;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Add package statement) Suppose you have Java source files under the direc-
 * tories chapter1, chapter2, . . . , chapter34. Write a program to insert the
 * statement package chapteri; as the first line for each Java source file under
 * the directory chapteri. Suppose chapter1, chapter2, . . . , chapter34
 * are under the root directory srcRootDirectory. The root directory and
 * chapteri directory may contain other folders and files. Use the following
 * command to run the program:
 * java Exercise12_18 srcRootDirectory
 * */

public class PackageAdd {

  public static void addPackageStatement(File file) {
    ArrayList<String> lines = new ArrayList<>();
    String packageStmt = "package " + file.getParentFile().getName() + ";";
    lines.add(packageStmt);

    // First read if it's requires to add package
    try (
      Scanner in = new Scanner(file);
    ) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        Matcher matcher = Pattern.compile(packageStmt + ".*").matcher(line);
        if (matcher.find()) {
          System.gc();
          return;
        }
        lines.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // if program reached there, then we add package statement
    try (
      PrintWriter out = new PrintWriter(new FileOutputStream(file), true);
    ) {
      for (String line : lines)
        out.println(line);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void addPackageStatements(File srcDir) {
    File[] files = srcDir.listFiles();
    if (files == null) return;

    for (File file : files)
      if (file.isDirectory())
        addPackageStatements(file);
      else
        addPackageStatement(file);

  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("invalid number of arguments");
      System.exit(-1);
    }

    File srcDir = new File(args[0]);
    if (!srcDir.exists()) {
      System.out.println(srcDir.getName() + " was not found.");
      System.exit(-1);
    }

    if (!srcDir.isDirectory()) {
      System.out.println(srcDir.getName() + " is not directory.");
      System.exit(-1);
    }


    addPackageStatements(srcDir);
    System.out.println("successfully added");

  }
}
