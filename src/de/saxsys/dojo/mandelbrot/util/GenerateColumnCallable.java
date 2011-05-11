package de.saxsys.dojo.mandelbrot.util;

import java.util.concurrent.Callable;

/**
 *
 * @author marco.dierenfeldt
 */
public class GenerateColumnCallable implements Callable {

    private double result;
    private double cRe;
    private double cIm;
    private final int height;
    private final double nMax;
    private final MandelbrotColor mColor;
    private final double deltaIm;

    public GenerateColumnCallable(GenerateColumnVo param, double result, double cRe, double cIm){
        this.result = result;
        this.cRe = cRe;
        this.cIm = cIm;
        this.height = param.getHeight();
        this.nMax = param.getnMax();
        this.mColor = param.getmColor();
        this.deltaIm = param.getDeltaIm();
    }

    public int[] call() {
        int[] rgbArray = new int[height];
        for (int row = 0; row < height; row++) {
            double x = 0.0;
            double y = 0.0;
            int I = 0;
            while ((I <= nMax) && (result < 2)) {
                I++;
                double xi = (x * x) - (y * y) + cRe;
                y = 2 * x * y + cIm;
                x = xi;
                result = Math.sqrt((x * x) + (y * y));
            }
            if (I >= nMax) {
                rgbArray[row] = mColor.getInfinityColor().getRGB();
            } else {
                rgbArray[row] = mColor.getColorForValue(I).getRGB();
            }
            result = 0;
            cIm = cIm - deltaIm;
        }
        return rgbArray;
    }
}
