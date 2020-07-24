import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {

    BufferedImage drawImage;
    Window window;
    FractalTree fractalTree;
    Graphics2D g2d;

    public DrawPanel(Window window) {

        fractalTree = new FractalTree(0, 0, 10, Math.PI / 16, 100);

        this.window = window;

        drawImage = new BufferedImage(window.getWidth(), window.getHeight(), BufferedImage.TYPE_INT_RGB);

        g2d = drawImage.createGraphics();

    }

    @Override
    public void paint(Graphics g) {


        g2d.setColor(Color.YELLOW);

        CoordinateTree currentTree = fractalTree.coordinateTree;

        drawPoints(currentTree);

        g.drawImage(drawImage, 0, 0, null);
    }


    public void drawPoints(CoordinateTree coordinateTree) {

        int realX = coordinateTree.x + window.getWidth() / 2;
        int realY = window.getHeight() - (coordinateTree.y + window.getHeight() / 2);

        g2d.fillRect(realX, realY, 4, 4);




        if(coordinateTree.leftTree == null || coordinateTree.rightTree == null) return;
        else {

            g2d.drawLine(realX, realY, coordinateTree.leftTree.x + window.getWidth() / 2, window.getHeight() - (coordinateTree.leftTree.y + window.getHeight() / 2));
            g2d.drawLine(realX, realY, coordinateTree.rightTree.x + window.getWidth() / 2, window.getHeight() - (coordinateTree.rightTree.y + window.getHeight() / 2));
        }


        drawPoints(coordinateTree.leftTree);
        drawPoints(coordinateTree.rightTree);



    }

}
