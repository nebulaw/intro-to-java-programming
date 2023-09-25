package chapter19.exercise11;

import chapter13.exercise17.Complex;

public class ComplexMatrix extends GenericMatrix<Complex> {

    @Override
    protected Complex add(Complex o1, Complex o2) {
        return o1.add(o2);
    }

    @Override
    protected Complex multiply(Complex o1, Complex o2) {
        return o1.multiply(o2);
    }

    @Override
    protected Complex zero() {
        return Complex.ZERO;
    }
}
