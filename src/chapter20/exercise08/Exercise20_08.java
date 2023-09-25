package chapter20.exercise08;

import java.util.Random;
import java.util.Scanner;

public class Exercise20_08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        int lotteryNumber = random.nextInt(100, 1000);
        int savedLotteryNumber = lotteryNumber;
        System.out.print("Guess the lottery number: ");
        int guessNumber = in.nextInt();

        if (lotteryNumber == guessNumber) {
            System.out.println("Exact match: you win $10,000");
            System.exit(0);
        }

        int[] guessCounts = new int[10];
        while (guessNumber > 0) {
            guessCounts[guessNumber % 10]++;
            guessNumber /= 10;
        }

        int[] lotteryDigits = new int[10];
        while (lotteryNumber > 0) {
            lotteryDigits[lotteryNumber % 10]++;
            lotteryNumber /= 10;
        }

        int matchCount = 0;
        for (int i = 0; i < 10; i++)
            matchCount += Math.min(lotteryDigits[i], guessCounts[i]);
        System.out.println(matchCount);

        switch (matchCount) {
            case 2 -> System.out.println("Matched two digits: you won $2,000");
            case 1 -> System.out.println("Matched one digit: you won $1,000");
            default -> System.out.println("Didn't match: you lost");
        }
        System.out.println("Lottery number was " + savedLotteryNumber);


    }
}
