package wbcadventure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen extends SkillBar implements KeyListener{
    
    @Override
    public void keyTyped(KeyEvent e) {
//        switch(e.getKeyChar()){
//            case 'q' : setSkillDuration(0);    break;
//            case 'w' : setSkillDuration(1);    break;
//        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyChar());
    }
    
}
