package wbcadventure;

public class HPcontroller {
    private int healthPoint;
    private int maxHealthPoint;
    
    public HPcontroller(){
        healthPoint=0;
        maxHealthPoint=0;
    }
    
    public HPcontroller(int maxhp){
        healthPoint=maxhp;
        maxHealthPoint=maxhp;
    }
    /**
     * get current HP of character
     * @return 
     */
    public int getHP(){
        return healthPoint;
    }
    /**
     * get max HP of character
     * @return 
     */
    public int getMaxHP(){
        return maxHealthPoint;
    }
    /**
     * minus HP by amt
     * @param amt 
     */
    public void decreaseHP(int amt){
        this.healthPoint-=amt;
    }
    /**
     * plus HP by amt
     * @param amt 
     */
    public void increaseHP(int amt){
        healthPoint+=amt;
    }
    /**
     * plus maxHP by plusMax
     * @param plusMax 
     */
    public void increaseMaxHP(int plusMax){
        maxHealthPoint+=plusMax;
    }
    /**
     * fully restore HP
     */
    public void heal(){
        healthPoint=maxHealthPoint;
    }
    
}
