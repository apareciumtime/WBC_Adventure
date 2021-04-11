package wbcadventure;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class SkillBar extends JPanel{
    ArrayList<ImageIcon> skill1Arr = new ArrayList<>();
    ArrayList<ImageIcon> skill2Arr = new ArrayList<>();
    ArrayList<ImageIcon> skill3Arr = new ArrayList<>();
    ArrayList<ImageIcon> skill4Arr = new ArrayList<>();
    
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    public SkillBar(){
//        this.setBorder(border);
        this.setLayout(null);
        
        /**
         * Skill 1 ArrayList : Pending , Duration , CoolDown
         */
        skill1Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill1Pending.png"));     //0 Pending
        skill1Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill1Duration.png"));    //1 Duration
        skill1Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill1Cooldown.png"));    //2 Cooldown
        /**
         * Skill 2 ArrayList : Pending , Duration , CoolDown
         */
        skill2Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill2Pending.png"));     //0 Pending
        skill2Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill2Duration.png"));    //1 Duration
        skill2Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill2Cooldown.png"));    //2 Cooldown
        /**
         * Skill 3 ArrayList : Pending , Duration , CoolDown
         */
        skill3Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill3Pending.png"));     //0 Pending
        skill3Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill3Duration.png"));    //1 Duration
        skill3Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill3Cooldown.png"));    //2 Cooldown
        /**
         * Skill 4 ArrayList : Pending , Duration , CoolDown
         */
        skill4Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill4Pending.png"));     //0 Pending
        skill4Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill4Duration.png"));    //1 Duration
        skill4Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill4Cooldown.png"));    //2 Cooldown

        
        JLabel skill1Label = new JLabel();
        skill1Label.setIcon(skill1Arr.get(0));
        skill1Label.setBounds(0,0,154,154);
//        skill1Label.setBorder(border);
        
        JLabel skill2Label = new JLabel();
        skill2Label.setIcon(skill2Arr.get(0));
        skill2Label.setBounds(154,0,154,154);
//        skill2Label.setBorder(border);
        
        JLabel skill3Label = new JLabel();
        skill3Label.setIcon(skill3Arr.get(0));
        skill3Label.setBounds(308,0,154,154);
//        skill3Label.setBorder(border);
        
        JLabel skill4Label = new JLabel();
        skill4Label.setIcon(skill4Arr.get(0));
        skill4Label.setBounds(462,0,154,154);
//        skill4Label.setBorder(border);
        
        
        this.add(skill1Label);
        this.add(skill2Label);
        this.add(skill3Label);
        this.add(skill4Label);
        
    }
}