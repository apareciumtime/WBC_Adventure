package wbcadventure;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class WBCAdventure {
    public static void main(String[] args) {
        BackgroundFrame bgFrame = new BackgroundFrame();
        
        bgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bgFrame.setVisible(true);
        /*
        MainMenu menu = new MainMenu();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);*/
        //Test Skill output
        /*JFrame frameTestSkill=new JFrame();
        frameTestSkill.setSize(1920,1080);
        frameTestSkill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTestSkill.setVisible(true);
        Skill s=new Skill("skill_1",2,20,10,"skill_1");
        JLabel skillTest=new JLabel();
        skillTest.setIcon(s.getIcon());
        skillTest.setBounds(0,0,1000,1000);
        skillTest.setOpaque(true);
        JPanel skillPanel=new JPanel();
        frameTestSkill.add(skillPanel);
        skillPanel.setBounds(0,0,1920,1080);
        skillPanel.add(skillTest);*/
    }
    
}
