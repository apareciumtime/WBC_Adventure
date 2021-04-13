package wbcadventure;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
public class StartGame extends JFrame {
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private JLayeredPane layerPane = new JLayeredPane();
    
    //private KeyListen key = new KeyListen();

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
    private Uplayer uplayer = new Uplayer();
    
    
    
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
        //this.addKeyListener(key);
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                switch(e.getKeyChar()){
                    case 'q' : changeDuration(0);   break;
                    //case 'w' : setSkillDuration(1);    break;
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
    public void changeDuration(int i){
        uplayer.getSkillBar().setSkillDuration(i);
    }
    public class Uplayer extends JPanel{
    
    private wbcadventure.SkillBar skillBarPanel = new wbcadventure.SkillBar();
    private ProgressBar hpBarPanel = new ProgressBar();
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    
    
    public Uplayer(){
        skillBarPanel.setBounds(50,800, 616, 154);
        skillBarPanel.setOpaque(false);
        
        hpBarPanel.setBounds(10,10,1900,100);
        hpBarPanel.setOpaque(false);
        
        this.setLayout(null);
        this.add(skillBarPanel);
        this.add(hpBarPanel);
        
        
    }
    public wbcadventure.SkillBar getSkillBar(){
        return skillBarPanel;
    }
}
    
    public class SkillBar extends JPanel{
        private JLabel skill1Label = new JLabel();
        private JLabel skill2Label = new JLabel();
        private JLabel skill3Label = new JLabel();
        private JLabel skill4Label = new JLabel();
    
        private JLayeredPane layer = new JLayeredPane();
    
        private Timer timer = new Timer();
    
        private Skill skill1 = new Skill(0,100,500,5000);
        private Skill skill2 = new Skill(1,500,500,7000);
        private Skill skill3 = new Skill(2,1000,500,10000);
        private Skill skill4 = new Skill(3,5000,700,15000);
        private Border border = BorderFactory.createLineBorder(Color.gray,1);

        public SkillBar(){
            this.setBorder(border);
            this.setLayout(null);

            setSkillUnable(0);
            setSkillUnable(1);
            setSkillUnable(2);
            setSkillUnable(3);

            setEnable(0);

            skill1Label.setBounds(0, 0, 154, 154);
            skill2Label.setBounds(154, 0, 154, 154);
            skill3Label.setBounds(308, 0, 154, 154);
            skill4Label.setBounds(462, 0, 154, 154);

            this.add(skill1Label); 
            this.add(skill2Label);
            this.add(skill3Label);
            this.add(skill4Label);
        }

        public void setEnable(int skillNumber){
            setSkillPending(skillNumber);
        }

        public void setSkillUnable(int skillNumber){
            switch(skillNumber){
                case 0 :    skill1Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
                case 1 :    skill2Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
                case 2 :    skill3Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
                case 3 :    skill4Label.setIcon(new ImageIcon("src/source/uplayer/skillIcon/Cooldown.png"));break;
            }
        }

        public void setSkillPending(int skillNumber){
            switch(skillNumber){
                case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
                case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
                case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
                case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(0));break;
            }
        }

        public void setSkillDuration(int skillNumber){
            switch(skillNumber){
                case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
                case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
                case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
                case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(1));break;
            }
        }

        public void setSkillCooldown(int skillNumber){
            switch(skillNumber){
                case 0 :    skill1Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
                case 1 :    skill2Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
                case 2 :    skill3Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
                case 3 :    skill4Label.setIcon(skill1.getSkillArr(skillNumber).get(2));break;
            }
        }
}
    
}
