package chapter21.exercise06;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * count the occurrences of numbers entered
 * */

public class Exercise21_06 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter a file: ");
    String filePath = in.next();
    System.out.print("Enter numbers: ");
    Set<String> nums = new HashSet<>();
    String num;
    while (!(num = in.next()).equals("0"))
      nums.add(num);

    displayCounts(new File(filePath), nums);
  }

  public static void displayCounts(File file, Set<String> nums) {
    Map<String, Integer> counts = new HashMap<>();
    for (String num : nums)
      counts.put(num, 0);

    try (Scanner in = new Scanner(file)) {
      while (in.hasNext()) {
        String num = in.next();
        if (nums.contains(num))
          counts.put(num, counts.get(num) + 1);
      }
    } catch (IOException e) {
      System.out.println("error while reading");
    }

    for (String num : nums)
      System.out.println(num + ": " + counts.get(num));
  }
}
