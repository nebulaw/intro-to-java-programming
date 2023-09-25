package chapter11.exercise02;

public class Student extends Person {
  public static final int FRESHMEN = 0;
  public static final int SOPHOMORE = 1;
  public static final int JUNIOR = 2;
  public static final int SENIOR = 3;

  private final int status;

  public Student(String name, String address, String phoneNumber, String email, int status) {
    super(name, address, phoneNumber, email);
    this.status = status;
  }

  @Override
  public String toString() {
    return String.format("Student[name=%s]", name);
  }

}
