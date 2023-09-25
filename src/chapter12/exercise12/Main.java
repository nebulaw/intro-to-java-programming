package chapter12.exercise12;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * (Reformat Java source code) Write a program that converts the Java source
 * code from the next-line brace style to the end-of-line brace style. For example,
 * the following Java source in (a) uses the next-lin
 *
 * (a)
 * public class Test
 * {
 *    public static void main(String[] args)
 *    {
 *
 *    }
 * }
 *
 * (b)
 * public class Test {
 *    public static void main(String[] args) {
 *    // Some statements
 *    }
 * }
 *
 *
 */


public class Main {
  private static final int MAX_LINES = 1000;

  public static void main(String[] args) {

    if (args.length != 1) {
      System.out.println("invalid number of arguments");
      System.exit(-1);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println("file was not found.");
      System.exit(0);
    }

    String[] lines = new String[MAX_LINES];
    String line;
    int i = 0;

    try (
      BufferedReader in = new BufferedReader(new FileReader(file));
    ) {
      while ((line = in.readLine()) != null) {
        Matcher matcher = Pattern.compile(".*\\{.*").matcher(line);
        if (matcher.find())
          lines[i - 1] += " {";
        else lines[i++] = line;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (
      PrintWriter out = new PrintWriter(new FileOutputStream(file), true);
    ) {
      for (int j = 0; j < i; j++)
        out.println(lines[j]);
    } catch (IOException e) {
      System.out.println("error while writing file");
    }

  }
}
