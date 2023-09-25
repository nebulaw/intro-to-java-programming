package chapter19.exercise01;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
class GenericStack<E> {
    private ArrayList<E> list = new ArrayList<>();
    private static int DEFAULT_SIZE = 16;
    private E[] stack;
    private int sp;

    public GenericStack() {
        stack = (E[]) new Object[DEFAULT_SIZE];
    }

    public int getSize() {
        return sp;
    }

    public E peek() {
        return stack[sp - 1];
    }

    public void push(E o) {
        if (sp >= stack.length) {
            E[] temp = (E[]) new Object[sp * 2];
            System.arraycopy(stack, 0, temp, 0, sp);
            stack = temp;
        }
        stack[sp++] = o;
    }

    public E pop() {
        if (sp < 1)
            throw new RuntimeException("Stack is empty");
        return stack[--sp];
    }

    public boolean isEmpty() {
        return sp == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E o : stack)
            sb.append(o).append(" ");
        return "Stack: " + sb;
    }
}
