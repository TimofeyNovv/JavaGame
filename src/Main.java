import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main {
    static Hero character = new Hero();

    static int numberfon = 2;
    static ArrayList<Floor> floors = new ArrayList<>();

    static Image fonImage = new ImageIcon("images/backgrounds/fon2.png").getImage();

    public static void main(String[] args) {

        Screen screen = new Screen();

        floors.add(new Floor(0, 1058, 190, 22));
        floors.add(new Floor(205, 992, 190, 22));
        floors.add(new Floor(418, 940, 190, 22));
        floors.add(new Floor(628, 833, 190, 22));
        floors.add(new Floor(840, 650, 190, 22));
        floors.add(new Floor(1059, 650, 190, 22));
        floors.add(new Floor(1279, 402, 190, 22));
        floors.add(new Floor(1498, 344, 190, 22));
        floors.add(new Floor(1730, 344, 190, 22));

        FlowPanel panel = new FlowPanel();
        screen.add(panel);

        Thread thread = new Thread(panel);
        thread.start();

        screen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE -> {
                        System.exit(0);
                    }

                    case KeyEvent.VK_SPACE -> {
                        character.jump();
                    }
                    case KeyEvent.VK_A -> {
                        character.moveLeft();
                    }
                    case KeyEvent.VK_D -> {
                        if (character.getCoordX() > 1900 && character.getCoordY() < 650 && numberfon == 2){
                            System.out.println("skd;akslk;a");
                            character.setCoordX((short) 1);
                            character.setCoordY(150);
                            floors.clear();
                            fonImage = new ImageIcon("images/backgrounds/fon3.png").getImage();
                            numberfon = 3;
                        } else {
                            character.moveRight();
                        }
                    }


                }
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_D -> {
                        character.stop();
                    }
                    case KeyEvent.VK_A -> {
                        character.stop();
                    }
                }
                super.keyReleased(e);
            }
        });

        screen.setVisible(true);
    }

    public Image getFonimage() {
        return fonImage;
    }
}