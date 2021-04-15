package wbcadventure;
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
public class NormalEnemy extends Enemy {
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    public NormalEnemy(WBC wbc){
        super(wbc);
        
        this.addCharacIcon(new ImageIcon("src/source/character/Enemies/Enemy.gif"));
        this.addCharacIcon(new ImageIcon("src/source/character/Enemies/Enemy2.gif"));
        
        Random rand=new Random();
        int randIcon=rand.nextInt(50)%2;
        
        this.setBounds(0,0,150,200);
        //this.getEnemyLabel().setBounds(0,0,150,200);
        
        if(randIcon==0){
            this.getEnemyLabel().setIcon(this.getCharacIcon(0));
            this.getEnemyLabel().setOpaque(false);
            this.getEnemyLabel().setVisible(true);
            this.getEnemyLabel().setLayout(null);
            this.getEnemyLabel().setBounds(0,0,150,200);
            this.add(this.getEnemyLabel());
            System.out.println("Rand 0");
        }
        else{
            this.getEnemyLabel().setIcon(this.getCharacIcon(1));
            this.getEnemyLabel().setOpaque(false);
            this.getEnemyLabel().setVisible(true);
            this.getEnemyLabel().setLayout(null);
            this.getEnemyLabel().setBounds(0,0,150,200);
            System.out.println("Rand 1");
        }
    }
    
    public int randomHP(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(50)%4;
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
        int casenum=rand.nextInt(50)%2;
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
