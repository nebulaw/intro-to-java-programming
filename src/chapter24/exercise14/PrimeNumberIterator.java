package chapter24.exercise14;

import java.util.Iterator;

import static chapter10.exercise03.MyInteger.isPrime;

public class PrimeNumberIterator implements Iterator<Integer> {
    private int current = 2, LIMIT;

    public PrimeNumberIterator(int limit) {
        this.LIMIT = limit;
    }

    public void setLimit(int limit) {
        this.LIMIT = limit;
    }

    @Override
    public boolean hasNext() {
        return current < LIMIT;
    }

    @Override
    public Integer next() {
        while (!isPrime(current))
            current++;
        if (current > LIMIT)
            return null;
        return current++;
    }

    public static void main(String[] args) {
        PrimeNumberIterator it = new PrimeNumberIterator(100_000);
        int count = 0;
        while (it.hasNext()) {
            System.out.printf("%7d", it.next());
            if (count++ % 10 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println("encountered prime numbers: " + count);

    }
}
