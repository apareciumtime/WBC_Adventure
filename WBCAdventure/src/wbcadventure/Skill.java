package wbcadventure;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Skill{
    private int skillNumber;
    private JLabel skillStatusLabel;
    private boolean enable = false;
    private boolean canUse = false;
    private boolean timeoutDuration = true;
    private int power;
    private int duration;
    private int cooldown;
    private ImageIcon icon;
    
    private ArrayList<ImageIcon> skill1Arr = new ArrayList<>();
    private ArrayList<ImageIcon> skill2Arr = new ArrayList<>();
    private ArrayList<ImageIcon> skill3Arr = new ArrayList<>();
    private ArrayList<ImageIcon> skill4Arr = new ArrayList<>();
    
    /**
     * Constructor to create new Skill
     * @param skillNumber : which skill
     * @param power : power of the skill
     * @param cooldown : cooldown of the skill
     * @param duration : duration of the skill
     */
    public Skill(int skillNumber, int power, int duration, int cooldown){
        this.skillNumber = skillNumber;
        this.power = power;
        this.duration = duration;
        this.cooldown = cooldown;
        String path = "src/source/skillEffect/skill_" + (skillNumber+1) + ".GIF";
        icon = new ImageIcon(path);        
    }
    
    /**
     * set status of skill
     * - *true* after unlock this skill
     * - *false* before unlock this skill 
     * @param status
     */
    public void setEnable(boolean status){
        enable=status;
    }
    
    /**
     * set status of skill
     * - *true* if we can use this skill now
     * - *false* if we have to wait cooldown
     * @param status
     */
    public void setCanUse(boolean status){
        canUse=status;
    }
    
    /**
     * set status of timeoutDuration
     * - *true* if skill has not used
     * - *false* if skill has used and timeout of Duration
     * @param status 
     */
    public void setTimeoutDuration(boolean status){
        timeoutDuration = status;
    }
    
    /**
     * get name of skill
     * @return 
     */
    public int getSkillNumber(){
        return skillNumber;
    }
    
    /**
     * get status (unlock or not)
     * @return 
     */
    public boolean getEnable(){
        return enable;
    }
    
    /**
     * get status(can use or not)
     * @return 
     */
    public boolean getCanUse(){
        return canUse;
    }
    
    /**
     * get power that will increase the damage of character
     * @return 
     */
    public int getPower(){
        return power;
    }
    
    /**
     * get cooldown time
     * @return 
     */    
    public int getCooldown(){
        return cooldown;
    }
    
    /**
     * get duration that skill will affect to damage
     * @return 
     */
    public int getDuration(){
        return duration;
    }
    
    
    /**
     * get imageicon of skill to show when use
     * @return 
     */
    public ImageIcon getIcon(){
        return icon;
    }
    
    /**
     * Method return Skill ArraysList
     * @param skillNumber : which skill
     * @return Skill ArraysList as ArrayList<ImageIcon> object
     */
    public ArrayList<ImageIcon> getSkillArr(int skillNumber){
        switch(skillNumber){
            case 0: 
                /**
                 * Skill 1 ArrayList : Pending , Duration , CoolDown
                 */
                skill1Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill1Pending.png"));     //0 Pending
                skill1Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill1Duration.png"));    //1 Duration
                skill1Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill1Cooldown.png"));    //2 Cooldown
                return skill1Arr;
            
            case 1:
                /**
                 * Skill 2 ArrayList : Pending , Duration , CoolDown
                 */
                skill2Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill2Pending.png"));     //0 Pending
                skill2Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill2Duration.png"));    //1 Duration
                skill2Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill2Cooldown.png"));    //2 Cooldown
                return skill2Arr;

            case 2:
                /**
                 * Skill 3 ArrayList : Pending , Duration , CoolDown
                 */
                skill3Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill3Pending.png"));     //0 Pending
                skill3Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill3Duration.png"));    //1 Duration
                skill3Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill3Cooldown.png"));    //2 Cooldown
                return skill3Arr;
                
            case 3:
                /**
                 * Skill 4 ArrayList : Pending , Duration , CoolDown
                 */
                skill4Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill4Pending.png"));     //0 Pending
                skill4Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill4Duration.png"));    //1 Duration
                skill4Arr.add(new ImageIcon("src/source/uplayer/skillIcon/Skill4Cooldown.png"));    //2 Cooldown
                return skill4Arr;
        }
        return null;
    }
}
