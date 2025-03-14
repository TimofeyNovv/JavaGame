import java.awt.*;

public class Hero {
    private short coordX = 20;

    private int coordY = 0;

    private boolean isjumped = true;

    private short speedX, speedY = Const.speedy;

    private Direction direction = Direction.NON;

    private Rectangle legs = new Rectangle(coordX + Const.CHARACTER_HAND_WIDTH, coordY + Const.CHARACTER_HEIGHT - 15,
            Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH, 15);

    private Rectangle head = new Rectangle(coordX + Const.CHARACTER_HAND_WIDTH, coordY,
            Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH * 2, 15);

    private Rectangle leftHand = new Rectangle(coordX, coordY + legs.height, Const.CHARACTER_HAND_WIDTH, Const.CHARACTER_HEIGHT - legs.height * 2);

    private Rectangle rightHand = new Rectangle(coordX + Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH, coordY + legs.height,
            Const.CHARACTER_HAND_WIDTH, Const.CHARACTER_HEIGHT - legs.height * 2);



    public void update() {
        coordX += speedX;
        coordY += speedY;

        legs.setBounds(coordX + Const.CHARACTER_HAND_WIDTH, coordY + Const.CHARACTER_HEIGHT - 15,
                Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH * 2, 15);

        head.setBounds(coordX + Const.CHARACTER_HAND_WIDTH, coordY,
                Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH * 2, 15);

        leftHand.setBounds(coordX, coordY + legs.height, Const.CHARACTER_HAND_WIDTH, Const.CHARACTER_HEIGHT - legs.height * 2);

        rightHand.setBounds(coordX + Const.CHARACTER_WIDTH - Const.CHARACTER_HAND_WIDTH, coordY + legs.height,
                Const.CHARACTER_HAND_WIDTH, Const.CHARACTER_HEIGHT - legs.height * 2);

        collision();
    }

    public void collision() {
        for (Floor block : Main.floors) {
            if (legs.intersects(block)) {
                coordY = block.y - Const.CHARACTER_HEIGHT;
                isjumped = false;
            } else if (head.intersects(block)) {
                coordY = block.y + block.height;
            } /*else if (leftHand.intersects(block)) {
                coordX += 12;
            } else if (rightHand.intersects(block)) {
                coordX -= 12;
            }*/
        }
        for (BonusSyget bonusic : Main.bonusSygets) {
            if (legs.intersects(bonusic.getBody()) || head.intersects(bonusic.getBody())
                    || leftHand.intersects(bonusic.getBody()) || rightHand.intersects(bonusic.getBody())) {
                bonusic.setX(3000);
            }
        }
        for (Bonus bonusic : Main.floor.getBonuses()) {
            if (legs.intersects(bonusic.getBody()) || head.intersects(bonusic.getBody())
                    || leftHand.intersects(bonusic.getBody()) || rightHand.intersects(bonusic.getBody())) {
                bonusic.setX(3000);
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

    public int strengthJump(int coordX, int numberFon){
        int jumpSpeed = 0;
        switch (numberFon){
            case 1 -> {
                jumpSpeed = 100;
            }
            case 2 -> {
                if (coordX > 0 && coordX < 400) {
                    jumpSpeed = 100;
                } else if (coordX > 401 && coordX < 580) {
                    jumpSpeed = 150;
                } else if (coordX > 600 && coordX < 700) {
                    jumpSpeed = 250;
                } else if (coordX > 701 && coordX < 1000) {
                    jumpSpeed = 50;
                } else if (coordX > 1001 && coordX < 1150) {
                    jumpSpeed = 260;
                } else if (coordX > 1051 && coordX < 2000) {
                    jumpSpeed = 70;
                }
            }
            case 3 -> {
                jumpSpeed = 150;
            }
            case 4 -> {
                jumpSpeed = 100;
            }
            case 6 -> {
                jumpSpeed = 200;
            }
            case 7 -> {
                jumpSpeed = 200;
            }
            case 8 -> {
                jumpSpeed = 200;
            }
            case 9 -> {
                jumpSpeed =  200;
            }
        }
        return jumpSpeed;
    }
    public void jump(int strengthJump) {
        if (!isjumped) {
            coordY -= strengthJump;
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

    public void setCoordX(short coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
}
