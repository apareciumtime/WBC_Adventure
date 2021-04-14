package wbcadventure;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public abstract class Enemy extends Character {
    private int randHP;
    private int randPower;
    private JLabel enemyLabel=new JLabel();
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
}
