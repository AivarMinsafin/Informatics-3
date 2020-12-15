package ru.itis.aivar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String DEFAULT_STATUS = "Status...";
    private JFrame mainFrame;
    private JPanel buttonsPanel;
    private JPanel statusPanel;
    private JPanel contentPanel;


    public void start() {
        mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Menu initialization
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem about = new JMenuItem("About");
        JMenuItem exit = new JMenuItem("Close");
        file.add(about);
        file.add(exit);
        about.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(menuBar, "Information...");
        });
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        file.add(about);
        file.add(exit);
        menuBar.add(file);
        mainFrame.setJMenuBar(menuBar);

        //Status initialization
        statusPanel = new JPanel();

        JLabel status = new JLabel("Status...");
        statusPanel.add(status);

        mainFrame.add(statusPanel, BorderLayout.SOUTH);

        //Buttons initialization
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
//        buttonsPanel.setSize((int) (mainFrame.getHeight() * 0.25), mainFrame.getHeight());
        List<JButton> buttons = new ArrayList<>();
        JButton drawButton = new JButton("Draw");
        drawButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton rotateButton = new JButton("Rotate");
        rotateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton formButton = new JButton("Form");
        formButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.add(drawButton);
        buttons.add(rotateButton);
        buttons.add(formButton);
        JPanel square = new Square();
        JPanel form = new JPanel();
        JTextField formField = new JTextField("Form field example");
        form.add(formField);
        JButton form2Button = new JButton("Submit");
        form.add(form2Button);
        JPanel rotate = new RotatingSquare();

        drawButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.remove(form);
                mainFrame.remove(rotate);
                mainFrame.add(square, BorderLayout.CENTER);
                square.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                status.setText("Draw square");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                status.setText(DEFAULT_STATUS);
            }
        });
        rotateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.remove(square);
                mainFrame.remove(form);
                mainFrame.add(rotate, BorderLayout.CENTER);
                int x = 0;
                while (x < 1000){
                    rotate.repaint();
                    x++;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                status.setText("Rotate square");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                status.setText(DEFAULT_STATUS);
            }
        });
        formButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.remove(square);
                mainFrame.remove(rotate);
                mainFrame.add(form, BorderLayout.CENTER);
                form.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                status.setText("Show form");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                status.setText(DEFAULT_STATUS);
            }
        });
//        for (JButton button : buttons) {
//            button.setSize(button.getWidth(), button.getHeight()/3);
//        }

        buttonsPanel.add(drawButton);
        buttonsPanel.add(rotateButton);
        buttonsPanel.add(formButton);

        mainFrame.add(buttonsPanel, BorderLayout.EAST);

        //Set visible
        mainFrame.setBounds(500, 500, 600, 600);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new App().start();
    }
}
