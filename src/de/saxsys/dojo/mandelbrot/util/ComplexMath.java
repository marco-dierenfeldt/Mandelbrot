package de.saxsys.dojo.mandelbrot.util;

/**
 *
 * @author Marco Dierenfeldt
 */
public class ComplexMath {

    public static ComplexNumber add(ComplexNumber first, ComplexNumber second){
        ComplexNumber sum = new ComplexNumber();

        sum.setImaginary(first.getImaginary()+second.getImaginary());
        sum.setReal(first.getReal()+second.getReal());

        return sum;
    }

    public static ComplexNumber subtract(ComplexNumber first, ComplexNumber second){
       ComplexNumber difference = new ComplexNumber();

        difference.setImaginary(first.getImaginary()-second.getImaginary());
        difference.setReal(first.getReal()-second.getReal());

        return difference;
    }

    public static double abs(ComplexNumber number){
        double abs = 0.0;
        abs = Math.sqrt((number.getReal()*number.getReal())+(number.getImaginary()*number.getImaginary()));
        return abs;
    }

    public static ComplexNumber multiply(ComplexNumber first, ComplexNumber second){
        ComplexNumber product = new ComplexNumber();

        product.setReal(((double) first.getReal()*(double) second.getReal())-((double) first.getImaginary()*(double) second.getImaginary()));
        product.setImaginary(((double) first.getReal()* (double) second.getImaginary())+((double) second.getReal()*(double) first.getImaginary()));

        return product;
    }

    public static ComplexNumber quadraticMandelbrotFunction(ComplexNumber z, ComplexNumber c){
        ComplexNumber result = null;

        result =add(multiply(z, z), c);

        return result;
    }

    public static ComplexNumber cubicMandelbrotFunction(ComplexNumber z, ComplexNumber c){
        ComplexNumber result = null;

        result =add(multiply(z,multiply(z, z)), c);

        return result;
    }
}