package chapter12.exercise29;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RenameFile {
  public static void renameFile(File file) throws IOException {
    String fileName = file.getName();
    String filePath = file.getPath().replace(fileName, "");
    Matcher matcher = Pattern.compile("Exercise(\\d)_(\\d+).java$").matcher(fileName);
    if (matcher.find()) {
      fileName = matcher.replaceAll("Exercise0$1_$2.java");
      if (file.renameTo(new File(filePath + fileName)))
        System.out.println("renamed to " + filePath + fileName);
    }
  }

  public static void renameInDir(File dir) throws IOException {
    File[] files = dir.listFiles();
    if (files == null)
      return;
    for (File file : files)
      if (file.isFile())
        renameFile(file);
  }


  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("please specify directory");
      System.exit(-1);
    }

    File path = args[0].equals("*") ? new File("./") : new File(args[0]);
    if (!path.exists()) {
      System.out.println(path.getName() + " does not exist.");
      System.exit(-1);
    }

    if (path.isDirectory()) {
      renameInDir(path);
    }


  }
}
