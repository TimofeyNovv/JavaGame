import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main {
    static Hero character = new Hero();

    static ArrayList<Floor> floors = new ArrayList<>();

    public static void main(String[] args) {
        Screen screen = new Screen();

        floors.add(new Floor(50,600, 170,380));
        floors.add(new Floor(280,580, 130,380));
        floors.add(new Floor(470,620, 150,380));
        floors.add(new Floor(50, 450, 100, 30));

        FlowPanel panel = new FlowPanel();
        screen.add(panel);
        panel.setBackground(Color.darkGray);

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
                    case KeyEvent.VK_D -> {
                        character.moveRight();
                    }
                    case KeyEvent.VK_A -> {
                        character.moveLeft();
                    }


                }
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_D -> {
                        character.stop();
                    }
                    case KeyEvent.VK_A -> {
                        character.stop();
                    }
                    case KeyEvent.VK_SPACE -> {
                        character.stop();
                    }
                }
                super.keyReleased(e);
            }
        });

        screen.setVisible(true);
    }
}