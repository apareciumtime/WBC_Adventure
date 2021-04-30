package wbcadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
import wbcadventure.MainMenu.Buttons;
import wbcadventure.PathSetGenerator.PathType;
public class Battle extends JPanel{
 
    private WBC wbc = new WBC();
    BossEnemy boss=new BossEnemy(wbc);
    private JLayeredPane layerPane = new JLayeredPane();
    private StartGame stgame;
    PathGenerator pGen=new PathGenerator(this);
    public Battle(StartGame stgame){
        
        this.stgame=stgame;
        layerPane.setBounds(0,0,1920,1080);
        layerPane.setOpaque(false);
        layerPane.setVisible(true);
        layerPane.setLayout(null);
        this.add(layerPane);
        pGen.startGeneratePath();
        System.out.println(pGen.getEnemyPanelArrayList());
    }
    
    public PathGenerator getPathGen(){
        return pGen;
    }
    
    public StartGame getStGame(){
        return stgame;
    }
    
    public WBC getWBC(){
        return wbc;
    }
    
    public BossEnemy getBoss(){
        return boss;
    }
        
    public JLayeredPane getLayerPane(){
        return layerPane;
    }
    
}
