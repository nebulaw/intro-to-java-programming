package chapter12.exercise24;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * (Create large dataset) Create a data file with 1,000 lines. Each line in the file
 * consists of a faculty member’s first name, last name, rank, and salary. The
 * faculty member’s first name and last name for the ith line are FirstNameI and
 * LastNameI. The rank is randomly generated as assistant, associate, and full.
 * The salary is randomly generated as a number with two digits after the decimal
 * point. The salary for an assistant professor should be in the range from 50,000
 * to 80,000, for associate professor from 60,000 to 110,000, and for full professor
 * from 75,000 to 130,000. Save the file in Salary.txt. Here are some sample data:
 * FirstName1 LastName1 assistant 60055.95
 * FirstName2 LastName2 associate 81112.45
 * ...
 * FirstName1000 LastName1000 full 92255.21
 * */

public class LargeData {

  public static void main(String[] args) {
    String[] ranks = { "Assistant", "Associate", "Full" };
    double[][] brackets = {
      { 50000, 80000  },
      { 60000, 110000 },
      { 75000, 130000 },
    };

    File file = new File("data/chapter12/faculty.txt");
    if (!file.exists())
      try {
        if (file.createNewFile())
          System.out.println("new file created.");
        else
          System.out.println("file not created.");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

    try (
      PrintWriter out = new PrintWriter(new FileOutputStream(file), true);
    ) {
      for (int i = 1; i <= 1000; i++) {
        out.print("FirstName" + i + " ");
        out.print("LastName" + i + " ");
        int status = (int)(Math.round(Math.random() * 2));
        out.print(ranks[status] + " ");
        double salary = brackets[status][0] + Math.random() * brackets[status][1];
        out.println(salary);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
