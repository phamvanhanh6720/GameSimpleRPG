package projectoop.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    private boolean[] keys;
    public boolean up, down,left, right,space,skill,pause=false;
    public boolean exit;
    public KeyBoard(){
        keys=new boolean[256];
    }

    public void update(){
        up=keys[KeyEvent.VK_UP]||keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_DOWN]||keys[KeyEvent.VK_S];
        left=keys[KeyEvent.VK_LEFT]||keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_RIGHT]||keys[KeyEvent.VK_D];
        space=keys[KeyEvent.VK_SPACE];
        skill=keys[KeyEvent.VK_F];
        pause=keys[KeyEvent.VK_P];
        exit=keys[KeyEvent.VK_ESCAPE];

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode()==keyEvent.VK_P){
            if(keys[keyEvent.getKeyCode()]==true){
                keys[keyEvent.getKeyCode()]=false;
            }
            else{
                keys[keyEvent.getKeyCode()]=true;
            }
        }
        else{
            keys[keyEvent.getKeyCode()]=true;
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode()==keyEvent.VK_P){
            return;
        }
        else{
            keys[keyEvent.getKeyCode()]=false;
        }

    }
}
