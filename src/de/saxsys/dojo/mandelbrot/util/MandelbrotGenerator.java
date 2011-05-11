package de.saxsys.dojo.mandelbrot.util;

import java.awt.image.BufferedImage;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco Dierenfeldt
 */
public class MandelbrotGenerator {

    private MandelbrotColor mcolor;
    private int width = 640;
    private int height = 480;
    private int nMax = 100;
    private double imaginaryMax = 1.2;
    private double imaginaryMin = -1.2;
    private double realMax = 1.0;
    private double realMin = -2.0;
    private double deltaIm = -0.004175365344467640918580375782881;
    private double deltaRe = 0.0046948356807511737089201877934272;
    private MandelbrotConfiguration mConfig;

    public MandelbrotGenerator() {
        mcolor = new MandelbrotColor();
        initDelta();
    }

    public MandelbrotGenerator(MandelbrotConfiguration mConfig) {
        this.mConfig = mConfig;
        this.height = mConfig.getHeight();
        this.width = mConfig.getWidth();
        this.imaginaryMax = mConfig.getImaginaryMax();
        this.imaginaryMin = mConfig.getImaginaryMin();
        this.realMax = mConfig.getRealMax();
        this.realMin = mConfig.getRealMin();
        this.nMax = mConfig.getnMax();
        mcolor = new MandelbrotColor();
        initDelta();
    }

    private void initDelta() {
        deltaIm = (imaginaryMin - imaginaryMax) / (height - 1);
        deltaRe = (realMax - realMin) / (width - 1);
    }

    public BufferedImage generate() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        MandelbrotColor mc = new MandelbrotColor();
        double cReMin = realMin;
        double cImMin = imaginaryMin;
        double cIm = 0.0;
        double cRe = 0.0;
        double erg = 0.0;
        cRe = cReMin;
        Future<int[]>[] columns = new Future[width];
        GenerateColumnVo columnparam = new GenerateColumnVo(height, nMax, mcolor, deltaIm);
        for (int col = 0; col < width; col++) {
            cIm = cImMin;

            Future<int[]> submit = threadPool.submit(new GenerateColumnCallable(columnparam, erg, cRe, cIm));
            columns[col] = submit;
            cRe = cRe + deltaRe;
        }

        try {
            for (int spalte = 0; spalte < width; spalte++) {
                int[] rgbs = columns[spalte].get();
                image.setRGB(spalte, 0, 1, rgbs.length, rgbs, 0, 1);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MandelbrotGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(MandelbrotGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        threadPool.shutdown();
        return image;
    }
    
    public BufferedImage generateWithComplexMath() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        MandelbrotColor mc = new MandelbrotColor();
        double cReMin = realMin;
        double cImMin = imaginaryMin;
        double cIm = 0.0;
        double cRe = 0.0;
        double erg = 0.0;
        cRe = cReMin;
        for (int spalte = 0; spalte < width; spalte++) {
            cIm = cImMin;
            for (int zeile = 0; zeile < height; zeile++) {
                double x = 0.0;
                double y = 0.0;
                ComplexNumber c = new ComplexNumber(cIm, cRe);
                ComplexNumber z = new ComplexNumber(x, y);
                int I = 0;

                while ((I <= nMax) && (erg < 2)) {
                    I++;
                    ComplexNumber ergC = null;
                    ergC = ComplexMath.quadraticMandelbrotFunction(z, c);
                    erg = ComplexMath.abs(ergC);
                    z = ergC;
                }

                if (I >= nMax) {
                    image.setRGB(spalte, zeile, mcolor.getInfinityColor().getRGB());
                } else {
                    image.setRGB(spalte, zeile, mcolor.getColorForValue(I).getRGB());
                }
                erg = 0;
                cIm = cIm - deltaIm;
            }
            cRe = cRe + deltaRe;
        }
        return image;
    }

    public BufferedImage generateCubicWithComplexMath() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        MandelbrotColor mc = new MandelbrotColor();
        double cReMin = realMin;
        double cImMin = imaginaryMin;
        double cIm = 0.0;
        double cRe = 0.0;
        double erg = 0.0;
        cRe = cReMin;
        for (int spalte = 0; spalte < width; spalte++) {
            cIm = cImMin;
            for (int zeile = 0; zeile < height; zeile++) {
                double x = 0.0;
                double y = 0.0;
                ComplexNumber c = new ComplexNumber(cIm, cRe);
                ComplexNumber z = new ComplexNumber(x, y);
                int I = 0;

                while ((I <= nMax) && (erg < 2)) {
                    I++;
                    ComplexNumber ergC = null;
                    ergC = ComplexMath.cubicMandelbrotFunction(z, c);
                    erg = ComplexMath.abs(ergC);
                    z = ergC;
                }

                if (I >= nMax) {
                    image.setRGB(spalte, zeile, mcolor.getInfinityColor().getRGB());
                } else {
                    image.setRGB(spalte, zeile, mcolor.getColorForValue(I).getRGB());
                }
                erg = 0;
                cIm = cIm - deltaIm;
            }
            cRe = cRe + deltaRe;
        }
        return image;
    }
}
