package chapter12.exercise05;

public class IllegalTriangleException extends RuntimeException {
  public IllegalTriangleException() {
    super("Illegal triangle.");
  }
  public IllegalTriangleException(String message) {
    super(message);
  }
}

