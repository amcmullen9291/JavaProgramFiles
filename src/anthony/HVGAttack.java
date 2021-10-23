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
    int movingSpeed = 2;

    HVGAttack(int player1LocationX, int player1LocationY, int width, int height){
        super(player1LocationX, player1LocationY, width, height);
        random = new Random();
        getY(); //put direct hit or random here
        getX();
        int direction = 1;
        direction++;
        setXDirection(direction);
        int yDirection =(int) Math.random();
        if(yDirection > .5){
            yDirection++;
//            move();
        }
    }

    public void targetGoblin (int player1LocationX, int player1LocationY){

    }// arguments come from 'player1.getX()' and 'player1.getY()' methods

    public void missedShot( int player1LocationX, int player1LocationY){
        random = new Random();
    } // arguments come from 'player1.getX()' and 'player1.getY()' methods


    public void setXDirection (int direction){
        xVelocity = direction;
    }
    public void setYDirection (int yDirection){
        xVelocity = yDirection;
    }


    public void move (){
        x+= xVelocity;
        y+= yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,width,height);
    }
//    public void keyPressed(KeyEvent e) {
//        int chance = (int) Math.random();
//        if (chance < .5) {
//            if (e.getKeyCode() == KeyEvent.VK_1) {
//                setXDirection(movingSpeed);  //missed target
//                setYDirection(movingSpeed);
//                move();
//            } else {
//                if (e.getKeyCode() == KeyEvent.VK_H) {
//                    setXDirection(movingSpeed);  //direct hit
//                    move();
//                }
//            }
//        }
//    }

}