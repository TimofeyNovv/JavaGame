import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Floor extends Rectangle {
    private ArrayList<Bonus> bonuses = new ArrayList<>();
    private Image starsImage = new ImageIcon("images/icons/bonus/star.png").getImage();

    public Floor(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

    public ArrayList<Floor> coordinationForFloor(int numberFon) {
        ArrayList<Floor> floors = new ArrayList<>();
        switch (numberFon) {
            case 1 -> {
                bonuses.add(new Bonus(0, 600, starsImage));
                bonuses.add(new Bonus(1800, 600, starsImage));
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
                bonuses.add(new Bonus(0, 900, starsImage));
                bonuses.add(new Bonus(255, 900, starsImage));
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
                floors.add(new Floor(0, 600, 1920, 100));
            }

            case 6 -> {
                System.out.println("6");
                bonuses.clear();
                bonuses.add(new Bonus(450, 500, starsImage));
                bonuses.add(new Bonus(1070, 500, starsImage));
                bonuses.add(new Bonus(1350, 686, starsImage));


                floors.add(new Floor(55,356,190,24));
                floors.add(new Floor(392,602,190,24));
                floors.add(new Floor(710,760,190,24));
                floors.add(new Floor(1020,597,190,24));
                floors.add(new Floor(1300,786,190,24));
                floors.add(new Floor(1678,856,190,24));
                floors.add(new Floor(0, 1080, 1920, 100));

            }
            case 7 -> {
                System.out.println("7");
                bonuses.clear();

                bonuses.add(new Bonus(430, 490, starsImage));
                bonuses.add(new Bonus(1050, 650, starsImage));
                bonuses.add(new Bonus(1180, 225  , starsImage));

                floors.add(new Floor(0, 977,195,24));
                floors.add(new Floor(146, 647,195,24));
                floors.add(new Floor(390, 590,195,24));
                floors.add(new Floor(592, 750,195,24));
                floors.add(new Floor(650, 376,195,24));
                floors.add(new Floor(802, 996,195,24));
                floors.add(new Floor(1004, 750,195,24));
                floors.add(new Floor(1240, 996,195,24));
                floors.add(new Floor(1704, 977,195,24));
                floors.add(new Floor(1510, 670,195,24));
                floors.add(new Floor(1600, 288,195,24));
                floors.add(new Floor(1120, 328,195,24));
                floors.add(new Floor(0, 1080, 1920, 100));

            }

            case 8 -> {
                floors.add(new Floor(0,646,189,24));
                floors.add(new Floor(200,797,220,24));
                floors.add(new Floor(820,600,180,24));
                floors.add(new Floor(530,844,127,24));
                floors.add(new Floor(836,976,176,24));
                floors.add(new Floor(1057,1010,316,24));
                floors.add(new Floor(1280,658,266,24));
                floors.add(new Floor(1590,946,316,24));
                floors.add(new Floor(0, 1080, 1920, 100));

            }

            case 9 -> {
                bonuses.add(new Bonus(60,700,starsImage));
                bonuses.add(new Bonus(770,438,starsImage));
                bonuses.add(new Bonus(1650,204,starsImage));
                bonuses.add(new Bonus(1750,890,starsImage));

                floors.add(new Floor(0,800,200,24));
                floors.add(new Floor(285,510,180,24));
                floors.add(new Floor(296,980,192,15));
                floors.add(new Floor(495,317,180,24));
                floors.add(new Floor(735,538,180,20));
                floors.add(new Floor(1032,684,180,20));
                floors.add(new Floor(1237,436,145,14));
                floors.add(new Floor(1593,304,210,14));
                floors.add(new Floor(1378,678,154,15));
                floors.add(new Floor(1543,678,154,15));
                floors.add(new Floor(555,920,192,16));
                floors.add(new Floor(1205,990,210,15));
                floors.add(new Floor(1730,990,155,15));

                floors.add(new Floor(0, 1080, 1920, 100));
            }

        }
        return floors;
    }

    public ArrayList<Bonus> getBonuses() {
        return bonuses;
    }
}
