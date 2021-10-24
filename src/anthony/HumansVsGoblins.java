package anthony;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class HumansVsGoblins {

    public static void main(String[] args) {

        HVGGameFrame frame = new HVGGameFrame();

        HumansVsGoblins overrideToString = new HumansVsGoblins();
        overrideToString.levelComplete();

        HVGLevelUp player = new HVGLevelUp();
        player.levelComplete();
    }

    void levelComplete(){
        System.out.println("Congratulations!");
    }

}
