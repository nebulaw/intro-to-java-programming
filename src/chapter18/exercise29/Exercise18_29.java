package chapter18.exercise29;

import java.io.File;
import java.util.Scanner;

public class Exercise18_29 {

    public static int countFiles(File file) {
        int count = 0;

        if (file.isDirectory() && file.listFiles() != null)
            for (File f : file.listFiles())
                count += countFiles(f);
        else
            count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a directory or a file: ");
        String dirPath = in.next();

        System.out.println(countFiles(new File(dirPath)) + " files");
    }
}
