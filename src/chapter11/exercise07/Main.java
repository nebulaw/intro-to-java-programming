package chapter11.exercise07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
  public static void shuffle(ArrayList<Integer> list) {
    Random random = new Random();
    for (int i = 0; i < list.size(); i++) {
      int randIndex = random.nextInt(i, list.size());
      Collections.swap(list, i, randIndex);
    }
  }
}
