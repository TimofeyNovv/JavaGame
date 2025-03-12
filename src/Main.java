import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main {
    static Hero character = new Hero();

    static Floor floor = new Floor(0, 0, 0, 0);

    static int numberfon = 1;

    static ArrayList<Floor> floors = new ArrayList<>();

    static ArrayList<Bonus> bonuses = new ArrayList<>();

    public static void main(String[] args) {
        floors = floor.coordinationForFloor(numberfon);
        Screen screen = new Screen();
        System.out.println(numberfon);
        System.out.println(numberfon);

        bonuses.add(new Bonus(100, 100, new ImageIcon("images/icons/photo_face.png").getImage()));
        bonuses.add(new Bonus(200, 800, new ImageIcon("images/icons/photo_pen.png").getImage()));

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
                        character.jump(character.strengthJump(Main.character.getCoordX(), numberfon));
                    }
                    case KeyEvent.VK_A -> {
                        character.moveLeft();
                    }
                    case KeyEvent.VK_D -> {
                        if (character.getCoordX() > 1900) {
                            character.setCoordX((short) 1);
                            character.setCoordY(150);
                            floors.clear();
                            numberfon++;
                            floors = floor.coordinationForFloor(numberfon);
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

    public static int getNumberfon() {
        return numberfon;
    }
}