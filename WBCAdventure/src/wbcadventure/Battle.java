package wbcadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
import wbcadventure.PathSetGenerator.PathType;
public class Battle extends JPanel{
    
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private WBC wbc = new WBC();
    private JLabel wbcLabel = new JLabel();
    private JLayeredPane layerPane = new JLayeredPane();
    ArrayList<Enemy> enemyArrayList=new ArrayList<>();
    private StartGame stgame;
    public Battle(StartGame stgame){
        
        this.stgame=stgame;
        NormalEnemy e1=new NormalEnemy(wbc);
        e1.setLocation(500,400);
        e1.setLayout(null);
        e1.setOpaque(false);
//        BossEnemy boss=new BossEnemy(wbc);
//        boss.setLocation(900,125);
//        boss.setLayout(null);
        
        enemyArrayList.add(e1);
//        enemyArrayList.add(boss);

        layerPane.add(wbc,Integer.valueOf(0));
        layerPane.add(e1,Integer.valueOf(1));
//        layerPane.add(boss,Integer.valueOf(3));
        
        layerPane.setBounds(0,0,1920,1080);
        layerPane.setOpaque(false);
        layerPane.setVisible(true);
        layerPane.setLayout(null);
        this.add(layerPane);
        
//        PathSetGenerator set=new PathSetGenerator(PathType.WIDE_FORK);
//        layerPane.add(set.generateWideFork(2,600,300),Integer.valueOf(3));
        PathGenerator pGen=new PathGenerator(this);
        pGen.startGeneratePath();
        pGen.translatePath();
        
        WBCMovement move=new WBCMovement(wbc,this,stgame);

    }
    
    public ArrayList<Enemy> getEnemyArr(){
        return enemyArrayList;
    }
    public void removeEnemy(int i){
        this.remove(enemyArrayList.get(i));
        enemyArrayList.remove(i);
    }
    public WBC getWBC(){
        return wbc;
    }
}
