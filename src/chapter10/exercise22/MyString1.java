package chapter10.exercise22;

import java.util.Scanner;

public class MyString1 {
  public char[] charArray;

  public MyString1(char[] chars) {
    if (chars[chars.length - 1] == '\0')
      charArray = new char[chars.length];
    else {
      charArray = new char[chars.length + 1];
      charArray[chars.length] = '\0';
    }
    System.arraycopy(chars, 0, charArray, 0, chars.length);
  }

  public char charAt(int index) {
    if (index >= charArray.length)
      throw new ArrayIndexOutOfBoundsException();
    return charArray[index];
  }

  public int length() {
    return charArray.length - 1;
  }

  // 4 - 2 -> 2
  public MyString1 substring(int begin, int end) {
    if (!(0 <= begin && begin < charArray.length) ||
        !(begin <= end && end < charArray.length))
      throw new RuntimeException("Invalid range: " + begin + " " + end);
    char[] substring = new char[end - begin + 1];
    for (int i = begin, k = 0; i < end; k++, i++)
      substring[k] = charArray[i];
    if (end != charArray.length && substring[end - 1] != '\0')
      substring[end - 1] = '\0';
    return new MyString1(substring);
  }

  public MyString1 toLowerCase() {
    char[] lower = new char[charArray.length];
    for (int i = 0; i < lower.length; i++)
      if (65 <= charArray[i] && charArray[i] <= 90)
        lower[i] = (char)(charArray[i] + 32);
      else
        lower[i] = charArray[i];
    return new MyString1(lower);
  }

  public boolean equals(MyString1 other) {
    if (length() != other.length())
      return false;
    for (int i = 0; i < length(); i++)
      if (charArray[i] != other.charAt(i))
        return false;
    return true;
  }

  public static MyString1 valueOf(int n) {
    if (n == 0)
      return new MyString1(new char[] { '0' });
    // save number sign
    int sign = n < 0 ? -1 : 1;
    // absolute value
    n *= sign;
    // create characters array given the sign of the number
    char[] repr = new char[(int)(Math.log10(n)) + (sign < 0 ? 2 : 1)];
    for (int i = repr.length - 1; i > (sign == -1 ? 0 : -1); n /= 10, i--)
      repr[i] = (char)(n % 10 + 48);
    if (sign == -1)
      repr[0] = '-';
    return new MyString1(repr);
  }

  // 244
  // 4
  // 24

  private static void removeEvensIntApproach() {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int res = 0;

    for (int i = 0; num > 0; num /= 10)
      if ((num % 10) % 2 != 0)
        res = res + (int) Math.pow(10, i++) * (num % 10);

    System.out.println(res);
  }

  @Override
  public String toString() {
    return String.valueOf(charArray);
  }

  public static void main(String[] args) {
    MyString1 s1 = new MyString1(new char[]{'a', 'k'});
    System.out.println(MyString1.valueOf(-0));
    System.out.println(s1.length());
    System.out.println(s1.equals(new MyString1(new char[]{'a', 'b'})));
  }
}
