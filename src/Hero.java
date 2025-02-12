import java.awt.*;

public class Hero {
    private short coordX = 100;
    private int coordY = 580;

    private boolean isjumped = true;
    private short speedX, speedY = Const.speedy;

    private Direction direction = Direction.NON;

    private Rectangle legs = new Rectangle(coordX, coordY + Const.CHARACTER_HEIGHT - 15,
            Const.CHARACTER_WIDTH, 15);

    private Rectangle had = new Rectangle(coordX, coordY, Const.CHARACTER_WIDTH, 15);

    public void update() {
        coordX += speedX;
        coordY += speedY;
        legs.setBounds(coordX, coordY + Const.CHARACTER_HEIGHT - 15, Const.CHARACTER_WIDTH, 15);
        had.setBounds(coordX, coordY, Const.CHARACTER_WIDTH, 15);
        collision();
        // coordX -= speedX;
    }

    public void collision(){
        for (Floor block : Main.floors) {
            if (legs.intersects(block)){
                coordY = block.y - Const.CHARACTER_HEIGHT;
                isjumped = false;
            } else if (had.intersects(block)) {
                coordY = block.y + block.height;
            }
        }

    }

    public void moveRight() {
        direction = Direction.RIGHT;
        speedX = Const.speedx;
    }

    public void moveLeft() {
        direction = Direction.LEFT;
        speedX = -Const.speedx;
    }
    public void jump(){
        if(!isjumped){
            coordY -= Const.JUMP_SPEED;
            isjumped = true;
        }

    }

    public void stop() {
        direction = Direction.NON;
        speedX = 0;
    }

    public short getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public Direction getDirection() {
        return direction;
    }

    public Rectangle getLegs() {
        return legs;
    }

    public Rectangle getHad() {
        return had;
    }
}
