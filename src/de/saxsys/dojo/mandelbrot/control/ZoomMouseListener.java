package de.saxsys.dojo.mandelbrot.control;

import de.saxsys.dojo.mandelbrot.MandelbrotGui;
import de.saxsys.dojo.mandelbrot.gui.MandelbrotPanel;
import de.saxsys.dojo.mandelbrot.util.MandelbrotConfiguration;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.PriorityQueue;

/**
 *
 * @author Marco Dierenfeldt
 */
public class ZoomMouseListener implements MouseListener{
    MandelbrotPanel mp;
    MandelbrotGui gui;

    public ZoomMouseListener(MandelbrotPanel mp,MandelbrotGui gui) {
        this.mp = mp;
        this.gui = gui;
        confQueue = new PriorityQueue<MandelbrotConfiguration>();
    }

    private PriorityQueue<MandelbrotConfiguration> confQueue;


    public void mouseClicked(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1) {
            int realX = calcRealX(e,mp);
            int realY = calcRealY(e,mp);
            System.out.println("Button1 clicked "+"("+e.getX()+"/"+e.getY()+")"
                    +"("+realX+"/"+realY+")");
            MandelbrotConfiguration mconf = mp.getmConfig();
            MandelbrotConfiguration newMconf = mconf.getNewConfigForPoint(realX, realY);
            confQueue.add(mconf);
            System.out.println(mconf);
            System.out.println(newMconf);
            mp.setmConfig(newMconf);
            gui.updateStatus();
            mp.generate();

        }
        if (e.getButton() == MouseEvent.BUTTON3){
            System.out.println("Button3 clicked "+"("+e.getX()+"/"+e.getY()+")");
            MandelbrotConfiguration mconf = confQueue.poll();
            if (mconf != null) {
                mp.setmConfig(mconf);
                mp.generate();
            }

        }
    }

    public void mousePressed(MouseEvent e) {
//        if (e.getButton()==e.BUTTON1) {
//            System.out.println("Button1 pressed");
//        }
    }

    public void mouseReleased(MouseEvent e) {
//        if (e.getButton()==e.BUTTON1) {
//            System.out.println("Button1 released");
//        }
    }

    public void mouseEntered(MouseEvent e) {
//            System.out.println("mouseEntered");
    }

    public void mouseExited(MouseEvent e) {
//          System.out.println("mouseExited");
  }

    private int calcRealX(MouseEvent e, MandelbrotPanel mp) {
        int mouseX = e.getX();
        int panelWidth = mp.getWidth();
        int mandelbrotWidth = mp.getmConfig().getWidth();

        int realx = (int) ((mandelbrotWidth * 1.0 / panelWidth) * mouseX);



        return realx;
    }

    private int calcRealY(MouseEvent e, MandelbrotPanel mp) {
        int mouseY = e.getY();
        int panelHeight = mp.getHeight();
        int mandelbrotHeight = mp.getmConfig().getHeight();

        int realy = (int) ((mandelbrotHeight * 1.0 / panelHeight) * mouseY);

        return realy;
    }

}
