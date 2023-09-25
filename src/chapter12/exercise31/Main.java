package chapter12.exercise31;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // main prompt
        System.out.print("Enter the year: ");
        String year = scanner.next();

        System.out.print("Enter the gender: ");
        String gender = scanner.next();
        if (!gender.equals("M") && !gender.equals("F")) {
            System.out.println("Invalid gender");
            System.exit(1);
        }

        System.out.print("Enter the name: ");
        String name = scanner.next();


        boolean found = false;
        // fetch data
        String parentPath = "https://raw.githubusercontent.com/transteph/java-exercises/master/BabyNamesRanking/";
        // retrieve the information
        URI uri = URI.create(parentPath + String.format("babynamesranking%s.txt", year));
        try (Scanner in = new Scanner(uri.toURL().openStream())) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] tokens = line.split("\t");
                // if data is correct
                if (line.contains(name)) {
                    System.out.printf("%s is ranked #%s in year %s\n", name, tokens[0].trim(), year);
                    found = true;
                    break;
                } else {
                    System.out.println("skipping non-valid line: " + line);
                }
            }
            if (!found)
                System.out.println(name + " is not listed in year " + year);
        } catch (IOException e) {
            System.out.println(year + " is not listed.");
        }
    }
}
