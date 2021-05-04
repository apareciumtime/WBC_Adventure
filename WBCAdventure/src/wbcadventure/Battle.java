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
    private BossEnemy boss=new BossEnemy(wbc);
    private JLayeredPane layerPane = new JLayeredPane();
    private StartGame stgame;
    private PathGenerator pGen=new PathGenerator(this);
    
    /**
     * Constructor of Battle : Object from class Battle is a JPanel which contain path,WBC,Enemy and Boss
     * @param stgame 
     */
    public Battle(StartGame stgame){
        this.stgame=stgame;
        layerPane.setBounds(0,0,1920,1080);
        layerPane.setOpaque(false);
        layerPane.setVisible(true);
        layerPane.setLayout(null);
        this.add(layerPane);
        pGen.startGeneratePath();
    }
    
    /**
     * get instance variable which is object from class PathGenerator
     * @return  PathGenerator object -> ${pGen}
     */
    public PathGenerator getPathGen(){
        return pGen;
    }
    
    /**
     * get instance variable which is object from class StartGame (the big panel of this battle panel)
     * @return StartGame object -> ${stgame}
     */
    public StartGame getStGame(){
        return stgame;
    }
    
    /**
     * get instance variable which is object from class WBC
     * @return WBC object -> ${wbc}
     */
    public WBC getWBC(){
        return wbc;
    }
    
    /**
     * get instance variable which is object from class BossEnemy
     * @return BossEnemy object -> ${boss}
     */
    public BossEnemy getBoss(){
        return boss;
    }
        
    /**
     * get instance variable which is JLayeredPane
     * @return JLayeredPane -> ${layerPane}
     */
    public JLayeredPane getLayerPane(){
        return layerPane;
    }
}
