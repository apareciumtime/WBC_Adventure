package wbcadventure;


import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class WBCMovement implements MouseListener,MouseMotionListener{
    private int x,y;
    private WBC wbc;
    private JLabel WBClabel;
    private Battle bt;
    private StartGame stgame;
    
    public WBCMovement(WBC wbc,Battle bt,StartGame stgame){
        this.stgame=stgame;
        this.wbc=wbc;
        this.bt=bt;
        wbc.getWBCLabel().addMouseListener(this);
        wbc.getWBCLabel().addMouseMotionListener(this);
        WBClabel=wbc.getWBCLabel();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        WBClabel.setIcon(wbc.getCharacIcon(1));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        WBClabel.setIcon(wbc.getCharacIcon(1));
        x=e.getX();
        y=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        WBClabel.setIcon(wbc.getCharacIcon(0));
        
        if (wbc.getWBCLabel().getBounds().intersects(bt.getEnemyArr().get(0).getBounds())){
//            System.out.println("Enemy mHP : "+enemyArrayList.get(0).getHPcontrol().getMaxHP());
//            System.out.println("Enemy HP : "+enemyArrayList.get(0).getHPcontrol().getHP());
//            System.out.println("wbc mHP : "+wbc.getHPcontrol().getMaxHP());
//            System.out.println("wbc HP : "+wbc.getHPcontrol().getHP());
            if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                stgame.getUplayer().getHPBarPanel().setEnemyHPBar();
                stgame.getUplayer().getHPBarPanel().setWBCHPBar();
            }
            else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel();
                stgame.getUplayer().getHPBarPanel().setWBCHPBar();
            }
            wbc.getWBCLabel().setLocation(bt.getEnemyArr().get(0).getX()-200,bt.getEnemyArr().get(0).getY());
            AttackController atk=new AttackController(wbc,bt.getEnemyArr().get(0));
            atk.duel();
            Character win=atk.getWinner();
            if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            }
            else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            }
            if(win instanceof WBC){
                System.out.println("winnnn");
                bt.getEnemyArr().get(0).setVisible(false);
                bt.removeEnemy(0);
                System.out.println(bt.getEnemyArr());
            }
            else{
                System.out.print("lose");
            }
                wbc.setImgCorner(bt.getEnemyArr().get(0).getX()-200,bt.getEnemyArr().get(0).getY());
                
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        e.getComponent().setLocation(e.getX()+e.getComponent().getX()-75
                ,e.getY()+e.getComponent().getY()-100);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
