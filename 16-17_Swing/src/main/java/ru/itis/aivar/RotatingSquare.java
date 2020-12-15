package ru.itis.aivar;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RotatingSquare extends JPanel {
    private double theta = 0;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.red);
        int side = (int) Math.sqrt(this.getWidth()*this.getHeight()/2);
        Rectangle rect2 = new Rectangle(50, 50, side, side);
        g2d.setTransform(AffineTransform.getRotateInstance(theta,50+side/2, (50+side/2)));
        theta+=0.03;
        g2d.draw(rect2);
        g2d.fill(rect2);
    }
}
