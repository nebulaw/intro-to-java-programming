package chapter19.exercise11;

import chapter13.exercise17.Complex;

public class Exercise19_11 {
    private static final char MUL = '*';
    private static final char ADD = '+';

    public static void main(String[] args) {
        Complex[][] m1 = new Complex[][] {
                { new Complex(2, 3), new Complex(20, 3), new Complex(20, 1) },
                { new Complex(5, 6), new Complex(34, 5), new Complex(89, 89)},
                { new Complex(12, 6), new Complex(8, 5), new Complex(214, 4)},
                { new Complex(45, 25), new Complex(88, 88), new Complex(12, 23)},
        };
        Complex[][] m2 = new Complex[][] {
                { new Complex(24, 21), new Complex(244, 2), new Complex(24, 12) },
                { new Complex(25, 53), new Complex(55, 87), new Complex(45, 78) },
                { new Complex(88, 77), new Complex(21, 59), new Complex(83, 28)},
        };
        Complex[][] m4 = new Complex[][] {
                { new Complex(24, 21), new Complex(244, 2), new Complex(24, 12) },
                { new Complex(25, 53), new Complex(55, 87), new Complex(45, 78) },
                { new Complex(88, 77), new Complex(21, 59), new Complex(83, 28)},
        };

        ComplexMatrix complexMatrix = new ComplexMatrix();
        ComplexMatrix.printResult(m1, m2, complexMatrix.multiplyMatrix(m1, m2), MUL);
        ComplexMatrix.printResult(m2, m4, complexMatrix.addMatrix(m2, m4), ADD);
    }
}
