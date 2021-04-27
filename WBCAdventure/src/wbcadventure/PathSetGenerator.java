package wbcadventure;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PathSetGenerator {
    //ArrayList เก็บว่าตัวที่จะสร้างได้ต่อไปเป็นทางแบบไหนได้บ้าง และต้องต่อที่พิกัดอะไร
    private ArrayList<PathType> canBeNext=new ArrayList<>();
    private ArrayList<Point> canBeNextLocate=new ArrayList<>();
    
    //เก็บจุดที่อยู่ กับมุมขวาบนของpanelทาง
    private Point locate;
    private Point rightUpCorner;
    
    //เก็บชนิดของทาง
    private PathType type;
    
    //เอาตัวจาก class Battle มาใช้ด้วย
    private Battle battleObj;
    
    //เอาตัวจาก class PathGenerator มาใช้ด้วย
    private PathGenerator pathGenObj;
    
    
    //Enum ชนิดของทาง
    public enum PathType{
        SQUARE,WIDE_FORK,STRAIGHT,NARROW_FORK,DOWNRIGHT,UPRIGHT;
    }

    //constructor
    public PathSetGenerator(PathType type,Battle bt,PathGenerator pg){
        pathGenObj=pg;
        battleObj=bt;
        this.type=type;
    }
    
    /**
     * Generate Square size x*y , locate at (xlocate,ylocate)
     * @param x : number of blocks for x-Axis
     * @param y : number of blocks for y-Axis
     * @param xlocate : location x
     * @param ylocate : location y
     * @param type : 0 is start square,1 is boss square
     * @return 
     */
    public JPanel generateSquare(int x,int y,int xlocate,int ylocate,int type,int door,EnemyBlankPanel bos){
        System.out.println("gen Square at "+xlocate+","+ylocate);
        locate=new Point(xlocate,ylocate);
        rightUpCorner=new Point(xlocate+150*x,ylocate+150*y);
        if(type==0){
            canBeNext.add(PathType.STRAIGHT);
            canBeNextLocate.add(new Point(xlocate+150*x,ylocate+(door-1)*150));
        }
        if(x==7 && y==3){
            EnemyBlankPanel boss=new EnemyBlankPanel(PathType.SQUARE,true,new ArrayList<>());
            this.setUp(bos);
            bos.setBounds(xlocate+150,ylocate-350,900,750);
            pathGenObj.getAllEnemyCooPanel().add(bos);
        }
        JPanel square=new JPanel();
        setUp(square);
        square.setBounds(xlocate,ylocate,150*x,150*y);
        
        JLabel topL=new JLabel();
        this.addPathIconSQ(square, topL, 1, 0, 0);
        
        JLabel topR=new JLabel();
        this.addPathIconSQ(square, topR, 3,(x-1)*150,0);
        
        JLabel botL=new JLabel();
        this.addPathIconSQ(square, botL, 4,0,(y-1)*150);
        
        JLabel botR=new JLabel();
        this.addPathIconSQ(square, botR, 6,(x-1)*150,(y-1)*150);
        
        for(int i=1;i<=y-2;i++){
            JLabel sideL=new JLabel();
            if (type==1&&i==door-1){
                this.addPathIconSQ(square, sideL,9,0,150*(door-1));  
            }
            else {
                this.addPathIconSQ(square, sideL,7,0,150*i);      
            }

            
            JLabel sideR=new JLabel();
            if (type==0&&i==door-1){
                this.addPathIconSQ(square, sideR,10,(x-1)*150,150*(door-1));  
            }
            else{
                this.addPathIconSQ(square, sideR, 8,(x-1)*150,150*i);
            }
            
        }
        
        for(int i=1;i<=x-2;i++){
            JLabel sideU=new JLabel();
            this.addPathIconSQ(square, sideU,2,150*i,0);
            
            JLabel sideD=new JLabel();
            this.addPathIconSQ(square, sideD,5,150*i,(y-1)*150);

            for(int j=1;j<=y-2;j++){
                JLabel cen=new JLabel();
                this.addPathIconSQ(square,cen,0,150*i,150*j);
            }
        }
        
        
        
        return square;
    }
    
    /**
     * Generate Wide Fork long i blocks , locate at(xlocate,ylocate)
     * @param i
     * @param xlocate
     * @param ylocate
     * @return 
     */
    public JPanel generateWideFork(int i,int xlocate,int ylocate){
        System.out.println("gen Fork at "+xlocate+","+ylocate+" long "+i);
        locate=new Point(xlocate,ylocate);
        rightUpCorner=new Point(600+150*i,ylocate);
        
        
        canBeNext.add(PathType.STRAIGHT);
        canBeNextLocate.add(new Point(xlocate+600+150*i,ylocate+150));
        
        
        JPanel stfork=new JPanel();
        stfork.setBounds(xlocate,ylocate,600+150*i,450); 
        setUp(stfork);
        
        JLabel crossL=new JLabel();
        this.addPathIconPlain(stfork,crossL,5,0,150);
        
        JLabel upL=new JLabel();
        this.addPathIconPlain(stfork,upL,6,0,0);
        
        JLabel downL=new JLabel();
        this.addPathIconPlain(stfork,downL,8,0,300);
        
        JLabel stUpL=new JLabel();
        this.addPathIconPlain(stfork,stUpL,7,150,0);
        
        JLabel stDownL=new JLabel();
        this.addPathIconPlain(stfork,stDownL,9,150,300);

        PathType p=PathType.WIDE_FORK;
        boolean beChoice=false;
        for(int j=1;j<=i;j++){
            beChoice=(j==1)?true:false;
            if(j%2==1){
                ArrayList<Integer> arrNum=new ArrayList<>();
                arrNum.add(0);
                if(beChoice==true){arrNum.add(1); arrNum.add(3);
                    if(i==4){arrNum.add(5);}
                }
                EnemyBlankPanel enemyUpPanel=new EnemyBlankPanel(p,beChoice,arrNum);
                this.setUp(enemyUpPanel);
                enemyUpPanel.setBounds(xlocate+150+150*j,ylocate-50-55,150,200);
                pathGenObj.addEnemyCoordinate(enemyUpPanel);
                
                ArrayList<Integer> arrNum2=new ArrayList<>();
                arrNum2.add(0);
                if(beChoice==true){arrNum2.add(1); arrNum2.add(2);
                    if(i==4){arrNum2.add(4);}
                }
                EnemyBlankPanel enemyDownPanel=new EnemyBlankPanel(p,beChoice,arrNum2);
                this.setUp(enemyDownPanel);
                enemyDownPanel.setBounds(xlocate+150+150*j,ylocate+250-55,150,200);
                pathGenObj.addEnemyCoordinate(enemyDownPanel);
            }
            JLabel stUp=new JLabel();
            this.addPathIconPlain(stfork,stUp,0,150*(j+1),0);
            
            JLabel stDown=new JLabel();
            this.addPathIconPlain(stfork,stDown,0,150*(j+1),300);
        }
        if(i%2==0){
            ArrayList<Integer> arrNum=new ArrayList<>();
            arrNum.add(0);
            EnemyBlankPanel enemyUpLastPanel=new EnemyBlankPanel(p,beChoice,arrNum);
            this.setUp(enemyUpLastPanel);
            enemyUpLastPanel.setBounds(xlocate+300+150*i,ylocate-50-55,150,200);
            pathGenObj.addEnemyCoordinate(enemyUpLastPanel);
            
            EnemyBlankPanel enemyDownLastPanel=new EnemyBlankPanel(p,beChoice,arrNum);
            this.setUp(enemyDownLastPanel);
            enemyDownLastPanel.setBounds(xlocate+300+150*i,ylocate+250-55,150,200);
            pathGenObj.addEnemyCoordinate(enemyDownLastPanel);
        }
        
        JLabel crossR=new JLabel();
        this.addPathIconPlain(stfork,crossR,14,450+150*i,150);
        
        JLabel upR=new JLabel();
        this.addPathIconPlain(stfork,upR,15,450+150*i,300);
        
        JLabel downR=new JLabel();
        this.addPathIconPlain(stfork,downR,13,450+150*i,0);
        
        JLabel stUpR=new JLabel();
        this.addPathIconPlain(stfork,stUpR,12,300+150*i,0);
        
        JLabel stDownR=new JLabel();
        this.addPathIconPlain(stfork,stDownR,16,300+150*i,300);
    
        return stfork;
    }
    
    /**
     * Generate Narrow Fork long i blocks , locate at (xlocate,ylocate)
     * @param i
     * @param xlocate
     * @param ylocate
     * @return 
     */
    public JPanel generateNarrowFork(int i,int xlocate,int ylocate){
        System.out.println("gen Narrow Fork at "+xlocate+","+ylocate+" long "+i);
        locate=new Point(xlocate,ylocate);
        rightUpCorner=new Point(xlocate+300+150*i,ylocate);
        
        
        canBeNext.add(PathType.STRAIGHT);
        canBeNextLocate.add(new Point(xlocate+300+150*i,ylocate+150));
        
        
        JPanel narFork=new JPanel();
        narFork.setBounds(xlocate,ylocate,300+150*i,300);
        setUp(narFork);
        
        JLabel enter=new JLabel();
        this.addPathIconPlain(narFork,enter,11,0,0);
        
        JLabel enterdown=new JLabel();
        this.addPathIconPlain(narFork,enterdown,4,0,150);
        
        PathType p=PathType.WIDE_FORK;
        boolean beChoice=false;

        for(int j=1;j<=i;j++){
            JLabel paraUp=new JLabel();
            this.addPathIconPlain(narFork,paraUp,0,150*j,0);
            beChoice=true;
            ArrayList<Integer> arrNum=new ArrayList<>();
            arrNum.add(0);
            arrNum.add(1);
            
            if(j==2){
                EnemyBlankPanel enemyDownPanel=new EnemyBlankPanel(p,beChoice,arrNum);
                this.setUp(enemyDownPanel);
                enemyDownPanel.setBounds(xlocate+150*j,ylocate+100-55,150,200);
                pathGenObj.addEnemyCoordinate(enemyDownPanel);
            }
            else if(j==4){
                EnemyBlankPanel enemyUpPanel=new EnemyBlankPanel(p,beChoice,arrNum);
                this.setUp(enemyUpPanel);
                enemyUpPanel.setBounds(xlocate+150*j,ylocate-50-55,150,200);
                pathGenObj.addEnemyCoordinate(enemyUpPanel);
            }

            JLabel paraDow=new JLabel();
            this.addPathIconPlain(narFork,paraDow,0,150*j,150);
        }
        
        JLabel exitdown=new JLabel();
        this.addPathIconPlain(narFork,exitdown,3,150+150*i,0);
        
        JLabel exit=new JLabel();
        this.addPathIconPlain(narFork,exit,10,150+150*i,150);
        
        
        
        return narFork;
    }
    
    /**
     * Generate Straight Path long i blocks , locate at (xlocate,ylocate)
     * @param i
     * @param xlocate
     * @param ylocate
     * @return 
     */
    public JPanel generateStraight(int i,int xlocate,int ylocate){
        System.out.println("gen Straight at "+xlocate+","+ylocate+" long "+i);
        locate=new Point(xlocate,ylocate);
        rightUpCorner=new Point(xlocate+150*i,ylocate);
        canBeNext.add(PathType.STRAIGHT);
        canBeNextLocate.add(rightUpCorner);
        canBeNext.add(PathType.WIDE_FORK);
        canBeNextLocate.add(new Point(xlocate+150*i,ylocate-150));
        canBeNext.add(PathType.DOWNRIGHT);
        canBeNextLocate.add(rightUpCorner);
        canBeNext.add(PathType.UPRIGHT);
        canBeNextLocate.add(new Point(xlocate+150*i,ylocate-150));
        canBeNext.add(PathType.NARROW_FORK);
        canBeNextLocate.add(rightUpCorner);
//        canBeNext.add(PathType.SQUARE);
//        canBeNextLocate.add(new Point(xlocate+150*i,ylocate-150));
        
        
        JPanel Straight =new JPanel();
        Straight.setBounds(xlocate,ylocate,150*i,150);
        setUp(Straight);
        
        for(int j=0;j<i;j++){
            JLabel st=new JLabel();
            this.addPathIconPlain(Straight,st,0,150*j,0);
            ArrayList<Integer> arrNum=new ArrayList<>();
            arrNum.add(0);
            if(j%2==1){
                EnemyBlankPanel enemyUpPanel=new EnemyBlankPanel(PathType.STRAIGHT,false,arrNum);
                this.setUp(enemyUpPanel);
                enemyUpPanel.setBounds(xlocate+150*j,ylocate-50-55,150,200);
                pathGenObj.addEnemyCoordinate(enemyUpPanel);
            }
        }
        
        
        
        return Straight;
    }
    
    /**
     * Generate Path that go down to the right , locate at (xlocate,ylocate)
     * @param xlocate
     * @param ylocate
     * @return 
     */
    public JPanel generateDownRight(int xlocate,int ylocate){
        System.out.println("gen Down Right at "+xlocate+","+ylocate);
        locate=new Point(xlocate,ylocate);
        rightUpCorner=new Point(xlocate+150,ylocate);
        
        
        canBeNext.add(PathType.STRAIGHT);
        canBeNextLocate.add(new Point(xlocate+150,ylocate+150));
        canBeNext.add(PathType.WIDE_FORK);
        canBeNextLocate.add(rightUpCorner);
        canBeNext.add(PathType.NARROW_FORK);
        canBeNextLocate.add(new Point(xlocate+150,ylocate+150));
        
        JPanel dr=new JPanel();
        dr.setBounds(xlocate,ylocate,150, 300);
        setUp(dr);
        
        JLabel enter=new JLabel();
        this.addPathIconPlain(dr,enter,3,0,0);
        
        JLabel exit=new JLabel();
        this.addPathIconPlain(dr,exit,4,0,150);
        
        
        
        return dr;
    }
    
    /** Generate Path that go up to the right , locate at (xlocate,ylocate)
     * 
     * @param xlocate
     * @param ylocate
     * @return 
     */
    public JPanel generateUpRight(int xlocate,int ylocate){
        System.out.println("gen Up Right at"+xlocate+","+ylocate);
        locate=new Point(xlocate,ylocate);
        rightUpCorner=new Point(xlocate+150,ylocate);

        canBeNext.add(PathType.STRAIGHT);
        canBeNextLocate.add(rightUpCorner);
        canBeNext.add(PathType.WIDE_FORK);
        canBeNextLocate.add(new Point(xlocate+150,ylocate-150));
        canBeNext.add(PathType.NARROW_FORK);
        canBeNextLocate.add(new Point(xlocate+150,ylocate));
        
        JPanel ur=new JPanel();
        ur.setBounds(xlocate,ylocate,150,300);
        setUp(ur);
        
        JLabel enter=new JLabel();
        this.addPathIconPlain(ur,enter,1,0,150);
        
        JLabel exit=new JLabel();
        this.addPathIconPlain(ur,exit,2,0,0);
        
        return ur;
        }
    
    /**
     * set everything for JLabel (setOpaque false , setLayout null , setVisible true)
     * @param lab 
     */
    public void setUp(JLabel lab){
        lab.setOpaque(false);
        lab.setLayout(null);
        lab.setVisible(true);
        lab.setBounds(0,0,150,150);
    }
    
    /**
     * set everything foe JPanel (setOpaque false , setLayout null , setVisible true)
     * @param pa 
     */
    public void setUp(JPanel pa){
        pa.setOpaque(false);
        pa.setLayout(null);
        pa.setVisible(true);
    }
    
    /**
     * Add label {$la} with Icon of path number {$iconnum} to the Panel {$pa} , locate at (lox,loy)
     * **For Plain Path
     * @param pa
     * @param la
     * @param iconnum
     * @param lox
     * @param loy 
     */
    public void addPathIconPlain(JPanel pa,JLabel la,int iconnum,int lox,int loy){
        la.setIcon((new PathWay(0)).getIcon(iconnum));
        setUp(la);
        pa.add(la);
        la.setLocation(lox,loy);
    }
    
    /**
     * Add label {$la} with Icon of path number {$iconnum} to the Panel {$pa} , locate at (lox,loy)
     * **For Square
     * @param pa
     * @param la
     * @param iconnum
     * @param lox
     * @param loy 
     */
    public void addPathIconSQ(JPanel pa,JLabel la,int iconnum,int lox,int loy){
        la.setIcon((new PathWay(1)).getIcon(iconnum));
        setUp(la);
        pa.add(la);
        la.setLocation(lox,loy);
    }
    
    /**
     * get ArrayList canBeNextLocate
     * @return
     */
    public ArrayList<Point> getCanBeNextLocate(){
        return canBeNextLocate;
    }
    
    /**
     * get ArrayList canBenext
     * @return 
     */
    public ArrayList<PathType> getCanBeNext(){
        return canBeNext;
    }
    
    /**
     * get type of path
     * @return 
     */
    public PathType getType(){
        return type;
    }
}
