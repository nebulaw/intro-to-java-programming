package chapter10.exercise01;

public class Main {
  public static void main(String[] args) {
    Time.setOffset(4);
    Time currTime = new Time();
    System.out.println(currTime);
  }
}
