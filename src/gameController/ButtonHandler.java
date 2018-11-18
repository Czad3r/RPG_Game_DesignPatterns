package gameController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {

    public boolean left, right, up, down;


    public void keyPressed(KeyEvent key) {

        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                up=true;
                break;
            case KeyEvent.VK_DOWN:
                down=true;
                break;
            case KeyEvent.VK_LEFT:
                left=true;
                break;
            case KeyEvent.VK_RIGHT:
                right=true;
                break;
        }
    }

    public void keyReleased(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                up=false;
                break;
            case KeyEvent.VK_DOWN:
                down=false;
                break;
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                break;
        }
    }


    public void keyTyped(KeyEvent key) {

    }
}
