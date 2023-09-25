package chapter19.exercise11;


@SuppressWarnings("unchecked")
public abstract class GenericMatrix<E> {
    protected abstract E add(E o1, E o2);

    protected abstract E multiply(E o1, E o2);

    protected abstract E zero();

    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        if ((matrix1.length != matrix2.length) ||
                (matrix1[0].length != matrix2[0].length))
            throw new RuntimeException("The matrices do not match");
        E[][] ret = (E[][]) new Object[matrix1.length][matrix1[0].length];

        for (int i = 0; i < ret.length; i++)
            for (int j = 0; j < ret[i].length; j++)
                ret[i][j] = add(matrix1[i][j], matrix2[i][j]);
        return ret;
    }

    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        if (matrix1[0].length != matrix2.length)
            throw new RuntimeException("The matrices do not match");
        E[][] ret = (E[][]) new Object[matrix1.length][matrix2[0].length];

        for (int i = 0; i < ret.length; i++)
            for (int j = 0; j < ret[0].length; j++) {
                ret[i][j] = zero();
                for (int k = 0; k < matrix1[0].length; k++)
                    ret[i][j] = add(ret[i][j], multiply(matrix1[i][k], matrix2[k][j]));
            }
        return ret;
    }

    public static void printResult(Object[][] m1, Object[][] m2, Object[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++)
                System.out.print(" " + m1[i][j]);

            if (i == m1.length / 2)
                System.out.print("  " + op + " ");
            else
                System.out.print("    ");
            if (i < m2.length)
                for (int j = 0; j < m2[i].length; j++)
                    System.out.print(" " + m2[i][j]);
            else
                for (int j = 0; j < m2[0].length; j++)
                    System.out.print("         ");

            if (i == m1.length / 2)
                System.out.print(" = ");
            else
                System.out.print("   ");

            if (i < m3.length)
                for (int j = 0; j < m3[i].length; j++)
                    System.out.print(m3[i][j] + " ");
            System.out.println();
        }
    }
}
