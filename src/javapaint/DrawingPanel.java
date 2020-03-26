package javapaint;
import java.util.Random;
import javax.annotation.processing.Completion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;
//import javapaint.ConfigPanel;


public class DrawingPanel extends JPanel {
    Random rand=new  Random();
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    //...NEXT SLIDE

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
        int radius = 20+rand.nextInt(200);//generate a random number
       String sides =frame.configPanel.sidesField.getValue().toString() ; //get the value from UI (in ConfigPanel)
        String []colors={"BLACK","GRAY","RED","BLUE","ORANGE","GREEN","PINK"};
        int index=frame.configPanel.colorCombo.getSelectedIndex();//get the index of the selected color
        Color color;
        if(index==0)
            color=Color.BLACK;
        else if(index==1)
            color=Color.GRAY;
        else if(index==2)
            color=Color.RED;
        else if(index==3)
            color=Color.BLUE;
        else if(index==4)
            color=Color.ORANGE;
        else if(index==5)
            color=Color.GREEN;
        else color=Color.PINK;
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, Integer.parseInt(sides)));
    }
    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}