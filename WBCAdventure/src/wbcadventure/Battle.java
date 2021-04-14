package wbcadventure;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.Border;
public class Battle extends JPanel{
    
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    private WBC wbc = new WBC();
    private JLabel wbcLabel = new JLabel();
    
    public Battle(){
        wbc.setBounds(0, 0, 150, 200);
        wbc.setOpaque(false);
        
        wbcLabel.add(wbc);
        wbcLabel.setBounds(500, 500, 300, 200);
        wbcLabel.setLayout(null);
        
        this.add(wbcLabel);
    }

    
    public wbcadventure.WBC getWBCLabel(){
        return wbc;
    }

    
}
