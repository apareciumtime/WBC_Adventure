package wbcadventure;

import java.awt.Color;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import wbcadventure.PathSetGenerator.PathType;

public class PathGenerator {
    private int x=0,y=0;
    private PathSetGenerator prevPathGen;
    private PathSetGenerator nextPathGen;
    private JPanel prevPathSet;
    private JPanel nextPathSet;
    private JPanel bigPanel;
    private JLayeredPane path;
    private JPanel allEnemyCoordinatePanel=new JPanel();
    private Battle battleObj;
    private ArrayList<JPanel> enemyCoordinatePanelSet=new ArrayList<>();
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    public PathGenerator(JPanel big){
        path=new JLayeredPane();
        path.setBounds(x, y,10000,1080);
        allEnemyCoordinatePanel.setBounds(x, y, 10000, 1080);
        this.setUp(allEnemyCoordinatePanel);
        bigPanel=big;
        battleObj=(Battle)big;
    }
    
    /**
     * Generate path from start to the end (All random)
     */
    public void startGeneratePath(){
        setUp(path);

        Random rand=new Random();
        prevPathGen=new PathSetGenerator(PathType.SQUARE,battleObj,this);
        prevPathSet=prevPathGen.generateSquare(4,3,0,300,0,2); 
        path.add(prevPathSet,Integer.valueOf(0));
        
        for(int i=1;i<=11;i++){
            int randomnum=rand.nextInt(prevPathGen.getCanBeNext().size());
            
            System.out.println(randomnum);
            PathType whatCanBeNext=prevPathGen.getCanBeNext().get(randomnum);
            int whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(randomnum).getX();
            int whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(randomnum).getY();
            System.out.println("locate array"+prevPathGen.getCanBeNextLocate().toString());
            System.out.println("benext array"+prevPathGen.getCanBeNext().toString());
            switch(whatCanBeNext){
                case WIDE_FORK: 
                    if(whereCanBeNextY>=150 && whereCanBeNextY<=450){
                        nextPathGen=new PathSetGenerator(PathType.WIDE_FORK,battleObj,this);
                        nextPathSet=nextPathGen.generateWideFork(rand.nextInt(3)+2,whereCanBeNextX,whereCanBeNextY);
                    }
                    else if(whereCanBeNextY<150){
                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY+150);
                    }
                    else{
                        nextPathGen=new PathSetGenerator(PathType.UPRIGHT,battleObj,this);
                        nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY); 
                    }
                    break;
                case STRAIGHT:
                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                    nextPathSet=nextPathGen.generateStraight(rand.nextInt(2)+2,whereCanBeNextX,whereCanBeNextY); 
                    break;
                case NARROW_FORK: 
                    if(whereCanBeNextY>=150 && whereCanBeNextY<=600){
                        nextPathGen=new PathSetGenerator(PathType.NARROW_FORK,battleObj,this);
                        nextPathSet=nextPathGen.generateNarrowFork(rand.nextInt(3)+3,whereCanBeNextX,whereCanBeNextY); 
                    }
                    else if(whereCanBeNextY<150){
                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY); 
                    }
                    else{
                        nextPathGen=new PathSetGenerator(PathType.UPRIGHT,battleObj,this);
                        nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY-150); 
                    }
                    break;
                case DOWNRIGHT: 
                    if(whereCanBeNextY<=600){
                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                    }
                    else{
                        nextPathGen=new PathSetGenerator(PathType.UPRIGHT,battleObj,this);
                        nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY-150);
                    } 
                    break;
                case UPRIGHT:
                    if(whereCanBeNextY>=150){
                        nextPathGen=new PathSetGenerator(PathType.UPRIGHT,battleObj,this);
                        nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY);
                    }
                    else{
                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY+150);
                    } 
                    nextPathGen=new PathSetGenerator(PathType.UPRIGHT,battleObj,this);
                    nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY);  
                    break;
                case SQUARE: 
                    nextPathGen=new PathSetGenerator(PathType.SQUARE,battleObj,this);
                    nextPathSet=nextPathGen.generateSquare(7,3,whereCanBeNextX,whereCanBeNextY,1,2);  
                    break;
                default: break;
            }
            path.add(nextPathSet,Integer.valueOf(i));
            prevPathGen=nextPathGen;
            prevPathSet=nextPathSet;
        }
        path.add(allEnemyCoordinatePanel,Integer.valueOf(15));
        bigPanel.add(path);
        for(JPanel pa:enemyCoordinatePanelSet){
            pa.setBorder(border);
        }
    }
    
    /**
     * Make the path move to the left
     */
    public void translatePath(){
        Timer time=new Timer();
        TimerTask move=new TimerTask() {
            @Override
            public void run() {
                for(int i=0;i<=200;i++){
                    x-=10;
                    path.setLocation(x,y);
//                    allEnemyCoordinatePanel.setLocation(x, y);
                    try {
                        sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }    
                }
            }
        };time.schedule(move,0,10100);
    }
    
    /**
     * set everything for JLabel (setOpaque false , setLayout null , setVisible true , setBorder)
     * @param pa 
     */
    public void setUp(JPanel pa){
        pa.setOpaque(false);
        pa.setLayout(null);
        pa.setVisible(true);
        pa.setBorder(border);
    }
    
    /**
     * set everything for JLayeredPane (setOpaque false , setLayout null , setVisible true , setBorder)
     * @param pa 
     */
    public void setUp(JLayeredPane pa){
        pa.setOpaque(false);
        pa.setLayout(null);
        pa.setVisible(true);
        pa.setBorder(border);
    }
    
    /**
     * get JPanel which have all empty Panel to fill enemy
     * @return 
     */
    public JPanel getAllEnemyCooPanel(){
        return allEnemyCoordinatePanel;
    }
    
    /**
     * add panel to fill enemy to ArrayList and allEnemyCoordinatePanel 
     * @param emptyPanel 
     */
    public void addEnemyCoordinate(JPanel emptyPanel){
        enemyCoordinatePanelSet.add(emptyPanel);
        allEnemyCoordinatePanel.add(emptyPanel);
    }
}
