import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Road extends JPanel implements ActionListener, Runnable {
    Timer roadTimer = new Timer(10, this);
    Image img = new ImageIcon("road.png").getImage();
    Car car = new Car();
    Thread enemiesCreating = new Thread(this);
    java.util.List<Enemy> enemies = new ArrayList<Enemy>();

    public Road() {
        roadTimer.start();
        enemiesCreating.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        car.move();
        repaint();
        testCollision();
    }

    @Override
    public void run() {
        while (true) {
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(3000));
                enemies.add(new Enemy(1300,rand.nextInt(270, 537),rand.nextInt(25), this));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            car.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            car.keyReleased(e);
        }

    }
    public void paint(Graphics g) {
        g = (Graphics2D)g;
        g.drawImage(img, car.layer1, 0, null);
        g.drawImage(img, car.layer2, 0, null);
        g.drawImage(car.img, car.x, car.y, null);
        g.drawImage(car.imgSUN, 900, 20, null);

        g.setColor(Color.RED);
        Font font = new Font("Arial", Font.ITALIC, 25);
        g.setFont(font);
        g.drawString("Вы какт продержались: " + car.s + " метроу", 50, 50);

        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy e = i.next();
            if (e.x <= -1152){
                i.remove();
            }else {
                e.move();
                g.drawImage(e.img, e.x, e.y, null);
            }
            System.out.println(enemies.size());
        }
    }
    private void testCollision() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (car.getRect().intersects(e.getRect())){
                i.remove();
                JOptionPane.showMessageDialog(null, "Ты проебал \n" + "Вы проехали: " + car.s);
                System.exit(1);
            }
        }
    }
}
