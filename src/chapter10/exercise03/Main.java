package chapter10.exercise03;

public class Main {
  public static void main(String[] args) {
    System.out.println(MyInteger.parseInt(new char[]{ '1', '1', '9' }));
    System.out.println(MyInteger.parseInt("1256"));
    System.out.println(MyInteger.parseInt("12b44aaa", true));
    System.out.println(MyInteger.parseInt("12a32bbbbbbb1", true));
  }
}
