package chapter18.exercise18;

import java.util.Scanner;

/**
 * Hanoi Tower, counting moves
 * */

public class Exercise18_18 {
    public static int count = 0;

    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        count++;
        if (n == 1)
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = in.nextInt();

        System.out.println("The moves are: ");
        moveDisks(n, 'A', 'B', 'C');
        System.out.println(count + " moves are needed");
    }
}
