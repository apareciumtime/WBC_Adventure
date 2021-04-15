package wbcadventure;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public abstract class Enemy extends Character {
    private int randHP;
    private int randPower;
    private JLabel enemyLabel=new JLabel();
    private int x;
    private int y;
    private int speedx=1;
    private int speedy=1;
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    public Enemy(WBC wbc){
        randHP=randomHP(wbc);
        randPower=randomPower(wbc);

        this.getHPcontrol().increaseMaxHP(randHP);
        this.getHPcontrol().heal();
        this.plusPowerDefault(randPower);
        
        this.setOpaque(false);
        this.setVisible(true);
        this.setBorder(border);
        
    }
    public abstract int randomHP(WBC wbc);
    public abstract int randomPower(WBC wbc);
    
    public JLabel getEnemyLabel(){
        return enemyLabel;
    }
    
    public void setLocation(int x,int y){
        super.setLocation(x, y);
        this.x=x;
        this.y=y;
    }
    
    public void setImgCorner(int x,int y){
        this.x-=x;
        this.y-=y;
        this.setLocation(this.x, this.y);
    }
}
