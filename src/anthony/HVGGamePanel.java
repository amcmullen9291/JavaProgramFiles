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
    static final int player_height = 25;
    static final int player_width = 25;
    static final int goblin_height = 60;
    static final int goblin_width = 40;

    Thread gameThread;
    Image image;
    Random random;
    HVGPlayer player1;
    HVGPlayer goblin;
    HVGAttack attack;
    HVGScore score;
    Graphics graphics;


    HVGGamePanel(){
        newPlayer();
        newAttack();
        score = new HVGScore(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true); //able to read keystrokes
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(SCREEN_SIZE);
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newAttack() {

    }

    public void newPlayer() {
        player1 = new HVGPlayer(0,(GAME_HEIGHT/2)-(player_height/2),player_width, player_height, 1 );
        goblin = new HVGPlayer(GAME_WIDTH-goblin_width,15,goblin_width, goblin_height,2 );

    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0, 0,this); // change coords to make where player is located
    }

    public void draw(Graphics g) {
        player1.draw(g);
        goblin.draw(g);

    }

    public void move(){

    }

    public void checkContact() {

    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            if(delta>=1){
                move();
                checkContact();
                repaint();
                delta--;
            }
        }
    }

    public class ActionListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){

        }

        public void keyReleased(KeyEvent e){

        }
    }
}
