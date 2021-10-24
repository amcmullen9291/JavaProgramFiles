package anthony;

import java.awt.*;
import java.util.*;
import java.awt.Color;

public class HVGAttack extends Rectangle{

    Random random;
    int xVelocity;
    int yVelocity;
    int movingSpeed = 5;

    HVGAttack(int player1LocationX, int player1LocationY, int width, int height){
        super(player1LocationX, player1LocationY, width, height);
        random = new Random();
        double chance = Math.random();
        if(chance > .5){
            int direction = 1;
            direction++;
            setXDirection(direction*movingSpeed); //targetGoblin()
        }
        if(chance < .5){ //missedTarget()
            int direction = 1;
            direction++;
            setXDirection(direction*movingSpeed);
            int yDirection = random.nextInt(2);
            if(yDirection==0){
                yDirection--;
                setYDirection(yDirection*movingSpeed);
            }else{
                int angle = random.nextInt(5 - 1 + 1) + 1;
                yDirection = yDirection++*angle;
                setYDirection(yDirection*movingSpeed);
            }
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
        yVelocity = yDirection;
    }


    public void move (){
        x+= xVelocity;
        y+= yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,width,height);
    }
}