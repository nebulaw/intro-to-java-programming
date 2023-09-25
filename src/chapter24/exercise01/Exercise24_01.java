package chapter24.exercise01;

public class Exercise24_01 {
    public static void main(String[] args) {
        MyArrayList<String> list1 = new MyArrayList<>(
                new String[] {"Tom", "George", "Peter", "Jean", "Jane"});
        MyArrayList<String> list2 = new MyArrayList<>(
                new String[] {"Tom", "George", "Michael", "Michelle", "Daniel"});

//        list1.addAll(list2);
//        list1.removeAll(list2);
        list1.retainAll(list2);
        System.out.println(list1);
        System.out.println(list2);
    }
}
