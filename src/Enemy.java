import javax.swing.*;
import java.awt.*;

public class Enemy {
    int x = 0;
    int y = 0;
    int v = 20;
    Image img = new ImageIcon("enemy.png").getImage();
    Road road;
    public Rectangle getRect(){
      return new Rectangle(x, y, 106, 39);
    }


    public Enemy(int x, int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }
    public void move() {
        x = x - road.car.v + v;
    }

}
