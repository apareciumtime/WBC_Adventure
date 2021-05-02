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
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import static javax.swing.SwingConstants.SOUTH;
import javax.swing.border.Border;
public class StartGame extends JFrame{
    
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
    private Uplayer uplayer;
    
    /**
     * Battle layer Set
     */
    private JPanel battlePanel = new JPanel();
    
    /**
     * Call battle for KeyListener , MouseListenter();
     */
    private Battle battle;    
    
    private Timer timer = new Timer();
    
    private SoundController soundControllerStart;
    
    private int setMute=1;
    
    private MainMenu mainMenu;
    
    public StartGame(MainMenu mainMenu){
        battle = new Battle(this);
        uplayer = new Uplayer(battle.getWBC());
        this.mainMenu = mainMenu;
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
        this.setTitle("White Blood Cell Adventure");
        ImageIcon iconGame = new ImageIcon("src/source/iconGame.png");
        this.setIconImage(iconGame.getImage());
        
        try {
            soundControllerStart = new SoundController(new File("src/source/sound/nyancat.wav"));
            soundControllerStart.getSoundControllerClip().open(soundControllerStart.getAudio());
            soundControllerStart.getSoundControllerClip().stop();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*Start KeyListener Zone*/
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                /*Type 'q' key to use Skill 1*/
                if(e.getKeyChar() == 'q' || e.getKeyChar() == 'Q' || e.getKeyChar() == 'ๆ' || e.getKeyChar() == '๐'){
                    if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                        uplayer.getSkillBarPanel().setSkillDuration(0);
                        uplayer.getSkillBarPanel().getSkill(0).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(1).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(2).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(3).setCanUse(false);
                        battle.getWBC().useSkill(0);
                        uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                        TimerTask cooldownSkill1 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(0).getEnable() && !uplayer.getSkillBarPanel().getSkill(0).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillCooldown(0);
                                    battle.getWBC().setVisibleFalse();
                                    uplayer.getSkillBarPanel().getSkill(1).setCanUse(true);
                                    uplayer.getSkillBarPanel().getSkill(2).setCanUse(true);
                                    uplayer.getSkillBarPanel().getSkill(3).setCanUse(true);
                                    uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                                    TimerTask pendingSkill1 = new TimerTask(){
                                        public void run(){
                                            uplayer.getSkillBarPanel().getSkill(0).setCanUse(true);
                                            
                                            uplayer.getSkillBarPanel().setSkillPending(0);
                                            
                                            uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                                        }
                                    }; timer.schedule(pendingSkill1, uplayer.getSkillBarPanel().getSkill(0).getCooldown()); 
                                }
                            }
                        };  timer.schedule(cooldownSkill1, uplayer.getSkillBarPanel().getSkill(0).getDuration());
                    }
                }
                /*Type 'w' key to use Skill 2*/
                else if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getKeyChar() == 'ไ' || e.getKeyChar() == '"'){
                    if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                        uplayer.getSkillBarPanel().setSkillDuration(1);
                        uplayer.getSkillBarPanel().getSkill(0).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(1).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(2).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(3).setCanUse(false);
                        battle.getWBC().useSkill(1);
                        uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                        TimerTask cooldownSkill1 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(1).getEnable() && !uplayer.getSkillBarPanel().getSkill(1).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillCooldown(1);
                                    battle.getWBC().setVisibleFalse();
                                    uplayer.getSkillBarPanel().getSkill(0).setCanUse(true);
                                    uplayer.getSkillBarPanel().getSkill(2).setCanUse(true);
                                    uplayer.getSkillBarPanel().getSkill(3).setCanUse(true);
                                    uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                                    TimerTask pendingSkill1 = new TimerTask(){
                                        public void run(){
                                            uplayer.getSkillBarPanel().getSkill(1).setCanUse(true);
                                            uplayer.getSkillBarPanel().setSkillPending(1);
                                            uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                                        }
                                    }; timer.schedule(pendingSkill1, uplayer.getSkillBarPanel().getSkill(1).getCooldown()); 
                                }
                            }
                        };  timer.schedule(cooldownSkill1, uplayer.getSkillBarPanel().getSkill(1).getDuration());
                    }
                }
                /*Type 'e' key to use Skill 3*/
                else if(e.getKeyChar() == 'e' || e.getKeyChar() == 'E' || e.getKeyChar() == 'ำ' || e.getKeyChar() == 'ฎ'){
                    if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                        uplayer.getSkillBarPanel().setSkillDuration(2);
                        uplayer.getSkillBarPanel().getSkill(0).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(1).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(2).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(3).setCanUse(false);
                        battle.getWBC().useSkill(2);
                        uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                        TimerTask cooldownSkill1 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(2).getEnable() && !uplayer.getSkillBarPanel().getSkill(2).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillCooldown(2);
                                    battle.getWBC().setVisibleFalse();
                                    uplayer.getSkillBarPanel().getSkill(0).setCanUse(true);
                                    uplayer.getSkillBarPanel().getSkill(1).setCanUse(true);
                                    uplayer.getSkillBarPanel().getSkill(3).setCanUse(true);
                                    uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                                    TimerTask pendingSkill1 = new TimerTask(){
                                        public void run(){
                                            uplayer.getSkillBarPanel().getSkill(2).setCanUse(true);
                                            uplayer.getSkillBarPanel().setSkillPending(2);
                                            uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                                        }
                                    }; timer.schedule(pendingSkill1, uplayer.getSkillBarPanel().getSkill(2).getCooldown()); 
                                }
                            }
                        };  timer.schedule(cooldownSkill1, uplayer.getSkillBarPanel().getSkill(2).getDuration());
                    }
                }
                else if(e.getKeyChar() == 'r' || e.getKeyChar() == 'R' || e.getKeyChar() == 'พ' || e.getKeyChar() == 'ฑ'){
                    if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                        uplayer.getSkillBarPanel().setSkillDuration(3);
                        uplayer.getSkillBarPanel().getSkill(0).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(1).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(2).setCanUse(false);
                        uplayer.getSkillBarPanel().getSkill(3).setCanUse(false);
                        battle.getWBC().useSkill(3);
                        uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                        TimerTask cooldownSkill1 = new TimerTask(){
                            public void run() {
                                if(uplayer.getSkillBarPanel().getSkill(3).getEnable() && !uplayer.getSkillBarPanel().getSkill(3).getCanUse()){
                                    uplayer.getSkillBarPanel().setSkillCooldown(3);
                                    battle.getWBC().setVisibleFalse();
                                    uplayer.getSkillBarPanel().getSkill(0).setCanUse(true);
                                    uplayer.getSkillBarPanel().getSkill(1).setCanUse(true);
                                    uplayer.getSkillBarPanel().getSkill(2).setCanUse(true);
                                    uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                                    TimerTask pendingSkill1 = new TimerTask(){
                                        public void run(){
                                            uplayer.getSkillBarPanel().getSkill(3).setCanUse(true);
                                            uplayer.getSkillBarPanel().setSkillPending(3);
                                            uplayer.getWBCPowerBar().setPower(battle.getWBC().getPowerDefault());
                                        }
                                    }; timer.schedule(pendingSkill1, uplayer.getSkillBarPanel().getSkill(3).getCooldown()); 
                                }
                            }
                        };  timer.schedule(cooldownSkill1, uplayer.getSkillBarPanel().getSkill(3).getDuration());
                    }
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
    public void setInformation(){
        BeforePlaying inform=new BeforePlaying();
        layerPane.add(inform,Integer.valueOf(4));
    }
    
    public void setEndGame(String type,StartGame old){
        EndGame end=new EndGame(type,old);
        layerPane.add(end,Integer.valueOf(5));
    }
    
    public void muteSoundController(){
        this.setMute = 0;
    }
    
    public void unmuteSoundController(){
        this.setMute = 1;
    }
    
    public class BeforePlaying extends JPanel{
        public BeforePlaying(){
            this.setBounds(0,0,1920,1080);
            this.setVisible(true);
            this.setOpaque(false);
            this.setLayout(null);
            
            JLayeredPane layer=new JLayeredPane();
            layer.setBounds(0,0,1920,1080);
            layer.setVisible(true);
            layer.setLayout(null);
            this.add(layer);
            
            JLabel information=new JLabel();
            information.setIcon(new ImageIcon("src/source/background/ShowBossHP.png"));
            information.setBounds(0,0,1920,1080);
            information.setVisible(true);
            information.setOpaque(false);
            information.setLayout(null);
            
            JPanel informationPa=new JPanel();
            informationPa.setBounds(0,0,1920,1080);
            informationPa.setVisible(true);
            informationPa.setOpaque(false);
            informationPa.add(information);
            informationPa.setLayout(null);
            layer.add(informationPa,Integer.valueOf(0));
            
            JPanel fontPanel=new JPanel();
            fontPanel.setBounds(0,0,1920,1080);
            fontPanel.setVisible(true);
            fontPanel.setOpaque(false);
            fontPanel.setLayout(null);
            layer.add(fontPanel,Integer.valueOf(3));
            
            JLabel BossHPLa=new JLabel(""+battle.getBoss().getHPcontrol().getHP(),JLabel.LEFT);
            BossHPLa.setBounds(891,385,281,57);
            BossHPLa.setVisible(true);
            BossHPLa.setOpaque(false);
            BossHPLa.setLayout(null);
            fontPanel.add(BossHPLa);
//            BossHPLa.setBorder(border);
            BossHPLa.setFont(new Font("Courier New", Font.BOLD, 50));
             
            JLabel WBCHPLa=new JLabel(""+battle.getWBC().getHPcontrol().getHP(),JLabel.LEFT);
            WBCHPLa.setBounds(835,660,281,57);
            WBCHPLa.setVisible(true);
            WBCHPLa.setOpaque(false);
            WBCHPLa.setLayout(null);
            fontPanel.add(WBCHPLa);
//            WBCHPLa.setBorder(border);
            WBCHPLa.setFont(new Font("Courier New", Font.BOLD, 50));

            JLabel go=new JLabel();
            go.setIcon(new ImageIcon("src/source/buttons/ButtonGo_normal.png"));
            go.setBounds(0,0,467,179);
            go.setVisible(true);
            go.setOpaque(false);
            go.setLayout(null);
            
            JPanel goPa=new JPanel();
            goPa.setBounds(0,0,467,179);
            goPa.setVisible(true);
            goPa.setOpaque(false);
            goPa.setLayout(null);
            goPa.add(go);
            
            JPanel goPaOfPa=new JPanel();
            goPaOfPa.setBounds(751,806,1920,1080);
            goPaOfPa.setVisible(true);
            goPaOfPa.setOpaque(false);
            goPaOfPa.setLayout(null);
            goPaOfPa.add(goPa);
            
            layer.add(goPaOfPa,Integer.valueOf(1));
            
            goPa.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                   go.setIcon(new ImageIcon("src/source/buttons/ButtonGo_click.png"));
                   setVisible(false);
                   battle.getPathGen().translatePath();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                     go.setIcon(new ImageIcon("src/source/buttons/ButtonGo_click.png"));
                     switch(setMute){
                         case 0 : soundControllerStart.getSoundControllerClip().stop(); break;
                         case 1 : soundControllerStart.getSoundControllerClip().start(); break;
                     }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    go.setIcon(new ImageIcon("src/source/buttons/ButtonGo_normal.png"));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    go.setIcon(new ImageIcon("src/source/buttons/ButtonGo_pass.png"));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    go.setIcon(new ImageIcon("src/source/buttons/ButtonGo_normal.png"));
                }
            });
        }
    }
    
    
public class EndGame extends JPanel{
    String type;
    StartGame oldSt;
    public EndGame(String type,StartGame old){
        oldSt=old;
        this.type=type;
        this.setBounds(0, 0,1920, 1080);
        this.setVisible(true);
        this.setOpaque(false);
        this.setLayout(null);
        
        JLayeredPane layerpane=new JLayeredPane();
        layerpane.setBounds(0, 0,1920, 1080);
        layerpane.setVisible(true);
        layerpane.setOpaque(false);
        layerpane.setLayout(null);
        this.add(layerpane);
        
        JLabel background=new JLabel();
        if(type.equals("win")){
            background.setIcon(new ImageIcon("src/source/background/winWindow.png"));
        }
        else if(type.equals("lose")){
            background.setIcon(new ImageIcon("src/source/background/loseWindow.png"));
        }
        background.setBounds(0, 0,1920, 1080);
        background.setVisible(true);
        background.setOpaque(false);
        layerpane.add(background,Integer.valueOf(0));
        
        JPanel pa=new JPanel();
        pa.setBounds(0,0,1920,1080);
        pa.setVisible(true);
        pa.setOpaque(false);
        pa.setLayout(null);
        Buttons re=new Buttons("Restart",264,724);
        Buttons menu=new Buttons("Menu",757,724);
        Buttons exit=new Buttons("Exit",1250,724);
        pa.add(re);
        pa.add(menu);
        pa.add(exit);
        layerpane.add(pa,Integer.valueOf(1));
        
    }
    
    public class Buttons extends JLabel{
    private String name;
    private ImageIcon normal;
    private ImageIcon pass;
    private ImageIcon click;
    public Buttons(String name,int x,int y){
        this.name=name;
        normal=new ImageIcon("src/source/buttons/Button"+name+"_normal.png");
        pass=new ImageIcon("src/source/buttons/Button"+name+"_pass.png");
        click=new ImageIcon("src/source/buttons/Button"+name+"_click.png");
        this.setIcon(normal);
        this.setOpaque(false);
        this.setBounds(x,y,467,179);
        this.setLayout(null);
        this.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e) {
              setIcon(click);
              if(name.equals("Restart")){
                  soundControllerStart.getSoundControllerClip().stop();
                  oldSt.setVisible(false);
                  StartGame start=new StartGame(mainMenu);
                  start.setBackground();
                  start.setUplayer();
                  start.setBattle();
                  start.setInformation();
              }
              else if(name.equals("Menu")){
                  soundControllerStart.getSoundControllerClip().stop();
                  oldSt.setVisible(false);
                  mainMenu.setVisible(true);
                  mainMenu.getSoundController().getSoundControllerClip().start();
              }
              else if(name.equals("Exit")){
                  System.exit(SOUTH);
              }
           }

           @Override
           public void mousePressed(MouseEvent e) {
                setIcon(click);
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               setIcon(normal);
           }

           @Override
           public void mouseEntered(MouseEvent e) {
               setIcon(pass);
           }

           @Override
           public void mouseExited(MouseEvent e) {
               setIcon(normal);
           }
        });
    }
}
}

    
}
