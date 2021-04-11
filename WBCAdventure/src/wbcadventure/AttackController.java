package wbcadventure;

public class AttackController {
    private Character attacker;
    private Character reciever;
    private boolean haveWinner;
    private Character winner=null;
    private Character loser=null;
    private String winnerSide;
    public AttackController(Character at,Character re){
        attacker=at;
        reciever=re;
    }
    
    public void duel(){
        while(checkHP()){
            attack();
            if(winner==null){
                swapRole();
            }
        }
        winnerControl();
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
        if(!haveWinner){
            if(attacker.getHPcontrol().getHP()-reciever.getPowerDefault()<0){
                attacker.getHPcontrol().decreaseHP(attacker.getHPcontrol().getHP());
                haveWinner=true;
                winner=reciever;
                loser=attacker;
            }
            else{
                attacker.getHPcontrol().decreaseHP(reciever.getPowerDefault());
            }
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
