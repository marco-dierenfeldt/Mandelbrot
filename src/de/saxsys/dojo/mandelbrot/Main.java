package de.saxsys.dojo.mandelbrot;

import de.saxsys.dojo.mandelbrot.util.MandelbrotConfiguration;
import de.saxsys.dojo.mandelbrot.util.MandelbrotGenerator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Marco Dierenfeldt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        MandelbrotConfiguration mConf = new MandelbrotConfiguration();
        
//        mConf.setWidth(768); //setting for cubic Mandelbrot
//        mConf.setHeight(1024); // setting for cubic Mandelbrot

        mConf.setWidth(1024);
        mConf.setHeight(768);

        mConf.setnMax(100);

//        mConf.setRealMin(-1.1); //value for generateCubicWithComplexMath()
//        mConf.setRealMax(1.1); //value for generateCubicWithComplexMath()
//        mConf.setImaginaryMin(-1.4); //value for generateCubicWithComplexMath()
//        mConf.setImaginaryMax(1.4); //value for generateCubicWithComplexMath()

        MandelbrotGenerator gen = new MandelbrotGenerator(mConf);
        long start = System.currentTimeMillis();
//        BufferedImage img = gen.generate();
        BufferedImage img = gen.generateWithComplexMath();
//        BufferedImage img = gen.generateCubicWithComplexMath();
        long stop = System.currentTimeMillis();
        long gentime = stop - start;
        System.out.println("gentime(ms) = " + gentime);
        ImageIO.write(img, "png", new File("D:\\tmp\\mandelbrot_021.png"));
        System.out.println("total(ms) = " + (System.currentTimeMillis()-start));


    }
}
