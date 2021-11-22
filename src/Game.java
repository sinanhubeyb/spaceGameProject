import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game extends JPanel implements KeyListener, ActionListener {

    private int passingTime = 0;
    private int fireCounter = 0;

    private BufferedImage image; //using png format
    private ArrayList<Fire> fires = new ArrayList<Fire>();

    private int fireY = 1;
    private int ballX=0;

    private int balldirX = 2;
    private int spaceShipX = 0;
    private int dirSpaceX = 20;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(ballX, 0, 20,20);
        g.drawImage(image, spaceShipX,490,image.getWidth()/10, image.getHeight()/10, this);

    }

    @Override
    public void repaint() {
        super.repaint(); //it calls paint every time and we use paint again..
    }

    public Game() {
        try {
            image = ImageIO.read(new FileImageInputStream(new File("20-206831_nasa-spaceship-png-real-rocket-png.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBackground(Color.BLACK);






    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
