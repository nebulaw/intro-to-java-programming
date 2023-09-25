package chapter21.exercise05;

import util.Pair;

import java.io.*;
import java.util.*;

/**
 * keyword
 * */

public class Exercise21_05 {
  private static final String CSS_COLOR_NAVY = "color: navy;";
  private static final String CSS_COLOR_GREEN = "color: green;";
  private static final String CSS_COLOR_BLUE = "color: blue";
  private static final String CSS_FONT_WEIGHT_700 = "font-weight: 700;";
  private static final HashSet<String> keywords = new HashSet<>(List.of(
      "abstract", "assert", "boolean",
      "break", "byte", "case", "catch", "char", "class", "const",
      "continue", "default", "do", "double", "else", "enum",
      "extends", "for", "final", "finally", "float", "goto",
      "if", "implements", "import", "instanceof", "int",
      "interface", "long", "native", "new", "package", "private",
      "protected", "public", "return", "short", "static",
      "strictfp", "super", "switch", "synchronized", "this",
      "throw", "throws", "transient", "try", "void", "volatile",
      "while", "true", "false", "null"
  ));

  public static void main(String[] args) {
//    if (args.length != 2)
//      exitWithMessage("usage: java source.java target.html", 1);
//
//    File sourceFile = new File(args[0]);
//    if (!sourceFile.exists())
//      exitWithMessage(sourceFile + " was not found", 1);
//    if (sourceFile.isDirectory())
//      exitWithMessage(sourceFile + " is a directory", 1);
//
//    File targetFile = new File(args[1]);
//    if (targetFile.exists())
//      exitWithMessage(targetFile + " already exists", 1);

    File sourceFile = new File("srcDirectory/chapter1/Class1.java");
    File targetFile = new File("srcDirectory/chapter1/Class1.html");

    // we take source file and produce stylized source code
    ArrayList<String> sourceCode = processSourceFile(sourceFile);

    // then make html page out of it that just inserts source
    // code into a base html template
    ArrayList<String> html = createHTMLTemplate(sourceCode);

    // write html into the target file
    writeHTML(targetFile, html);
  }

  public static void writeHTML(File targetFile, ArrayList<String> html) {
    try (
        PrintWriter out = new PrintWriter(targetFile);
    ) {
      for (String line : html)
        out.println(line);
    } catch (IOException e) {
      System.out.println("error while writing the file.");
    }
  }

  public static ArrayList<String> processSourceFile(File sourceFile) {
    ArrayList<String> sourceCode = new ArrayList<>();

    // read source file
    try (
        Scanner in = new Scanner(sourceFile)
    ) {
      boolean comment = false;
      while (in.hasNextLine()) {
        String line = stylizeLine(in.nextLine());
        System.out.println(line);
        sourceCode.add(line);
      }

    } catch (IOException e) {
      System.out.println("error while reading file");
    }

    // generate html
    return sourceCode;
  }

  private static String stylizeLine(String line) {
    for (String kw : keywords)
      line = line.replaceAll(kw + "[ |(]", "<span class=\"keyword\">$0</span>");
    return line;
  }

  public static ArrayList<String> createHTMLTemplate(ArrayList<String> sourceCode) {
    ArrayList<String> html = new ArrayList<>();
    html.addAll(templateStart());
    html.addAll(sourceCode);
    html.addAll(templateEnd());
    return html;
  }

  public static ArrayList<String> templateStart() {
    return new ArrayList<>(List.of(
        "<!DOCTYPE html>",
        "<html>",
        "<head>",
        "<style>",
        ".keyword { color: navy; font-weight: 800; }",
        ".comment { color: green; }",
        ".literal { color: blue; }",
        "</style>",
        "</head>",
        "<body>",
        "<code>",
        "<pre>"
    ));
  }

  public static ArrayList<String> templateEnd() {
    return new ArrayList<>(List.of(
        "</pre>",
        "</code>",
        "</body>",
        "</html>"
    ));
  }

  public static String stylizeKeyword(String keyword) {
    return "<span class=\"keyword\">" + keyword + "</span>";
  }

  public static String stylizeComment(String comment) {
    return "<span class=\"comment\">" + comment + "</span>";
  }

  public static String stylizeLiteral(String literal) {
    return "<span class=\"literal\">" + literal + "</span>";
  }

  public static void exitWithMessage(String message, int status) {
    System.out.println(message);
    System.exit(status);
  }

}
