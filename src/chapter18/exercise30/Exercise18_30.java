package chapter18.exercise30;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise18_30 {

    public static int countWordInFile(File file, String targetWord) {
        int count = 0;
        try (Scanner in = new Scanner(new FileInputStream(file))) {
            while (in.hasNextLine()) {
                Matcher matcher = Pattern.compile(targetWord).matcher(in.nextLine());
                while (matcher.find())
                    count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int countWordInDir(File file, String targetWord) {
        int count = 0;

        if (file.isDirectory() && file.listFiles() != null) {
            for (File f : file.listFiles())
                count += countWordInDir(f, targetWord);
        } else {
            count += countWordInFile(file, targetWord);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a directory or a file: ");
        String dirPath = in.next();
        System.out.print("Enter a target word: ");
        String targetWord = in.next();

        System.out.println(countWordInDir(new File(dirPath), targetWord) + " occurrences");
    }
}
