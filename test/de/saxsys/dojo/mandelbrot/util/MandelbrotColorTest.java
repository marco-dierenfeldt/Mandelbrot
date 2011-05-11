package de.saxsys.dojo.mandelbrot.util;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco Dierenfeldt
 */
public class MandelbrotColorTest {

    /**
     * Test of getInfinityColor method, of class MandelbrotColor.
     */
    @Test
    public void testGetInfinityColor() {
        System.out.println("getInfinityColor");
        MandelbrotColor instance = new MandelbrotColor();
        Color expResult = Color.BLACK;
        Color result = instance.getInfinityColor();
        assertEquals(expResult, result);

    }

    /**
     * Test of getColorForValue method, of class MandelbrotColor.
     */
    @Test
    public void testGetColorForValue() {
        System.out.println("getColorForValue");
        int[] values = {5, 7, 12, 25, 32, 46, 57, 63, 76, 89, 91, 100};
        Color[] colors = {new Color(0, 0, 73), new Color(0, 0, 87),
                          new Color(0, 0, 122), new Color(0, 0, 213),
                          new Color(225, 225, 0), new Color(0, 95, 95),
                          new Color(0, 205, 205), new Color(65, 0, 0),
                          new Color(195, 0, 0), new Color(0, 108, 0),
                          new Color(0, 122, 0), new Color(0, 185, 0)};

        assertEquals(values.length, colors.length);

        MandelbrotColor instance = new MandelbrotColor();
        for (int i = 0; i < colors.length; i++) {
            Color expResult = colors[i];
            int value = values[i];
            Color result = instance.getColorForValue(value);
            System.out.println("val: "+value+" exp: "+expResult+" col: "+result);
            assertEquals(expResult, result);
        }
    }
}
