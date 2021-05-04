package wbcadventure;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;


public class WBCMovement implements MouseListener,MouseMotionListener{
    private int x=300,y=300;
    private WBC wbc;
    private JPanel WBCPanel;
    private Battle bt;
    private StartGame stgame;
    private Timer timer = new Timer();
    private AttackController attackController;
    private ArrayList<EnemyBlankPanel> enemyarr;
    
    
    public WBCMovement(WBC wbc,Battle bt,StartGame stgame){
        this.stgame=stgame;
        this.wbc=wbc;
        this.bt=bt;
        wbc.getWBCPanel().addMouseListener(this);
        wbc.getWBCPanel().addMouseMotionListener(this);
        WBCPanel=wbc.getWBCPanel();
        enemyarr=bt.getPathGen().getEnemyPanelArrayList();
        wbc.setXforBoostSpeed(300);
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        wbc.getWBCLabel().setIcon(wbc.getCharacIcon(1));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        wbc.getWBCLabel().setIcon(wbc.getCharacIcon(1));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        try{
            boolean goFight=false;
            wbc.getWBCLabel().setIcon(wbc.getCharacIcon(0));
            if(enemyarr.get(0).getBeChoice()==true){
                if(wbc.getWBCPanel().getBounds().intersects(enemyarr.get(0).getBounds())){
                    this.fight(enemyarr.get(0));
                    goFight=true;
                }
                else if(wbc.getWBCPanel().getBounds().intersects(enemyarr.get(1).getBounds())){
                    this.fight(enemyarr.get(1));
                    goFight=true;
                }
            }
            else{
                if(wbc.getWBCPanel().getBounds().intersects(enemyarr.get(0).getBounds())){
                    this.fight(enemyarr.get(0));
                    goFight=true;
                }
            }
            if(!goFight){
                wbc.setLocation(x, y);
            }
        }
        catch(IndexOutOfBoundsException ex){
            
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
    
    public void fight(EnemyBlankPanel enemyPanel){
        stgame.getUplayer().setEnemyPowerBar(enemyPanel.getEnemy());
        if(enemyPanel.getEnemy() instanceof BossEnemy){
            wbc.getWBCPanel().setLocation(enemyPanel.getX()-250,enemyPanel.getY()+400);
            x=enemyPanel.getX()-250;
            y=enemyPanel.getY()+400;
        }
        else{
            wbc.getWBCPanel().setLocation(enemyPanel.getX()-150,enemyPanel.getY());
            x=enemyPanel.getX()-150;
            y=enemyPanel.getY();
        }
            wbc.setXforBoostSpeed(x);
            wbc.getWBCLabel().setIcon(wbc.getCharacIcon(2));
            stgame.getUplayer().getHPBarPanel().setWBCHPBar();
            
            if(enemyPanel.getEnemy() instanceof NormalEnemy){
                stgame.getUplayer().getHPBarPanel().setEnemyHPBar((NormalEnemy) enemyPanel.getEnemy());
            }
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().setBossHPBar();
            }
            
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 1
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 1
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 2
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 2
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 3
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 3
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 4
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 4
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 5
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 5
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 6
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 6
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 7
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 7
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 8
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 8
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 9
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 9
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 10
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 10
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 11
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 11
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 12
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 12
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 13
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 13
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 14
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 14
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 15
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 15
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 16
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 16
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 17
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 17
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 18
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 18
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 19
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy19
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 20
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); // Enemy 20
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 1
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 1
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 2
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 2
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 3
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 3
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 4
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 4
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 5
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 5
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 6
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 6
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 7
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 7
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 8
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 8
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 9
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 9
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 10
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 10
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 11
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 11
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 12
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 12
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 13
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 13
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 14
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 14
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 15
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 15
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 16
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 16
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 17
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 17
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 18
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy 18
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 19
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //Enemy19
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); //WBC 20
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){TimerTask attackWBC = new TimerTask(){public void run(){
            attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
            attackController.setValue();
            attackController.attacking(); // Enemy 20
            if(wbc.getHPcontrol().getHP()>0){TimerTask attackEnemy = new TimerTask(){public void run(){
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();

            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}   
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}   
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
            wbc.setBounds(0, 0, 0, 0);
            stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            }};  timer.schedule(attackEnemy, 1000);}
            else{TimerTask diedEnemy = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
             if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
             else if(enemyPanel.getEnemy() instanceof BossEnemy) stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
             wbc.setBounds(0, 0, 0, 0);
             stgame.setEndGame("lose",stgame);}}; timer.schedule(wait, 50);}}; timer.schedule(diedEnemy, 1000);}
            }};  timer.schedule(attackWBC, 1000);}
            else{TimerTask diedWBC = new TimerTask(){public void run(){TimerTask wait = new TimerTask(){public void run(){stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();
            if(enemyPanel.getEnemy() instanceof NormalEnemy) stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();
                stgame.setEndGame("win",stgame);}
            enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
            wbc.setPowerDefault((int)(wbc.getPowerDefault()*1.35));
            stgame.getUplayer().getAnotherPowerBar().setVisible(false);
            stgame.getUplayer().getWBCPowerBar().setPower(wbc.getPowerDefault());
            attackController.BufferHP();}};  timer.schedule(wait, 50);}};timer.schedule(diedWBC, 1000);}
            
//        System.out.println("arr to del "+enemyPanel.getMustBeDeleteArr());
        if(enemyPanel.getMustBeDeleteArr().size()==1){
            enemyarr.remove(0);
        }
        else{
            for(int in=enemyPanel.getMustBeDeleteArr().size()-1;in>=0;in--){
                int del=enemyPanel.getMustBeDeleteArr().get(in);
                System.out.println("delete "+del);
                enemyarr.remove(del);
            }
        }
    }  
}