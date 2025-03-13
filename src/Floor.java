import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Floor extends Rectangle {
    private ArrayList<Bonus> bonuses = new ArrayList<>();
    private Image startImage = new ImageIcon("images/icons/bonus/star.png").getImage();

    public Floor(int x, int y, int width, int height) {
        setBounds(x,y,width,height);
    }
    public ArrayList<Floor> coordinationForFloor(int numberFon){
        ArrayList<Floor> floors = new ArrayList<>();
        switch (numberFon){
            case 1 -> {
                bonuses.add(new Bonus(0,600, startImage));
                bonuses.add(new Bonus(1800,600, startImage));
                floors.add(new Floor(0, 1080, 1920, 20));
                floors.add(new Floor(0, 613, 190, 22));
                floors.add(new Floor(196, 718, 224, 38));
                floors.add(new Floor(531, 960, 183, 26));
                floors.add(new Floor(731, 593, 219, 25));
                floors.add(new Floor(1042, 925, 153, 20));
                floors.add(new Floor(1274, 774, 258, 28));
                floors.add(new Floor(1551, 964, 256, 28));
                floors.add(new Floor(1810, 767, 111, 27));
                floors.add(new Floor(1244, 413, 224, 27));
            }
            case 2 -> {
                bonuses.clear();
                bonuses.add(new Bonus(0,900, startImage));
                bonuses.add(new Bonus(255, 900, startImage));
                floors.add(new Floor(0, 1080, 1920, 20));
                floors.add(new Floor(0, 1058, 190, 22));
                floors.add(new Floor(205, 992, 190, 22));
                floors.add(new Floor(418, 940, 190, 22));
                floors.add(new Floor(628, 833, 190, 22));
                floors.add(new Floor(840, 650, 190, 22));
                floors.add(new Floor(1059, 650, 190, 22));
                floors.add(new Floor(1279, 402, 190, 22));
                floors.add(new Floor(1498, 344, 190, 22));
                floors.add(new Floor(1730, 344, 190, 22));
            }
            case 3 -> {
                floors.add(new Floor(0, 1080, 1920, 20));
                floors.add(new Floor(0, 342, 193, 24));
                floors.add(new Floor(192, 651, 192, 24));
                floors.add(new Floor(414, 819, 192, 26));
                floors.add(new Floor(639, 653, 193, 24));
                floors.add(new Floor(856, 819, 192, 25));
                floors.add(new Floor(1061, 652, 193, 24));
                floors.add(new Floor(1264, 545, 193, 22));
                floors.add(new Floor(1506, 398, 190, 22));
                floors.add(new Floor(1730, 295, 191, 22));
            }
            case 4 -> {
                System.out.println("4");
                floors.add(new Floor(0, 1080, 1920, 20));
                floors.add(new Floor(0,600, 1920,100));
            }

        }
        return floors;
    }

    public ArrayList<Bonus> getBonuses() {
        return bonuses;
    }
}
