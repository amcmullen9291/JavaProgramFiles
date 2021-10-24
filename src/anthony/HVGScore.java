package anthony;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;

public class HVGScore extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int goblin;
    int goblinHealth = 500;
    int level = 1;

    HVGScore(int GAME_WIDTH, int GAME_HEIGHT) {
        HVGScore.GAME_WIDTH = GAME_WIDTH;
        HVGScore.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Georgia", Font.BOLD,18));
        g.drawString("Level: " + level, 0,25);
        g.drawString("Health: " + goblinHealth+ " units lefts",0,45);
        g.drawString("Score: "+ goblin, 0,65);
    }

    void levelComplete(){
        System.out.println("Congratulations!");
    }

//    public static class Congrats extends HVGScore{
//        Congrats(int GAME_WIDTH, int GAME_HEIGHT) {
//            super(GAME_WIDTH, GAME_HEIGHT);
//        }

//        @Override
//        public void levelComplete(){
//            System.out.println("You are ready for another challenge.");
//        }
//    }

}

