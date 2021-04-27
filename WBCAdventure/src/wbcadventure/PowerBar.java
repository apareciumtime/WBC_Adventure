package wbcadventure;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PowerBar extends JPanel{
    private int power;
    private String type;
    private JLayeredPane layer;
    private JPanel powerpa;
    private JLabel powerlab;
    private JLabel powerNumLab;
    private JPanel powerNumPa;

    public PowerBar(String t,int p){
        type=t;
        power=p;
        layer=new JLayeredPane();
        
        this.setVisible(true);
        this.setOpaque(false);
        this.setLayout(null);
        
        layer.setVisible(true);
        layer.setBounds(0,0,530,150);
        layer.setLayout(null);
        layer.setOpaque(false);
        this.add(layer);
        
        powerlab=new JLabel();
        powerlab.setIcon(new ImageIcon("src/source/uplayer/PowerBar/PowerBar"+type+".png"));
        powerlab.setBounds(0,0,530,150);
        powerlab.setVisible(true);
        powerlab.setOpaque(false);
        
        powerpa=new JPanel();
        powerpa.setBounds(0,0,530,150);
        powerpa.add(powerlab);
        powerpa.setVisible(true);
        powerpa.setOpaque(false);
        powerpa.setLayout(null);
        layer.add(powerpa,Integer.valueOf(0));
        
        powerNumLab=new JLabel(""+power,JLabel.CENTER);
        powerNumLab.setFont(new Font("Courier New", Font.BOLD, 50));
        powerNumLab.setForeground(Color.WHITE);
        powerNumLab.setBounds(0,0,321,61);
        powerNumLab.setVisible(true);
        powerNumLab.setOpaque(false);
        
        
        powerNumPa=new JPanel();
        powerNumPa.setBounds(150,63,321,61);
        powerNumPa.setVisible(true);
        powerNumPa.setOpaque(false);
        powerNumPa.add(powerNumLab);
        
        layer.add(powerNumPa,Integer.valueOf(1));
    }
    
    public void setPower(int pw){
        power=pw;
        powerNumLab.setText(""+pw);
    }
    
    
}
