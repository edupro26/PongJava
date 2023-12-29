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
    private static final int HEIGHT = WIDTH * 9 / 16;

    private boolean running = false;
    private Thread gameThread;

    /* Game components */
    private Ball ball;
    private Paddle paddleLeft;
    private Paddle paddleRight;
    private Score gameScore;

    public PongGame() {
        this.frameInit();
        this.gameInit();
        new Frame("Pong", this);
        this.start();
    }

    private void frameInit() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(new AL());
    }

    private void gameInit() {
        ball = new Ball();
        paddleLeft = new Paddle();
        paddleRight = new Paddle();
        gameScore = new Score();
    }

    private synchronized void start() {
        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }

    private void stop() {
        try {
            gameThread.join();
            if (running)
                running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update() {
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

    public void paint(Graphics g) {
        // TODO
    }

    @Override
    public void run() {
        while (running) {
            // TODO
        }
        this.stop();
    }

}
