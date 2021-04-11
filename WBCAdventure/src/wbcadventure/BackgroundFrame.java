package wbcadventure;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JProgressBar;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class BackgroundFrame extends JFrame implements ActionListener{
    ImageIcon bg = new ImageIcon("src/source/background/background.jpg");   //background Image
    JLayeredPane layerPaneDefault = new JLayeredPane();                     //Default layer for background Image
    JLayeredPane layerPanePalette = new JLayeredPane();                     //Palette layer for path Image
    JLabel skill = new JLabel();
    JLabel skill2 = new JLabel();
    /**
     * BackgroundFrame default constructor use for start the first round game
     * User will start at the (0,0) point
     */
    public BackgroundFrame(){
        Dimension frameWork = new Dimension(1920,1080);
        this.setSize(frameWork);
        this.setLayout(null);
        this.setResizable(true);
        
        JLabel bgImg = new JLabel();
        bgImg.setIcon(bg);
        bgImg.setOpaque(true);
        bgImg.setBounds(0,0,1920,1080);
        
        ImageIcon pathImage = new ImageIcon("src/source/background/platePlain.png");
        JLabel path = new JLabel();
        path.setIcon(pathImage);
        path.setOpaque(false);
        path.setBounds(100,465,150,150);
        
        /*JLabel WBC = new JLabel();
        ImageIcon WBCIdle = new ImageIcon("src/source/character/WBC/WBCHappyForever.gif");
        WBC.setIcon(WBCIdle);
        this.add(WBC);
        WBC.setOpaque(false);
        WBC.setBounds(100,350,150,200);*/
        
        JLabel WBC = new JLabel();
        ImageIcon WBCIdle = new ImageIcon("src/source/character/WBC/WBCAngryStep2.png");
        WBC.setIcon(WBCIdle);
        this.add(WBC);
        WBC.setOpaque(false);
        WBC.setBounds(100,400,150,200);
        
        
        /*Timer loop = new Timer(10,this);
        loop.start(); */
            Skill s=new Skill("skill_1",2,20,10,"skill_1");
            skill.setIcon(s.getIcon());
            skill.setOpaque(false);
            skill.setBounds(200,350,500,500); 
            this.add(skill);
            skill.setIcon(null);
            s.getIcon().getImage().flush();
            skill2.setIcon(s.getIcon());
            skill2.setOpaque(false);
            skill2.setBounds(400,350,500,500); 
            this.add(skill2);

        /*
        JLabel Enemy = new JLabel();
        ImageIcon EnemyIdle = new ImageIcon("src/source/character/Enemies/Enemy.gif");
        Enemy.setIcon(EnemyIdle);
        this.add(Enemy);
        Enemy.setOpaque(false);
        Enemy.setBounds(250,350,150,200);  */
        
        layerPanePalette.add(WBC, JLayeredPane.PALETTE_LAYER);
        layerPanePalette.add(path, JLayeredPane.PALETTE_LAYER);
        layerPanePalette.setBounds(0,0,1920,1080);
        layerPanePalette.setVisible(true);
        
        layerPaneDefault.add(bgImg, JLayeredPane.DEFAULT_LAYER);
        layerPaneDefault.setBounds(0, 0, 1920, 1080);
        layerPaneDefault.setVisible(true);
        
        this.add(layerPanePalette);
        this.add(layerPaneDefault);  
        
          
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
