package chapter13.exercise01;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        final String relativeParentPath = "src/chapter17/";

        File dir = new File(relativeParentPath);
        for (int i = 1; i <= 19; i++) {
            File pkg = new File(relativeParentPath + String.format("exercise%s%d", i < 10 ? "0" : "", i));
            if (pkg.mkdir())
                System.out.println(pkg + " created.");
        }

    }
}
