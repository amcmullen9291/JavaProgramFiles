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
//        this.setBackground(Color.yellow);
        this.setBackground(Color.GREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


}
