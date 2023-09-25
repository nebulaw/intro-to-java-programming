package chapter11.exercise02;

import chapter10.exercise14.MyDate;

public class Employee extends Person {
  protected String office;
  private double salary;
  private MyDate dateHired;

  public Employee(String name, String address, String phoneNumber, String email,
                  String office, double salary, MyDate dateHired) {
    super(name, address, phoneNumber, email);
    this.office = office;
    this.salary = salary;
    this.dateHired = dateHired;
  }

  @Override
  public String toString() {
    return String.format("Employee[name=%s]", name);
  }
}
