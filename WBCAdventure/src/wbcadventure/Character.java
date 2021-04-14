package wbcadventure;
import javax.swing.*;
import java.util.ArrayList;
public abstract class Character extends JPanel {
    private HPcontroller characHP;
    private ArrayList<ImageIcon> characIcon=new ArrayList<>();
    private int powerDefault;
    public Character(HPcontroller HP,int pw){
        characHP=HP;
        //characIcon=icon;
        powerDefault=pw;
    }
    public Character(){
        characHP=new HPcontroller();
        powerDefault=0;
    }
    /**
     * get HP controller of character
     * @return 
     */
    public HPcontroller getHPcontrol(){
        return characHP;
    }
    /**
     * get imageicon of character at index i
     * @return 
     */
    public ImageIcon getCharacIcon(int i){
        return characIcon.get(i);
    }
    
    public void addCharacIcon(ImageIcon icon){
        characIcon.add(icon);
    }
    
    /**
     * get default power of character (don't use any skill)
     * @return 
     */
    public int getPowerDefault(){
        return powerDefault;
    }
    
    /**
     * plus default power of character when use skill
     * @return 
     */
    public void plusPowerDefault(int amt){
        powerDefault+=amt;
    }
    
    public void minusPowerDefault(int amt){
        powerDefault-=amt;
    }
}
