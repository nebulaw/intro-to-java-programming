package chapter12.exercise32;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String parentPath = "https://raw.githubusercontent.com/transteph/java-exercises/master/BabyNamesRanking/";

        System.out.printf("|%-6s|%-12s|%-12s|%-12s|%-12s|%-12s|%-12s|%-12s|%-12s|%-12s|%-12s|\n",
                "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");
        System.out.print(  "------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");

        Queue<String> boysNames = new LinkedList<>();
        Queue<String> girlNames = new LinkedList<>();

        for (int i = 2010; i >= 2001; i--) {
            URI uri = URI.create(parentPath + String.format("babynamesranking%d.txt", i));

            // process information
            try (Scanner in = new Scanner(uri.toURL().openStream())) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] tokens = line.split("\t");
                    if (tokens.length == 5) {
                        boysNames.offer(tokens[1]);
                        girlNames.offer(tokens[3]);
                    } else {
                        System.out.println("invalid line: " + line);
                    }
                    if (boysNames.size() == 5) break;
                }
            } catch (IOException e) {
                System.out.println("error while fetching year " + i);
                System.out.println("thus skipping.");
            }

            System.out.printf("|%-6d|", i);
            while (!girlNames.isEmpty())
                System.out.printf("%-12s|", girlNames.poll());
            while (!boysNames.isEmpty())
                System.out.printf("%-12s|", boysNames.poll());
            System.out.println();
        }

        System.out.print(  "------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
    }
}
