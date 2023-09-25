package chapter24.exercise13;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int LIMIT = 100_000;
    private int previous = 0, current = 1;

    public FibonacciIterator(int limit) {
        this.LIMIT = limit;
    }

    @Override
    public boolean hasNext() {
        return current <= LIMIT;
    }

    @Override
    public Integer next() {
        int var1 = current;
        current += previous;
        previous = var1;
        return var1;
    }

    public static void main(String[] args) {
        FibonacciIterator it = new FibonacciIterator(100_000);

        int count = 1;
        while (it.hasNext()) {
            System.out.printf("%10d", it.next());
            if (count % 10 == 0)
                System.out.println();
            count++;
        }

    }
}
