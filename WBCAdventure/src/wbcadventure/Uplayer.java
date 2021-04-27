package wbcadventure;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * The Panel Receive and Output all function on Up-Layered
 * @author Developers
 */
public class Uplayer extends JPanel{
    
    private SkillBar skillBarPanel;
    private ProgressBar hpBarPanel;
    private JPanel powerBar;
    PowerBar wbcPowerBar;
    PowerBar anotherPowerBar;
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    /**
     * Constructor create The Up-layer Panel
     * Contain 1.Skill Bar Panel 2.HP Bar Panel 3.Progression Bar Panel
     */
    public Uplayer(WBC wbc){
        skillBarPanel = new SkillBar(wbc);
        hpBarPanel = new ProgressBar(wbc);
        wbcPowerBar=new PowerBar("WBC",wbc.getPowerDefault());
        
        skillBarPanel.setBounds(80,850, 616, 154);
        skillBarPanel.setOpaque(false);
        
        hpBarPanel.setBounds(10,10,1900,100);
        hpBarPanel.setOpaque(false);
        
        wbcPowerBar.setBounds(742,850,530,150);
        wbcPowerBar.setOpaque(false);
                
        this.setLayout(null);
        this.add(skillBarPanel);
        this.add(hpBarPanel);    
        this.add(wbcPowerBar);

    }
    
    /**
     * Method return Skill Bar Panel from SkillBar Class
     * @return Panel from SkillBar Class as SkillBar Class Object
     */
    public wbcadventure.SkillBar getSkillBarPanel(){
        return skillBarPanel;
    }
    
    public ProgressBar getHPBarPanel(){
        return hpBarPanel;
    }
    
    public PowerBar getWBCPowerBar(){
        return wbcPowerBar;
    }
    
    public PowerBar getAnotherPowerBar(){
        return anotherPowerBar;
    }
    
    public void setEnemyPowerBar(Enemy ene){
        if(ene instanceof BossEnemy){
            anotherPowerBar=new PowerBar("Boss",ene.getPowerDefault());
        }
        if(ene instanceof NormalEnemy){
            NormalEnemy norEne=(NormalEnemy)ene;
            if(norEne.getCharacIconNum()==0){
                anotherPowerBar=new PowerBar("Enemy1",ene.getPowerDefault());
            }
            else if(norEne.getCharacIconNum()==1){
                anotherPowerBar=new PowerBar("Enemy2",ene.getPowerDefault());
            }
        }
        anotherPowerBar.setBounds(1300,850,530,150);
        anotherPowerBar.setOpaque(false);
        anotherPowerBar.setVisible(true);
        this.add(anotherPowerBar);
    }
}
