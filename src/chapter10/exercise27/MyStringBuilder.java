package chapter10.exercise27;

public class MyStringBuilder {
  protected String sequence;

  public MyStringBuilder(String s) {
    sequence = s;
  }

  public MyStringBuilder() {
    sequence = "";
  }

  public MyStringBuilder append(MyStringBuilder sb) {
    sequence += sb.sequence;
    return this;
  }

  public MyStringBuilder append(String s) {
    sequence += s;
    return this;
  }

  public MyStringBuilder append(int i) {
    sequence += String.valueOf(i);
    return this;
  }

  public int length() {
    return sequence.length();
  }

  public char charAt(int index) {
    if (!(0 <= index && index < sequence.length()))
      throw new ArrayIndexOutOfBoundsException("Index out of bound: " + index);
    return sequence.charAt(index);
  }

  public MyStringBuilder toLowerCase() {
    return new MyStringBuilder(sequence.toLowerCase());
  }

  public MyStringBuilder substring(int begin, int end) {
    if (!(0 <= begin && begin < length()) ||
        !(0 <= end && end < length()) || end < begin)
      return new MyStringBuilder("");
    return new MyStringBuilder(sequence.substring(begin, end));
  }

  @Override
  public String toString() {
    return sequence;
  }
}
