package wbcadventure;
import javax.swing.*;
import java.util.ArrayList;
public abstract class Character {
    private HPcontroller characHP;
    private ArrayList<ImageIcon> characIcon=new ArrayList<>();
    private int powerDefault;
    public Character(HPcontroller HP,int pw){
        characHP=HP;
        //characIcon=icon;
        powerDefault=pw;
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
}
