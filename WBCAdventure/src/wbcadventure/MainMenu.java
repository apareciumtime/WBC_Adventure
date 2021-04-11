package wbcadventure;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
public class MainMenu extends JFrame {
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    public MainMenu(){
        this.setSize(1920,1080);
        ImageIcon start_normal=new ImageIcon("src/source/buttons/Buttonstart_normal.png");
        JLabel start=new JLabel();
        start.setIcon(start_normal);
        start.setBounds(0,0,179,467);
        start.setOpaque(true);
        JPanel startPanel=new JPanel();
        this.add(startPanel);
        startPanel.setBounds(0,0,1920,1080);
        startPanel.add(start);
        
        
    }
}
