package gameController.Inputs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {

    public boolean left, right, up, down,escape;
    public boolean aLeft, aRight, aUp, aDown;



    public void keyPressed(KeyEvent key) {

        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                up=true;
                aUp=true;
                break;
            case KeyEvent.VK_DOWN:
                down=true;
                aDown=true;
                break;
            case KeyEvent.VK_LEFT:
                left=true;
                aLeft=true;
                break;
            case KeyEvent.VK_RIGHT:
                right=true;
                aRight=true;
                break;
            case KeyEvent.VK_ESCAPE:
                escape=true;
                break;
        }
    }

    public void keyReleased(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                up=false;
                aUp=false;
                break;
            case KeyEvent.VK_DOWN:
                down=false;
                aDown=false;
                break;
            case KeyEvent.VK_LEFT:
                left=false;
                aLeft=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                aRight=false;
                break;
        }
    }


    public void keyTyped(KeyEvent key) {

    }
}
