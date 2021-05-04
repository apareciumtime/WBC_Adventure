package wbcadventure;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class NormalEnemy extends Enemy {
    private static int nextCnt=0;
    private int cnt;
    private int characIcon;
    
    /**
     * Constructor of NormalEnemy
     * @param wbc 
     */
    public NormalEnemy(WBC wbc){
        super(wbc);
        
        this.plusPowerDefault(randomPower(wbc));
        
        cnt=nextCnt++;
        
        this.addCharacIcon(new ImageIcon("src/source/character/Enemies/Enemy.gif"));
        this.addCharacIcon(new ImageIcon("src/source/character/Enemies/Enemy2.gif"));
        
        Random rand=new Random();
        int randIcon=rand.nextInt(50)%2;
        
        this.setBounds(0,0,150,200);
        this.getNumberHP().setBounds(0,0,150,55);
        this.getNumberHP().setText(""+this.getHPcontrol().getHP());
        this.add(getNumberHP());
        
        switch(randIcon){
            case 0:
                this.getEnemyLabel().setIcon(this.getCharacIcon(0));
                characIcon=0;
                this.getEnemyLabel().setOpaque(false);
                this.getEnemyLabel().setVisible(true);
                this.getEnemyLabel().setLayout(null);
                this.getEnemyLabel().setBounds(0,0,150,200);
                this.add(this.getEnemyLabel());
                break;
            default:
                this.getEnemyLabel().setIcon(this.getCharacIcon(1));
                characIcon=1;
                this.getEnemyLabel().setOpaque(false);
                this.getEnemyLabel().setVisible(true);
                this.getEnemyLabel().setLayout(null);
                this.getEnemyLabel().setBounds(0,0,150,200);
                this.add(this.getEnemyLabel());
                break;
        }         
    }
    
    /**
     * Random HP for NormalEnemy by WBC's HP
     * @param wbc
     * @return 
     */
    public int randomHP(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(1000)%50;
        int wbcHP=wbc.getHPcontrol().getMaxHP();
        int enemyRandHP = wbcHP;
        switch(casenum){
            case 0 : enemyRandHP=(int)(wbcHP*2); break;
            case 1 : enemyRandHP=(int)(wbcHP*1.99); break;
            case 2 : enemyRandHP=(int)(wbcHP*1.98); break;
            case 3 : enemyRandHP=(int)(wbcHP*1.97); break;
            case 4 : enemyRandHP=(int)(wbcHP*1.96); break;
            case 5 : enemyRandHP=(int)(wbcHP*1.95); break;
            case 6 : enemyRandHP=(int)(wbcHP*1.94); break;
            case 7 : enemyRandHP=(int)(wbcHP*1.93); break;
            case 8 : enemyRandHP=(int)(wbcHP*1.92); break;
            case 9 : enemyRandHP=(int)(wbcHP*1.91); break;
            case 10 : enemyRandHP=(int)(wbcHP*1.25); break;
            case 11 : enemyRandHP=(int)(wbcHP*1.29); break;
            case 12 : enemyRandHP=(int)(wbcHP*1.27); break;
            case 13 : enemyRandHP=(int)(wbcHP*1.28); break;
            case 14 : enemyRandHP=(int)(wbcHP*1.29); break;
            case 15 : enemyRandHP=(int)(wbcHP*1.251); break;
            case 16 : enemyRandHP=(int)(wbcHP*1.21); break;
            case 17 : enemyRandHP=(int)(wbcHP*1.22); break;
            case 18 : enemyRandHP=(int)(wbcHP*1.293); break;
            case 19 : enemyRandHP=(int)(wbcHP*1.253); break;
            case 20 : enemyRandHP=(int)(wbcHP*1.295); break;
            case 21 : enemyRandHP=(int)(wbcHP*1.296); break;
            case 22 : enemyRandHP=(int)(wbcHP*1.297); break;
            case 23 : enemyRandHP=(int)(wbcHP*1.298); break;
            case 24 : enemyRandHP=(int)(wbcHP*1.299); break;
            case 25 : enemyRandHP=(int)(wbcHP); break;
            case 26 : enemyRandHP=(int)(wbcHP*1.90); break;
            case 27 : enemyRandHP=(int)(wbcHP*1.89); break;
            case 28 : enemyRandHP=(int)(wbcHP*1.88); break;
            case 29 : enemyRandHP=(int)(wbcHP*1.87); break;
            case 30 : enemyRandHP=(int)(wbcHP*1.86); break;
            case 31 : enemyRandHP=(int)(wbcHP*1.85); break;
            case 32 : enemyRandHP=(int)(wbcHP*1.84); break;
            case 33 : enemyRandHP=(int)(wbcHP*1.83); break;
            case 34 : enemyRandHP=(int)(wbcHP*1.82); break;
            case 35 : enemyRandHP=(int)(wbcHP*2.1); break;
            case 36 : enemyRandHP=(int)(wbcHP*2.09); break;
            case 37 : enemyRandHP=(int)(wbcHP*2.08); break;
            case 38 : enemyRandHP=(int)(wbcHP*2.07); break;
            case 39 : enemyRandHP=(int)(wbcHP*2.06); break;
            case 40 : enemyRandHP=(int)(wbcHP*2.05); break;
            case 41 : enemyRandHP=(int)(wbcHP*2.04); break;
            case 42 : enemyRandHP=(int)(wbcHP*2.03); break;
            case 43 : enemyRandHP=(int)(wbcHP*2.02); break;
            case 44 : enemyRandHP=(int)(wbcHP*2.01); break;
            case 45 : enemyRandHP=(int)(wbcHP*1.56); break;
            case 46 : enemyRandHP=(int)(wbcHP*1.58); break;
            case 47 : enemyRandHP=(int)(wbcHP*1.59); break;
            case 48 : enemyRandHP=(int)(wbcHP*1.57); break;
            case 49 : enemyRandHP=(int)(wbcHP*1.54); break;
        }
        return enemyRandHP;
    }
    
    /**
     * Random power for NormalEnemy by it's HP
     * @param wbc
     * @return 
     */
    public int randomPower(WBC wbc){
        Random rand=new Random();
        int casenum=rand.nextInt(50)%5;
        int enemyHP=this.getHPcontrol().getHP();
        int enemyRandPower;
        switch(casenum){
            case 0 : enemyRandPower=(int)(enemyHP*.08); break;
            case 1 : enemyRandPower=(int)(enemyHP*.09); break;
            case 2 : enemyRandPower=(int)(enemyHP*.1); break;
            case 3 : enemyRandPower=(int)(enemyHP*.11); break;
            default : enemyRandPower=(int)(enemyHP*.12); break;
        }
        return enemyRandPower;
    }
    
    
    /**
     * return String that tell number of NormalEnemy and it's HP
     * @return 
     */
    public String toString(){
        return "NormalEnemy num : "+cnt+" hp : "+this.getHPcontrol().getHP()+"\n";
    }
    
    /**
     * return int represent type of NormalEnemy
     * @return 
     */
    public int getCharacIconNum(){
        return characIcon;
    }
}