package projectoop.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    private boolean[] keys;
    public boolean up, down,left, right,space;
    public KeyBoard(){
        keys=new boolean[128];
    }

    public void update(){
        up=keys[KeyEvent.VK_UP]||keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_DOWN]||keys[KeyEvent.VK_DOWN];
        left=keys[KeyEvent.VK_LEFT]||keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_RIGHT]||keys[KeyEvent.VK_D];
        space=keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()]=false;
    }
}
