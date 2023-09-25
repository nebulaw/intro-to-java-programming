package chapter18.exercise31;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Replace words in all the files under a directory
 * */

public class Exercise18_31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a directory or a file: ");
        String path = in.next();
        System.out.print("Enter old word: ");
        String oldWord = in.next();
        System.out.print("Enter new word: ");
        String newWord = in.next();

        replaceWordInDir(new File(path), oldWord, newWord);
    }

    public static void replaceWordInDir(File dir, String ow, String nw) {
        if (dir.isDirectory() && dir.listFiles() != null) {
            for (File file : dir.listFiles())
                replaceWordInDir(file, ow, nw);
        } else {
            replaceWordInFile(dir, ow, nw);
        }
    }

    public static void replaceWordInFile(File file, String ow, String nw) {
        ArrayList<String> lines = new ArrayList<>();
        try (
            Scanner in = new Scanner(new FileInputStream(file))
        ) {
            while (in.hasNextLine()) {
                Matcher matcher = Pattern.compile(ow).matcher(in.nextLine());
                lines.add(matcher.replaceAll(nw));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
            PrintWriter out = new PrintWriter(new FileOutputStream(file), true)
        ) {
            for (String line : lines)
                out.println(line);
        } catch (IOException e) { e.printStackTrace(); }
    }
}
