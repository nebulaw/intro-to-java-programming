package chapter10.exercise28;

import chapter10.exercise27.MyStringBuilder;

public class MyStringBuilder2 extends MyStringBuilder {

  public MyStringBuilder2() {
    super();
  }

  public MyStringBuilder2(char[] chars) {
    super(String.valueOf(chars));
  }

  public MyStringBuilder2(String s) {
    super(s);
  }

  public MyStringBuilder2 reverse() {
    char[] reversed = new char[length()];
    for (int i = length() - 1; i >= 0; i--)
      reversed[length() - 1 - i] = sequence.charAt(i);
    sequence = String.valueOf(reversed);
    return this;
  }

  public MyStringBuilder2 substring(int begin) {
    if (!(0 <= begin && begin <= length()))
      return new MyStringBuilder2();
    char[] substring = new char[length() - begin];
    for (int i = begin, k = 0; i < length(); i++)
      substring[k++] = sequence.charAt(i);
    sequence = String.valueOf(substring);
    return this;
  }

  public MyStringBuilder2 toUpperCase() {
    sequence = sequence.toUpperCase();
    return this;
  }

}
