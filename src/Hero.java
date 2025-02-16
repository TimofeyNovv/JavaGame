import java.awt.*;

public class Hero {
    private short coordX = 628;

    private int coordY = 400;

    private int JUMP_SPEED = 270;

    private boolean isjumped = true;

    private short speedX, speedY = Const.speedy;

    private Direction direction = Direction.NON;

    private Rectangle legs = new Rectangle(coordX + Const.CHARACTER_HAND_WIDTH, coordY + Const.CHARACTER_HEIGHT - 15,
            Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH, 15);

    private Rectangle head = new Rectangle(coordX + Const.CHARACTER_HAND_WIDTH, coordY,
            Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH * 2, 15);

    private Rectangle leftHand = new Rectangle(coordX, coordY + legs.height, Const.CHARACTER_HAND_WIDTH, Const.CHARACTER_HEIGHT - legs.height * 2);

    private Rectangle rightHand = new Rectangle(coordX + Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH, coordY  + legs.height,
            Const.CHARACTER_HAND_WIDTH, Const.CHARACTER_HEIGHT  - legs.height * 2);

    public void update() {
        coordX += speedX;
        coordY += speedY;

        legs.setBounds(coordX + Const.CHARACTER_HAND_WIDTH, coordY + Const.CHARACTER_HEIGHT - 15,
                Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH * 2, 15);

        head.setBounds(coordX + Const.CHARACTER_HAND_WIDTH, coordY,
                Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH * 2, 15);

        leftHand.setBounds(coordX, coordY + legs.height, Const.CHARACTER_HAND_WIDTH, Const.CHARACTER_HEIGHT - legs.height * 2);

        rightHand.setBounds(coordX + Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH, coordY  + legs.height,
                Const.CHARACTER_HAND_WIDTH, Const.CHARACTER_HEIGHT  - legs.height * 2);

        collision();
    }

    public void collision() {
        for (Floor block : Main.floors) {
            if (legs.intersects(block)) {
                coordY = block.y - Const.CHARACTER_HEIGHT;
                isjumped = false;
            } else if (head.intersects(block)) {
                coordY = block.y + block.height;
            } else if (leftHand.intersects(block)) {
                coordX += 12;
            } else if (rightHand.intersects(block)) {
                coordX -= 12;
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

    public void jump() {
        if (!isjumped) {
            if (Main.character.coordX > 0 && Main.character.coordX < 400 ){
                JUMP_SPEED = 100;
            } else if (Main.character.coordX > 401 && Main.character.coordX < 580){
                JUMP_SPEED = 150;
            } else if (Main.character.coordX > 600 && Main.character.coordX < 700aa){
                JUMP_SPEED = 250;
            } else if (Main.character.coordX > 1030 && Main.character.coordX < 1280){
                JUMP_SPEED = 50;
            }
            coordY -= JUMP_SPEED;
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

    public Rectangle getHead() {
        return head;
    }

    public Rectangle getLeftHand() {
        return leftHand;
    }

    public Rectangle getRightHand() {
        return rightHand;
    }
}
