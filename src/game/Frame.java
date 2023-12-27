package game;


import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        PongGame pong = new PongGame();
        this.add(pong);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
