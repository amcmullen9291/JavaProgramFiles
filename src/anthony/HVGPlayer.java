package anthony;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;

public class HVGPlayer extends Rectangle{

//    int player1ID;
//    int goblinID;
    int id;
    int speed = 5;
    int goblinSpeed = 6;
    int yVelocity;
    int xVelocity;

    HVGPlayer(int xAxisStart, int yAxisStart, int player_width, int player_height, int id){
        super(xAxisStart, yAxisStart, player_width, player_height);
        this.id = id;
    }

    public void keyPressed(KeyEvent e){
        switch(id){
        case 1:
            if(e.getKeyCode()==KeyEvent.VK_W){
                setXDirection(-speed);
                move();
             }
            if(e.getKeyCode()==KeyEvent.VK_E){
                setXDirection(speed);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_N){
                setYDirection(-speed);
                move();
        }
            if(e.getKeyCode()==KeyEvent.VK_S){
                setYDirection(speed);
                move();
            }
            break;
        case 2:
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                setXDirection(-goblinSpeed);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                setXDirection(goblinSpeed);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_UP){
                setYDirection(-goblinSpeed);
                move();
            }

            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                setYDirection(goblinSpeed);
                move();
            }
            break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch(id){
        case 1:
            if(e.getKeyCode()==KeyEvent.VK_W){
                setXDirection(0);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_E){
                setXDirection(0);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_N){
                setYDirection(0);
                move();
            }

            if(e.getKeyCode()==KeyEvent.VK_S){
                setYDirection(0);
                move();
            }
            break;
        case 2:
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                setXDirection(0);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                setXDirection(0);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                setYDirection(0);
                move();
            }

            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                setYDirection(0);
                move();
            }
            break;
        }
    }

    public void setYDirection(int yDirection){
        yVelocity=yDirection;
    }

    public void setXDirection(int xDirection){
        xVelocity=xDirection;
    }
//    public void followHumanAcross (int xDirection, int xVelocity ){
//        xDirection =
//    }

    public void move(){
        x=x+xVelocity;
        y=y+yVelocity;
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
