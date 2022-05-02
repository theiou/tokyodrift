import javax.swing.*;

public class Main {
    static JFrame jFrame = new JFrame("TokyoDrift");

    public static void main(String[] args) {
        Road road = new Road();
        getFrame();
        jFrame.add(road);
    }

    static void getFrame() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setBounds(0, 0, 1152, 648);
        jFrame.setVisible(true);
    }
}