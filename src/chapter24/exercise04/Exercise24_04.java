package chapter24.exercise04;

import chapter19.exercise02.GenericStack;

public class Exercise24_04 {
    public static void main(String[] args) {
        GenericStack<Integer> primeNumberStack = new GenericStack<>(50);

        int count = 0, number = 2;
        while (count < 50) {
            boolean isPrime = true;
            for (int div = 2; div <= (int)(Math.sqrt(number)); div++)
                if (number % div == 0) {
                    isPrime = false;
                    break;
                }
            if (isPrime) {
                primeNumberStack.push(number);
                count++;
            }
            number++;
        }

        count = 1;
        while (!primeNumberStack.isEmpty()) {
            System.out.printf("%6d", primeNumberStack.pop());
            if (count % 10 == 0)
                System.out.println();
            count++;
        }
    }
}
