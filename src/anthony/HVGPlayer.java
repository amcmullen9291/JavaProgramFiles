package anthony;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;

public class HVGPlayer extends Rectangle{

    int player1ID;
    int goblinID;
    int id;
    int yVelocity;
    int xVelocity;

    HVGPlayer(int xAxisStart, int yAxisStart, int player_width, int player_height, int id){
        super(xAxisStart, yAxisStart, player_width, player_height);
        this.id = id;
    }

    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }

    public void setYDirection(int yDirection){

    }

    public void setXDirection(int xDirection){

    }

    public void move(){

    }

    public void draw(Graphics g){
        if(id==1){
            g.setColor(Color.yellow);
        }else{
            g.setColor(Color.DARK_GRAY);
        }
        g.fillRect(x,y,width,height);
    }
}
