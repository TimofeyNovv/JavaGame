import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FlowPanel extends JPanel implements Runnable {

    private BufferedImage[] imagesHero = new BufferedImage[2];
    private Animation animHero;
    private BufferedImage imageH;

    public FlowPanel() {

        try {
            imageH = ImageIO.read(new File("images/heroright/0.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        animHero = new Animation(false);
        for (byte i = 0; i < imagesHero.length; i++) {
            try {
                imagesHero[i] = ImageIO.read(new File("images/heroright/" + i + ".png"));
                animHero.addFrame(imagesHero[i], 50);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (imageH != null) {
            g.drawImage(imageH, Main.character.getCoordX(), Main.character.getCoordY(), null);

            //Отображение rectangle персонажа
            g.drawRect(Main.character.getHad().x, Main.character.getHad().y,
                    Main.character.getHad().width, Main.character.getHad().height);
            g.drawRect(Main.character.getLegs().x, Main.character.getLegs().y,
                    Main.character.getLegs().width, Main.character.getLegs().height);

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
                if (Main.character.getDirection() == Direction.RIGHT || Main.character.getDirection() == Direction.LEFT) {
                    imageH = animHero.getImage();
                }
                animHero.update(10);
                update();
                repaint();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
