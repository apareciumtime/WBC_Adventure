package wbcadventure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.Timer;
//import javax.swing.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AttackController {
    private Character attacker;
    private Character receiver;
    private boolean haveWinner;
    private boolean isDuel=false;
    private boolean isAttack=false;
    private Character winner=null;
    private Character loser=null;
    private String winnerSide;
    private ProgressBar hpBar;
    Timer aniTimer=new Timer();
//    private AttackerThread atttread=new AttackerThread();
//    private DuelThread duelthread=new DuelThread();
    public AttackController(Character at,Character re,ProgressBar hpBar){
        this.hpBar=hpBar;
        attacker=at;
        receiver=re;
    }
    
    /**
     * Start one match of fighting
     */
    public void duel(){
        if(attacker instanceof WBC){
            ((WBC)attacker).setIconNowWBC(((WBC)attacker).getCharacIcon(2));
            ((WBC)attacker).getWBCLabel().setIcon(((WBC)attacker).getCharacIcon(2));
            System.out.println("Change Image");
        }
        isDuel=true;
        while(checkHP()){
            TimerTask attackAnitaskForward=new TimerTask(){
                public void run(){
                    for(int i=0;i<=10;i++){
                        attacker.setImgCorner(1,0);
                        try {
                            sleep(50);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    TimerTask attackBackend = new TimerTask(){
                        public void run(){
                            attack();
                            TimerTask attackAnitaskBackward=new TimerTask(){
                                public void run(){
                                    for(int i=0;i<=10;i++){
                                        attacker.setImgCorner(-1,0);
                                        try {
                                            sleep(50);
                                        } catch (InterruptedException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                }
                            }; aniTimer.schedule(attackAnitaskBackward,0);
                        }
                    };aniTimer.schedule(attackBackend,500);
                }
            }; aniTimer.schedule(attackAnitaskForward,0);
        }
        isDuel=false;
        winnerControl();
    }
    
    public boolean getIsDuel(){
        return isDuel;
    }
    
    private boolean checkHP(){
        return attacker.getHPcontrol().getHP()>0&&receiver.getHPcontrol().getHP()>0;
    }
    
    private void attack(){
        isAttack=true;
        if(receiver.getHPcontrol().getHP()-attacker.getPowerDefault()<=0){
            receiver.getHPcontrol().decreaseHP(receiver.getHPcontrol().getHP());
            haveWinner=true;
            winner=attacker;
            loser=receiver;
        }
        else{
            receiver.getHPcontrol().decreaseHP(attacker.getPowerDefault());
            System.out.println("attack!");
        }
        if(receiver instanceof WBC){
            hpBar.getHPBarWBC().setValue(receiver.getHPcontrol().getHP()-attacker.getPowerDefault());
        }
        else if(receiver instanceof Enemy){
            hpBar.getHPBarEnemy().setValue(receiver.getHPcontrol().getHP()+attacker.getPowerDefault());
        }
        }     
     

    private void swapRole(){
        Character mid;
        mid=attacker;
        attacker=receiver;
        receiver=mid;
    }
    
    private void winnerControl(){
        if(winner instanceof WBC){
            if(loser instanceof BossEnemy){
                //แสดงผล congrats
            }
            else{
                winner.getHPcontrol().increaseMaxHP(loser.getHPcontrol().getMaxHP());
                winner.getHPcontrol().heal();
            }
            
        }
        else if(winner instanceof Enemy){
            //เชื่อมไปแสดงผลหน้า game over
        }
    }
    private void setIsAttack(boolean isatk){
        isAttack=isatk;
    }
    private boolean getIsAttack(){
        return isAttack;
    }
    
    public Character getWinner(){
        return winner;
    }
    
//    class AttackerThread extends Thread{
//        public void run(){
//            try { 
//                for(int i=0;i<=10;i++){
//                    attacker.setImgCorner(1,0);
//                    sleep(50);
//                } 
//            }
//            catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//            try { 
//                for(int i=0;i<=10;i++){
//                    attacker.setImgCorner(-1,0);
//                    sleep(50);
//                } 
//            }
//            catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//            finally{
//                if(receiver.getHPcontrol().getHP()-attacker.getPowerDefault()<=0){
//                    receiver.getHPcontrol().decreaseHP(receiver.getHPcontrol().getHP());
//                    haveWinner=true;
//                    winner=attacker;
//                    loser=receiver;
//                }
//                else{
//                    receiver.getHPcontrol().decreaseHP(attacker.getPowerDefault());
//                    System.out.println("attack!");
//                }
//                if(receiver instanceof WBC){
//                    hpBar.getHPBarWBC().setValue(receiver.getHPcontrol().getHP()-attacker.getPowerDefault());
//                }
//                else if(receiver instanceof Enemy){
//                    hpBar.getHPBarEnemy().setValue(receiver.getHPcontrol().getHP()+attacker.getPowerDefault());
//                }    
//            }
//        }
//    }
//    
//    class DuelThread extends Thread{
//        public void run(){
//            try { 
//                isDuel=true;
//                while(checkHP()){
//                    attack();
//                    if(winner==null){
//                        swapRole();
//                    }
//                }
//                sleep(200);
//                
//            } 
//            catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//            finally{
//                isDuel=false;
//                winnerControl();
//            }
//        
//        }
//    }
    
    
    /*
    public Character getWinner(){
        return winner;
    }*/
/*
    public class AttListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            attacker.setImgCorner(10, 0);
        }
        
    }*/
}
