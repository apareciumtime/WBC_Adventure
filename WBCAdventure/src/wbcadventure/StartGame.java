 package wbcadventure;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
public class StartGame extends JFrame{
    /**
     * Border Set
     */
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    /**
     * JLayeredPane Set
     */
    private JLayeredPane layerPane = new JLayeredPane();

    /**
     * background Set
     */
    private JPanel backgroundPanel = new JPanel();
    private Background background = new Background();
    
    /**
     * Path Layer Set
     */
    private JPanel pathPanel = new JPanel();
    
    /**
     * Call Up-layer for KeyListener
     */
    private Uplayer uplayer = new Uplayer();
    
    /**
     * Battle layer Set
     */
    private JPanel battlePanel = new JPanel();
    
    /**
     * Call battle for KeyListener , MouseListenter();
     */
    private Battle battle = new Battle(this);    
    
    private Timer timer = new Timer();
    
    public StartGame(){
        /**
         * Frame Setting
         */
        this.setSize(new Dimension(1920,1080));
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setUndecorated(true);            //FullScreen
        this.setLayout(null);  
        this.setVisible(true);
        layerPane.setBounds(0,0,1920,1080);
        this.add(layerPane);
        this.setFocusable(true);
        ImageIcon iconGame = new ImageIcon("src/source/iconGame.png");
        this.setIconImage(iconGame.getImage());
        
        /*Start KeyListener Zone*/
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                switch(e.getKeyChar()){
                    /**
                     *  Type Q key to use Skill 1
                     */
                    case'q' :
                        TimerTask durationSkill1 = new TimerTask(){
                            public void run() {
                                battle.getWBC().useSkill(0);
                                if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillDuration(0);
                                    uplayer.getSkillBarPanel().getSkill(0).setCanUse(false);
                                    TimerTask cooldownSkill1 = new TimerTask(){
                                        public void run() {
                                            battle.getWBC().setVisibleFalse();
                                            if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && !uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(0);
                                                
                                                TimerTask pendingSkill1 = new TimerTask(){
                                                    public void run(){
                                                        if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && !uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                                            uplayer.getSkillBarPanel().setSkillPending(0);
                                                            uplayer.getSkillBarPanel().getSkill(0).setCanUse(true);
                                                        }
                                                        TimerTask skill = new TimerTask(){
                                                            public void run(){
                                                            }
                                                        };timer.schedule(skill, 1000);  
                                                    }
                                                };  timer.schedule(pendingSkill1, uplayer.getSkillBarPanel().getSkill(0).getDuration()+uplayer.getSkillBarPanel().getSkill(0).getCooldown());
                                            }
                                        }
                                    };  timer.schedule(cooldownSkill1, uplayer.getSkillBarPanel().getSkill(0).getDuration());
                                }
                            }
                        };  timer.schedule(durationSkill1, 0);
                        break;
                    /**
                     * Type W key to use Skill 1
                     */
                    case 'w' :
                        TimerTask durationSkill2 = new TimerTask(){
                            public void run() {
                                battle.getWBC().useSkill(1);
                                if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillDuration(1);
                                    uplayer.getSkillBarPanel().getSkill(1).setCanUse(false);
                                    
                                    TimerTask cooldownSkill2 = new TimerTask(){
                                        public void run() {
                                            battle.getWBC().setVisibleFalse();
                                            if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && !uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(1);
                                                    
                                                TimerTask pendingSkill2 = new TimerTask(){
                                                    public void run(){
                                                        if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && !uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                                            uplayer.getSkillBarPanel().setSkillPending(1);
                                                            uplayer.getSkillBarPanel().getSkill(1).setCanUse(true);
                                                        }
                                                    }
                                                };  timer.schedule(pendingSkill2, uplayer.getSkillBarPanel().getSkill(1).getDuration()+uplayer.getSkillBarPanel().getSkill(1).getCooldown());
                                            }
                                        }
                                    };  timer.schedule(cooldownSkill2, uplayer.getSkillBarPanel().getSkill(1).getDuration());
                                }
                            }
                        };  timer.schedule(durationSkill2, 0);
                        break;
                    /**
                     * Type E key to use Skill 1
                     */    
                    case 'e' :
                        TimerTask durationSkill3 = new TimerTask(){
                            public void run() {
                                battle.getWBC().useSkill(2);
                                if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillDuration(2);
                                    uplayer.getSkillBarPanel().getSkill(2).setCanUse(false);
                                    
                                    TimerTask cooldownSkill3 = new TimerTask(){
                                        public void run() {
                                            battle.getWBC().setVisibleFalse();
                                            if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && !uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(2);
                                                
                                                TimerTask pendingSkill3 = new TimerTask(){
                                                    public void run(){
                                                        if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && !uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                                            uplayer.getSkillBarPanel().setSkillPending(2);
                                                            uplayer.getSkillBarPanel().getSkill(2).setCanUse(true);
                                                        }
                                                    }
                                                };  timer.schedule(pendingSkill3, uplayer.getSkillBarPanel().getSkill(2).getDuration()+uplayer.getSkillBarPanel().getSkill(2).getCooldown());
                                            }
                                        }
                                    };  timer.schedule(cooldownSkill3, uplayer.getSkillBarPanel().getSkill(2).getDuration());
                                }  
                            }
                        };  timer.schedule(durationSkill3, 0);
                        break;
                    /**
                     * Type R key to use Skill 1
                     */    
                    case 'r' :
                        TimerTask durationSkill4 = new TimerTask(){
                            public void run() {
                                battle.getWBC().useSkill(3);
                                if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillDuration(3);
                                    uplayer.getSkillBarPanel().getSkill(3).setCanUse(false);
                                    
                                    TimerTask cooldownSkill4 = new TimerTask(){
                                        public void run() {
                                            battle.getWBC().setVisibleFalse();
                                            if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && !uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(3);

                                                TimerTask pendingSkill4 = new TimerTask(){
                                                    public void run(){
                                                        if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && !uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                                            uplayer.getSkillBarPanel().setSkillPending(3);
                                                            uplayer.getSkillBarPanel().getSkill(3).setCanUse(true);
                                                        }
                                                    }
                                                };  timer.schedule(pendingSkill4, uplayer.getSkillBarPanel().getSkill(3).getDuration()+uplayer.getSkillBarPanel().getSkill(3).getCooldown());
                                            }
                                        }
                                    };  timer.schedule(cooldownSkill4, uplayer.getSkillBarPanel().getSkill(3).getDuration());
                                }   
                            }
                        };  timer.schedule(durationSkill4, 0);
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println(e.getKeyChar());
            }
                });
        /*End KeyListener Zone*/
        /*Start KeyListener Zone*/
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                switch(e.getKeyChar()){
                    /**
                     *  Type Q key to use Skill 1
                     */
                    case'q' :
                        
                        TimerTask durationSkill1 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                    battle.getWBC().useSkill(0);
                                    System.out.println("Check");
                                    TimerTask cooldownSkill1 = new TimerTask(){
                                        public void run() {
                                            if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && !uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(0);
                                                battle.getWBC().setVisibleFalse();
                                            }
                                        }
                                    };  timer.schedule(cooldownSkill1, uplayer.getSkillBarPanel().getSkill(0).getDuration());
                                }
                            }
                        };  timer.schedule(durationSkill1, 0);
                        break;
                    /**
                     * Type W key to use Skill 1
                     */
                    case 'w' :
                        TimerTask durationSkill2 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                    battle.getWBC().useSkill(1);
                                    TimerTask cooldownSkill2 = new TimerTask(){
                                        public void run() {
                                            if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && !uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(1);
                                                battle.getWBC().setVisibleFalse();
                                            }
                                        }
                                    };  timer.schedule(cooldownSkill2, uplayer.getSkillBarPanel().getSkill(1).getDuration());
                                }
                            }
                        };  timer.schedule(durationSkill2, 0);
                        break;
                    /**
                     * Type E key to use Skill 1
                     */    
                    case 'e' :
                        TimerTask durationSkill3 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                    battle.getWBC().useSkill(2);
                                    TimerTask cooldownSkill3 = new TimerTask(){
                                        public void run() {
                                            if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && !uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(2);
                                                battle.getWBC().setVisibleFalse();
                                            }
                                        }
                                    };  timer.schedule(cooldownSkill3, uplayer.getSkillBarPanel().getSkill(2).getDuration());
                                }
                            }
                        };  timer.schedule(durationSkill3, 0);
                        break;
                    /**
                     * Type R key to use Skill 1
                     */    
                    case 'r' :
                        TimerTask durationSkill4 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                    battle.getWBC().useSkill(3);
                                    TimerTask cooldownSkill4 = new TimerTask(){
                                        public void run() {
                                            if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && !uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(3);
                                                battle.getWBC().setVisibleFalse();
                                            }
                                        }
                                    };  timer.schedule(cooldownSkill4, uplayer.getSkillBarPanel().getSkill(3).getDuration());
                                }
                            }
                        };  timer.schedule(durationSkill4, 0);
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println(e.getKeyChar());
            }
                });
        /*End KeyListener Zone*/
        
    }
    
    public void setBackground(){
        /**
         * background Label Setting
         */
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(background.getBackgroundImage());
        backgroundLabel.setBounds(0, -5, 1920, 1080);
        backgroundLabel.setOpaque(false);
        
        /**
         * background Panel Setting
         */
        backgroundPanel.add(backgroundLabel);
        backgroundPanel.setBounds(0,-5,1920,1080);
        backgroundPanel.setOpaque(false);
        
        /**
         * LayeredPane Setting
         */
        layerPane.add(backgroundPanel, Integer.valueOf(0));
        layerPane.setBorder(border);
    }
    
    public void setPath(){
        /**
         * Set starting path with Square
         */
        PathWay square = new PathWay(1, battle.getWBC());
        
        /**
         * start point Label Setting
         */
        JLabel squareCornerLT = new JLabel();
        squareCornerLT.setIcon(square.getIcon(1));
        squareCornerLT.setBounds(0,0,150,150);
//        squareCornerLT.setBorder(border);
        
        JLabel squareBorderT1 = new JLabel();
        squareBorderT1.setIcon(square.getIcon(2));
        squareBorderT1.setBounds(150,0,150,150);
//        squareBorderT1.setBorder(border);
        
        JLabel squareBorderT2 = new JLabel();
        squareBorderT2.setIcon(square.getIcon(2));
        squareBorderT2.setBounds(300,0,150,150);
//        squareBorderT2.setBorder(border);
        
        JLabel squareCornerRT = new JLabel();
        squareCornerRT.setIcon(square.getIcon(3));
        squareCornerRT.setBounds(450,0,150,150);
//        squareCornerRT.setBorder(border);
        
        JLabel squareBorderL = new JLabel();
        squareBorderL.setIcon(square.getIcon(7));
        squareBorderL.setBounds(0,150,150,150);
//        squareBorderL.setBorder(border);
        
        JLabel squareCenterLabel1 = new JLabel();
        squareCenterLabel1.setIcon(square.getIcon(0));
        squareCenterLabel1.setBounds(150,150,150,150);
//        squareCenterLabel1.setBorder(border);
        
        JLabel squareCenterLabel2 = new JLabel();
        squareCenterLabel2.setIcon(square.getIcon(0));
        squareCenterLabel2.setBounds(300,150,150,150);
//        squareCenterLabel2.setBorder(border);
        
        JLabel squareGateR = new JLabel();
        squareGateR.setIcon(square.getIcon(10));
        squareGateR.setBounds(450,150,150,150);
//        squareGateR.setBorder(border);
        
        
        JLabel squareCornerLB = new JLabel();
        squareCornerLB.setIcon(square.getIcon(4));
        squareCornerLB.setBounds(0,300,150,150);
//        squareCornerLB.setBorder(border);
        
        JLabel squareBorderB1 = new JLabel();
        squareBorderB1.setIcon(square.getIcon(5));
        squareBorderB1.setBounds(150,300,150,150);
//        squareBorderB1.setBorder(border);
        
        JLabel squareBorderB2 = new JLabel();
        squareBorderB2.setIcon(square.getIcon(5));
        squareBorderB2.setBounds(300,300,150,150);
//        squareBorderB2.setBorder(border);
        
        JLabel squareCornerRB = new JLabel();
        squareCornerRB.setIcon(square.getIcon(6));
        squareCornerRB.setBounds(450,300,150,150);
//        squareCornerRB.setBorder(border);
        
        
        
        /**
         * start point Panel Setting
         */
        pathPanel.setBounds(0, 300, 600, 450);
        pathPanel.setOpaque(false);
//        startPointPanel.setBorder(border);
        pathPanel.setLayout(null);
        
        pathPanel.add(squareCornerLT);
        pathPanel.add(squareBorderT1);
        pathPanel.add(squareBorderT2);
        pathPanel.add(squareCornerRT);
        pathPanel.add(squareBorderL);
        pathPanel.add(squareCenterLabel1);
        pathPanel.add(squareCenterLabel2);
        pathPanel.add(squareGateR);
        pathPanel.add(squareCornerLB);
        pathPanel.add(squareBorderB1);
        pathPanel.add(squareBorderB2);
        pathPanel.add(squareCornerRB);
        
        
        layerPane.add(pathPanel, Integer.valueOf(1));
        layerPane.setBorder(border);
        
    }
    
    public void setUplayer(){
        uplayer.setBounds(0, 0, 1920, 1080);
        uplayer.setOpaque(false);
        uplayer.setLayout(null);
        
        layerPane.add(uplayer, Integer.valueOf(3));
    }
    
    public Uplayer getUplayer(){
        return uplayer;
    }
    
    public void setBattle(){
        battle.setBounds(0,0,1920,1080);
        battle.setOpaque(false);
        battle.setLayout(null);
        
        layerPane.add(battle,Integer.valueOf(2));
    }

}
