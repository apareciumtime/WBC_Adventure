package wbcadventure;
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class BossEnemy extends Enemy{
    private int enemyRandHP;
    
    public BossEnemy(WBC wbc){
        super(wbc);
        this.addCharacIcon(new ImageIcon("src/source/character/Boss/Boss.gif"));
        this.setBounds(0,0,900,750);
        this.getEnemyLabel().setIcon(this.getCharacIcon(0));
        this.getEnemyLabel().setBounds(0,0,900,750);
        this.add(this.getEnemyLabel());
        
        this.getNumberHP().setBounds(150,0,150,55);
        this.getNumberHP().setText(""+this.getHPcontrol().getHP());
        this.add(getNumberHP());
    }
    
    public int randomHP(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(4);
        int wbcHP=wbc.getHPcontrol().getMaxHP();
        switch(casenum){
            case 0 : enemyRandHP=wbcHP*10000+(int)(17409*.119); break;
            case 1 : enemyRandHP=wbcHP*10000+(int)(10652*.104); break;
            case 2 : enemyRandHP=wbcHP*10000+(int)(14106*.181); break;
            case 3 : enemyRandHP=wbcHP*10000+(int)(18089*.156); break;
            default : enemyRandHP=wbcHP*10000; break;
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
            case 0 : enemyRandPower = (int)(this.getHPcontrol().getMaxHP()*.0019); break;
            case 1 : enemyRandPower = (int)(this.getHPcontrol().getMaxHP()*.0027); break;
            default : enemyRandPower = (int)(this.getHPcontrol().getMaxHP()*.0032); break;
        }
        return enemyRandPower;
    }
}