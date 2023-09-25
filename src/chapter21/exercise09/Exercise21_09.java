package chapter21.exercise09;

import util.Pair;

import java.util.*;

public class Exercise21_09 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Random random = new Random();
    Map<String, String> states = new HashMap<>();

    states.put("Alabama", "Montgomery");
    states.put("Alaska", "Juneau");
    states.put("Arizona", "Phoenix");
    states.put("Arkansas", "Little Rock");
    states.put("California", "Sacramento");
    states.put("Colorado", "Denver");
    states.put("Connecticut", "Hartford");
    states.put("Delaware", "Dover");
    states.put("Florida", "Tallahassee");
    states.put("Georgia", "Atlanta");
    states.put("Hawaii", "Honolulu");
    states.put("Idaho", "Boise");
    states.put("Illinois", "Springfield");
    states.put("Indiana", "Indianapolis");
    states.put("Iowa", "Des Moines");
    states.put("Kansas", "Topeka");
    states.put("Kentucky", "Frankfort");
    states.put("Louisiana", "Baton Rouge");
    states.put("Maine", "Augusta");
    states.put("Maryland", "Annapolis");
    states.put("Massachusetts", "Boston");
    states.put("Michigan", "Lansing");
    states.put("Minnesota", "St. Paul");
    states.put("Mississippi", "Jackson");
    states.put("Missouri", "Jefferson City");
    states.put("Montana", "Helena");
    states.put("Nebraska", "Lincoln");
    states.put("Nevada", "Carson City");
    states.put("New Hampshire", "Concord");
    states.put("New Jersey", "Trenton");
    states.put("New Mexico", "Santa Fe");
    states.put("New York", "Albany");
    states.put("North Carolina", "Raleigh");
    states.put("North Dakota", "Bismarck");
    states.put("Ohio", "Columbus");
    states.put("Oklahoma", "Oklahoma City");
    states.put("Oregon", "Salem");
    states.put("Pennsylvania", "Harrisburg");
    states.put("Rhode Island", "Providence");
    states.put("South Carolina", "Columbia");
    states.put("South Dakota", "Pierre");
    states.put("Tennessee", "Nashville");
    states.put("Texas", "Austin");
    states.put("Utah", "Salt Lake City");
    states.put("Vermont", "Montpelier");
    states.put("Virginia", "Richmond");
    states.put("Washington", "Olympia");
    states.put("West Virginia", "Charleston");
    states.put("Wisconsin", "Madison");
    states.put("Wyoming", "Cheyenne");

    for (Map.Entry<String, String> entry : states.entrySet()) {
      String state = entry.getKey();
      String capital = entry.getValue();

      System.out.print("What is the capital of " + state + "? ");
      String userAnswer = in.nextLine();

      if (capital.equalsIgnoreCase(userAnswer)) {
        System.out.println("Your answer is correct.");
      } else {
        System.out.println("The correct answer is " + capital);
      }
    }

  }
}
