import java.awt.*;

public class Bonus {
    private int x, y;
    private Rectangle body = new Rectangle();
    private boolean isTake = false;

    private Image imageBonus;

    public Bonus(int x, int y, Image imageIcon) {
        this.x = x;
        this.y = y;
        this.imageBonus = imageIcon;
        body.setRect(x, y, 50, 50);


    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isTake() {
        return isTake;
    }

    public Rectangle getBody() {
        return body;
    }

    public Image getImageBonus() {
        return imageBonus;
    }
}
