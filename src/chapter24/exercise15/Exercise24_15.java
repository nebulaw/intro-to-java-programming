package chapter24.exercise15;

import chapter24.exercise01.MyArrayList;

import java.util.Collections;

public class Exercise24_15 {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>(new Integer[]{
                56, 12, 53
        });
        MyArrayList<Integer> list2 = new MyArrayList<>(new Integer[]{
                90, 23, 53
        });

        test_addAll(list1, list2);
        test_retainAll(list1, list2);
        test_removeAll(list1, list2);
    }

    public static <E> void test_addAll(MyArrayList<E> list1, MyArrayList<E> list2) {
        MyArrayList<E> list1copy = list1.copy();
        MyArrayList<E> list2copy = list2.copy();
        list1copy.addAll(list2copy);
        displayTestResult("REMOVE ALL", list1, list2, list1copy, true);
    }

    public static <E> void test_retainAll(MyArrayList<E> list1, MyArrayList<E> list2) {
        MyArrayList<E> list1copy = list1.copy();
        MyArrayList<E> list2copy = list2.copy();
        list1copy.retainAll(list2copy);
        displayTestResult("REMOVE ALL", list1, list2, list1copy, true);
    }

    public static <E> void test_removeAll(MyArrayList<E> list1, MyArrayList<E> list2) {
        MyArrayList<E> list1copy = list1.copy();
        MyArrayList<E> list2copy = list2.copy();
        list1copy.removeAll(list2copy);
        displayTestResult("REMOVE ALL", list1, list2, list1copy, true);
    }

    public static <E> void displayTestResult(String title, MyArrayList<E> l1, MyArrayList<E> l2, MyArrayList<E> result, boolean status) {
        System.out.printf("------------ %-15s ------------\n", title);
        System.out.println("List1  | " + l1);
        System.out.println("List2  | " + l2);
        System.out.println("Result | " + result);
        System.out.println((status ? "PASSED" : "DIDN'T PASS!"));
    }

}
