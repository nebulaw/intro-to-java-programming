package chapter17.exercise07;

import chapter17.exercise06.Loan;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exercise17_07 {
    public static void main(String[] args) {
        double sum = 0.0;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/chapter17/Exercise17_07.dat"))) {
            Loan loan;
            while ((loan = (Loan) in.readObject()) != null)
                sum += loan.getLoanAmount();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("reading ended");
        }

        System.out.println("sum is " + sum);
    }

    public static Loan readLoan() {
        Loan retVal = null;

        return retVal;
    }
}
