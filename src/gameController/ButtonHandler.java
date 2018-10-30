package gameController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {
    public void keyPressed(KeyEvent key) {

        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                Instances.player.setUp(true);
                break;
            case KeyEvent.VK_DOWN:
                Instances.player.setDown(true);
                break;
            case KeyEvent.VK_LEFT:
                Instances.player.setLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                Instances.player.setRight(true);
                break;
        }
    }

    public void keyReleased(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                Instances.player.setUp(false);
                break;
            case KeyEvent.VK_DOWN:
                Instances.player.setDown(false);
                break;
            case KeyEvent.VK_LEFT:
                Instances.player.setLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                Instances.player.setRight(false);
                break;
        }
    }


    public void keyTyped(KeyEvent key) {

    }
}
