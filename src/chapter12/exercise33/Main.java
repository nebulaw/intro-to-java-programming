package chapter12.exercise33;

import java.io.IOException;
import java.net.URI;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = in.nextLine();
        crawler(url);
    }

    public static void crawler(String startingURL) {
        Queue<String> queueOfPendingURLs = new PriorityQueue<>();
        Set<String> traversedURLs = new HashSet<>();
        queueOfPendingURLs.add(startingURL);

        while (!queueOfPendingURLs.isEmpty() && traversedURLs.size() <= 100) {
            String urlString = queueOfPendingURLs.poll();
            if (!traversedURLs.contains(urlString)) {
                traversedURLs.add(urlString);
                System.out.println("Craw " + urlString);

                for (String s : getSubURLs(urlString)) {
                    if (!traversedURLs.contains(s))
                        queueOfPendingURLs.offer(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();
        try {
            URI uri = URI.create(urlString);
            Scanner in = new Scanner(uri.toURL().openStream());
            int current = 0;
            while (in.hasNext()) {
                String line = in.nextLine();
                current = line.indexOf("https:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) {
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("https:", endIndex);
                    } else current = -1;
                }
            }
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return list;
    }
}
