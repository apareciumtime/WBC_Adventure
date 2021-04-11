package wbcadventure;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class ProgressBar extends JPanel{

    WBC wbcCharacter = new WBC();
    JProgressBar hpBarWBC = new JProgressBar();
    JLayeredPane layer = new JLayeredPane();
    
    private Border border = BorderFactory.createLineBorder(Color.gray,1);

    
    public ProgressBar(){
        
//        
//        JLabel hpBarWBCLabel = new JLabel();
//        hpBarWBCLabel.add(hpBarWBC);
//        hpBarWBCLabel.setBounds(0, 0, 1920, 100);

        JLabel HPBarWBCLabel = new JLabel();
        JLabel progressBarWBC = new JLabel();
        JLabel HPBarWBCImg = new JLabel();
        
        HPBarWBCImg.setIcon(new ImageIcon("src/source/uplayer/HPBar/HPBarWBC.png"));
        HPBarWBCImg.setOpaque(false);
        HPBarWBCImg.setBounds(0, 0, 790, 75);
        HPBarWBCImg.setBorder(border);
        
        
        hpBarWBC.setValue(wbcCharacter.getHPcontrol().getMaxHP());
//        hpBarWBC.setStringPainted(true);
        hpBarWBC.setBounds(0,0,565, 42);
        hpBarWBC.setForeground(new Color(0x6fc998));
        hpBarWBC.setBackground(new Color(0xde9898));
        hpBarWBC.setValue(50);
        progressBarWBC.add(hpBarWBC);
        progressBarWBC.setBounds(210,15,565,42);
        layer.add(progressBarWBC,Integer.valueOf(0));

        
//        this.add(hpBarWBCLabel);

        layer.add(HPBarWBCImg,Integer.valueOf(1));
        layer.setBounds(0, 0, 1920 , 75);
        layer.setBorder(border);
        
        layer.setVisible(true);
        this.add(layer);
        this.setLayout(null);
        this.setBounds(0, 0, 1920, 100);
        this.setBorder(border);
    }

}
