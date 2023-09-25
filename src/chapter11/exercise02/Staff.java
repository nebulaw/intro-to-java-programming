package chapter11.exercise02;


import chapter10.exercise14.MyDate;

public class Staff extends Employee {
  private String title;

  public Staff(String name, String address, String phoneNumber, String email,
               String office, double salary, MyDate dateHired, String title) {
    super(name, address, phoneNumber, email, office, salary, dateHired);
    this.title = title;
  }

  @Override
  public String toString() {
    return String.format("Staff[name=%s]", name);
  }
}
