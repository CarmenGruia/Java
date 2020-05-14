package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JFrame {
    JFrame mainframe = new JFrame();
    JPanel controlPanel=new JPanel();
    JPanel designPanel=new JPanel();
    DesignPanel panel=new DesignPanel();
    JTextField textField1 = new JTextField("Type here...");
    JLabel label1= new JLabel ("");
    JButton button1 = new JButton("Add");

    public ControlPanel(JFrame f) {
        mainframe = f;
        mainframe.setSize(1000, 600);
        controlPanel.setBounds(0,0,1000,200);
        designPanel.setBounds(0,200,1000,400);
        mainframe.add(controlPanel);
        mainframe.add(designPanel);

        textField1.setBounds(30, 10, 300, 30);

        button1.setBounds(450, 10, 100, 30);
        button1.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text=textField1.getText();
                if(text.equals("javax.swing.JButton"))
                {label1.setText("It is applicable");
                JButton button=panel.createButton();
                designPanel.add(button);
                designPanel.revalidate();
                }
                else if(text.equals("javax.swing.JLabel"))
                {label1.setText("It is applicable");
                    JLabel label=panel.createLabel();
                    designPanel.add(label);
                    designPanel.revalidate();
                }
                else if(text.equals("javax.swing.JTextField"))
                {label1.setText("It is applicable");
                    JTextField textField=panel.createTextField();
                    designPanel.add(textField);
                    designPanel.revalidate();
                }
                else label1.setText("It is not applicable");

            }
        });
        label1.setBounds(650, 10, 300, 30);

        controlPanel.add(textField1);
        controlPanel.add(button1);
        controlPanel.add(label1);
        mainframe.setLayout(null);
        mainframe.setVisible(true);
    }

}
