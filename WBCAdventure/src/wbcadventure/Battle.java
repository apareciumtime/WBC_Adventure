package wbcadventure;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
public class Battle extends JPanel{
    
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private WBC wbc = new WBC();
    private JLabel wbcLabel = new JLabel();
    private JLayeredPane layerPane = new JLayeredPane();
    ArrayList<Enemy> enemyArr=new ArrayList<>();
    public Battle(){
//        wbc.setBounds(0, 0, 150, 200);
//        wbc.setOpaque(false);
//        
//        wbcLabel.add(wbc);
//        wbcLabel.setBounds(500, 500, 300, 200);
//        wbcLabel.setLayout(null);
        NormalEnemy e1=new NormalEnemy(wbc);
        e1.setLocation(800,400);
        e1.setLayout(null);
        BossEnemy boss=new BossEnemy(wbc);
        boss.setLocation(900,125);
        boss.setLayout(null);
        
        layerPane.add(wbc,Integer.valueOf(0));
        layerPane.add(e1,Integer.valueOf(1));
        layerPane.add(boss,Integer.valueOf(2));
        
        layerPane.setBounds(0,0,1920,1080);
        layerPane.setOpaque(false);
        layerPane.setVisible(true);
        layerPane.setLayout(null);
        this.add(layerPane);

    
    /*public wbcadventure.WBC getWBCLabel(){
        return wbc;
    }*/

    }   
}
