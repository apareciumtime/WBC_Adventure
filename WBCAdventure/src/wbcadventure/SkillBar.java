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
    
    private Timer timer = new Timer();
    
    private WBC wbc;
    
    private Skill skill1 = new Skill(0,100,1000,2000);
    private Skill skill2 = new Skill(1,3500,1000,5000);
    private Skill skill3 = new Skill(2,5000,1000,15000);
    private Skill skill4 = new Skill(3,10000,1000,50000);
    
    private Border border = BorderFactory.createLineBorder(Color.gray,1);

    /**
     * Constructor create Skill Bar
     */
    public SkillBar(WBC wbc){
        this.wbc=wbc;
//        this.setBorder(border);
        this.setLayout(null);
        
        setSkillUnable(0);
        setSkillUnable(1);
        setSkillUnable(2);
        setSkillUnable(3);
        
        setSkillEnable(wbc.getHPcontrol().getMaxHP());
        
        skill1Label.setBounds(  0, 0, 154, 154);
        skill2Label.setBounds(154, 0, 154, 154);
        skill3Label.setBounds(308, 0, 154, 154);
        skill4Label.setBounds(462, 0, 154, 154);
        
        this.add(skill1Label); 
        this.add(skill2Label);
        this.add(skill3Label);
        this.add(skill4Label);
    }
    
    /**
     * To set the Skill Bar Unable to use
     * @param skillNumber : which skill
     */
    public void setSkillUnable(int skillNumber){
        switch(skillNumber){
            case 0 :    skill1Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
            case 1 :    skill2Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
            case 2 :    skill3Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
            case 3 :    skill4Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
        }
    }
    
    /**
     * To set Skill Bar Enable to use : it depends on Maximum of Health point of White Blood Cell character
     * @param healthPointMax : The currently maximum of Health Point of White Blood Cell character 
     */
    public void setSkillEnable(int healthPointMax){
        if(healthPointMax >= 5000){
            setSkillPending(3);
            setSkillPending(2);
            setSkillPending(1);
            setSkillPending(0);
            skill1.setEnable(true);
            skill1.setCanUse(true);
            skill2.setEnable(true);
            skill2.setCanUse(true);
            skill3.setEnable(true);
            skill3.setCanUse(true);
            skill4.setEnable(true);
            skill4.setCanUse(true);
        }
        else if(healthPointMax >= 3000){
            setSkillPending(2);
            setSkillPending(1);
            setSkillPending(0);
            skill1.setEnable(true);
            skill1.setCanUse(true);
            skill2.setEnable(true);
            skill2.setCanUse(true);
            skill3.setEnable(true);
            skill3.setCanUse(true);
        }
        else if(healthPointMax >=  1400){
            setSkillPending(1);
            setSkillPending(0);
            skill1.setEnable(true);
            skill1.setCanUse(true);
            skill2.setEnable(true);
            skill2.setCanUse(true);
        }
        else if(healthPointMax >=  600){
            setSkillPending(0);
            skill1.setEnable(true);
            skill1.setCanUse(true);
        }
    }
    
    /**
     * To set skill to be Pending Status
     * @param skillNumber : which skill
     */
    public void setSkillPending(int skillNumber){
        switch(skillNumber){
            case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
            case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
            case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
            case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
        }
    }
    
    /**
     * To set skill to be Duration Status
     * @param skillNumber : which skill
     */
    public void setSkillDuration(int skillNumber){
        switch(skillNumber){
            case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
            case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
            case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
            case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
        }
    }
    
    /**
     * To set skill to be Cooldown Status
     * @param skillNumber : which skill
     */
    public void setSkillCooldown(int skillNumber){
        switch(skillNumber){
            case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
            case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
            case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
            case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
        }
    }
    
    /**
     * To get the skill as Skill Class Object that was constructed in the SkillBar Class
     * @param skillNumber : which skill
     */
    public wbcadventure.Skill getSkill(int skillNumber){
        switch(skillNumber){
            case 0 : return skill1;
            case 1 : return skill2;
            case 2 : return skill3;
            case 3 : return skill4;
        }
        return null;
    }

    /**
     * To get Skill Label
     * @param skillNumber : which skill label
     * @return 
     */
    public JLabel getSkillLabel(int skillNumber){
        switch(skillNumber){
            case 0 : return skill1Label;
            case 1 : return skill2Label;
            case 2 : return skill3Label;
            case 3 : return skill4Label;
        }
        return null;
    }
}