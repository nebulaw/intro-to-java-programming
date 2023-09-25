package chapter11.exercise02;


import chapter10.exercise14.MyDate;

public class Faculty extends Employee {
  private int hours;
  private int rank;

  public Faculty(String name, String address, String phoneNumber, String email,
                 String office, double salary, MyDate dateHired, int hours, int rank) {
    super(name, address, phoneNumber, email, office, salary, dateHired);
    this.hours = hours;
    this.rank = rank;
  }

  @Override
  public String toString() {
    return String.format("Faculty[name=%s]", name);
  }
}
