package wbcadventure;
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class BossEnemy extends Enemy{
    private int enemyRandHP;
    
    /**
     * Constructor of BossEnemy : Object from class BossEnemy is a JPanel which contain boss ImageIcon
     * @param wbc 
     */
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
    
    /**
     * random Boss's HP by WBC's HP
     * @param wbc
     * @return enemyRandHP : contain number which is Boss's HP
     */
    public int randomHP(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(4);
        int wbcHP=wbc.getHPcontrol().getMaxHP();
        switch(casenum){
            case 0 : enemyRandHP=wbcHP*10000+(int)(1709*.119); break;
            case 1 : enemyRandHP=wbcHP*10000+(int)(1062*.104); break;
            case 2 : enemyRandHP=wbcHP*10000+(int)(1416*.181); break;
            case 3 : enemyRandHP=wbcHP*10000+(int)(1808*.156); break;
            default : enemyRandHP=wbcHP*10000; break;
        }
        return enemyRandHP;
    }
    
    /**
     * random Boss's power by it's HP
     * @param wbc
     * @return enemyRandPower : contain number which is Boss's power
     */
    public int randomPower(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(4);
        int enemyHP=this.getHPcontrol().getHP();
        int wbcHP=wbc.getHPcontrol().getMaxHP();
        int wbcPower=wbc.getPowerDefault();
        int enemyRandPower;
        switch(casenum){
            case 0 : enemyRandPower = (int)(wbcHP/20); break;
            case 1 : enemyRandPower = (int)(wbcHP/28); break;
            default : enemyRandPower = (int)(wbcHP/24); break;
        }
        return enemyRandPower;
    }
}