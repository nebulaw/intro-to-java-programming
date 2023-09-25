package chapter13.exercise13;

import java.util.Arrays;
import java.util.Objects;

public class Course implements Cloneable {
  private String courseName;
  private String[] students = new String[100];
  private int numberOfStudents;

  public Course(String courseName) {
    this.courseName = courseName;
    numberOfStudents = 0;
  }

  public void addStudent(String student) {
    if (numberOfStudents >= students.length) {
      String[] temp = new String[students.length * 2];
      System.arraycopy(students, 0, temp, 0, students.length);
      students = temp;
    }
    students[numberOfStudents++] = student;
  }

  public void dropStudent(String name) {
    int studentIndex = -1;
    // find student index
    for (int i = 0; i < numberOfStudents; i++)
      if (students[i].equals(name)) {
        studentIndex = i;
        break;
      }
    // check if found
    if (studentIndex == -1)
      throw new RuntimeException("Student " + name + " does not exist");
    // if found then remove it
    for (int i = studentIndex; i < numberOfStudents - 1; i++)
      students[i] = students[i + 1];
    students[numberOfStudents - 1] = null;
    numberOfStudents--;
  }

  public void clear() {
    for (int i = 0; i < numberOfStudents; i++)
      students[i] = null;
    numberOfStudents = 0;
  }

  public void displayStudents() {
    System.out.println("Students: " +
        Arrays.stream(students)
            .filter(Objects::nonNull)
            .reduce("", (rest, st) -> rest + " " + st));
  }

  public String[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  public String getCourseName() {
    return courseName;
  }

  @Override
  public Object clone() {
    Course ret = new Course(courseName);
    ret.numberOfStudents = numberOfStudents;
    System.arraycopy(students, 0, ret.students, 0, numberOfStudents);
    return ret;
  }

}
