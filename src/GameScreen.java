import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {


    //Constructor
    public GameScreen(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {

        GameScreen screen = new GameScreen("Space Game");
        screen.setResizable(false); // We've pulled focus through the JFrame
        screen.setFocusable(false);

        screen.setSize(800, 600);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game game = new Game();
        game.requestFocus(); //It gives us the focus to understand the operations done on the keyboard.
        game.addKeyListener(game); //keyListener is an interface that allows us to do our operations from the keyboard.
        game.setFocusable(true); //We gave Jpanel the focus
        game.setFocusTraversalKeysEnabled(false);//JPanel understand keyboard command with this method

        screen.add(game);// We added the game(JPanel) to screen(JFrame)
        screen.setVisible(true);








    }
}
