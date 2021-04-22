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
    private int xDes;
    private int check=0;
    
    public PathGenerator(JPanel big){
        path=new JLayeredPane();
        path.setBounds(x, y,1000000000,1080);
        allEnemyCoordinatePanel.setBounds(x, y, 1000000000, 1080);
        this.setUp(allEnemyCoordinatePanel);
        bigPanel=big;
        battleObj=(Battle)big;
    }
    
    /**
     * Generate path from start to the end (All random)
     */
    public void startGeneratePath(){
        WBC wbc=new WBC();
        path.add(wbc,Integer.valueOf(99));
        wbc.setLocation(300, 300);
        
        BossEnemy boss=new BossEnemy(wbc);
        
        WBCMovement move=new WBCMovement(wbc,battleObj,battleObj.getStGame());
        
        setUp(path);

        Random rand=new Random();
        prevPathGen=new PathSetGenerator(PathType.SQUARE,battleObj,this);
        prevPathSet=prevPathGen.generateSquare(4,3,0,300,0,2,null); 
        path.add(prevPathSet,Integer.valueOf(0));
        int whereCanBeNextX=0;
        int whereCanBeNextY=0;
        int cntLayer=0;
        int bossHP=boss.getHPcontrol().getMaxHP();
        while(true){
            int randomnum=rand.nextInt(prevPathGen.getCanBeNext().size());
            System.out.println(randomnum);
            PathType whatCanBeNext=prevPathGen.getCanBeNext().get(randomnum);
            whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(randomnum).getX();
            whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(randomnum).getY();
            System.out.println("locate array"+prevPathGen.getCanBeNextLocate().toString());
            System.out.println("benext array"+prevPathGen.getCanBeNext().toString());
            switch(whatCanBeNext){
                case WIDE_FORK: 
                    if(whereCanBeNextY>=300 && whereCanBeNextY<=450){
                        nextPathGen=new PathSetGenerator(PathType.WIDE_FORK,battleObj,this);
                        nextPathSet=nextPathGen.generateWideFork(rand.nextInt(3)+2,whereCanBeNextX,whereCanBeNextY);
                    }
                    else if(whereCanBeNextY<300){
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
//                case SQUARE: 
//                    nextPathGen=new PathSetGenerator(PathType.SQUARE,battleObj,this);
//                    nextPathSet=nextPathGen.generateSquare(7,3,whereCanBeNextX,whereCanBeNextY,1,2,boss);  
//                    break;
                default: break;
            }
            path.add(nextPathSet,Integer.valueOf(cntLayer));
            prevPathGen=nextPathGen;
            prevPathSet=nextPathSet;

            if(bossHP/(cntLayer+1)<10000){
                System.out.println("Stoppppp------------------------------");
                switch(prevPathGen.getType()){
                    case WIDE_FORK :
                        whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                        whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                        if(prevPathGen.getCanBeNextLocate().get(0).getY()==300){
                            //เพิ่มstraight 1 ช่อง ค่อยลง*2 จบstraight
                            for(int c=0;c<5;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        else if(prevPathGen.getCanBeNextLocate().get(0).getY()==450){
                            //เพิ่มstraight 1 ช่อง ค่อยลง จบstraight
                            for(int c=0;c<3;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        else if(prevPathGen.getCanBeNextLocate().get(0).getY()==600){
                            //เพิ่มstraight 1 ช่อง พอดี
                            nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                            nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                            path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                            prevPathGen=nextPathGen;
                            prevPathSet=nextPathSet;
                            whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                            whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                        }
                        break;
                        
                    case NARROW_FORK : 
                        whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                        whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                        if(prevPathSet.getY()==150){
                            //เพิ่มstraight 1 ช่อง ค่อยลง*2 จบstraight
                            for(int c=0;c<5;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        else if(prevPathSet.getY()==300){
                            // เพิ่มstraight 1 ช่อง ค่อยลง จบstraight
                            for(int c=0;c<3;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        else if(prevPathSet.getY()==450){
                            // straight 1 ช่อง พอดี
                            nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                            nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                            path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                            prevPathGen=nextPathGen;
                            prevPathSet=nextPathSet;
                            whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                            whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                        }
                        else if(prevPathSet.getY()==600){
                            // straight 1 ช่อง ค่อยขึ้น 1 จบstraight
                            for(int c=0;c<3;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(3).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(3).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.UPRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        break;
                    case STRAIGHT : 
                        whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                        whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                        if(prevPathSet.getY()<600){
                            int num=((600-prevPathSet.getY())/150)*2+1;
                            for(int c=0;c<num;c++){
                                //ตรง ลง ตรง ลง ตาม num
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        else if(prevPathSet.getY()==750){
                            //ตรง ขึ้น1 ตรง
                            for(int c=0;c<3;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(3).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(3).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.UPRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        break;
                    case DOWNRIGHT : 
                        whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                        whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                        if(prevPathSet.getY()==150){
                            //ตรง ลง2 ตรง
                            for(int c=0;c<5;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        else if(prevPathSet.getY()==300){
                            //ตรง ลง ตรง
                            for(int c=0;c<3;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        else if(prevPathSet.getY()==450){
                            nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                            nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                            path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                            prevPathGen=nextPathGen;
                            prevPathSet=nextPathSet;
                            whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                            whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                        }
                        else if(prevPathSet.getY()==600){
                            //ตรง ขึ้น1 ตรง
                            for(int c=0;c<3;c++){
                                if(c%2==0){
                                    nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(3).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(3).getY();
                                }
                                else{
                                    nextPathGen=new PathSetGenerator(PathType.UPRIGHT,battleObj,this);
                                    nextPathSet=nextPathGen.generateUpRight(whereCanBeNextX,whereCanBeNextY);
                                    path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                    prevPathGen=nextPathGen;
                                    prevPathSet=nextPathSet;
                                    whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                    whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        break;
                        
                    case UPRIGHT : 
                        whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                        whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                        if(prevPathSet.getY()<600){
                            int num=((600-prevPathSet.getY())/150)*2+1;
                            for(int c=0;c<num;c++){
                                //ตรง ลง ตรง ลง ตาม num
                                if(c%2==0){
                                        nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                                        nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                                        path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                        prevPathGen=nextPathGen;
                                        prevPathSet=nextPathSet;
                                        whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(2).getX();
                                        whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(2).getY();
                                }
                                else{
                                        nextPathGen=new PathSetGenerator(PathType.DOWNRIGHT,battleObj,this);
                                        nextPathSet=nextPathGen.generateDownRight(whereCanBeNextX,whereCanBeNextY);
                                        path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                                        prevPathGen=nextPathGen;
                                        prevPathSet=nextPathSet;
                                        whereCanBeNextX=(int)prevPathGen.getCanBeNextLocate().get(0).getX();
                                        whereCanBeNextY=(int)prevPathGen.getCanBeNextLocate().get(0).getY();
                                }
                            }
                        }
                        if(prevPathSet.getY()==600){
                            nextPathGen=new PathSetGenerator(PathType.STRAIGHT,battleObj,this);
                            nextPathSet=nextPathGen.generateStraight(1,whereCanBeNextX,whereCanBeNextY);
                            path.add(nextPathSet,Integer.valueOf(cntLayer));  cntLayer++;
                            prevPathGen=nextPathGen;
                            prevPathSet=nextPathSet;
                        }
                        break;
                }
                whereCanBeNextX=(int)prevPathSet.getX()+150;
                whereCanBeNextY=(int)prevPathSet.getY()-150;
                nextPathGen=new PathSetGenerator(PathType.SQUARE,battleObj,this);
                nextPathSet=nextPathGen.generateSquare(7,3,whereCanBeNextX,whereCanBeNextY,1,2,boss); 
                path.add(nextPathSet,Integer.valueOf(cntLayer+15));
                xDes=nextPathSet.getX();
                break;
            }
            cntLayer++;
        }
        path.add(allEnemyCoordinatePanel,Integer.valueOf(cntLayer+1));
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
                while(true){
                    x-=2;
                    if(xDes+x<=750){
                        break;
                    }
                    path.setLocation(x,y);
                    for(int j=0;j<enemyCoordinatePanelSet.size();j++){
                        if(enemyCoordinatePanelSet.get(j)!=null){
                            if(enemyCoordinatePanelSet.get(j).getX()+x<=1920){
                                NormalEnemy enemy=new NormalEnemy(battleObj.getWBC());
                                enemyCoordinatePanelSet.get(j).add(enemy);
                                battleObj.getEnemyArr().add(enemy);
                                //วิธีเรียกenemyจาก coordinatePanelSet
                                //System.out.println(enemyCoordinatePanelSet.get(j).getComponentAt(0,0).toString());
                                enemyCoordinatePanelSet.set(j,null);
                                //System.out.println(battleObj.getEnemyArr());
                            }
                        }
                    }
                    battleObj.getWBC().getHPcontrol().increaseMaxHP(10);
                    battleObj.getWBC().getHPcontrol().heal();
                    try {
                        sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }    
                }
            }
        };time.schedule(move,3000,10100);
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
    
    public ArrayList<JPanel> getAllEnemyCoordinatePanel(){
        return enemyCoordinatePanelSet;
    }
    
    public JLayeredPane getPathLayerPane(){
        return path;
    }
}
