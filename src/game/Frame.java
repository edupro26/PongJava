package game;


import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {

    public Frame(String title, PongGame game) {
        this.add(game);
        this.setTitle(title);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
