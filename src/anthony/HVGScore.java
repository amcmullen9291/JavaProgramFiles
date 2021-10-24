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
    Congrats congrats; //for method override req

    HVGScore(int GAME_WIDTH, int GAME_HEIGHT) {

    }

    public void draw(Graphics g) {

    }

    public class Congrats extends HVGLevelUp{
        @Override
        public void levelComplete(){
            System.out.println("You are ready for another challenge.");
        }
    }

}

