package wbcadventure;
import java.util.ArrayList;
import javax.swing.JPanel;
import wbcadventure.PathSetGenerator.PathType;

public class EnemyBlankPanel extends JPanel{
    private PathType OnPathType;
    private boolean beChoice;
    private ArrayList<Integer> mustBeDelete=new ArrayList<>();
    private Enemy enemyOnPanel;
    
    public EnemyBlankPanel(PathType pt,boolean ch,ArrayList<Integer> a){
        OnPathType=pt;
        beChoice=ch;
        mustBeDelete=a;
    }
     
    /**
     * get type of the path that this enemy stay
     * @return 
     */
    public PathType getPathType(){
        return OnPathType;
    }
    
    /**
     * if this enemy is a choice in FORK, return true
     * @return 
     */
    public boolean getBeChoice(){
        return beChoice;
    }
    
    /**
     * get ArrayList of index that must be remove after this enemy died
     * @return 
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
     * @return 
     */
    public Enemy getEnemy(){
        return enemyOnPanel;
    }
    
    public String toString(){
        if(enemyOnPanel!=null)
            return "HP : "+enemyOnPanel.getHPcontrol().getMaxHP();
        else
            return null;
    }
}
