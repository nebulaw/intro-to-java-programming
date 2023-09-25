package chapter21.exercise12;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise21_12 {
    public static void main(String[] args) {
        final String parentPath = "https://raw.githubusercontent.com/transteph/java-exercises/master/BabyNamesRanking/";
        ArrayList<String> boyNames = new ArrayList<>(), girlNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a file name for baby name ranking: ");
        String fileName = scanner.next();

        String fileAbsPath = parentPath + fileName;
        URI uri = URI.create(fileAbsPath);

        try (Scanner in = new Scanner(uri.toURL().openStream())) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] tokens = line.split("\t");
                if (tokens.length != 5)
                    continue;
                boyNames.add(tokens[1].trim());
                girlNames.add(tokens[3].trim());
            }
        } catch (IOException e) {
            System.out.println("error while reading " + fileAbsPath);
        }

        // retainAll is a good solution
        int i = 1;
        boyNames.retainAll(girlNames);
        System.out.printf("%d names used for both genders\n", boyNames.size());
        for (String name : boyNames) {
            System.out.printf("%-12s ", name);
            if (i++ % 10 == 0)
                System.out.println();
        }


    }
}
