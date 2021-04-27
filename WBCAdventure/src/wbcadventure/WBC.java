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
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private ArrayList<Skill> skillArr=new ArrayList<>();
    private final int wbc_width;
    private final int wbc_height;
    private int xForBoostSpeed=0,yForBoostSpeed=0;
    private Point imagecorner;
    private Point prevpt;
    private ImageIcon iconNowWBC;
    private JLabel wbclabel = new JLabel();
    private JLabel numberHP;
    private int powerSkill;
    private SkillBar skillBar;
    private JLabel skillEffect = new JLabel();
    
    public WBC(){
        super(new HPcontroller(150),(int)(150*.39));
        this.setBorder(border);
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
//        wbclabel.setBorder(border);
        
        numberHP = new JLabel(""+this.getHPcontrol().getHP(),JLabel.CENTER);
        numberHP.setBounds((int)imagecorner.getX(),(int)imagecorner.getY(),160,55);
        numberHP.setFont(new Font("Courier New", Font.BOLD, 50));
        numberHP.setLayout(null);
        numberHP.setVisible(true);
//        numberHP.setBorder(border);
        
        this.setBounds(200,400,wbc_width+150,wbc_height+20);
//        this.setBorder(border);
        this.setOpaque(false);
        this.setVisible(true);
        this.setLayout(null);
        this.add(skillEffect);
        this.add(numberHP);
        this.add(wbclabel);
    }
    
    public void setPrevPt(Point p){
        prevpt=p;
    }
    public Point getPrevPt(){
        return prevpt;
    }
    
    public void setImgCorner(int x,int y){
        imagecorner.translate(x, y);
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
    public JPanel getWBCPanel(){
        return this;
    } 
    
    public JLabel getWBCLabel(){
        return wbclabel;
    }
    
    public void setPowerDefault(){
        
    }
    
    public JLabel getNumberHP(){
        return numberHP;
    }
    
    
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
    
    public void setVisibleFalse(){
        skillEffect.setBounds(0, 0, 0, 0);
        skillEffect.setVisible(false);
        this.setPowerDefault(powerSkill);
    }
    
    public JLabel getSkillEffect(){
        return skillEffect;
    }
    
    public int getXforBoostSpeed(){
        return xForBoostSpeed;
    }
    public int getYforBoostSpeed(){
        return yForBoostSpeed;
    }
    
    public void setXforBoostSpeed(int xf){
        xForBoostSpeed=xf;
    }
    public void setYforBoostSpeed(int yf){
        yForBoostSpeed=yf;
    }
}
