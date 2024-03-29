package anthony;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

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
    HVGPlayer wall1;
    HVGPlayer wall2;
    HVGPlayer wall3;
    HVGPlayer wall4;
    HVGPlayer wall5;
    HVGPlayer wall6;
    HVGPlayer wall7;
    HVGPlayer trophy;

    HVGAttack attack;
    HVGScore score;
    Graphics graphics;
//    HVGScore.Congrats congrats;


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
        int playerLocationX = (int)player1.getX(); //starts ball from player1
        int playerLocationY = (int)player1.getY(); //starts ball from player1

        attack = new HVGAttack(playerLocationX, playerLocationY, BALLISTIC_DIAMETER, BALLISTIC_DIAMETER);
        goblin.getX();
        goblin.getY();
        if(Math.random() <= .5){
            attack.targetGoblin((int)player1.getX()+1, (int)player1.getY());
        }else{
            attack.missedShot((int)player1.getX(), (int)player1.getY());
        }

    }

    public void newPlayer() {
        player1 = new HVGPlayer(0,(GAME_HEIGHT/2)-(player_height/2),player_width, player_height, 1 );
        goblin = new HVGPlayer(GAME_WIDTH-goblin_width,15,goblin_width, goblin_height,2 );
        wall1 = new HVGPlayer(GAME_WIDTH/3,GAME_HEIGHT/2, 25,245,3);
        wall2 = new HVGPlayer((GAME_WIDTH/3)+260,(GAME_HEIGHT/2)-150, 25,245,4);
        wall3 = new HVGPlayer((GAME_HEIGHT/2)-150,(GAME_HEIGHT/2)-150, 245,25,5);
        wall4 = new HVGPlayer((GAME_HEIGHT/2)-190,GAME_WIDTH/3, 245,35,6);
        wall5 = new HVGPlayer((GAME_HEIGHT/2)-150,(GAME_HEIGHT/2)-150, 200,55,7);
        wall6 = new HVGPlayer(GAME_WIDTH-255,(GAME_HEIGHT/2)+150, 255,24,8);
        wall7 = new HVGPlayer(GAME_WIDTH-200,200, 100,100,9);
        trophy = new HVGPlayer((GAME_HEIGHT/2)+40,375, 15,15,10);

    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0, 0,this);
    }

    public void draw(Graphics g) {
        player1.draw(g);
        goblin.draw(g);
        attack.draw(g);
        score.draw(g);
        wall1.draw(g);
        wall2.draw(g);
        wall3.draw(g);
        wall4.draw(g);
        wall5.draw(g);
        wall6.draw(g);
        wall7.draw(g);
        trophy.draw(g);
    }

    public void move(){
        player1.move();
        goblin.move();
        attack.move();
    }

    public void checkContact() {
        if(player1.y <=0){
            player1.y=0;
        }
        if(player1.y >=(GAME_HEIGHT-player_height)){
            player1.y=GAME_HEIGHT-player_height;
        }
        if(player1.x <=0){
            player1.x=0;
        }
        if(player1.x >=(GAME_WIDTH-player_width)){
            player1.x=GAME_WIDTH-player_width;
        }
        if(goblin.y <=0){
            goblin.y=0;
        }
        if(goblin.y >=(GAME_HEIGHT-player_height)){
            goblin.y=GAME_HEIGHT-player_height;
        }
        if(goblin.x <=0){
            goblin.x=0;
        }
        if(goblin.x >=(GAME_WIDTH-player_width)){
            goblin.x=GAME_WIDTH-player_width;
        }
        if(attack.x >= GAME_WIDTH){
            newAttack();
            move();
        }
        if(attack.y >= GAME_HEIGHT){
            newAttack();
            move();
        }
        if(attack.y < 0){
            newAttack();
            move();
        }
        //checks for direct hit
        if(attack.intersects(goblin)){
            System.out.println("Direct hit"); //prints multiple times bc of refresh rate?
            score.goblinHealth -= 7;
            System.out.println("your health: " + score.goblinHealth + " units left.");
        }
        if(goblin.intersects(trophy)){
            System.out.println("Level up!");
            score.goblin +=50;
            score.level++;
            attack.movingSpeed++;
            System.out.println("level " + score.level + "!" );
            System.out.println("Current total: " + score.goblin);
            newPlayer();
            newAttack();
        }
        if(score.goblinHealth<=0){
            System.out.println("Try again.");
            score.goblin =0;
            score.goblinHealth=500;
            score.level=1;
            newPlayer();
            newAttack();
        } //game reset
        if(goblin.intersects(player1)){
                JOptionPane.showMessageDialog(null, "A Battle ensues.");
                score.goblinHealth -= 5;
                newAttack();
                move();
        }//battle result
        if((goblin.intersects(wall1))||(goblin.intersects(wall2))||(goblin.intersects(wall3))){
            goblin.setXDirection(-5);
            goblin.setXDirection(10);
        }
        if((goblin.intersects(wall4))||(goblin.intersects(wall5))||(goblin.intersects(wall6))){
            goblin.setXDirection(-5);
            goblin.setXDirection(10);
        }
        if(goblin.intersects(wall7)){
            goblin.setXDirection(-5);
            goblin.setXDirection(10);
        }
        if(goblin.intersects(wall6)){
            if(goblin.getY()< wall6.getY()) {
            goblin.setYDirection(-10);
            }
            else{
                goblin.setYDirection(10);
            }
        }
        if(player1.x >=GAME_WIDTH-player_width){
            newPlayer();
            newAttack();
            System.out.println("You have been invaded.");
            score.goblin -= 25;
        }
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
            player1.keyPressed(e);
            goblin.keyPressed(e);
        }

        public void keyReleased(KeyEvent e){
            player1.keyReleased(e);
            goblin.keyReleased(e);
        }
    }
}