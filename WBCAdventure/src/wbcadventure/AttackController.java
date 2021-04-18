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
    private Character interfacer;
    private Timer timer = new Timer();
    private Uplayer uplayer;
    private int maxHPReceiver;
    private final int maximumHPReceiver;
    private Character winner;
    
    
    
    public AttackController(Character attacker, Character receiver,Uplayer uplayer){
        this.attacker = attacker;
        this.receiver = receiver;
        this.uplayer = uplayer;
        this.maxHPReceiver = receiver.getHPcontrol().getMaxHP();
        this.maximumHPReceiver = this.maxHPReceiver;
    }
    
    public void attacking(){
        if(attacker instanceof WBC){
            System.out.println("forward");
            TimerTask forwardWBC = new TimerTask(){
                public void run(){
                    System.out.println("attack");
                    attacker.setLocation(attacker.getX()+120, attacker.getY());
                    
                    TimerTask attackWBC = new TimerTask(){
                        public void run(){
                            uplayer.getHPBarPanel().getHPBarEnemy().setValue(maxHPReceiver - receiver.getHPcontrol().getHP());
                            maxHPReceiver -= receiver.getHPcontrol().getHP();
                            uplayer.getHPBarPanel().getHPBarEnemy().setString(""+receiver.getHPcontrol().getHP());
                            ((Enemy) receiver).getNumberHP().setText(""+receiver.getHPcontrol().getHP());
                            attacker.setLocation(attacker.getX()-120, attacker.getY());
                            
                        }
                    };timer.schedule(attackWBC, 500);
                }
            }; timer.schedule(forwardWBC, 500);
        }
        else if(attacker instanceof Enemy){
            System.out.println("forward");
            TimerTask forwardEnemy = new TimerTask(){
                public void run(){
                    System.out.println("attack");
                    attacker.setLocation(attacker.getX()-120, attacker.getY());
                    
                    TimerTask attackEnemy = new TimerTask(){
                        public void run(){
                            uplayer.getHPBarPanel().getHPBarWBC().setValue(receiver.getHPcontrol().getHP());
                            uplayer.getHPBarPanel().getHPBarWBC().setString(""+receiver.getHPcontrol().getHP());
                            ((WBC)receiver).getNumberHP().setText(""+receiver.getHPcontrol().getHP());
                            attacker.setLocation(attacker.getX()+120, attacker.getY());
                        }
                    };timer.schedule(attackEnemy, 500);
                }
            }; timer.schedule(forwardEnemy, 500);
        } 
    }
    
    public void setValue(){
        receiver.getHPcontrol().decreaseHP(attacker.getPowerDefault());
    }
    
    public void BufferHP(){
        attacker.getHPcontrol().increaseMaxHP(this.maximumHPReceiver);
        attacker.getHPcontrol().heal();
        uplayer.getHPBarPanel().getHPBarWBC().setString(((WBC)attacker).getHPcontrol().getHP()+"");
        ((WBC) (attacker)).getNumberHP().setText(((WBC)attacker).getHPcontrol().getHP()+"");
    }
    
    public void setWinner(){
        this.winner = attacker;
    }
    
    public Character gerWinner(){
        return winner;
    }
   
    
}