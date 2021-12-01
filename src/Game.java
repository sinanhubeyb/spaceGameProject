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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(1,this);
    private int passingTime = 0;
    private int fireCounter = 0;

    private BufferedImage image; //using png format
    private ArrayList<Fire> fires = new ArrayList<Fire>();

    private int firedir = 1;
    private int ballX=0;

    private int balldirX = 2;
    private int spaceShipX = 0;
    private int dirSpaceX = 20;
    public boolean check(){
        for (Fire fire : fires){
            if (new Rectangle(fire.getX(),fire.getY(),10,20).intersects(new Rectangle(ballX,0,20,20))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        passingTime += 5;
        g.setColor(Color.red);
        g.fillOval(ballX, 0, 20,20);
        g.drawImage(image, spaceShipX,490,image.getWidth()/10, image.getHeight()/10, this);

        for (Fire fire : fires){
            if (fire.getY()<0){
                fires.remove(fire);
            }

        }
        g.setColor(Color.BLUE);

        for (Fire fire : fires){
            g.fillRect(fire.getX(),fire.getY(),10,20);
        }

        if (check()){
            timer.stop();
            String message = "You Win!\n"+ "Fire Number: " + fireCounter + "\nTime: " + passingTime/1000.0 + " ms ";
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }

    }

    @Override
    public void repaint() {
        super.repaint(); //it calls paint every time and we use paint again..
    }

    public Game() {
        try {
            image = ImageIO.read(new FileImageInputStream(new File("spacehip.png")));
        } catch (IOException e) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE,null,e);
        }

        setBackground(Color.BLACK);


        timer.start();




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Fire fire : fires){
            fire.setY(fire.getY() - firedir);

        }


        ballX += balldirX;
        if (ballX>=750){
            balldirX = -balldirX;
        }

        if (ballX<=0){
            balldirX = -balldirX;
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode(); //return the value when we press left arrow or right arrow
        if (c == KeyEvent.VK_LEFT){
            if (spaceShipX<=0){//not going to -20 coordination
                spaceShipX=0;

            }else{
                spaceShipX -=dirSpaceX;
            }

        }else if(c== KeyEvent.VK_RIGHT){
            if (spaceShipX>=720){//not going to after 720
                spaceShipX=720;

            }else{
                spaceShipX +=dirSpaceX;
            }

        }else if (c==KeyEvent.VK_SPACE){
            fires.add(new Fire(spaceShipX+15,470));
            fireCounter++;
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
