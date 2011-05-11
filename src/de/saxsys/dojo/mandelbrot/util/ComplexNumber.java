package de.saxsys.dojo.mandelbrot.util;

/**
 *
 * @author Marco Dierenfeldt
 */
public class ComplexNumber {
    private double imaginary;
    private double real;

    public ComplexNumber(double imaginary, double real) {
        this.imaginary = imaginary;
        this.real = real;
    }

    public ComplexNumber() {
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    @Override
    public boolean equals(Object obj) {
        ComplexNumber other = (ComplexNumber) obj;
        if((other.getReal()==this.real)&&(other.getImaginary()==this.imaginary))
        {
            return true;
        }
        return false;
    }

}
