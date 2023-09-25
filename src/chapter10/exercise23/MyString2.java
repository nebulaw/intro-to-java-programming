package chapter10.exercise23;

import chapter10.exercise22.MyString1;

public class MyString2 extends MyString1 {

  String value;

  public MyString2(String s) {
    super(s.toCharArray());
    value = s;
  }

  private MyString2(char[] chars) {
    super(chars);
    value = String.valueOf(chars);
  }

  public int compare(String other) {
    int l = Math.min(value.length(), other.length());
    for (int i = 0; i < l; i++)
      if (value.charAt(i) != other.charAt(i))
        return value.charAt(i) - other.charAt(i);
    return value.length() - other.length();
  }

  public MyString2 substring(int begin) {
    if (!(0 <= begin && begin < value.length()))
      throw new RuntimeException("Invalid starting index: " + begin);
    MyString1 ss = substring(begin, value.length());
    return new MyString2(ss.charArray);
  }

  public MyString2 toUpperCase() {
    char[] upper = new char[charArray.length];
    for (int i = 0; i < upper.length; i++)
      if (97 <= charArray[i] && charArray[i] <= 122)
        upper[i] = (char)(charArray[i] - 32);
      else
        upper[i] = charArray[i];
    return new MyString2(upper);
  }

  public char[] toChars() {
    return charArray;
  }

  public static MyString2 valueOf(boolean b) {
    return new MyString2(b ? "true" : "false");
  }

  public static void main(String[] args) {
    MyString2 s = new MyString2("abcdefghijklmnopqrstuvwxvz");
    System.out.println(s.toUpperCase().toLowerCase());
    System.out.println(MyString2.valueOf(false));
  }

}
