package wbcadventure;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
public class StartGame extends JFrame {
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
     * start point Set
     */
    private JPanel startPointPanel = new JPanel();
    
    /**
     * up layer Set
     */
    private JPanel uplayerPanel = new JPanel();
    
    /**
     * Call Up-layer for KeyListener
     */
    private Uplayer uplayer = new Uplayer();
    
    
    
    public StartGame(){
        /**
         * Frame Setting
         */
        this.setSize(new Dimension(1920,1080));
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);            //FullScreen
        this.setLayout(null);  
        this.setVisible(true);
        layerPane.setBounds(0,0,1920,1080);
        this.add(layerPane);
        
        
        /*Start KeyListener Zone*/
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                switch(e.getKeyChar()){
                    /**
                     *  Type Q key to use Skill 1
                     */
                    case'q' :
                        Timer timer1 = new Timer();
                        TimerTask durationSkill1 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillDuration(0);
                                    uplayer.getSkillBarPanel().getSkill(0).setCanUse(false);
                                    
                                    TimerTask cooldownSkill1 = new TimerTask(){
                                        public void run() {
                                            if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && !uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(0);
                                                
                                                TimerTask pendingSkill1 = new TimerTask(){
                                                    public void run(){
                                                        if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && !uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                                            uplayer.getSkillBarPanel().setSkillPending(0);
                                                            uplayer.getSkillBarPanel().getSkill(0).setCanUse(true);
                                                        }
                                                    }
                                                };  timer1.schedule(pendingSkill1, uplayer.getSkillBarPanel().getSkill(0).getDuration()+uplayer.getSkillBarPanel().getSkill(0).getCooldown());
                                            }
                                        }
                                    };  timer1.schedule(cooldownSkill1, uplayer.getSkillBarPanel().getSkill(0).getDuration());
                                }
                            }
                        };  timer1.schedule(durationSkill1, 0);
                        break;
                    /**
                     * Type W key to use Skill 1
                     */
                    case 'w' :
                        Timer timer2 = new Timer();
                        TimerTask durationSkill2 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillDuration(1);
                                    uplayer.getSkillBarPanel().getSkill(1).setCanUse(false);
                                    
                                    TimerTask cooldownSkill2 = new TimerTask(){
                                        public void run() {
                                            if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && !uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(1);
                                                    
                                                TimerTask pendingSkill2 = new TimerTask(){
                                                    public void run(){
                                                        if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && !uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                                            uplayer.getSkillBarPanel().setSkillPending(1);
                                                            uplayer.getSkillBarPanel().getSkill(1).setCanUse(true);
                                                        }
                                                    }
                                                };  timer2.schedule(pendingSkill2, uplayer.getSkillBarPanel().getSkill(1).getDuration()+uplayer.getSkillBarPanel().getSkill(1).getCooldown());
                                            }
                                        }
                                    };  timer2.schedule(cooldownSkill2, uplayer.getSkillBarPanel().getSkill(1).getDuration());
                                }
                            }
                        };  timer2.schedule(durationSkill2, 0);
                        break;
                    /**
                     * Type E key to use Skill 1
                     */    
                    case 'e' :
                        Timer timer3 = new Timer();
                        TimerTask durationSkill3 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillDuration(2);
                                    uplayer.getSkillBarPanel().getSkill(2).setCanUse(false);
                                    
                                    TimerTask cooldownSkill3 = new TimerTask(){
                                        public void run() {
                                            if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && !uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(2);
                                                
                                                TimerTask pendingSkill3 = new TimerTask(){
                                                    public void run(){
                                                        if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && !uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                                            uplayer.getSkillBarPanel().setSkillPending(2);
                                                            uplayer.getSkillBarPanel().getSkill(2).setCanUse(true);
                                                        }
                                                    }
                                                };  timer3.schedule(pendingSkill3, uplayer.getSkillBarPanel().getSkill(2).getDuration()+uplayer.getSkillBarPanel().getSkill(2).getCooldown());
                                            }
                                        }
                                    };  timer3.schedule(cooldownSkill3, uplayer.getSkillBarPanel().getSkill(2).getDuration());
                                }  
                            }
                        };  timer3.schedule(durationSkill3, 0);
                        break;
                    /**
                     * Type R key to use Skill 1
                     */    
                    case 'r' :
                        Timer timer4 = new Timer();
                        TimerTask durationSkill4 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillDuration(3);
                                    uplayer.getSkillBarPanel().getSkill(3).setCanUse(false);
                                    
                                    TimerTask cooldownSkill4 = new TimerTask(){
                                        public void run() {
                                            if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && !uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                                uplayer.getSkillBarPanel().setSkillCooldown(3);

                                                TimerTask pendingSkill4 = new TimerTask(){
                                                    public void run(){
                                                        if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && !uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                                            uplayer.getSkillBarPanel().setSkillPending(3);
                                                            uplayer.getSkillBarPanel().getSkill(3).setCanUse(true);
                                                        }
                                                    }
                                                };  timer4.schedule(pendingSkill4, uplayer.getSkillBarPanel().getSkill(3).getDuration()+uplayer.getSkillBarPanel().getSkill(3).getCooldown());
                                            }
                                        }
                                    };  timer4.schedule(cooldownSkill4, uplayer.getSkillBarPanel().getSkill(3).getDuration());
                                }   
                            }
                        };  timer4.schedule(durationSkill4, 0);
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
    
    public void setStartPoint(){
        
        /**
         * Set starting path with Square
         */
        PathWay square = new PathWay(1);
        
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
        startPointPanel.setBounds(0, 300, 600, 450);
        startPointPanel.setOpaque(false);
//        startPointPanel.setBorder(border);
        startPointPanel.setLayout(null);
        
        startPointPanel.add(squareCornerLT);
        startPointPanel.add(squareBorderT1);
        startPointPanel.add(squareBorderT2);
        startPointPanel.add(squareCornerRT);
        startPointPanel.add(squareBorderL);
        startPointPanel.add(squareCenterLabel1);
        startPointPanel.add(squareCenterLabel2);
        startPointPanel.add(squareGateR);
        startPointPanel.add(squareCornerLB);
        startPointPanel.add(squareBorderB1);
        startPointPanel.add(squareBorderB2);
        startPointPanel.add(squareCornerRB);
        
        
        layerPane.add(startPointPanel, Integer.valueOf(1));
        layerPane.setBorder(border);
        
    }
    
    public void setUplayer(){
        uplayer.setBounds(0, 0, 1920, 1080);
        uplayer.setOpaque(false);
//        uplayer.setBorder(border);
        
        uplayerPanel.setBounds(0, 0, 1920, 1080);
        uplayerPanel.setOpaque(false);
        uplayerPanel.setLayout(null);
        
        uplayerPanel.add(uplayer);
        layerPane.add(uplayerPanel, Integer.valueOf(5));
//        layerPane.setBorder(border);
    }
}
