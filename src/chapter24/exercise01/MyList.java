package chapter24.exercise01;

public interface MyList<E> extends Iterable<E> {
    void add(E e);

    void add(int index, E e);

    boolean addAll(MyList<E> otherList);

    void clear();

    boolean contains(E e);

    E get(int index);

    int indexOf(E e);

    int lastIndexOf(E e);

    boolean isEmpty();

    boolean remove(E e);

    boolean removeAll(MyList<E> otherList);

    boolean retainAll(MyList<E> otherList);

    E remove(int index);

    Object set(int index, E e);

    int size();
}
