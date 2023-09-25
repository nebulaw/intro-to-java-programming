package chapter23.exercise12;

import java.util.ArrayList;
import java.util.Random;

public class Exercise23_12 {
  private static Random random = new Random();

  public static void main(String[] args) {

  }

  public static MyInteger[] generate(int n) {
    MyInteger[] retVals = new MyInteger[n];
    for (int i = 0; i < n; i++)
      retVals[i] = new MyInteger(random.nextInt(1000));
    return retVals;
  }

  public static ArrayList<MyInteger> bucketSort(MyInteger[] list) {
    return null;
  }

  private static class MyInteger {
    private String integerValue;

    public MyInteger() {
      integerValue = "0";
    }

    public MyInteger(String value) {
      integerValue = value;
    }

    public MyInteger(int value) {
      integerValue = String.valueOf(value);
    }

    public int get(int i) {
      if (i < 0 || i >= integerValue.length())
        return 0;
      return integerValue.charAt(i) - 48;
    }

    public int getKey() {
      return integerValue.charAt(getSize() - 1) - 48;
    }

    public int getValue() {
      return Integer.parseInt(integerValue);
    }

    public int getSize() {
      return integerValue.length();
    }
  }
}
