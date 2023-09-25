package chapter11.exercise09;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the array size n: ");
        int n = in.nextInt();

        Random random = new Random();
        int[][] array = new int[n][n];
        // fill randomly
        System.out.println("The random array is");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(2);
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        ArrayList<Integer> rowIndices = new ArrayList<>();
        ArrayList<Integer> columnIndices = new ArrayList<>();
        int maxRowSum = 0, maxColumnSum = 0;

        for (int i = 0; i < n; i++) {
            int rowSum = 0, columnSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += array[i][j];
                columnSum += array[j][i];
            }
            // get row indices
            if (rowSum == maxRowSum) {
                rowIndices.add(i);
            } else if (rowSum > maxRowSum) {
                maxRowSum = rowSum;
                rowIndices.clear();
                rowIndices.add(i);
            }
            // get column indices
            if (columnSum == maxRowSum) {
                columnIndices.add(columnSum);
            } else if (columnSum > maxColumnSum) {
                maxColumnSum = columnSum;
                columnIndices.clear();
                columnIndices.add(i);
            }
        }

        System.out.println("The largest row index: " + rowIndices);
        System.out.println("The largest column index: " + columnIndices);

    }
}
