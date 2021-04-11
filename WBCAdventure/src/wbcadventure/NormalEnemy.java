package wbcadventure;
import java.util.Random;
public class NormalEnemy extends Enemy {
    public NormalEnemy(WBC wbc){
        super(wbc);
    }
    
    public int randomHP(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(4);
        int wbcHP=wbc.getHPcontrol().getMaxHP();
        int enemyRandHP;
        switch(casenum){
            case 0 : enemyRandHP=wbcHP+15; break;
            case 1 : enemyRandHP=wbcHP-10; break;
            case 2 : enemyRandHP=wbcHP+10; break;
            case 3 : enemyRandHP=wbcHP-15; break;
            default : enemyRandHP=wbcHP; break;
        }
        return enemyRandHP;
    }
    
    public int randomPower(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(2);
        int enemyHP=this.getHPcontrol().getHP();
        int wbcHP=wbc.getHPcontrol().getMaxHP();
        int wbcPower=wbc.getPowerDefault();
        int enemyRandPower;
        switch(casenum){
            case 0 : enemyRandPower=wbcPower+(Math.abs(wbcHP-enemyHP))%wbcPower; break;
            case 1 : enemyRandPower=wbcPower-(Math.abs(wbcHP-enemyHP))%wbcPower; break;
            default : enemyRandPower=wbcPower; break;
        }
        return enemyRandPower;
    }
}
