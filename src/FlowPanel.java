import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FlowPanel extends JPanel implements Runnable {

    private BufferedImage[] imagesHero = new BufferedImage[1];
    private Animation animHeroRight;
    private Animation animHeroLeft;
    private BufferedImage imageH;

    private Image fonimage;
    //fonimage =

    public FlowPanel() {

        try {
            imageH = ImageIO.read(new File("images/heroright/0.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        animHeroRight = new Animation(false);
        animHeroLeft = new Animation(false);
        for (byte i = 0; i < imagesHero.length; i++) {
            try {
                imagesHero[i] = ImageIO.read(new File("images/heroright/" + i + ".png"));
                animHeroRight.addFrame(imagesHero[i], 50);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for (byte i = 0; i < imagesHero.length; i++) {
            try {
                imagesHero[i] = ImageIO.read(new File("images/heroleft/" + i + ".png"));
                animHeroLeft.addFrame(imagesHero[i], 50);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (imageH != null) {
            g.drawImage(Main.fon2image, 0, 0, null);

            g.drawImage(imageH, Main.character.getCoordX(), Main.character.getCoordY(), null);

            //Отображение rectangle персонажа
            g.drawRect(Main.character.getLeftHand().x, Main.character.getLeftHand().y,
                    Main.character.getLeftHand().width, Main.character.getLeftHand().height);

            g.drawRect(Main.character.getHead().x, Main.character.getHead().y,
                    Main.character.getHead().width, Main.character.getHead().height);

            g.drawRect(Main.character.getLegs().x, Main.character.getLegs().y,
                    Main.character.getLegs().width, Main.character.getLegs().height);

            g.drawRect(Main.character.getRightHand().x, Main.character.getRightHand().y,
                    Main.character.getRightHand().width, Main.character.getRightHand().height);

            //Отображение rectangle для платформ
            for (Floor block : Main.floors) {
                g.drawRect(block.x, block.y, block.width, block.height);
            }
        }
    }

    public void update() {
        Main.character.update();
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (Main.character.getDirection() == Direction.RIGHT) {
                    imageH = animHeroRight.getImage();
                } else if (Main.character.getDirection() == Direction.LEFT) {
                    imageH = animHeroLeft.getImage();
                }
                animHeroRight.update(10);
                animHeroLeft.update(10);
                update();
                repaint();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
