package chapter11.exercise05;

import java.util.ArrayList;
import java.util.Objects;

public class Course {
  private String courseName;
  private ArrayList<String> students = new ArrayList<>(100);

  public Course(String courseName) {
    this.courseName = courseName;
  }

  public void addStudent(String student) {
    students.add(student);
  }

  public void dropStudent(String name) {
    students.remove(name);
  }

  public void clear() {
    students.clear();
  }

  public void displayStudents() {
    System.out.println("Students: " +
      students.stream()
        .filter(Objects::nonNull)
        .reduce("", (rest, st) -> rest + " " + st));
  }

  public ArrayList<String> getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return students.size();
  }

  public String getCourseName() {
    return courseName;
  }
}