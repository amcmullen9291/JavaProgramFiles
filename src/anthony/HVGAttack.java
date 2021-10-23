package anthony;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;

public class HVGAttack extends Rectangle{

    Random random;
    int xVelocity;
    int yVelocity;

    HVGAttack(int player1LocationX, int player1LocationY, int width, int height){
        super(player1LocationX, player1LocationY, width, height);
        random = new Random();
        getY(); //put direct hit or random here
        getX();
        int direction = 1;
            direction++;
            setXDirection(direction);
        }

    public void targetGoblin (int player1LocationX, int player1LocationY){

    }// arguments come from 'player1.getX()' and 'player1.getY()' methods

    public void missedShot( int player1LocationX, int player1LocationY){
        random = new Random();
    } // arguments come from 'player1.getX()' and 'player1.getY()' methods


    public void setXDirection (int direction){
        xVelocity = direction;
    }
    public void move (){
        x+= xVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,width,height);
    }

}
