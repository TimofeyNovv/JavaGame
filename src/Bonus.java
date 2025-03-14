import java.awt.*;

public class Bonus {
    private int x, y;

    private Rectangle body = new Rectangle();

    private boolean isTake = false;

    private int width = 100, height = 100;

    private Image imageBonus;

    public Bonus(int x, int y, Image imageBonus) {
        this.x = x;
        this.y = y;
        this.imageBonus = imageBonus;
        body.setRect(x, y, width, height);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getBody() {
        return body;
    }

    public Image getImageBonus() {
        return imageBonus;
    }

    public void setX(int x) {
        this.x = x;
    }
}
