package wbcadventure;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
public class MainMenu extends JFrame {
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    public MainMenu(){
        this.setSize(1920,1080);
        /*ImageIcon menubg=new ImageIcon("src/source/background/mainMenuBG.jpg");
        JLabel background=new JLabel();
        background.setBounds(0,0,1920,1080);
        background.setIcon(menubg);
        this.add(background);*/
        Buttons start = new Buttons("Start");
        JPanel startPanel = new JPanel();
        startPanel.add(start);
        startPanel.setBounds(0,0,500,500);
        startPanel.setOpaque(true);
        this.add(startPanel);
    }
}
