package wbcadventure;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.SOUTH;

public class EndGame extends JPanel{
    String type;
    public EndGame(String type){
        this.type=type;
        this.setBounds(0, 0,1920, 1080);
        this.setVisible(true);
        this.setOpaque(false);
        
        JLayeredPane layerpane=new JLayeredPane();
        layerpane.setBounds(0, 0,1920, 1080);
        layerpane.setVisible(true);
        layerpane.setOpaque(false);
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
        
        Buttons re=new Buttons("Restart",264,724);
        layerpane.add(re,Integer.valueOf(1));
        Buttons menu=new Buttons("Menu",757,724);
        layerpane.add(re,Integer.valueOf(2));
        Buttons exit=new Buttons("Exit",1250,724);
        layerpane.add(re,Integer.valueOf(3));
        
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
              if(name.equals("ReStart")){
                  
              }
              else if(name.equals("Menu")){
                  
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
