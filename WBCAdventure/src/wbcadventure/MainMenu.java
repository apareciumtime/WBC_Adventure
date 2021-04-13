package wbcadventure;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.SwingConstants.SOUTH;
import javax.swing.border.Border;
public class MainMenu extends JFrame {
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private JLayeredPane layerPane = new JLayeredPane();
    public MainMenu(){
        this.setSize(new Dimension(1920,1080));
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);  
        this.setVisible(true);
        this.setBackground();
        this.setButtons();
        layerPane.setBounds(0,0,1920,1080);
        this.add(layerPane);
        
    }
    public void setButtons(){
        JPanel pa=new JPanel();
        pa.setBounds(0,0,1920,1080);
        pa.setOpaque(false);
        pa.setLayout(null);
        
        Buttons start = new Buttons("Start",456,637);
        //start.setBorder(border);
        pa.add(start);
        
        Buttons load = new Buttons("Load",996,637);
        //load.setBorder(border);
        pa.add(load);
        
        Buttons setting = new Buttons("Setting",456,816);
        //setting.setBorder(border);
        pa.add(setting);
        
        Buttons exit = new Buttons("Exit",996,816);
        //exit.setBorder(border);
        pa.add(exit);
        
        layerPane.add(pa,Integer.valueOf(1));
    }
    
    public void setBackground(){
        JPanel bgPanel=new JPanel();
        bgPanel.setBorder(border);
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
                  StartGame start=new StartGame();
                    start.setBackground();
                    start.setStartPoint();
                    start.setUplayer();
                  setVisibleToFalse();
              }
              else if(name.equals("Load")){
                  
              }
              else if(name.equals("Setting")){
                      
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
