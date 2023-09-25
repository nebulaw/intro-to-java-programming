package chapter12.exercise06_10;


public class BinaryFormatException extends NumberFormatException {
  public BinaryFormatException(String message) {
    super(message);
  }
  public BinaryFormatException() {
    super("invalid character occurred.");
  }
}

