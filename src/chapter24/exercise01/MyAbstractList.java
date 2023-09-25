package chapter24.exercise01;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0;

    protected MyAbstractList() {
    }

    protected MyAbstractList(E[] objects) {
        for (E object : objects) add(object);
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public boolean addAll(MyList<E> otherList) {
        int oldSize = size;
        for (E e : otherList)
            if (!contains(e)) add(e);
        return oldSize == size;
    }

    @Override
    public boolean removeAll(MyList<E> otherList) {
        boolean status = false;
        for (E e : otherList)
            if (remove(e)) status = true;
        return status;
    }

    @Override
    public boolean retainAll(MyList<E> otherList) {
        boolean status = false;
        for (E e : this)
            if (!otherList.contains(e)) {
                status = true;
                remove(indexOf(e));
            }
        return status;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(E e) {
        int idx = indexOf(e);
        if (idx < 0)
            return false;
        remove(idx);
        return true;
    }
}
