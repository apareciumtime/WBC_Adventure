package wbcadventure;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PathSetGenerator {
    private ArrayList<PathType> canBeNext=new ArrayList<>();
    private ArrayList<Point> canBeNextLocate=new ArrayList<>();
    Point locate;
    Point rightUpCorner;
    PathType type;
    
    public enum PathType{
        SQUARE,WIDE_FORK,STRAIGHT,NARROW_FORK,DOWNRIGHT,UPRIGHT;
    }

    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    public PathSetGenerator(PathType type){
        this.type=type;
    }
    
    //ลานบอส ขอประตูอยู่ช่อง2
    /**
     * generate square size x*y at (xlocate,ylocate)
     * @param x : number of blocks for x-Axis
     * @param y : number of blocks for y-Axis
     * @param xlocate : location x
     * @param ylocate : location y
     * @param type : 0 is start square,1 is boss square
     * @return 
     */
    public JPanel generateSquare(int x,int y,int xlocate,int ylocate,int type,int door){
        System.out.println("gen Square at "+xlocate+","+ylocate);
        locate=new Point(xlocate,ylocate);
        rightUpCorner=new Point(xlocate+150*x,ylocate+150*y);
        if(type==0){
            canBeNext.add(PathType.STRAIGHT);
            canBeNextLocate.add(new Point(xlocate+150*x,ylocate+(door-1)*150));
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
        
        for(int j=1;j<=i;j++){
            JLabel stUp=new JLabel();
            this.addPathIconPlain(stfork,stUp,0,150*(j+1),0);
            
            JLabel stDown=new JLabel();
            this.addPathIconPlain(stfork,stDown,0,150*(j+1),300);
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
        
        for(int j=1;j<=i;j++){
            JLabel paraUp=new JLabel();
            this.addPathIconPlain(narFork,paraUp,0,150*j,0);
            
            JLabel paraDow=new JLabel();
            this.addPathIconPlain(narFork,paraDow,0,150*j,150);
        }
        
        JLabel exitdown=new JLabel();
        this.addPathIconPlain(narFork,exitdown,3,150+150*i,0);
        
        JLabel exit=new JLabel();
        this.addPathIconPlain(narFork,exit,10,150+150*i,150);
        
        
        
        return narFork;
    }
    
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
        }
        
        
        
        return Straight;
    }
    
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
        dr.setBounds(600, 300, 150, 300);
        setUp(dr);
        
        JLabel enter=new JLabel();
        this.addPathIconPlain(dr,enter,3,0,0);
        
        JLabel exit=new JLabel();
        this.addPathIconPlain(dr,exit,4,0,150);
        
        
        
        return dr;
    }
    
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
        ur.setBounds(600, 300, 150, 300);
        setUp(ur);
        
        JLabel enter=new JLabel();
        this.addPathIconPlain(ur,enter,1,0,150);
        
        JLabel exit=new JLabel();
        this.addPathIconPlain(ur,exit,2,0,0);
        
        
        
        return ur;
        }
    public void setUp(JLabel lab){
        lab.setOpaque(false);
        lab.setLayout(null);
        lab.setVisible(true);
        //lab.setBorder(border);
        lab.setBounds(0,0,150,150);
    }
    
    public void setUp(JPanel pa){
        pa.setOpaque(false);
        pa.setLayout(null);
        pa.setVisible(true);
        pa.setBorder(border);
    }
    
    public void addPathIconPlain(JPanel pa,JLabel la,int iconnum,int lox,int loy){
        la.setIcon((new PathWay(0)).getIcon(iconnum));
        setUp(la);
        pa.add(la);
        la.setLocation(lox,loy);
    }
    
    public void addPathIconSQ(JPanel pa,JLabel la,int iconnum,int lox,int loy){
        la.setIcon((new PathWay(1)).getIcon(iconnum));
        setUp(la);
        pa.add(la);
        la.setLocation(lox,loy);
    }
    
    public ArrayList<Point> getCanBeNextLocate(){
        return canBeNextLocate;
    }
    
    public ArrayList<PathType> getCanBeNext(){
        return canBeNext;
    }
    
    public PathType getType(){
        return type;
    }
}
