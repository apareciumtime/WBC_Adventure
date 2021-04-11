package wbcadventure;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.Border;
public class Uplayer extends JPanel{
    
    private SkillBar skillBarPanel = new SkillBar();
    private ProgressBar hpBarPanel = new ProgressBar();
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    
    public Uplayer(){
        skillBarPanel.setBounds(10,620, 616, 154);
        skillBarPanel.setOpaque(false);
        
        hpBarPanel.setBounds(0,0,1920,100);
        hpBarPanel.setOpaque(false);
        
        this.setLayout(null);
        this.add(skillBarPanel);
        this.add(hpBarPanel);
        
        
    }
}
