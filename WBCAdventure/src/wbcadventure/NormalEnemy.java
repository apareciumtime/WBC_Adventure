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
    public NormalEnemy(WBC wbc){
        super(wbc);
        
        cnt=nextCnt++;
        
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
                characIcon=0;
                this.getEnemyLabel().setOpaque(false);
                this.getEnemyLabel().setVisible(true);
                this.getEnemyLabel().setLayout(null);
                this.getEnemyLabel().setBounds(0,0,150,200);
                this.add(this.getEnemyLabel());
                System.out.println("Rand 0");
                break;
            default:
                this.getEnemyLabel().setIcon(this.getCharacIcon(1));
                characIcon=1;
                this.getEnemyLabel().setOpaque(false);
                this.getEnemyLabel().setVisible(true);
                this.getEnemyLabel().setLayout(null);
                this.getEnemyLabel().setBounds(0,0,150,200);
                this.add(this.getEnemyLabel());
                System.out.println("Rand 1");
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
            case 0 : enemyRandHP=(int)(wbcHP*0.75); break;
            case 1 : enemyRandHP=(int)(wbcHP*0.76); break;
            case 2 : enemyRandHP=(int)(wbcHP*0.77); break;
            case 3 : enemyRandHP=(int)(wbcHP*0.78); break;
            case 4 : enemyRandHP=(int)(wbcHP*0.79); break;
            case 5 : enemyRandHP=(int)(wbcHP*0.80); break;
            case 6 : enemyRandHP=(int)(wbcHP*0.81); break;
            case 7 : enemyRandHP=(int)(wbcHP*0.82); break;
            case 8 : enemyRandHP=(int)(wbcHP*0.83); break;
            case 9 : enemyRandHP=(int)(wbcHP*0.84); break;
            case 10 : enemyRandHP=(int)(wbcHP*0.85); break;
            case 11 : enemyRandHP=(int)(wbcHP*0.86); break;
            case 12 : enemyRandHP=(int)(wbcHP*0.87); break;
            case 13 : enemyRandHP=(int)(wbcHP*0.88); break;
            case 14 : enemyRandHP=(int)(wbcHP*0.89); break;
            case 15 : enemyRandHP=(int)(wbcHP*0.9); break;
            case 16 : enemyRandHP=(int)(wbcHP*0.91); break;
            case 17 : enemyRandHP=(int)(wbcHP*0.82); break;
            case 18 : enemyRandHP=(int)(wbcHP*0.93); break;
            case 19 : enemyRandHP=(int)(wbcHP*0.94); break;
            case 20 : enemyRandHP=(int)(wbcHP*0.95); break;
            case 21 : enemyRandHP=(int)(wbcHP*0.96); break;
            case 22 : enemyRandHP=(int)(wbcHP*0.97); break;
            case 23 : enemyRandHP=(int)(wbcHP*0.98); break;
            case 24 : enemyRandHP=(int)(wbcHP*0.99); break;
            case 25 : enemyRandHP=(int)(wbcHP); break;
            case 26 : enemyRandHP=(int)(wbcHP*1.01); break;
            case 27 : enemyRandHP=(int)(wbcHP*1.02); break;
            case 28 : enemyRandHP=(int)(wbcHP*1.03); break;
            case 29 : enemyRandHP=(int)(wbcHP*1.04); break;
            case 30 : enemyRandHP=(int)(wbcHP*1.05); break;
            case 31 : enemyRandHP=(int)(wbcHP*1.06); break;
            case 32 : enemyRandHP=(int)(wbcHP*1.07); break;
            case 33 : enemyRandHP=(int)(wbcHP*1.08); break;
            case 34 : enemyRandHP=(int)(wbcHP*1.09); break;
            case 35 : enemyRandHP=(int)(wbcHP*1.1); break;
            case 36 : enemyRandHP=(int)(wbcHP*1.11); break;
            case 37 : enemyRandHP=(int)(wbcHP*1.12); break;
            case 38 : enemyRandHP=(int)(wbcHP*1.13); break;
            case 39 : enemyRandHP=(int)(wbcHP*1.14); break;
            case 40 : enemyRandHP=(int)(wbcHP*1.15); break;
            case 41 : enemyRandHP=(int)(wbcHP*1.16); break;
            case 42 : enemyRandHP=(int)(wbcHP*1.17); break;
            case 43 : enemyRandHP=(int)(wbcHP*1.18); break;
            case 44 : enemyRandHP=(int)(wbcHP*1.19); break;
            case 45 : enemyRandHP=(int)(wbcHP*1.2); break;
            case 46 : enemyRandHP=(int)(wbcHP*1.21); break;
            case 47 : enemyRandHP=(int)(wbcHP*1.22); break;
            case 48 : enemyRandHP=(int)(wbcHP*1.23); break;
            case 49 : enemyRandHP=(int)(wbcHP*1.24); break;
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
            case 0 : enemyRandPower=(int)(enemyHP*.1); break;
            case 1 : enemyRandPower=(int)(enemyHP*.11); break;
            case 2 : enemyRandPower=(int)(enemyHP*.12); break;
            case 3 : enemyRandPower=(int)(enemyHP*.13); break;
            default : enemyRandPower=(int)(enemyHP*.14); break;
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
    
    public int getCharacIconNum(){
        return characIcon;
    }
}
