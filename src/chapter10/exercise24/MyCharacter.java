package chapter10.exercise24;

/**
 * MyCharacter(char value)
 * MyCharacter(int value)
 * static boolean isDigit()
 * static boolean isAlpha()
 * static boolean isUpper()
 * static boolean isLower()
 * static char toLower()
 * static char toUpper()
 * */

public class MyCharacter {
  char value;

  public MyCharacter(int value) {
    value = !(0 <= value && value <= 255) ? (char)0 : (char)value;
  }

  public MyCharacter(char value) {
    this.value = value;
  }

  public boolean isDigit() {
    return MyCharacter.isDigit(value);
  }

  public boolean isAlpha() {
    return MyCharacter.isAlpha(value);
  }

  public boolean isUpper() {
    return MyCharacter.isUpper(value);
  }

  public boolean isLower() {
    return MyCharacter.isLower(value);
  }

  public char toUpper() {
    return MyCharacter.toUpper(value);
  }

  public char toLower() {
    return MyCharacter.toLower(value);
  }

  public static boolean isDigit(char c) {
    return 48 <= c && c <= 57;
  }

  public static boolean isAlpha(char c) {
    return (65 <= c && c <= 90) || (97 <= c && c <= 122);
  }

  public static boolean isUpper(char c) {
    return 65 <= c && c <= 90;
  }

  public static boolean isLower(char c) {
    return 97 <= c && c <= 122;
  }

  public static char toUpper(char c) {
    return 97 <= c && c <= 122 ? (char)(c - 32) : c;
  }

  public static char toLower(char c) {
    return 65 <= c && c <= 90 ? (char)(c + 32) : c;
  }

  public String toString() {
    return "" + value;
  }

  public static void main(String[] args) {

    MyCharacter c1 = new MyCharacter('2');
    System.out.println(c1.isDigit());
    System.out.println(MyCharacter.isAlpha('a'));
    System.out.println(MyCharacter.toLower('B'));
  }

}
