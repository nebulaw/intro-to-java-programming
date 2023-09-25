package chapter19.exercise02;

import java.util.ArrayList;

public class GenericStack<T> extends ArrayList<T> {

    public GenericStack() {
        super();
    }

    public GenericStack(int capacity) {
        super(capacity);
    }

    public void push(T o) {
        add(o);
    }

    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return remove(size() - 1);
    }

    public T peek() {
        return get(size() - 1);
    }

}
