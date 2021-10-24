package anthony;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;

public class HVGGameFrame extends JFrame{

    HVGGamePanel panel;

    HVGGameFrame(){
        panel = new HVGGamePanel();
        this.add(panel);
        this.setTitle("HVG: Humans vs. Goblins");
        this.setResizable(false);
        this.setBackground(Color.GREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        JFrame f = new JFrame("Humans VS. Goblins");
        //set size and location of frame
        f.setSize(390, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultLookAndFeelDecorated(true);
        JLabel labelM = new JLabel("Humans vs. Goblins");
        labelM.setBounds(50, 50, 200, 10);
        JLabel theRules = new JLabel("The Rules:");
        JLabel enumeration = new JLabel("Reach the other side of ");
        JLabel enumeration2 = new JLabel("the battle field to complete the challenge.");
        JLabel enumeration3 = new JLabel("Use the arrow keys to navigate.");
        JLabel enumeration4 = new JLabel("the space bar stops forward");
        JLabel enumeration5 = new JLabel("movement.");

        //set size of the text box
        theRules.setBounds(50, 75, 200, 35);
        enumeration.setBounds(50,105,200,15);
        enumeration2.setBounds(50,120,200,15);
        enumeration3.setBounds(50,135,200,15);
        enumeration4.setBounds(50,145,200,15);
        enumeration5.setBounds(50,155,200,15);

//        JButton beginButton = new JButton("Begin!");
//        beginButton.setBounds(125, 180, 100, 30);
//        beginButton.setBackground(Color.pink);
        JRadioButton beginButton = new JRadioButton("Begin");
        beginButton.setBounds(195, 180, 100, 30);
        beginButton.setBackground(Color.orange);

        //add button to the frame
        f.add(beginButton);
        //add elements to the frame
        f.add(labelM);
        f.add(theRules);
        f.add(enumeration);
        f.add(enumeration2);
        f.add(enumeration3);
        f.add(enumeration4);
        f.add(enumeration5);
        f.setLayout(null);
        f.setVisible(true);
    }




}