package wbcadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.*;
import javax.swing.border.Border;
public class WBC extends Character{
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private ArrayList<Skill> skillArr=new ArrayList<>();
    private final int wbc_width;
    private final int wbc_height;
    //private int x,y;
    private Point imagecorner;
    private Point prevpt;
    private ImageIcon iconNowWBC;
    //private JLabel wbclabel=new JLabel();
    public WBC(){
        super(new HPcontroller(150),5);
        ImageIcon WBCHappy=new ImageIcon("src/source/character/WBC/WBCHappyForever.gif");
        ImageIcon WBCAngry1=new ImageIcon("src/source/character/WBC/WBCAngryStep1.png");
        ImageIcon WBCAngry2=new ImageIcon("src/source/character/WBC/WBCAngryStep2.png");
        super.addCharacIcon(WBCHappy);
        super.addCharacIcon(WBCAngry1);
        super.addCharacIcon(WBCAngry2);
        
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCHappyForever.gif"));
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCAngryStep1.png"));
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCAngryStep2.png"));
        iconNowWBC=this.getCharacIcon(0);
        wbc_width=this.getCharacIcon(0).getIconWidth();
        wbc_height=this.getCharacIcon(0).getIconHeight();
        /*
        skillArr.add(new Skill("skill_1",1,20,10,"skill_1"));
        skillArr.add(new Skill("skill_2",1,20,10,"skill_2"));
        skillArr.add(new Skill("skill_3",1,20,10,"skill_3"));
        skillArr.add(new Skill("skill_4",1,20,10,"skill_4"));*/
        
        imagecorner=new Point(0,0);
        this.setIcon(iconNowWBC);
        this.setBounds((int)imagecorner.getX(),(int)imagecorner.getY(),wbc_width,wbc_height);
        this.setOpaque(true);
        this.setLayout(null);
        
        ClickListener clickListener=new ClickListener();
        DragListener dragListener=new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        iconNowWBC.paintIcon(this, g,(int)imagecorner.getX(),(int)imagecorner.getY());
    }
    
    public class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            iconNowWBC=getCharacIcon(1);
            prevpt=e.getPoint();
        }
        public void mouseClicked ( MouseEvent e ){
            iconNowWBC=getCharacIcon(1);
        }
    public void mouseEntered ( MouseEvent e ){}
    public void mouseExited ( MouseEvent e ){}
    public void mouseReleased ( MouseEvent e ){
            iconNowWBC=getCharacIcon(0);
        }
    }
    
    public class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            Point currentpt=e.getPoint();
            imagecorner.translate(
                    (int)(currentpt.getX()-prevpt.getX()),
                    (int)(currentpt.getY()-prevpt.getY())
                    );
            prevpt=currentpt;
            repaint();
        }
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



/*package wbcadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.*;
import javax.swing.border.Border;
public class WBC extends Character{
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private ArrayList<Skill> skillArr=new ArrayList<>();
    private final int wbc_width;
    private final int wbc_height;
    //private int x,y;
    private Point imagecorner;
    private Point prevpt;
    private ImageIcon iconNowWBC;
    private JLabel wbclabel=new JLabel();
    public WBC(){
        super(new HPcontroller(150),5);
        
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCHappyForever.gif"));
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCAngryStep1.png"));
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCAngryStep2.png"));
        iconNowWBC=this.getCharacIcon(0);
        wbc_width=this.getCharacIcon(0).getIconWidth();
        wbc_height=this.getCharacIcon(0).getIconHeight();
        
        this.setBounds(0,0,1920,1080);
        this.setOpaque(true);
        this.setVisible(true);
        this.setLayout(null);
        
        imagecorner=new Point(0,0);
        wbclabel.setIcon(iconNowWBC);
        wbclabel.setBounds((int)imagecorner.getX(),(int)imagecorner.getY(),wbc_width,wbc_height);
        wbclabel.setOpaque(true);
        wbclabel.setLayout(null);
        wbclabel.setVisible(true);
        wbclabel.setBorder(border);
        
        this.add(wbclabel);
        
        ClickListener clickListener=new ClickListener();
        DragListener dragListener=new DragListener();
        wbclabel.addMouseListener(clickListener);
        wbclabel.addMouseMotionListener(dragListener);
    }
/*
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        iconNowWBC.paintIcon(wbclabel, g,(int)imagecorner.getX(),(int)imagecorner.getY());
    }*/
    /*
    public class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            wbclabel.setIcon(getCharacIcon(1));
            prevpt=e.getPoint();
        }
        public void mouseClicked ( MouseEvent e ){
            wbclabel.setIcon(getCharacIcon(1));
        }
	public void mouseEntered ( MouseEvent e ){}
	public void mouseExited ( MouseEvent e ){}
	public void mouseReleased ( MouseEvent e ){
            wbclabel.setIcon(getCharacIcon(0));
        }
    }
    
    public class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            Point currentpt=e.getPoint();
            imagecorner.translate(
                    (int)(currentpt.getX()-prevpt.getX()),
                    (int)(currentpt.getY()-prevpt.getY())
            );
            prevpt=currentpt;
            wbclabel.setLocation((int)imagecorner.getX(),(int)imagecorner.getY());
            //wbclabel.repaint();
        }
    }
    
    /**
     * get object Skill at index i
     * @param i
     * @return 
     */
/*
    public Skill getSkill(int i){
        return skillArr.get(i);
    }
}
*/