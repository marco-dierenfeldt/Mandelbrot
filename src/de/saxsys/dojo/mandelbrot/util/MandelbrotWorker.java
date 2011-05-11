package de.saxsys.dojo.mandelbrot.util;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author Marco Dierenfeldt
 */
public class MandelbrotWorker extends SwingWorker{

    private BufferedImage image;
    private JPanel panel;
    private double cRe;
    private double cIm;
    private double deltaIm;
    private int height;
    private int spalte;
    private int nMax;
    private MandelbrotColor mcolor;

    public MandelbrotWorker(BufferedImage image, JPanel panel, double cRe, double cIm, double deltaIm, int height, int spalte, int nMax, MandelbrotColor mcolor) {
        this.image = image;
        this.panel = panel;
        this.cRe = cRe;
        this.cIm = cIm;
        this.deltaIm = deltaIm;
        this.height = height;
        this.spalte = spalte;
        this.nMax = nMax;
        this.mcolor = mcolor;
    }



    @Override
    protected Object doInBackground() throws Exception {
        double erg = 0;
        for (int zeile = 0; zeile < height; zeile++) {
                double x = 0.0;
                double y = 0.0;
                int I = 0;

                while ((I <= nMax) && (erg < 2)) {
                    I++;
                    double xi = (x*x) - Math.pow(y, 2) + cRe;
                    y = 2 * x * y + cIm;
                    x = xi;
                    erg = Math.sqrt((x*x)+(y*y));
                }
                if (I >= nMax) {
                    image.setRGB(spalte, zeile, mcolor.getInfinityColor().getRGB());
                }else {
                    image.setRGB(spalte,zeile, mcolor.getColorForValue(I).getRGB());
                }
                erg = 0;
                cIm = cIm - deltaIm;
        }
        return image;
    }

    @Override
    protected void done() {
        panel.repaint();
    }
}
