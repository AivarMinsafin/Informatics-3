package ru.itis.aivar;

import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.white);

        g.setColor(Color.red);
        int side = (int) Math.sqrt(this.getWidth()*this.getHeight()/2);
        g.fillRect(50, 50, side, side);
    }

}
