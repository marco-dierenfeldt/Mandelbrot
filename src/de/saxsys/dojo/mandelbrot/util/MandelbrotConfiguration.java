package de.saxsys.dojo.mandelbrot.util;

/**
 *
 * @author Marco Dierenfeldt
 */
public class MandelbrotConfiguration implements Comparable<Object>{

    private int width = 640;
    private int height = 480;
    private int nMax = 100;
    private double imaginaryMax = 1.2;
    private double imaginaryMin = -1.2;
    private double realMax = 1.0;
    private double realMin = -2.0;
    private double deltaIm = -0.004175365344467640918580375782881;
    private double deltaRe = 0.0046948356807511737089201877934272;

    public MandelbrotConfiguration() {
        initDelta();
    }

    public MandelbrotConfiguration getNewConfigForPoint(int x, int y) {
        MandelbrotConfiguration mConf = new MandelbrotConfiguration();

        double pointX = realMin+ Math.abs(x * deltaRe);
        double pointY = imaginaryMin + Math.abs(y * deltaIm);
        double tmpDeltaIm = (imaginaryMax - imaginaryMin) / 4;
        double tmpDeltaRe = (realMax - realMin) / 4;
        double tmpImMin = pointY - tmpDeltaIm;
        double tmpImMax = pointY + tmpDeltaIm;
        double tmpReMin = pointX - tmpDeltaRe;
        double tmpReMax = pointX + tmpDeltaRe;

        mConf.setHeight(height);
        mConf.setWidth(width);
        mConf.setnMax(nMax);
        mConf.setImaginaryMax(tmpImMax);
        mConf.setImaginaryMin(tmpImMin);
        mConf.setRealMax(tmpReMax);
        mConf.setRealMin(tmpReMin);

        return mConf;
    }

    private void initDelta() {
        deltaIm = (imaginaryMin - imaginaryMax) / (height - 1);
        deltaRe = (realMax - realMin) / (width - 1);
    }

    public void setWidth(int width) {
        this.width = width;
        initDelta();
    }

    public void setHeight(int height) {
        this.height = height;
        initDelta();
    }

    public void setImaginaryMax(double imaginaryMax) {
        this.imaginaryMax = imaginaryMax;
        initDelta();
    }

    public void setImaginaryMin(double imaginaryMin) {
        this.imaginaryMin = imaginaryMin;
        initDelta();
    }

    public void setRealMax(double realMax) {
        this.realMax = realMax;
        initDelta();
    }

    public void setRealMin(double realMin) {
        this.realMin = realMin;
        initDelta();
    }

    @Override
    public String toString() {
        return ""+width+"x"+height+" - "+nMax+" - "+imaginaryMax+"/"+imaginaryMin+"/"+realMax+"/"+realMin;
    }

    @Override
    public int hashCode() {
        return super.hashCode();

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }



    //generated accessors
    public double getDeltaIm() {
        return deltaIm;
    }

    public void setDeltaIm(double deltaIm) {
        this.deltaIm = deltaIm;
    }

    public double getDeltaRe() {
        return deltaRe;
    }

    public void setDeltaRe(double deltaRe) {
        this.deltaRe = deltaRe;
    }

    public int getHeight() {
        return height;
    }

    public double getImaginaryMax() {
        return imaginaryMax;
    }

    public double getImaginaryMin() {
        return imaginaryMin;

    }

    public int getnMax() {
        return nMax;
    }

    public void setnMax(int nMax) {
        this.nMax = nMax;
    }

    public double getRealMax() {
        return realMax;
    }

    public double getRealMin() {
        return realMin;
    }

    public int getWidth() {
        return width;
    }

    public int compareTo(Object o) {
        MandelbrotConfiguration conf = (MandelbrotConfiguration) o;
        
        double confWidth = conf.getRealMax()-conf.getRealMin();
        double confheight = conf.getImaginaryMax()-conf.getImaginaryMin();
        
        double selfWidth = this.getRealMax()-this.getRealMin();
        double selfheight = this.getImaginaryMax()-this.getImaginaryMin();

        if(confWidth > selfWidth && confheight > selfheight) return -1;
        if(confWidth < selfWidth && confheight < selfheight) return 1;


        return 0;
    }
}
