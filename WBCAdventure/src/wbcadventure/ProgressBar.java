package wbcadventure;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class ProgressBar extends JPanel{
    
    private JLayeredPane layer = new JLayeredPane();
    
    private WBC wbcCharacter;
    private JLabel wbcHPBarLabel        = new JLabel();
    private JLabel wbcProgressBarLabel  = new JLabel();
    private JLabel wbcHPBarIcon         = new JLabel();
    private JProgressBar hpBarWBC = new JProgressBar();
    
    private NormalEnemy enemyCharacter;
    private JLabel enemyHPBarLabel          = new JLabel();
    private JLabel enemyProgressBarLabel    = new JLabel();
    private JLabel enemyHPBarIcon           = new JLabel();
    private JProgressBar hpBarEnemy = new JProgressBar();
    
    private BossEnemy bossCharacter;
    private JLabel bossHPBarLabel       = new JLabel();
    private JLabel bossProgressBarLabel  = new JLabel();
    private JLabel bossHPBarIcon        = new JLabel();
    private JProgressBar hpBarBoss = new JProgressBar();
    
    public ProgressBar(WBC wbc){
        wbcCharacter=wbc;
        bossCharacter = new BossEnemy(wbcCharacter);
        
        layer.setBounds(0, 0, 1920 , 75);
        this.add(layer);
        this.setLayout(null);
        this.setBounds(0, 0, 1920, 100);
        
        wbcHPBarIcon.setIcon(new ImageIcon("src/source/uplayer/HPBar/HPBarWBC.png"));
        wbcHPBarIcon.setOpaque(false);
        wbcHPBarIcon.setBounds(0, 0, 790, 75);
        
        hpBarWBC.setBounds(0,0,565, 42);
        hpBarWBC.setForeground(new Color(0x6fc998));
        hpBarWBC.setBackground(new Color(0xde9898));

        
        wbcProgressBarLabel.add(hpBarWBC);
        wbcProgressBarLabel.setBounds(210,15,565,42);
        
        wbcProgressBarLabel.setVisible(false);
        wbcHPBarIcon.setVisible(false);
        hpBarWBC.setVisible(false);
        
        layer.add(wbcProgressBarLabel, Integer.valueOf(0));
        layer.add(wbcHPBarIcon,Integer.valueOf(1));

        enemyHPBarIcon.setIcon(new ImageIcon("src/source/uplayer/HPBar/HPBarEnemy.png"));
        enemyHPBarIcon.setOpaque(false);
        enemyHPBarIcon.setBounds(1110, 0, 790, 75);
        
        hpBarEnemy.setBounds(0,0,565, 42);
        hpBarEnemy.setForeground(new Color(0xde9898));
        hpBarEnemy.setBackground(new Color(0x6fc998));
        
        enemyProgressBarLabel.add(hpBarEnemy);
        enemyProgressBarLabel.setBounds(1129,15,565,42);
        
        enemyProgressBarLabel.setVisible(false);
        enemyHPBarIcon.setVisible(false);
        hpBarEnemy.setVisible(false);
        
        layer.add(enemyProgressBarLabel, Integer.valueOf(0));
        layer.add(enemyHPBarIcon,Integer.valueOf(1));
        
        bossHPBarIcon.setIcon(new ImageIcon("src/source/uplayer/HPBar/HPBarEnemy.png"));
        bossHPBarIcon.setOpaque(false);
        bossHPBarIcon.setBounds(1110, 0, 790, 75);
        
        hpBarBoss.setBounds(0,0,565, 42);
        hpBarBoss.setForeground(new Color(0xde9898));
        hpBarBoss.setBackground(new Color(0x6fc998));
        
        bossProgressBarLabel.add(hpBarBoss);
        bossProgressBarLabel.setBounds(1129,15,565,42);
        
        bossProgressBarLabel.setVisible(false);
        bossHPBarIcon.setVisible(false);
        hpBarBoss.setVisible(false);
        
        layer.add(bossProgressBarLabel, Integer.valueOf(0));
        layer.add(bossHPBarIcon,Integer.valueOf(1));
    }
    
    public void setWBCHPBar(){
        wbcProgressBarLabel.setVisible(true);
        wbcHPBarIcon.setVisible(true);
        hpBarWBC.setVisible(true);
        
        hpBarWBC.setMaximum(wbcCharacter.getHPcontrol().getMaxHP());
        hpBarWBC.setValue(wbcCharacter.getHPcontrol().getMaxHP());
        hpBarWBC.setStringPainted(true);
        hpBarWBC.setFont(new Font("Courier New", Font.BOLD, 26));
        hpBarWBC.setString(""+wbcCharacter.getHPcontrol().getHP());
    }
    
    
    public void setEnemyHPBar(NormalEnemy enemyCharacter){
        this.enemyCharacter = enemyCharacter;
        enemyProgressBarLabel.setVisible(true);
        enemyHPBarIcon.setVisible(true);
        hpBarEnemy.setVisible(true);
        
        hpBarEnemy.setMaximum(enemyCharacter.getHPcontrol().getMaxHP());
        hpBarEnemy.setStringPainted(true);
        hpBarEnemy.setFont(new Font("Courier New", Font.BOLD, 26));
        hpBarEnemy.setString(""+(enemyCharacter.getHPcontrol().getMaxHP()));
        hpBarEnemy.setValue(0); 
           
        
    }
    
    public void setBossHPBar(){
        bossProgressBarLabel.setVisible(true);
        bossHPBarIcon.setVisible(true);
        hpBarBoss.setVisible(true);
        
        hpBarBoss.setMaximum(bossCharacter.getHPcontrol().getMaxHP());
        hpBarBoss.setStringPainted(true);
        hpBarBoss.setFont(new Font("Courier New", Font.BOLD, 26));
        hpBarBoss.setString(""+(bossCharacter.getHPcontrol().getMaxHP()-bossCharacter.getHPcontrol().getHP()));
        hpBarBoss.setValue(0);
             
    }
    
    public void turnOffWBCHPBar(){
        wbcHPBarIcon.setVisible(false);
        wbcProgressBarLabel.setVisible(false);
        hpBarWBC.setVisible(false);
        remove(wbcHPBarIcon);
        remove(wbcProgressBarLabel);
        remove(hpBarWBC);
    }

    public void turnOffEnemyHPBar(){
        enemyHPBarIcon.setVisible(false);
        enemyProgressBarLabel.setVisible(false);
        hpBarEnemy.setVisible(false);
        remove(enemyHPBarIcon);
        remove(enemyProgressBarLabel);
        remove(hpBarEnemy);
    }

    public void turnOffBossHPBar(){
        bossHPBarIcon.setVisible(false);
        bossProgressBarLabel.setVisible(false);
        hpBarBoss.setVisible(false);
        remove(bossHPBarIcon);
        remove(bossProgressBarLabel);
        remove(hpBarBoss);
    }
    
    public wbcadventure.Character getWBCCharacter(){
        return wbcCharacter;
    }
    
    public wbcadventure.Character getEnemyCharacter(){
        return enemyCharacter;
    }
    
    public wbcadventure.Character getBossCharacter(){
        return bossCharacter;
    }
    
    public JProgressBar getHPBarWBC(){
        return hpBarWBC;
    }
    
    public JProgressBar getHPBarEnemy(){
        return hpBarEnemy;
    }
    
    public JProgressBar getHPBarBoss(){
        return hpBarBoss;
    } 
}
