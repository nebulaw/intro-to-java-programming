package chapter17.exercise18;

public class Exercise17_18 {
  public static void main(String[] args) {
    System.out.println(getBits(2100));
  }

  public static String getBits(int value) {
    int lastByte = value & 0xFF;
    return Integer.toBinaryString(lastByte);
  }
}
