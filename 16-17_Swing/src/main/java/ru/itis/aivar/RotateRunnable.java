package ru.itis.aivar;

import javax.swing.*;

public class RotateRunnable implements Runnable{
    private JPanel rotate;

    public RotateRunnable(JPanel rotate) {
        this.rotate = rotate;
    }

    @Override
    public void run() {
        while (true){
            rotate.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
