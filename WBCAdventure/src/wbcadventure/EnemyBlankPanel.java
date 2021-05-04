package wbcadventure;
import java.util.ArrayList;
import javax.swing.JPanel;
import wbcadventure.PathSetGenerator.PathType;

public class EnemyBlankPanel extends JPanel{
    private PathType OnPathType;
    private boolean beChoice;
    private ArrayList<Integer> mustBeDelete=new ArrayList<>();
    private Enemy enemyOnPanel;
    
    /**
     * Constructor of EnemyBlankPanel : class of blank panel to add enemy in the fixed location
     * @param pt : type of path that blank panel live in
     * @param ch : tell that this blank panel is on fork or not
     * @param a : ArrayList of index which have to be delete if win this enemy
     */
    public EnemyBlankPanel(PathType pt,boolean ch,ArrayList<Integer> a){
        OnPathType=pt;
        beChoice=ch;
        mustBeDelete=a;
    }
     
    /**
     * get type of the path that this enemy stay
     * @return type of path -> ${OnPathType}
     */
    public PathType getPathType(){
        return OnPathType;
    }
    
    /**
     * if this enemy is a choice in FORK, return true
     * @return boolean -> ${beChoice}
     */
    public boolean getBeChoice(){
        return beChoice;
    }
    
    /**
     * get ArrayList of index that must be remove after this enemy died
     * @return ArrayList<Integer> -> ${mustBeDelete}
     */
    public ArrayList<Integer> getMustBeDeleteArr(){
        return mustBeDelete;
    }
    
    /**
     * add object from class NormalEnemy to this blank
     * @param e 
     */
    public void addEnemy(Enemy e){
        enemyOnPanel=e;
        this.add(e);
    }
    
    /**
     * get NormalEnemy object from this blank
     * @return Enemy Object -> ${enemyOnPanel}
     */
    public Enemy getEnemy(){
        return enemyOnPanel;
    }
    
    /**
     * return string which tell HP of Enemy in blank panel / null
     * @return String
     */
    public String toString(){
        if(enemyOnPanel!=null)
            return "HP : "+enemyOnPanel.getHPcontrol().getMaxHP();
        else
            return null;
    }
}
