package wbcadventure;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Pause extends JPanel {
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private JLayeredPane layerPane = new JLayeredPane();
    public Pause(){
        this.setBounds(0,0,1920,1080);
        this.setOpaque(true);
        this.setVisible(false);
    }
    public void setBackground(){
        JLabel bgPause=new JLabel();
        bgPause.setBounds(0,0,1920,1080);
        bgPause.setIcon(new ImageIcon("src/source/background/PauseBackground.png"));
    }
}
