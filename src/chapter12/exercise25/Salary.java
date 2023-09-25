package chapter12.exercise25;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        String path = "http://cs.armstrong.edu/liang/data/Salary.txt";
        // first_name last_name rank salary
        ArrayList<Integer> assistants = new ArrayList<>();
        ArrayList<Integer> associate = new ArrayList<>();
        ArrayList<Integer> full = new ArrayList<>();

        try (Scanner in = new Scanner(URI.create(path).toURL().openStream())) {
            while (in.hasNextLine()) {
                String faculty = in.next();
                // we do not care about lastName and rank, so skip them
                in.next(); in.next();
                int salary = in.nextInt();
                switch (faculty) {
                    case "assistant" -> assistants.add(salary);
                    case "associate" -> associate.add(salary);
                    case "full" -> full.add(salary);
                    default -> System.out.println("skipping non faculty member " + faculty);
                }
            }
        } catch (IOException e) {
            System.out.println("error while reading path: " + path);
        }

        System.out.println("Assistant professors' average salary: " + averageOf(assistants));
        System.out.println("Associate professors' average salary: " + averageOf(associate));
        System.out.println("Full professors' average salary: " + averageOf(full));
    }

    private static int averageOf(List<Integer> list) {
        long sum = 0;
        for (int n : list)
            sum += n;
        return (int)(sum / list.size());
    }
}
