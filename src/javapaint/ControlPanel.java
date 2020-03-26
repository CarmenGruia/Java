package javapaint;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton resetBtn =new JButton("Reset");
    JButton exitBtn =new JButton("Exit");
    //create all buttons (Load, Reset, Exit)
 //...TODO

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //add all buttons
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG",
                    new FileOutputStream("/home/carmen/Desktop/test2.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void exit(ActionEvent e)
    {

            frame.dispose();

    }
    private void reset(ActionEvent e)
    {
         frame.remove(frame.canvas);
        frame.canvas = new DrawingPanel(frame);
        add(frame.canvas);

    }


}