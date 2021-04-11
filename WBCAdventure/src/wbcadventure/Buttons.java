package wbcadventure;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Buttons extends JLabel implements MouseListener {
    private String name;
    private ImageIcon normal;
    private ImageIcon pass;
    private ImageIcon click;
    public Buttons(String name){
        this.name=name;
        normal=new ImageIcon("src/source/buttons/Button"+name+"_normal.png");
        pass=new ImageIcon("src/source/buttons/Button"+name+"_pass.png");
        click=new ImageIcon("src/source/buttons/Button"+name+"_click.png");
        this.setIcon(normal);
        this.setOpaque(true);
        this.setBounds(0,0,179,467);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
       this.setIcon(click);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setIcon(normal);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setIcon(pass);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(normal);
    }
    
}
