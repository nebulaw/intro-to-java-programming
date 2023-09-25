package chapter12.exercise17;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

  public static boolean isTargetWordGuessed(int[] guessed) {
    boolean status = true;
    for (int i : guessed)
      if (i == 0)
        status = false;
    return status;
  }

  // false if not updated, true if input was occured
  public static boolean updateTargetWord(String targetWord, String input, int[] guessed) {
    boolean updated = false;
    for (int i = 0; i < targetWord.length(); i++)
      if (input.equals(targetWord.charAt(i) + "")) {
        guessed[i] = 1;
        updated = true;
      }
    return updated;
  }

  public static String getWord(String targetWord, int[] guessed) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < guessed.length; i++)
      sb.append(guessed[i] != 0 ? targetWord.charAt(i) : "*");
    return sb.toString();
  }

  public static void main(String[] args) {
    File file = new File("words.txt");
    ArrayList<String> words = new ArrayList<>();

    // initialize words
    try (
      Scanner in = new Scanner(file);
    ) {
      while (in.hasNext())
        words.add(in.next());
    } catch (IOException e) {
      e.printStackTrace();
    }

    Scanner scanner = new Scanner(System.in);

    while (true) {
      String targetWord = words.get((int)(Math.random() * words.size()));
      int[] guessed = new int[targetWord.length()];
      ArrayList<String> recordedInputs = new ArrayList<>();
      int countMissed = 0;

      while (countMissed < 7) {
        System.out.print("(Guess) Enter a letter in word " + getWord(targetWord, guessed) + " > ");
        String input = scanner.next();
        if (input.length() != 1) {
          System.out.println("\tinvalid input");
          continue;
        }
        if (recordedInputs.contains(input)) {
          System.out.println("\t" + input + " already tried.");
          continue;
        }
        recordedInputs.add(input);
        if (!updateTargetWord(targetWord, input, guessed)) {
          countMissed++;
          System.out.println("\t" + input + " is not in the word." +
            " you have " + (7 - countMissed) + " tries left.");
        }
        if (countMissed == 7) {
          System.out.println("\tYou lost.");
          break;
        }
        if (isTargetWordGuessed(guessed)) {
          System.out.println("The word is " + targetWord + ". You missed " + countMissed + " times.");
          break;
        }
      }
      System.out.print("Do you want to guess another word? Enter y or n > ");
      String userChoice = scanner.next();
      if (userChoice.equals("n")) {
        System.out.println("Exiting");
        break;
      }
    }



  }

}
