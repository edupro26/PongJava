package components;

import java.awt.*;

public class Paddle extends Rectangle implements Component {

    private final Color color;

    public Paddle(int x, int y, int width, int height, Color c) {
        super(x, y, width, height);
        color = c;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

}
