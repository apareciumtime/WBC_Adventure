package wbcadventure;
import javax.swing.ImageIcon;
public class Skill {
    private String name;
    private boolean enable;
    private boolean canUse;
    private int power;
    private int cooldown;
    private int duration;
    private ImageIcon icon;
    /**
     * 
     * @param name
     * @param power 
     * @param cooldown
     * @param duration
     * @param pathAdd : file's name
     */
    public Skill(String name,int power,int cooldown,int duration,String pathAdd){
        this.name=name;
        enable=false;
        canUse=false;
        this.power=power;
        this.cooldown=cooldown;
        this.duration=duration;
        String path="src/source/skillEffect/"+pathAdd+".GIF";
        icon=new ImageIcon(path);
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
     * get name of skill
     * @return 
     */
    public String getName(){
        return name;
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
}
