package wbcadventure;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public abstract class Enemy extends Character {
    private int randHP;
    private int randPower;
    private JLabel enemyLabel = new JLabel();
    private JLabel numberHP;
    private int x;
    private int y;
    private int speedx=1;
    private int speedy=1;
    
    /**
     * constructor of Enemy
     * @param wbc 
     */
    public Enemy(WBC wbc){
        randHP=randomHP(wbc);
        this.getHPcontrol().increaseMaxHP(randHP);
        this.getHPcontrol().heal();
        
        randPower=randomPower(wbc);
        this.plusPowerDefault(randPower);
        
        numberHP = new JLabel(""+randHP,JLabel.CENTER);
        numberHP.setFont(new Font("Courier New", Font.BOLD, 36));
        numberHP.setLayout(null);
        numberHP.setVisible(true);

        this.setOpaque(false);
        this.setVisible(true);
        
    }
    
    public abstract int randomHP(WBC wbc);
    public abstract int randomPower(WBC wbc);
    
    /**
     * get JLabel of Enemy
     * @return JLabel -> ${enemyLabel}
     */
    public JLabel getEnemyLabel(){
        return enemyLabel;
    }
    
    /**
     * set location for Enemy and set value of instance variable x,y
     * @param x
     * @param y 
     */
    public void setLocation(int x,int y){
        super.setLocation(x, y);
        this.x=x;
        this.y=y;
    }
    
    /**
     * move location of Enemy to the left and down
     * @param x
     * @param y 
     */
    public void setImgCorner(int x,int y){
        this.x-=x;
        this.y-=y;
        this.setLocation(this.x, this.y);
    }
    
    /**
     * get JLabel which show Enemy's HP
     * @return 
     */
    public JLabel getNumberHP(){
        return numberHP;
    }
}