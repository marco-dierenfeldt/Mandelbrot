package de.saxsys.dojo.mandelbrot.util;

import de.saxsys.dojo.mandelbrot.util.ComplexNumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco Dierenfeldt
 */
public class ComplexMathTest {

    ComplexNumber first = null;
    ComplexNumber second = null;

    @Before
    public void setUp() {
        first = new ComplexNumber(-0.725, 2.346);
        second = new ComplexNumber(0.520, -1.357);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ComplexMath.
     */
    @Test
    public void testAdd() {
        System.out.println("add");

        ComplexNumber expResult = new ComplexNumber(-0.205, 0.989);
        ComplexNumber result = ComplexMath.add(first, second);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.001);
        assertEquals(expResult.getReal(), result.getReal(), 0.001);
    }

    /**
     * Test of subtract method, of class ComplexMath.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        ComplexNumber expResult = new ComplexNumber(-1.245, 3.703);
        ComplexNumber result = ComplexMath.subtract(first, second);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.001);
        assertEquals(expResult.getReal(), result.getReal(), 0.001);
    }

    /**
     * Test of abs method, of class ComplexMath.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        ComplexNumber number = first;
        double expResult = 2.4554716451223785206823317843028;
        double result = ComplexMath.abs(number);
        assertEquals(expResult, result, 0.001);
        
    }

    /**
     * Test of multiply method, of class ComplexMath.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber expResult = new ComplexNumber(2.203745, -2.806522);
        ComplexNumber result = ComplexMath.multiply(first, second);
        
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.001);
        assertEquals(expResult.getReal(), result.getReal(), 0.001);
    }

    /**
     * Test of quadraticMandelbrotFunction method, of class ComplexMath.
     */
    @Test
    public void testQuadraticMandelbrotFunction() {
        System.out.println("quadraticMandelbrotFunction");
        ComplexNumber z = first;
        ComplexNumber c = second;
        ComplexNumber expResult = new ComplexNumber(-3.9217, 6.335091);
        ComplexNumber result = ComplexMath.quadraticMandelbrotFunction(z, c);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.001);
        assertEquals(expResult.getReal(), result.getReal(), 0.001);
    }
}
