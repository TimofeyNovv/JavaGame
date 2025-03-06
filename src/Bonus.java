import java.awt.*;

public class Bonuses {
    private int x, y;
    private Rectangle body = new Rectangle();
    private boolean isTake = false;

    private Image imageIcon;

    public Bonuses(int x, int y, Image imageIcon) {
        this.x = x;
        this.y = y;
        this.imageIcon = imageIcon;
        body.setRect(x, y, 50, 50);
    }

    public void collision(){
        if (body.intersects(Main.character.getLeftHand()) || body.intersects(Main.character.getRightHand())
        || body.intersects(Main.character.getLegs()) || body.intersects(Main.character.getHead())){
            isTake = true;

        }
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

    public Image getImageIcon() {
        return imageIcon;
    }
}
