package game;


import components.Ball;
import components.Paddle;
import components.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PongGame extends JPanel implements Runnable {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private Ball ball;
    private Paddle paddleLeft;
    private Paddle paddleRight;
    private Score gameScore;

    public PongGame() {
        this.createComponents();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(new AL());

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // TODO
    }

    public void paint(Graphics g) {
        // TODO
    }

    private void createComponents() {
        // TODO
    }

    private class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            // TODO
        }

        public void keyReleased(KeyEvent e) {
            // TODO
        }

    }
}
