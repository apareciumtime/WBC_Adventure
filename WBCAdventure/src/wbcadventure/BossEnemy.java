package wbcadventure;
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
public class BossEnemy extends Enemy {
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    public BossEnemy(WBC wbc){
        super(wbc);
        
        this.addCharacIcon(new ImageIcon("src/source/character/Boss/Boss.gif"));
        
        this.setBounds(0,0,900,750);
        
        this.getEnemyLabel().setIcon(this.getCharacIcon(0));
        this.getEnemyLabel().setBounds(0,0,900,750);
        this.add(this.getEnemyLabel());
    }
    
    public int randomHP(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(4);
        int wbcHP=wbc.getHPcontrol().getMaxHP();
        int enemyRandHP;
        switch(casenum){
            case 0 : enemyRandHP=wbcHP*50+30; break;
            case 1 : enemyRandHP=wbcHP*128+10; break;
            case 2 : enemyRandHP=wbcHP*50+10; break;
            case 3 : enemyRandHP=wbcHP*55; break;
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
