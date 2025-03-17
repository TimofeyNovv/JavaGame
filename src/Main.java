import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main {
    static Hero character = new Hero();

    static Floor floor = new Floor(0, 0, 0, 0);

    static int numberfon = 13;

    static boolean isConec = false;

    static ArrayList<Floor> floors = new ArrayList<>();

    static ArrayList<BonusSyget> bonusSygets = new ArrayList<>();

    public static void main(String[] args) {
        floors = floor.coordinationForFloor(numberfon);
        Screen screen = new Screen();
        System.out.println(numberfon);
        System.out.println(numberfon);


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
                    case KeyEvent.VK_1 -> {
                        Main.setNumberfon(5);
                    }
                    case KeyEvent.VK_2 -> {
                        Main.setNumberfon(6);
                        floors = floor.coordinationForFloor(numberfon);
                    }
                    case KeyEvent.VK_3 -> {
                        Main.setNumberfon(12);
                        floors = floor.coordinationForFloor(numberfon);
                    }
                    /*case KeyEvent.VK_4 -> {
                        Main.setNumberfon(1);
                        floors = floor.coordinationForFloor(numberfon);
                    }*/
                    case KeyEvent.VK_9 -> {
                        Main.setIsConec(true);
                        System.out.println("9");
                    }
                    case KeyEvent.VK_5 -> {
                        Main.setNumberfon(13);
                        floors = floor.coordinationForFloor(numberfon);
                    }
                    case KeyEvent.VK_6 ->{
                        Main.setNumberfon(1);
                        floors = floor.coordinationForFloor(numberfon);
                        Main.character.setCoordY(300);
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

    public static void setNumberfon(int numberfon) {
        Main.numberfon = numberfon;
    }

    public static void setIsConec(boolean isConec) {
        Main.isConec = isConec;
    }

    public static boolean isIsConec() {
        return isConec;
    }
}