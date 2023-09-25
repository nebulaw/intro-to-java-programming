package chapter18.exercise28;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Exercise18_28 {
    public static long getSize(File file) {
        long size = 0;
        Stack<File> fileStack = new Stack<>();
        File fileCurrent;

        fileStack.push(file);
        while (!fileStack.isEmpty() && (fileCurrent = fileStack.pop()) != null)
            if (fileCurrent.isFile())
                size += fileCurrent.length();
            else {
                File[] files = fileCurrent.listFiles();
                if (files != null)
                    for (File f : files)
                        fileStack.push(f);
            }
        return size;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a directory or a file: ");
        String dirPath = in.next();

        System.out.println(getSize(new File(dirPath)) + " bytes");
    }
}
