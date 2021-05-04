package wbcadventure;
import java.awt.Color;
import java.awt.Font;
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
    private ArrayList<Skill> skillArr=new ArrayList<>();
    private final int wbc_width;
    private final int wbc_height;
    private int xForBoostSpeed=0;
    private Point imagecorner;
    private Point prevpt;
    private ImageIcon iconNowWBC;
    private JLabel wbclabel = new JLabel();
    private JLabel numberHP;
    private int powerSkill;
    private SkillBar skillBar;
    private JLabel skillEffect = new JLabel();
    
    /**
     * Constructor of WBC
     */
    public WBC(){
        super(new HPcontroller(150),(int)(150*.39));
        this.skillBar = skillBar;
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCHappyForever.gif"));
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCAngryStep1.png"));
        super.addCharacIcon(new ImageIcon("src/source/character/WBC/WBCAngryStep2.png"));
        iconNowWBC=this.getCharacIcon(0);
        wbc_width=this.getCharacIcon(0).getIconWidth();
        wbc_height=this.getCharacIcon(0).getIconHeight();
        
        imagecorner=new Point(0,10);
        
        wbclabel.setIcon(iconNowWBC);
        wbclabel.setBounds((int)imagecorner.getX(),(int)imagecorner.getY(),wbc_width,wbc_height);
        wbclabel.setOpaque(false);
        wbclabel.setLayout(null);
        wbclabel.setVisible(true);

        numberHP = new JLabel(""+this.getHPcontrol().getHP(),JLabel.CENTER);
        numberHP.setBounds((int)imagecorner.getX(),(int)imagecorner.getY(),160,55);
        numberHP.setFont(new Font("Courier New", Font.BOLD, 36));
        numberHP.setLayout(null);
        numberHP.setVisible(true);

        this.setBounds(200,400,wbc_width+150,wbc_height+20);
        this.setOpaque(false);
        this.setVisible(true);
        this.setLayout(null);
        this.add(skillEffect);
        this.add(numberHP);
        this.add(wbclabel);
    }
    
    /**
     * set previous point that WBC locate
     * @param p 
     */
    public void setPrevPt(Point p){
        prevpt=p;
    }
    
    /**
     * get previous point that WBC locate
     * @return Point object -> ${prevpt}
     */
    public Point getPrevPt(){
        return prevpt;
    }
    
    /**
     * translate WBC image corner
     * @param x
     * @param y 
     */
    public void setImgCorner(int x,int y){
        imagecorner.translate(x, y);
    }

    /**
     * get image corner of WBC
     * @return 
     */
    public Point getImgCorner(){
        return imagecorner;
    }
    /**
     * set current icon of WBC
     * @param i 
     */
    public void setIconNowWBC(ImageIcon i){
        iconNowWBC=i;
    }
    
    /**
     * get current icon of WBC
     * @return 
     */
    public ImageIcon getIconNowWBC(){
        return iconNowWBC;
    }
    
    /**
     * get panel of WBC icon
     * @return 
     */
    public JPanel getWBCPanel(){
        return this;
    } 
    
    /**
     * get label of WBC
     * @return 
     */
    public JLabel getWBCLabel(){
        return wbclabel;
    }
    
    /**
     * get label of WBC's HP
     * @return 
     */
    public JLabel getNumberHP(){
        return numberHP;
    }
    
    /**
     * set icon for skill and deal with powerDefault when use skill
     * @param skillNumber 
     */
    public void useSkill(int skillNumber){
        switch(skillNumber){
            case 0: 
                    skillEffect.setIcon(new ImageIcon("src/source/skillEffect/skill1loop.GIF"));
                    skillEffect.setBounds((int)imagecorner.getX(),(int)imagecorner.getY()-50,300,200);
                    this.plusPowerDefault(100);
                    this.powerSkill = 100;
                    break;
            case 1:
                    skillEffect.setIcon(new ImageIcon("src/source/skillEffect/skill2loop.GIF"));
                    skillEffect.setBounds((int)imagecorner.getX(),(int)imagecorner.getY()-50,300,200);
                    this.plusPowerDefault(3500);
                    this.powerSkill = 3500;
                    break;
            case 2:
                    skillEffect.setIcon(new ImageIcon("src/source/skillEffect/skill3loop.GIF"));
                    skillEffect.setBounds((int)imagecorner.getX(),(int)imagecorner.getY()-50,300,200);
                    this.plusPowerDefault(5000);
                    this.powerSkill = 5000;
                    break;
            case 3:
                    skillEffect.setIcon(new ImageIcon("src/source/skillEffect/skill4loop.GIF"));
                    skillEffect.setBounds((int)imagecorner.getX(),(int)imagecorner.getY()-50,300,200);
                    this.plusPowerDefault(10000);
                    this.powerSkill = 10000;
                    break;
        }
        skillEffect.setVisible(true);
    }
    
    /**
     * set skill visible to false
     */
    public void setVisibleFalse(){
        skillEffect.setBounds(0, 0, 0, 0);
        skillEffect.setVisible(false);
        this.setPowerDefault(this.getPowerDefault() - powerSkill);
    }
    
    /**
     * get label of skill effect
     * @return 
     */
    public JLabel getSkillEffect(){
        return skillEffect;
    }
    
    /**
     * get x locate of WBC to boost speed of path translation
     * @return 
     */
    public int getXforBoostSpeed(){
        return xForBoostSpeed;
    }
    
    /**
     * set x locate of WBC to boost speed of path translation
     * @param xf 
     */
    public void setXforBoostSpeed(int xf){
        xForBoostSpeed=xf;
    }
}
