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

        final int pWIDTH = 20, pHEIGHT = 100;
        final int yPADDLE = HEIGHT/2 - pHEIGHT/2;
        paddleLeft = new Paddle(0, yPADDLE, pWIDTH, pHEIGHT, Color.GREEN);
        paddleRight = new Paddle(WIDTH - pWIDTH, yPADDLE, pWIDTH, pHEIGHT, Color.RED);

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

    public void update() {
        // TODO
    }

    public void paint(Graphics g) {
        Image image = createImage(getWidth(), getHeight());
        Graphics graphics = image.getGraphics();

        paddleLeft.draw(graphics);
        paddleRight.draw(graphics);
        ball.draw(graphics);
        gameScore.draw(graphics);

        g.drawImage(image,0,0,this);
    }

    @Override
    public void run() {
        // Simple game loop with FPS and UPS counter
        final double UPS = 60.0;
        final double FPS = 60.0;

        final double uTIME = 1000000000 / UPS;
        final double fTIME = 1000000000 / FPS;

        double uDelta = 0, fDelta = 0;
        int uCounter = 0, fCounter = 0;
        long start = System.nanoTime();
        long timer = System.currentTimeMillis();
        while (running) {
            long now = System.nanoTime();
            uDelta += (now - start);
            fDelta += (now - start);
            start = now;

            if (uDelta >= uTIME) {
                this.update();
                uCounter++;
                uDelta -= uTIME;
            }
            if (fDelta >= fTIME) {
                this.repaint();
                fCounter++;
                fDelta -= fTIME;
            }

            if (System.currentTimeMillis() - timer == 1000) {
                System.out.println("FPS: " + fCounter + ", UPS: " + uCounter);
                uCounter = 0;
                fCounter = 0;
                timer += 1000;
            }
        }
        this.stop();
    }

    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            // TODO
        }

        public void keyReleased(KeyEvent e) {
            // TODO
        }

    }

}
