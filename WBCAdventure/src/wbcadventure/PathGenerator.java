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
    //JPanel path;
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    public PathGenerator(JPanel big){
        bigPanel=big;
    }
    
    public void startGeneratePath(){
        path=new JLayeredPane();
        path.setBounds(x, y,10000,10000);
        setUp(path);

        Random rand=new Random();
        prevPathGen=new PathSetGenerator(PathType.SQUARE);
        prevPathSet=prevPathGen.generateSquare(4,3,0,300,0,2); 
        path.add(prevPathSet,Integer.valueOf(0));
        
        for(int i=1;i<=11;i++){
            
            int randomnum=rand.nextInt(prevPathGen.getCanBeNext().size());
            // *square ออกมาอีกทีตอนเจอbossเท่านั้น
            System.out.println(randomnum);
            PathType whatCanBeNext=prevPathGen.getCanBeNext().get(randomnum);
            int whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(randomnum).getX();
            int whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(randomnum).getY();
            System.out.println("locate array"+prevPathGen.getCanBeNextLocate().toString());
            System.out.println("benext array"+prevPathGen.getCanBeNext().toString());
            switch(whatCanBeNext){
                case WIDE_FORK: 
                    if(whereCanBeNextY>=150 && whereCanBeNextY<=450){
                        nextPathGen=new PathSetGenerator(PathType.WIDE_FORK);
                        nextPathSet=nextPathGen.generateWideFork(rand.nextInt(3)+2,whereCanBeNextX,whereCanBeNextY);
                    }
                    else if(whereCanBeNextY<150){
                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT);
                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                    }
                    else{
                        nextPathGen=new PathSetGenerator(PathType.UPRIGHT);
                        nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY); 
                    }
                    break;
                case STRAIGHT:
                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT);
                    nextPathSet=nextPathGen.generateStraight(rand.nextInt(2)+2,whereCanBeNextX,whereCanBeNextY); 
                    break;
                case NARROW_FORK: 
                    if(whereCanBeNextY>=150 && whereCanBeNextY<=600){
                        nextPathGen=new PathSetGenerator(PathType.NARROW_FORK);
                        nextPathSet=nextPathGen.generateNarrowFork(rand.nextInt(3)+3,whereCanBeNextX,whereCanBeNextY); 
                    }
                    else if(whereCanBeNextY<150){
                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT);
                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY); 
                    }
                    else{
                        nextPathGen=new PathSetGenerator(PathType.UPRIGHT);
                        nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY); 
                    }
                    break;
                case DOWNRIGHT: 
                    if(whereCanBeNextY<=600){
                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT);
                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                    }
                    else{
                        nextPathGen=new PathSetGenerator(PathType.UPRIGHT);
                        nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY);
                    } 
                    break;
                case UPRIGHT:
                    if(whereCanBeNextY>=150){
                        nextPathGen=new PathSetGenerator(PathType.UPRIGHT);
                        nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY);
                    }
                    else{
                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT);
                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                    } 
                    nextPathGen=new PathSetGenerator(PathType.UPRIGHT);
                    nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY);  
                    break;
                case SQUARE: 
                    nextPathGen=new PathSetGenerator(PathType.SQUARE);
                    nextPathSet=nextPathGen.generateSquare(6,4,whereCanBeNextX,whereCanBeNextY,1,2);  
                    break;
                default: break;
            }
            path.add(nextPathSet,Integer.valueOf(i));
            prevPathGen=nextPathGen;
            prevPathSet=nextPathSet;
        }
        bigPanel.add(path);
    }
    
    public void translatePath(){
        Timer time=new Timer();
        TimerTask move=new TimerTask() {
            @Override
            public void run() {
                for(int i=0;i<=200;i++){
                    x-=10;
                    path.setLocation(x,y);
                    try {
                        sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }    
                }
            }
        };time.schedule(move,5000,10100);
    }
    
    public void setUp(JPanel pa){
        pa.setOpaque(false);
        pa.setLayout(null);
        pa.setVisible(true);
        pa.setBorder(border);
    }
    
    public void setUp(JLayeredPane pa){
        pa.setOpaque(false);
        pa.setLayout(null);
        pa.setVisible(true);
        pa.setBorder(border);
    }
}
