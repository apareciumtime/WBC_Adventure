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
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    /**
     * Constructor create The Up-layer Panel
     * Contain 1.Skill Bar Panel 2.HP Bar Panel 3.Progression Bar Panel
     */
    public Uplayer(WBC wbc){
        skillBarPanel = new SkillBar(wbc);
        hpBarPanel = new ProgressBar(wbc);
        
        skillBarPanel.setBounds(50,800, 616, 154);
        skillBarPanel.setOpaque(false);
        
        hpBarPanel.setBounds(10,10,1900,100);
        hpBarPanel.setOpaque(false);
        
        this.setLayout(null);
        this.add(skillBarPanel);
        this.add(hpBarPanel);    
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
}
