package anthony;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;

public class HVGGamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH =1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH *(0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static int BALLISTIC_DIAMETER = 20; //not final so more than one type of bullet
    static final int player_height = 100;
    static final int player_width = 25;

    Thread gameThread;
    Image image;
    Random random;
    HVGPlayer human;
    HVGPlayer goblin;
    HVGAttack attack;
    HVGScore score;


    HVGGamePanel(){
        newPlayer();
        newAttack();
        score = new HVGScore(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true); //able to read key presses
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(SCREEN_SIZE);
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newAttack() {

    }

    public void newPlayer() {

    }

    public void paint() {

    }

    public void draw() {

    }

    public void move(){

    }

    public void checkContact() {

    }

    public void run(){

    }

    public class ActionListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){

        }

        public void keyReleased(KeyEvent e){

        }
    }
}
