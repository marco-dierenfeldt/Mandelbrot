package de.saxsys.dojo.mandelbrot.util;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author Marco Dierenfeldt
 */
public class MandelbrotColor {

    private HashMap<Integer, Color> colormap;
    private Color infinityColor = Color.BLACK;

    public MandelbrotColor() {
        colormap = new HashMap<Integer, Color>();
        colormap.put(0, new Color(0, 0, 30));
        colormap.put(1, new Color(0, 0, 45));
        colormap.put(2, new Color(0, 0, 52));
        colormap.put(3, new Color(0, 0, 59));
        colormap.put(4, new Color(0, 0, 66));
        colormap.put(5, new Color(0, 0, 73));
        colormap.put(6, new Color(0, 0, 80));
        colormap.put(7, new Color(0, 0, 87));
        colormap.put(8, new Color(0, 0, 94));
        colormap.put(9, new Color(0, 0, 101));
        colormap.put(10, new Color(0, 0, 108));
        colormap.put(11, new Color(0, 0, 115));
        colormap.put(12, new Color(0, 0, 122));
        colormap.put(13, new Color(0, 0, 129));
        colormap.put(14, new Color(0, 0, 136));
        colormap.put(15, new Color(0, 0, 143));
        colormap.put(16, new Color(0, 0, 150));
        colormap.put(17, new Color(0, 0, 157));
        colormap.put(18, new Color(0, 0, 164));
        colormap.put(19, new Color(0, 0, 171));
        colormap.put(20, new Color(0, 0, 178));
        colormap.put(21, new Color(0, 0, 185));
        colormap.put(22, new Color(0, 0, 192));
        colormap.put(23, new Color(0, 0, 199));
        colormap.put(24, new Color(0, 0, 206));
        colormap.put(25, new Color(0, 0, 213));
        colormap.put(26, new Color(0, 0, 220));
        colormap.put(27, new Color(0, 0, 227));
        colormap.put(28, new Color(0, 0, 234));
        colormap.put(29, new Color(0, 0, 241));
        colormap.put(30, new Color(0, 0, 248));
        colormap.put(31, new Color(255, 255, 0));
        colormap.put(32, new Color(225, 225, 0));
        colormap.put(33, new Color(200, 200, 0));
        colormap.put(34, new Color(175, 175, 0));
        colormap.put(35, new Color(150, 150, 0));
        colormap.put(36, new Color(125, 125, 0));
        colormap.put(37, new Color(100, 100, 0));
        colormap.put(38, new Color(75, 75, 0));
        colormap.put(39, new Color(50, 50, 0));
        colormap.put(40, new Color(25, 25, 0));
        colormap.put(41, new Color(0, 45, 45));
        colormap.put(42, new Color(0, 55, 55));
        colormap.put(43, new Color(0, 65, 65));
        colormap.put(44, new Color(0, 75, 75));
        colormap.put(45, new Color(0, 85, 85));
        colormap.put(46, new Color(0, 95, 95));
        colormap.put(47, new Color(0, 105, 105));
        colormap.put(48, new Color(0, 115, 115));
        colormap.put(49, new Color(0, 125, 125));
        colormap.put(50, new Color(0, 135, 135));
        colormap.put(51, new Color(0, 145, 145));
        colormap.put(52, new Color(0, 155, 155));
        colormap.put(53, new Color(0, 165, 165));
        colormap.put(54, new Color(0, 175, 175));
        colormap.put(55, new Color(0, 185, 185));
        colormap.put(56, new Color(0, 195, 195));
        colormap.put(57, new Color(0, 205, 205));
        colormap.put(58, new Color(0, 215, 215));
        colormap.put(59, new Color(0, 225, 225));
        colormap.put(60, new Color(0, 235, 235));
        colormap.put(61, new Color(45, 0, 0));
        colormap.put(62, new Color(55, 0, 0));
        colormap.put(63, new Color(65, 0, 0));
        colormap.put(64, new Color(75, 0, 0));
        colormap.put(65, new Color(85, 0, 0));
        colormap.put(66, new Color(95, 0, 0));
        colormap.put(67, new Color(105, 0, 0));
        colormap.put(68, new Color(115, 0, 0));
        colormap.put(69, new Color(125, 0, 0));
        colormap.put(70, new Color(135, 0, 0));
        colormap.put(71, new Color(145, 0, 0));
        colormap.put(72, new Color(155, 0, 0));
        colormap.put(73, new Color(165, 0, 0));
        colormap.put(74, new Color(175, 0, 0));
        colormap.put(75, new Color(185, 0, 0));
        colormap.put(76, new Color(195, 0, 0));
        colormap.put(77, new Color(205, 0, 0));
        colormap.put(78, new Color(215, 0, 0));
        colormap.put(79, new Color(225, 0, 0));
        colormap.put(80, new Color(0, 45, 0));
        colormap.put(81, new Color(0, 52, 0));
        colormap.put(82, new Color(0, 59, 0));
        colormap.put(83, new Color(0, 66, 0));
        colormap.put(84, new Color(0, 73, 0));
        colormap.put(85, new Color(0, 80, 0));
        colormap.put(86, new Color(0, 87, 0));
        colormap.put(87, new Color(0, 94, 0));
        colormap.put(88, new Color(0, 101, 0));
        colormap.put(89, new Color(0, 108, 0));
        colormap.put(90, new Color(0, 115, 0));
        colormap.put(91, new Color(0, 122, 0));
        colormap.put(92, new Color(0, 129, 0));
        colormap.put(93, new Color(0, 136, 0));
        colormap.put(94, new Color(0, 143, 0));
        colormap.put(95, new Color(0, 150, 0));
        colormap.put(96, new Color(0, 157, 0));
        colormap.put(97, new Color(0, 164, 0));
        colormap.put(98, new Color(0, 171, 0));
        colormap.put(99, new Color(0, 178, 0));
        colormap.put(100, new Color(0, 185, 0));
    }

    public Color getInfinityColor() {
        return infinityColor;
    }

    public Color getColorForValue(int value) {
        Color color = Color.MAGENTA;
        if (value <= 100) {
            return colormap.get(value);
        }

        return color;
    }
}
