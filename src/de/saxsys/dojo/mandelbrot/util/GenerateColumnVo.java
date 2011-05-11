package de.saxsys.dojo.mandelbrot.util;

/**
 *
 * @author marco.dierenfeldt
 */
public class GenerateColumnVo {


    private final int height;
    private final double nMax;
    private final MandelbrotColor mColor;
    private final double deltaIm;

    public GenerateColumnVo(int height, double nMax, MandelbrotColor mColor, double deltaIm) {
        this.height = height;
        this.nMax = nMax;
        this.mColor = mColor;
        this.deltaIm = deltaIm;
    }
    
    public int getHeight() {
        return height;
    }

    public double getDeltaIm() {
        return deltaIm;
    }

    public MandelbrotColor getmColor() {
        return mColor;
    }

    public double getnMax() {
        return nMax;
    }

}
