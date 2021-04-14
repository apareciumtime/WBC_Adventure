package wbcadventure;
public class AttackController {
    private Character attacker;
    private Character reciever;
    private boolean haveWinner;
    private boolean isDuel=false;
    private Character winner=null;
    private Character loser=null;
    private String winnerSide;
    public AttackController(Character at,Character re){
        attacker=at;
        reciever=re;
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
        return attacker.getHPcontrol().getHP()!=0&&reciever.getHPcontrol().getHP()!=0;
    }
    
    private void attack(){
        if(reciever.getHPcontrol().getHP()-attacker.getPowerDefault()<0){
            reciever.getHPcontrol().decreaseHP(reciever.getHPcontrol().getHP());
            haveWinner=true;
            winner=attacker;
            loser=reciever;
        }
        else{
            reciever.getHPcontrol().decreaseHP(attacker.getPowerDefault());
        }
    } 

    private void swapRole(){
        Character mid;
        mid=attacker;
        attacker=reciever;
        reciever=mid;
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
    
}
