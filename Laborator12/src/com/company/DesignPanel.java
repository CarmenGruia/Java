package com.company;

import javax.swing.*;

public class DesignPanel extends JPanel{
    int x=10;
    int y=210;
    public JButton createButton(){
        JButton button=new JButton("Button");
        if(x+100>=1000)
        {
            x=10;
            y=y+50;
        }
        button.setBounds(x,y,200,30);
        return button;

    }
    public JLabel createLabel(){
        JLabel label=new JLabel("Label");
        if(x+100>=1000)
        {
            x=10;
            y=y+50;
        }
        label.setBounds(x,y,200,30);
        return label;
    }
    public JTextField createTextField(){
        JTextField text=new JTextField("TextField");
        if(x+100>=1000)
        {
            x=10;
            y=y+50;
        }
        text.setBounds(x,y,200,30);
        return text;
    }
}
