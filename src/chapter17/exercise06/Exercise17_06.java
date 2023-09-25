package chapter17.exercise06;

import java.io.*;

public class Exercise17_06 {
    public static void main(String[] args) {
        Loan loan = new Loan();
        writeLoan(loan);
        Loan readLoan = readLoan();
    }

    public static void writeLoan(Loan loan) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/chapter17/Exercise17_06.dat"))) {
            out.writeObject(loan);
            System.out.println("successfully written : " + loan);
        } catch (IOException e) {
            System.out.println("hi error occurred.");
        }
    }

    public static Loan readLoan() {
        Loan loan = null;
        try (ObjectInputStream out = new ObjectInputStream(new FileInputStream("data/chapter17/Exercise17_06.dat"))) {
            loan = (Loan) out.readObject();
            System.out.println("successfully read : " + loan);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("hi error occurred.");
        }
        return loan;
    }
}
