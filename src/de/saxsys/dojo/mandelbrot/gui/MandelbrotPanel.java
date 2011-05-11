package de.saxsys.dojo.mandelbrot.gui;

import de.saxsys.dojo.mandelbrot.MandelbrotGui;
import de.saxsys.dojo.mandelbrot.control.ZoomMouseListener;
import de.saxsys.dojo.mandelbrot.util.MandelbrotConfiguration;
import de.saxsys.dojo.mandelbrot.util.MandelbrotGenerator;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Marco Dierenfeldt
 */
public class MandelbrotPanel extends JPanel {

    private MandelbrotConfiguration mConfig;
    private MandelbrotGenerator mGen;
    private BufferedImage img;

    public MandelbrotPanel(MandelbrotGui gui) {
        mConfig = new MandelbrotConfiguration();
        mConfig.setWidth(1024);
        mConfig.setHeight(768);
        mGen = new MandelbrotGenerator(mConfig);

        this.addMouseListener(new ZoomMouseListener(this, gui));
        img = mGen.generate();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        paint(g);
    }

    public MandelbrotConfiguration getmConfig() {
        return mConfig;
    }

    public void setmConfig(MandelbrotConfiguration mConfig) {
        this.mConfig = mConfig;
    }

    public void generate(){
        this.mGen = new MandelbrotGenerator(mConfig);
        this.img = mGen.generate();
        repaint();
    }

    public void saveFile(File imgFile) {
        String imagename = imgFile.getPath();
        String postfix = imagename.substring(imagename.lastIndexOf(".")+1);
        try {
            ImageIO.write(img, postfix, imgFile);
        } catch (IOException ex) {
            Logger.getLogger(MandelbrotPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
