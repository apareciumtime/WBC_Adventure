package wbcadventure;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import static javax.swing.SwingConstants.SOUTH;
import java.io.File;
import javax.swing.border.Border;
public class MainMenu extends JFrame {
    private JLayeredPane layerPane = new JLayeredPane();
    private SoundController soundController;
    private StartGame start;
    Setting sett=new Setting();
    private int forSound=1;
    public MainMenu(){
        this.setSize(1920,1080);
//        this.setSize(new Dimension(1920,1080));
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
//        this.setUndecorated(true);            //FullScreen
        this.setVisible(true);
        layerPane.setBounds(0,0,1920,1080);
        this.add(layerPane);
        this.setTitle("White Blood Cell Adventure");
        ImageIcon iconGame = new ImageIcon("src/source/iconGame.png");
        this.setIconImage(iconGame.getImage());
        
        start=new StartGame(this);
        start.setVisible(false);
        
        layerPane.add(sett,Integer.valueOf(4));
        sett.setVisible(false);
        
        try {
            soundController = new SoundController(new File("src/source/sound/chocobo.wav"));
            soundController.getSoundControllerClip().open(soundController.getAudio());
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        soundController.getSoundControllerClip().start();
        
    }
    
    public void setButtons(){
        JPanel pa=new JPanel();
        pa.setBounds(0,0,1920,1080);
        pa.setOpaque(false);
        pa.setLayout(null);
        
        Buttons start = new Buttons("Start",456,637);
//        start.setBorder(border);
        pa.add(start);
        
        Buttons load = new Buttons("Load",996,637);
//        load.setBorder(border);
        pa.add(load);
        
        Buttons setting = new Buttons("Setting",456,816);
//        setting.setBorder(border);
        pa.add(setting);
        
        Buttons exit = new Buttons("Exit",996,816);
//        exit.setBorder(border);
        pa.add(exit);
        
        layerPane.add(pa,Integer.valueOf(1));
    }
    
    public void restart(){
        start=new StartGame(this);
    }
    
    public SoundController getSoundController(){
        return soundController;
    }
    
    public void setBackground(){
        JPanel bgPanel=new JPanel();
        bgPanel.setBounds(0,0,1920,1080);
        bgPanel.setOpaque(true);
        bgPanel.setLayout(null);
        bgPanel.setVisible(true);
        JLabel bgLabel=new JLabel();
        bgLabel.setIcon(new ImageIcon("src/source/background/mainMenuBG.jpg"));
        bgLabel.setBounds(0,0,1920,1080);
        bgLabel.setOpaque(true);
        bgLabel.setLayout(null);
        bgLabel.setVisible(true);
        bgPanel.add(bgLabel);
        layerPane.add(bgPanel, Integer.valueOf(0));
    }
    
    public void setVisibleToFalse(){
        this.setVisible(false);
    }
    
    public int getForSound(){
        return forSound;
    }
    
public class Setting extends JPanel{
    private JLayeredPane lay=new JLayeredPane();
    private JLabel bg=new JLabel();
    private Buttons soundButton=new Buttons("SoundOpen",340,292);
    private Buttons menuButton=new Buttons("Menu",746,783);
    public Setting(){
        lay.setBounds(0,0,1920,1080);
        lay.setVisible(true);
        this.setBounds(0,0,1920,1080);
        this.setVisible(true);
        this.setOpaque(false);
        this.setLayout(null);
        this.add(lay);
        bg.setIcon(new ImageIcon("src/source/background/SettingBackground.png"));
        bg.setBounds(0,0,1920,1080);
        bg.setVisible(true);
        lay.add(bg,Integer.valueOf(0));
        soundButton.setSize(500,500);
        lay.add(soundButton,Integer.valueOf(1));
        lay.add(menuButton,Integer.valueOf(2));
    }
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
              if(name.equals("Start")){
                    soundController.getSoundControllerClip().stop();
                    restart();
                    start.setVisible(true);
                    start.setBackground();
                    start.setUplayer();
                    start.setBattle();
                    start.setInformation();
                    if(forSound==1){
                        start.unmuteSoundController();
                    }
                    else if(forSound==0){
                        start.muteSoundController();
                    }
                    setVisibleToFalse();
              }
              else if(name.equals("Load")){
                  
              }
              else if(name.equals("Setting")){
                  sett.setVisible(true);
              }
              else if(name.equals("Exit")){
                  System.exit(SOUTH);
              }
              else if(name.equals("Menu")){
                  sett.setVisible(false);
              }
              else if(name.equals("SoundOpen")&&forSound==1){
                  //mute sound
                  start.muteSoundController();
                  soundController.getSoundControllerClip().stop();
                  normal=new ImageIcon("src/source/buttons/ButtonSoundMute_normal.png");
                  pass=new ImageIcon("src/source/buttons/ButtonSoundMute_pass.png");
                  click=new ImageIcon("src/source/buttons/ButtonSoundMute_click.png");
                  forSound=0;
              }
              else if(name.equals("SoundOpen")&&forSound==0){
                  //play sound
                  start.unmuteSoundController();
                  soundController.getSoundControllerClip().start();
                  normal=new ImageIcon("src/source/buttons/ButtonSoundOpen_normal.png");
                  pass=new ImageIcon("src/source/buttons/ButtonSoundOpen_pass.png");
                  click=new ImageIcon("src/source/buttons/ButtonSoundOpen_click.png");
                  forSound=1;
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
