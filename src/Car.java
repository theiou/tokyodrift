import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Car {
    public static final int MAX_V = 30;
    public static final int MAX_TOP = 265;
    public static final int MAX_BOTTOM = 537;

    Image img = new ImageIcon("car.png").getImage();
    Image imgSUN = new ImageIcon("sunFORMISHA.png").getImage();

    public Rectangle getRect(){
        return new Rectangle(x, y, 184, 75);
    }

//cars speed
    int v = 20;
    int dv = 0;
    int dy = 0;
//cars coords
    int x = 0;
    int y = 400;
    int s = 0;
//bg coords
    int layer1 = 0;
    int layer2 = 1152;

    public void move() {
        s += 1;
        v += dv;

        if (v <= 0) v = 0;
        if (v >= MAX_V) v = MAX_V;
        y += dy;
        if (y >= MAX_BOTTOM) y = MAX_BOTTOM;
        if (y <= MAX_TOP) y = MAX_TOP;

        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 1152;
        }else {
            layer1 -= v;
            layer2 -= v;
        }
        layer1 -= v;
        layer2 -= v;

    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            dv = 1;
        }
        if (key == KeyEvent.VK_LEFT){
            dv = -1;
        }
        if (key == KeyEvent.VK_UP){
            dy = -7;
        }
        if (key == KeyEvent.VK_DOWN){
            dy = 7;
        }

    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            dv = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
            dy = 0;
        }

    }
}
