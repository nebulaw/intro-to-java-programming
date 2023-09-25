package chapter21.exercise01;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise21_01 {
  public static void main(String[] args) {
    Set<String> set1 = new LinkedHashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
    Set<String> set2 = new LinkedHashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

    for (String w : union(set1, set2))
      System.out.print(w + " ");
    System.out.println();

    for (String w : difference(set1, set2))
      System.out.print(w + " ");
    System.out.println();

    for (String w : intersection(set1, set2))
      System.out.print(w + " ");
    System.out.println();
  }

  public static Set<String> union(Set<String> set1, Set<String> set2) {
    Set<String> union = new LinkedHashSet<>(set1);
    union.addAll(set2);
    return union;
  }

  public static Set<String> difference(Set<String> set1, Set<String> set2) {
    Set<String> d1 = new LinkedHashSet<>(set1);
    Set<String> d2 = new LinkedHashSet<>(set2);
    d1.removeAll(set2);
    d2.removeAll(set1);
    return union(d1, d2);
  }

  public static Set<String> intersection(Set<String> set1, Set<String> set2) {
    Set<String> intersection = union(set1, set2);
    intersection.removeAll(difference(set1, set2));
    return intersection;
  }
}
