package wbcadventure;
import javax.swing.*;
import java.util.ArrayList;

public abstract class Character extends JPanel {
    private HPcontroller characHP;
    private ArrayList<ImageIcon> characIcon=new ArrayList<>();
    private int powerDefault;
    
    /**
     * Constructor of Character class
     * @param HP : HP controller of character
     * @param pw : power of character
     */
    public Character(HPcontroller HP,int pw){
        characHP=HP;
        //characIcon=icon;
        powerDefault=pw;
    }
    
    /**
     * default constructor for character
     */
    public Character(){
        characHP=new HPcontroller();
        powerDefault=0;
    }
    
    /**
     * get HP controller of character
     * @return HPcontroller Object -> ${characHP}
     */
    public HPcontroller getHPcontrol(){
        return characHP;
    }
    
    /**
     * get imageicon of character at index i
     * @return ImageIcon object
     */
    public ImageIcon getCharacIcon(int i){
        return characIcon.get(i);
    }
    
    /**
     * add imageicon of character to ${characIcon} ArrayList
     * @param icon 
     */
    public void addCharacIcon(ImageIcon icon){
        characIcon.add(icon);
    }
    
    /**
     * get default power of character (don't use any skill)
     * @return ${powerDefault}
     */
    public int getPowerDefault(){
        return powerDefault;
    }
    
    /**
     * increase powerDefault by amt
     * @param amt 
     */
    public void plusPowerDefault(int amt){
        this.powerDefault = this.powerDefault + amt;
    }
    
    /**
     * decrease powerDefault by amt
     * @param amt 
     */
    public void minusPowerDefault(int amt){
        powerDefault-=amt;
    }
    
    /**
     * set powerDefault value
     * @param power 
     */
    public void setPowerDefault(int power){
        this.powerDefault = power;
    }
}
