package game;


import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {

    public Frame() {
        PongGame pong = new PongGame();
        this.add(pong);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
