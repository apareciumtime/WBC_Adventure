package wbcadventure;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.Timer;
import java.util.TimerTask;

public class SkillBar extends JPanel{
    private JLabel skill1Label = new JLabel();
    private JLabel skill2Label = new JLabel();
    private JLabel skill3Label = new JLabel();
    private JLabel skill4Label = new JLabel();
    
    private JLayeredPane layer = new JLayeredPane();
    
    private Timer timer = new Timer();
    
    private Skill skill1 = new Skill(0,100,500,5000);
    private Skill skill2 = new Skill(1,500,500,7000);
    private Skill skill3 = new Skill(2,1000,500,10000);
    private Skill skill4 = new Skill(3,5000,700,15000);
    private Border border = BorderFactory.createLineBorder(Color.gray,1);

    public SkillBar(){
        this.setBorder(border);
        this.setLayout(null);
        
        setSkillUnable(0);
        setSkillUnable(1);
        setSkillUnable(2);
        setSkillUnable(3);
        
        setEnable(0);
        
        skill1Label.setBounds(0, 0, 154, 154);
        skill2Label.setBounds(154, 0, 154, 154);
        skill3Label.setBounds(308, 0, 154, 154);
        skill4Label.setBounds(462, 0, 154, 154);
        
        this.add(skill1Label); 
        this.add(skill2Label);
        this.add(skill3Label);
        this.add(skill4Label);
    }
    
    public void setEnable(int skillNumber){
        setSkillPending(skillNumber);
    }
    
    public void setSkillUnable(int skillNumber){
        switch(skillNumber){
            case 0 :    skill1Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
            case 1 :    skill2Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
            case 2 :    skill3Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
            case 3 :    skill4Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
        }
    }
    
    public void setSkillPending(int skillNumber){
        switch(skillNumber){
            case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
            case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
            case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
            case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
        }
    }
    
    public void setSkillDuration(int skillNumber){
        switch(skillNumber){
            case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
            case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
            case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
            case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
        }
    }
    
    public void setSkillCooldown(int skillNumber){
        switch(skillNumber){
            case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
            case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
            case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
            case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
        }
    }
}

    

    
    
    
//    private Border border = BorderFactory.createLineBorder(Color.gray,1);
//    
//    private JLayeredPane layerSkill1 = new JLayeredPane();
//    private JLayeredPane layerSkill2 = new JLayeredPane();
//    private JLayeredPane layerSkill3 = new JLayeredPane();
//    private JLayeredPane layerSkill4 = new JLayeredPane();
//    
//    private JLabel skillBarLabel = new JLabel();
//    
//    private JLabel labelSkill1Unable = new JLabel(); 
//    private JLabel labelSkill2Unable = new JLabel();
//    private JLabel labelSkill3Unable = new JLabel();
//    private JLabel labelSkill4Unable = new JLabel();
//    
//    private JLabel labelSkill1Enable = new JLabel();
//    private JLabel labelSkill2Enable = new JLabel();
//    private JLabel labelSkill3Enable = new JLabel();
//    private JLabel labelSkill4Enable = new JLabel();
//    
//    private JLabel labelSkill1Pending = new JLabel();
//    private JLabel labelSkill2Pending = new JLabel();
//    private JLabel labelSkill3Pending = new JLabel();
//    private JLabel labelSkill4Pending = new JLabel();
//    
//    private JLabel labelSkill1Duration = new JLabel();
//    private JLabel labelSkill2Duration = new JLabel();
//    private JLabel labelSkill3Duration = new JLabel();
//    private JLabel labelSkill4Duration = new JLabel();
//    
//    private JLabel labelSkill1Cooldown = new JLabel();
//    private JLabel labelSkill2Cooldown = new JLabel();
//    private JLabel labelSkill3Cooldown = new JLabel();
//    private JLabel labelSkill4Cooldown = new JLabel();
//
//    private Skill skill1 = new Skill(0, 100, 500 ,1000);
//    private Skill skill2 = new Skill(0, 100, 500 ,1000);
//    private Skill skill3 = new Skill(0, 100, 500 ,1000);
//    private Skill skill4 = new Skill(0, 100, 500 ,1000);
    
//    public SkillBar(){       
//        this.setLayout(null);
//        /**
//         * labelSkillUnable
//         */
//        labelSkill1Unable.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));
//        labelSkill2Unable.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));
//        labelSkill3Unable.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));
//        labelSkill4Unable.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));
//        
//        /**
//         * add labelSkillUnable to layerSkill 0
//         */
//        layerSkill1.add(labelSkill1Unable, Integer.valueOf(0));
//        layerSkill2.add(labelSkill2Unable, Integer.valueOf(0));
//        layerSkill3.add(labelSkill3Unable, Integer.valueOf(0));
//        layerSkill4.add(labelSkill4Unable, Integer.valueOf(0));
//        
//        /**
//         * labelSkillEnable
//         */
//        labelSkill1Enable.setIcon(skill1.getSkillArr(0).get(0));
//        labelSkill2Enable.setIcon(skill2.getSkillArr(1).get(0));
//        labelSkill3Enable.setIcon(skill3.getSkillArr(2).get(0));
//        labelSkill4Enable.setIcon(skill4.getSkillArr(3).get(0));
//        
//        /**
//         * add labelSkillEnable to layerSkill 1
//         */
//        layerSkill1.add(labelSkill1Enable, Integer.valueOf(1));
//        layerSkill2.add(labelSkill1Enable, Integer.valueOf(1));
//        layerSkill3.add(labelSkill1Enable, Integer.valueOf(1));
//        layerSkill4.add(labelSkill1Enable, Integer.valueOf(1));
//        
//        /**
//         * labelSkillDuration
//         */
//        labelSkill1Duration.setIcon(skill1.getSkillArr(0).get(1));
//        labelSkill2Duration.setIcon(skill2.getSkillArr(1).get(1));
//        labelSkill3Duration.setIcon(skill3.getSkillArr(2).get(1));
//        labelSkill4Duration.setIcon(skill4.getSkillArr(3).get(1));
//        
//        /**
//         * add labelSkillDuration to layerSkill 2
//         */
//        layerSkill1.add(labelSkill1Duration, Integer.valueOf(2));
//        layerSkill2.add(labelSkill1Duration, Integer.valueOf(2));
//        layerSkill3.add(labelSkill1Duration, Integer.valueOf(2));
//        layerSkill4.add(labelSkill1Duration, Integer.valueOf(2));
//        
//        /**
//         * labelSkillCooldown
//         */
//        labelSkill1Cooldown.setIcon(skill1.getSkillArr(0).get(2));
//        labelSkill2Cooldown.setIcon(skill2.getSkillArr(1).get(2));
//        labelSkill3Cooldown.setIcon(skill3.getSkillArr(2).get(2));
//        labelSkill4Cooldown.setIcon(skill4.getSkillArr(3).get(2));
//        
//        /**
//         * add labelSkillCooldown to layerSkill 3
//         */
//        layerSkill1.add(labelSkill1Cooldown, Integer.valueOf(3));
//        layerSkill2.add(labelSkill1Cooldown, Integer.valueOf(3));
//        layerSkill3.add(labelSkill1Cooldown, Integer.valueOf(3));
//        layerSkill4.add(labelSkill1Cooldown, Integer.valueOf(3));
//        
//        /**
//         * labelSkillPending
//         */
//        labelSkill1Pending.setIcon(skill1.getSkillArr(0).get(0));
//        labelSkill2Pending.setIcon(skill2.getSkillArr(1).get(0));
//        labelSkill3Pending.setIcon(skill3.getSkillArr(2).get(0));
//        labelSkill4Pending.setIcon(skill4.getSkillArr(3).get(0));
//        
//        /**
//         * add labelSkillPending to layerSkill 4
//         */
//        layerSkill1.add(labelSkill1Pending, Integer.valueOf(4));
//        layerSkill2.add(labelSkill1Pending, Integer.valueOf(4));
//        layerSkill3.add(labelSkill1Pending, Integer.valueOf(4));
//        layerSkill4.add(labelSkill1Pending, Integer.valueOf(4));
//        
//        layerSkill1.setBounds(  0, 0, 154, 154);
//        layerSkill1.setOpaque(true);
//        layerSkill2.setOpaque(true);
//        layerSkill3.setOpaque(true);
//        layerSkill4.setOpaque(true);
//        layerSkill1.setBounds(154, 0, 154, 154);
//        layerSkill1.setBounds(308, 0, 154, 154);
//        layerSkill1.setBounds(462, 0, 154, 154);
//        
//        layerSkill1.setBorder(border);
//        layerSkill2.setBorder(border);
//        layerSkill3.setBorder(border);
//        layerSkill4.setBorder(border);
//        
//        setUnableSkill(0);
//        setUnableSkill(1);
//        setUnableSkill(2);
//        setUnableSkill(3);
//        
//        setEnableSkill(0);
//        setEnableSkill(1);
//        setEnableSkill(2);
//        setEnableSkill(3);
//        
//        skillBarLabel.add(layerSkill1);
//        skillBarLabel.add(layerSkill2);
//        skillBarLabel.add(layerSkill3);
//        skillBarLabel.add(layerSkill4);
//        
//        
//        skillBarLabel.setBounds(0, 0, 616, 154);
//        skillBarLabel.setBorder(border);
//        this.add(skillBarLabel);
//        
//        
//    }
//    
//    public void setUnableSkill(int skillNumber){
//        switch(skillNumber){
//            case 0:labelSkill1Unable.setVisible(true);  break;                 
//            case 1:labelSkill2Unable.setVisible(true);  break;
//            case 2:labelSkill3Unable.setVisible(true);  break;
//            case 3:labelSkill4Unable.setVisible(true);  break;  
//        }
//    }
//        
//        
//    public void setEnableSkill(int skillNumber){
//        switch(skillNumber){
//            case 0: labelSkill1Unable.setVisible(false);
//                    labelSkill1Enable.setVisible(true);     break;
//            
//            case 1: labelSkill2Unable.setVisible(false);
//                    labelSkill2Enable.setVisible(true);     break;
//            
//            case 2: labelSkill3Unable.setVisible(false);
//                    labelSkill3Enable.setVisible(true);     break;
//            
//            case 3: labelSkill4Unable.setVisible(false);
//                    labelSkill4Enable.setVisible(true);     break;
//        }
//    }
//    
//    public void setDurationSkill(int skillNumber){
//        switch(skillNumber){
//            case 0: labelSkill1Enable.setVisible(false);
//                    labelSkill1Duration.setVisible(true);   break;
//            
//            case 1: labelSkill2Enable.setVisible(false);
//                    labelSkill2Duration.setVisible(true);   break;
//            
//            case 2: labelSkill3Enable.setVisible(false);
//                    labelSkill3Duration.setVisible(true);   break;
//            
//            case 3: labelSkill4Enable.setVisible(false);
//                    labelSkill4Duration.setVisible(true);   break;
//        }
//    }
//    
//    public void setCooldownSkill(int skillNumber){
//        switch(skillNumber){
//            case 0: labelSkill1Duration.setVisible(false);
//                    labelSkill1Cooldown.setVisible(true);   break;
//            
//            case 1: labelSkill2Duration.setVisible(false);
//                    labelSkill2Cooldown.setVisible(true);   break;
//            
//            case 2: labelSkill3Duration.setVisible(false);
//                    labelSkill3Cooldown.setVisible(true);   break;
//            
//            case 3: labelSkill4Duration.setVisible(false);
//                    labelSkill4Cooldown.setVisible(true);   break;
//        }
//    }
//        
//    public void setPending(int skillNumber){
//        switch(skillNumber){
//            case 0: labelSkill1Cooldown.setVisible(false);
//                    labelSkill1Pending.setVisible(true);    break;
//            
//            case 1: labelSkill2Cooldown.setVisible(false);
//                    labelSkill2Pending.setVisible(true);    break;
//            
//            case 2: labelSkill3Cooldown.setVisible(false);
//                    labelSkill3Pending.setVisible(true);    break;
//            
//            case 3: labelSkill4Cooldown.setVisible(false);
//                    labelSkill4Pending.setVisible(true);    break;
//        }
//    }
//}