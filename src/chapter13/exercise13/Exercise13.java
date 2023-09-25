package chapter13.exercise13;

/**
 * (Enable the Course class cloneable) Rewrite the Course class in Listing 10.6
 * to add a clone method to perform a deep copy on the students field.
 * */

public class Exercise13 {
  public static void main(String[] args) {
    Course course = new Course("Java");

    course.addStudent("Karlo");
    course.addStudent("Nika");
    course.addStudent("Andria");
    course.displayStudents();

    course.dropStudent("Nika");
    course.displayStudents();

    Course courseClone = (Course) course.clone();
    courseClone.displayStudents();
  }
}
