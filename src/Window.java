import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {

    DrawPanel drawPanel;

    public Window() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setTitle("Fractal");

        drawPanel = new DrawPanel(this);
        this.add(drawPanel);

        this.setVisible(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(1);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

}
