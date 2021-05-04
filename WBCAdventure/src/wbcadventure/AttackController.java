package wbcadventure;
 
import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class AttackController {
    private Character attacker;
    private Character receiver;
    
    private int maxHPReceiver;
    private final int maximumHPReceiver;
    
    private Timer timer = new Timer();
    
    private Uplayer uplayer;
    
    /**
     * AttackController accumulate data of attacker and receiver for duel
     * @param attacker : Character class who will attack
     * @param receiver : Character class who will be attacked
     * @param uplayer  : Uplayer class give the SkillBar class object
     */
    public AttackController(Character attacker, Character receiver,Uplayer uplayer){
        this.attacker = attacker;
        this.receiver = receiver;
        this.uplayer = uplayer;
        
        uplayer.getSkillBarPanel().setSkillEnable(attacker.getHPcontrol().getMaxHP());
        
        this.maxHPReceiver = receiver.getHPcontrol().getMaxHP();
        this.maximumHPReceiver = this.maxHPReceiver;
    }
    
    /**
     * attacking method show the action of attacker and HealthPoint number showing for user of both of attacker and receiver
     */
    public void attacking(){
        if(attacker instanceof WBC){
            TimerTask forwardWBC = new TimerTask(){
                public void run(){
                    ((WBC)attacker).getWBCLabel().setIcon(((WBC)attacker).getCharacIcon(2));
                    attacker.setLocation(attacker.getX()+50, attacker.getY());
                    if(receiver.getHPcontrol().getHP() <= 0){
                        uplayer.getHPBarPanel().getHPBarEnemy().setValue(maxHPReceiver);
                        uplayer.getHPBarPanel().getHPBarBoss().setValue(maxHPReceiver);
                        maxHPReceiver -= receiver.getHPcontrol().getHP();
                        uplayer.getHPBarPanel().getHPBarEnemy().setString("0");
                        uplayer.getHPBarPanel().getHPBarBoss().setString("0");
                        ((Enemy) receiver).getNumberHP().setForeground(Color.red);
                        ((Enemy) receiver).getNumberHP().setFont(new Font("Courier New", Font.BOLD, 50));
                        ((Enemy) receiver).getNumberHP().setText("DIE!!");
                    }
                    else{
                        uplayer.getHPBarPanel().getHPBarEnemy().setValue(maxHPReceiver - receiver.getHPcontrol().getHP());
                        uplayer.getHPBarPanel().getHPBarBoss().setValue(maxHPReceiver - receiver.getHPcontrol().getHP());
                        maxHPReceiver -= receiver.getHPcontrol().getHP();
                        uplayer.getHPBarPanel().getHPBarEnemy().setString(""+receiver.getHPcontrol().getHP());
                        uplayer.getHPBarPanel().getHPBarBoss().setString(""+receiver.getHPcontrol().getHP());
                        ((Enemy) receiver).getNumberHP().setText(""+receiver.getHPcontrol().getHP());
                    }
                    
                    TimerTask attackWBC = new TimerTask(){
                        public void run(){
                            attacker.setLocation(attacker.getX()-50, attacker.getY());         
                            ((WBC)attacker).getWBCLabel().setIcon(((WBC)attacker).getCharacIcon(0));
                        }
                    };timer.schedule(attackWBC, 500);
                }
            }; timer.schedule(forwardWBC, 500);
        }
        else if(attacker instanceof Enemy){
            TimerTask forwardEnemy = new TimerTask(){
                public void run(){
                    if(receiver.getHPcontrol().getHP() <= 0){
                        uplayer.getHPBarPanel().getHPBarWBC().setValue(0);
                    uplayer.getHPBarPanel().getHPBarWBC().setString("0");
                    ((WBC) receiver).getNumberHP().setForeground(Color.red);
                    ((WBC) receiver).getNumberHP().setFont(new Font("Courier New", Font.BOLD, 50));
                    ((WBC)receiver).getNumberHP().setText("DIE!!");
                    }
                    else{
                        attacker.setLocation(attacker.getX()-20, attacker.getY());
                        uplayer.getHPBarPanel().getHPBarWBC().setValue(receiver.getHPcontrol().getHP());
                        uplayer.getHPBarPanel().getHPBarWBC().setString(""+receiver.getHPcontrol().getHP());
                        ((WBC)receiver).getNumberHP().setText(""+receiver.getHPcontrol().getHP());
                    }
                    
                    TimerTask attackEnemy = new TimerTask(){
                        public void run(){
                            attacker.setLocation(attacker.getX()+20, attacker.getY());
                        }
                    };timer.schedule(attackEnemy, 500);
                }
            }; timer.schedule(forwardEnemy, 500);
        } 
    }
    
    /**
     * setValue method compute the health point of receiver who was attacked by attacker's power
     */
    public void setValue(){
        receiver.getHPcontrol().decreaseHP(attacker.getPowerDefault());
        
    }
    
    /**
     * BufferHP method give new Max Health Point of WBC Character after won the enemy by add Health Point of WBC by Health Point of Enemy
     */
    public void BufferHP(){
        attacker.getHPcontrol().increaseMaxHP(this.maximumHPReceiver);
        attacker.getHPcontrol().heal();
        uplayer.getHPBarPanel().getHPBarWBC().setString(((WBC)attacker).getHPcontrol().getHP()+"");
        ((WBC) (attacker)).getNumberHP().setText(((WBC)attacker).getHPcontrol().getHP()+"");
    }
}