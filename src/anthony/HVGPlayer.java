package anthony;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class HVGPlayer extends Rectangle{

    int id;
    int speed = 5;
    int goblinSpeed = 6;
    int yVelocity;
    int xVelocity;
    Graphics g;
    static int playerScore;

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
                    try {
                        Robot robot = new Robot();
                        // Simulate a key press
                        for(int robotMove =0; robotMove<3; robotMove++) {
                            robot.keyPress(KeyEvent.VK_E);
                            robot.keyRelease(KeyEvent.VK_E);
                        }
                    } catch (AWTException bot) {
                        bot.printStackTrace();
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    setXDirection(goblinSpeed);
                    move();
                    try {
                        Robot robot = new Robot();
                        // Simulate a key press
                        for(int robotMove =0; robotMove<3; robotMove++) {
                            robot.keyPress(KeyEvent.VK_E);
                            robot.keyRelease(KeyEvent.VK_E);
                        }
                    } catch (AWTException bot) {
                        bot.printStackTrace();
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(-goblinSpeed);
                    move();
                    try {
                        Robot robot = new Robot();
                        // Simulate a key press
                        for(int robotMove =0; robotMove<3; robotMove++) {
                            robot.keyPress(KeyEvent.VK_N);
                            robot.keyRelease(KeyEvent.VK_N);
                        }
                    } catch (AWTException bot) {
                        bot.printStackTrace();
                    }

                }

                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(goblinSpeed);
                    move();
                    try {
                        Robot robot = new Robot();
                        // Simulate a key press
                        for(int robotMove =0; robotMove<3; robotMove++) {
                            robot.keyPress(KeyEvent.VK_S);
                            robot.keyRelease(KeyEvent.VK_S);
                        }
                    } catch (AWTException bot) {
                        bot.printStackTrace();
                    }

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
                if(e.getKeyCode()==KeyEvent.VK_L){
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }

                if(e.getKeyCode()==KeyEvent.VK_DOWN){
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

    public void move(){
        x=x+xVelocity;
        y=y+yVelocity;
    }

    public void draw(Graphics g){
        if(id==1){
            g.setColor(Color.yellow);
        }else if(id==2){
            g.setColor(Color.DARK_GRAY);
        }else if(id==3){
            g.setColor(Color.CYAN);
        }else if(id==4){
            g.setColor(Color.PINK);
        }else if(id==5){
            g.setColor(Color.RED);
        }else if(id==6){
            g.setColor(Color.BLUE);
        }else if(id==7){
            g.setColor(Color.RED);
        }else if(id==8){
            g.setColor(Color.BLACK);
        }else if(id==9){
            g.setColor(Color.WHITE);
        }
        g.fillRect(x,y,width,height);
    }
}