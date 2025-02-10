import javax.swing.*;

public class Screen extends JFrame {
    public Screen(){
        setSize(700,700);
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
