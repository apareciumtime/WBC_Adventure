package wbcadventure;
public class AttackController {
    private Character attacker;
    private Character receiver;
    private boolean haveWinner;
    private boolean isDuel=false;
    private boolean isAttack=false;
    private Character winner=null;
    private Character loser=null;
    private String winnerSide;
    private int damage=0;
    private ProgressBar hpbar;
    public AttackController(Character at,Character re,ProgressBar hpbar){
        this.hpbar=hpbar;
        attacker=at;
        receiver=re;
    }
    
    /**
     * Start one match of fighting
     */
    public void duel(){
        isDuel=true;
        while(checkHP()){
            attack();
            if(winner==null){
                swapRole();
            }
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
//            System.out.println(winner);
        }
        else{
            receiver.getHPcontrol().decreaseHP(attacker.getPowerDefault());
            System.out.println("attack!");
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
    /*
    public Character getWinner(){
        return winner;
    }*/
}
