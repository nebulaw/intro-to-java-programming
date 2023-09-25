package chapter12.exercise06_10;

public class HexFormatException extends NumberFormatException {
  public HexFormatException(String message) {
    super(message);
  }
  public HexFormatException() {
    super("invalid character occurred.");
  }
}

