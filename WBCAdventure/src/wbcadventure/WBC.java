package wbcadventure;
import java.util.ArrayList;
import javax.swing.*;
public class WBC extends Character{
    private ArrayList<Skill> skillArr=new ArrayList<>();
    public WBC(){
        super(new HPcontroller(150),5);
        ImageIcon WBCHappy=new ImageIcon("src/source/character/WBC/WBCHappyForever.gif");
        ImageIcon WBCAngry1=new ImageIcon("src/source/character/WBC/WBCAngryStep1.png");
        ImageIcon WBCAngry2=new ImageIcon("src/source/character/WBC/WBCAngryStep2.png");
        super.addCharacIcon(WBCHappy);
        super.addCharacIcon(WBCAngry1);
        super.addCharacIcon(WBCAngry2);
        skillArr.add(new Skill("skill_1",1,20,10,"skill_1"));
        skillArr.add(new Skill("skill_2",1,20,10,"skill_2"));
        skillArr.add(new Skill("skill_3",1,20,10,"skill_3"));
        skillArr.add(new Skill("skill_4",1,20,10,"skill_4"));
    }
    /**
     * get object Skill at index i
     * @param i
     * @return 
     */
    public Skill getSkill(int i){
        return skillArr.get(i);
    }
}
