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
    private JLabel wbclabel=new JLabel();
    public WBC(){
        super(new HPcontroller(100),5);
        
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCHappyForever.gif"));
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCAngryStep1.png"));
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCAngryStep2.png"));
        iconNowWBC=this.getCharacIcon(0);
        wbc_width=this.getCharacIcon(0).getIconWidth();
        wbc_height=this.getCharacIcon(0).getIconHeight();
        
        this.setBounds(0,0,1920,1080);
        this.setBorder(border);
        this.setOpaque(false);
        this.setVisible(true);
        this.setLayout(null);
        
        imagecorner=new Point(200,400);
        wbclabel.setIcon(iconNowWBC);
        wbclabel.setBounds((int)imagecorner.getX(),(int)imagecorner.getY(),wbc_width,wbc_height);
        wbclabel.setOpaque(false);
        wbclabel.setLayout(null);
        wbclabel.setVisible(true);
        wbclabel.setBorder(border);
        
        this.add(wbclabel);
        
//        ClickListener clickListener=new ClickListener();
//        DragListener dragListener=new DragListener();
//        wbclabel.addMouseListener(clickListener);
//        wbclabel.addMouseMotionListener(dragListener);
    }

//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        iconNowWBC.paintIcon(wbclabel, g,(int)imagecorner.getX(),(int)imagecorner.getY());
//    }
//    
//    public class ClickListener extends MouseAdapter{
//        public void mousePressed(MouseEvent e){
//            wbclabel.setIcon(getCharacIcon(1));
//            prevpt=e.getPoint();
//        }
//        public void mouseClicked ( MouseEvent e ){
//            wbclabel.setIcon(getCharacIcon(1));
//        }
//	public void mouseEntered ( MouseEvent e ){}
//	public void mouseExited ( MouseEvent e ){}
//	public void mouseReleased ( MouseEvent e ){
//            wbclabel.setIcon(getCharacIcon(0));
//            
//        }
//    }
//    
//    public class DragListener extends MouseMotionAdapter{
//        public void mouseDragged(MouseEvent e){
//            Point currentpt=e.getPoint();
//            imagecorner.translate(
//                    (int)(currentpt.getX()-prevpt.getX()+2),
//                    (int)(currentpt.getY()-prevpt.getY())
//            );
//            wbclabel.setLocation((int)imagecorner.getX()+3,(int)imagecorner.getY());
//            prevpt=currentpt;  
//            wbclabel.repaint();
//        }
//    }
    
    /**
     * get object Skill at index i
     * @param i
     * @return 
     */

    public Skill getSkill(int i){
        return skillArr.get(i);
    }
        public void setPrevPt(Point p){
        prevpt=p;
    }
    public Point getPrevPt(){
        return prevpt;
    }
    
    public void setImgCorner(int x,int y){
        imagecorner.translate(x,y);
    }

    public Point getImgCorner(){
        return imagecorner;
    }
    public void setIconNowWBC(ImageIcon i){
        iconNowWBC=i;
    }
    public ImageIcon getIconNowWBC(){
        return iconNowWBC;
    }
    public JLabel getWBCLabel(){
        return wbclabel;
    } 
}
