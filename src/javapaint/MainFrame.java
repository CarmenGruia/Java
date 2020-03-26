package javapaint;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SpringLayout;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {

        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
       canvas = new DrawingPanel(this);
       configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);

        //JFrame uses a BorderLayout by default
        add(configPanel,"North");
        add(controlPanel,"South");
        add(canvas,"Center"); //this is BorderLayout.CENTER


        //invoke the layout manager
        pack();
    }
}