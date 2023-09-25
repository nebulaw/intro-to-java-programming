package chapter13.helper;

public class InvalidTriangleException extends RuntimeException {
  public InvalidTriangleException() {
    super("caught invalid triangle.");
  }

  public InvalidTriangleException(String message) {
    super(message);
  }
}
