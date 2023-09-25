package chapter22.exercise14;

import java.util.ArrayList;

public class Exercise22_14 {
    public static void main(String[] args) {
        long[] tests = new long[] { 8000000, 10000000, 12000000, 14000000, }; // 16000000, 180000005 };

        // Header
        System.out.print("            |");
        for (long test : tests)
            System.out.printf("%12d", test);
        System.out.println();
        System.out.print("------------|");
        for (int i = 0; i < 12 * tests.length + 2; i++)
            System.out.print("-");
        System.out.println();

        boolean test5 = true, test6 = true, test7 = true;

        // Listing 22.5
        if (test5) {
            System.out.print("Listing 22.5|");
            for (long test : tests) {
                long timeStarted = System.currentTimeMillis();
                listing5(test);
                long timeEnded = System.currentTimeMillis();
                System.out.printf("%10dms", timeEnded - timeStarted);
            }
            System.out.println();
        }

        // Listing 22.6
        if (test6) {
            System.out.print("Listing 22.6|");
            for (long test : tests) {
                long timeStarted = System.currentTimeMillis();
                listing6(test);
                long timeEnded = System.currentTimeMillis();
                System.out.printf("%10dms", timeEnded - timeStarted);
            }
            System.out.println();
        }

        // Listing 22.7
        if (test7) {
            System.out.print("Listing 22.7|");
            for (long test : tests) {
                long timeStarted = System.currentTimeMillis();
                listing7(test);
                long timeEnded = System.currentTimeMillis();
                System.out.printf("%10dms", timeEnded - timeStarted);
            }
            System.out.println();
        }
    }

    public static void listing5(long n) {
        long count = 0;
        long number = 2;

        while (number <= n) {
            boolean isPrime = true;
            for (int div = 2; div <= (int)(Math.sqrt(number)); div++)
                if (number % div == 0) {
                    isPrime = false;
                    break;
                }
            if (isPrime)
                count++;
            number++;
        }
    }

    public static void listing6(long n) {
        long count = 0;
        long number = 2;
        long squareRoot = 1;

        while (number <= n) {
            boolean isPrime = true;

            if (squareRoot * squareRoot < number)
                squareRoot++;

            for (int div = 2; div <= squareRoot; div++)
                if (number % div == 0) {
                    isPrime = false;
                    break;
                }
            if (isPrime)
                count++;
            number++;
        }
    }

    public static void listing7(long n) {
        ArrayList<Long> list = new ArrayList<>();
        long count = 0;
        long number = 2;
        long squareRoot = 1;

        while (number <= n) {
            boolean isPrime = true;

            if (squareRoot * squareRoot < number)
                squareRoot++;

            for (int i = 2; i < list.size() && list.get(i) <= squareRoot; i++)
                if (number % list.get(i) == 0) {
                    isPrime = false;
                    break;
                }
            if (isPrime) {
                count++;
                list.add(number);
            }
            number++;
        }
    }

}
