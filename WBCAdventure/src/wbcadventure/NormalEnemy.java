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
        
        this.getNumberHP().setBounds(0,0,150,55);
        System.out.println(this.getHPcontrol().getHP());
        this.getNumberHP().setText(""+this.getHPcontrol().getHP());
        this.add(getNumberHP());
        
        switch(randIcon){
            case 0:
                this.getEnemyLabel().setIcon(this.getCharacIcon(0));
                this.getEnemyLabel().setOpaque(false);
                this.getEnemyLabel().setVisible(true);
                this.getEnemyLabel().setLayout(null);
                this.getEnemyLabel().setBounds(0,0,150,200);
                this.add(this.getEnemyLabel());
                System.out.println("Rand 0");
            default:
                this.getEnemyLabel().setIcon(this.getCharacIcon(1));
                this.getEnemyLabel().setOpaque(false);
                this.getEnemyLabel().setVisible(true);
                this.getEnemyLabel().setLayout(null);
                this.getEnemyLabel().setBounds(0,0,150,200);
                this.add(this.getEnemyLabel());
                System.out.println("Rand 1");
        }        
        
    }
    
    public int randomHP(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(100)%12;
        int wbcHP=wbc.getHPcontrol().getMaxHP();
        int enemyRandHP;
        switch(casenum){
            case 0 : enemyRandHP=wbcHP+18; break;
            case 1 : enemyRandHP=wbcHP-16; break;
            case 2 : enemyRandHP=wbcHP+17; break;
            case 3 : enemyRandHP=wbcHP-19; break;
            case 4 : enemyRandHP=wbcHP-11; break;
            case 5 : enemyRandHP=wbcHP-16; break;
            case 6 : enemyRandHP=wbcHP-2; break;
            case 7 : enemyRandHP=wbcHP-8; break;
            case 8 : enemyRandHP=wbcHP-7; break;
            case 9 : enemyRandHP=wbcHP-6; break;
            case 10 : enemyRandHP=wbcHP-5; break;
            default : enemyRandHP=wbcHP; break;
        }
        return enemyRandHP;
    }
    
    public int randomPower(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(50)%5;
        int enemyHP=this.getHPcontrol().getHP();
        int enemyRandPower;
        switch(casenum){
            case 0 : enemyRandPower=(int)(enemyHP*.2); break;
            case 1 : enemyRandPower=(int)(enemyHP*.21); break;
            case 2 : enemyRandPower=(int)(enemyHP*.22); break;
            case 3 : enemyRandPower=(int)(enemyHP*.23); break;
            default : enemyRandPower=(int)(enemyHP*.24); break;
        }
        return enemyRandPower;
    }
}
