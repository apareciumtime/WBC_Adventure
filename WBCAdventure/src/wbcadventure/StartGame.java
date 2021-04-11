package wbcadventure;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
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
        
    }
    
    public void setBackground(){
        /**
         * background Label Setting
         */
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(background.getBackgroundImage());
        backgroundLabel.setBounds(0, -50, 1920, 1080);
        backgroundLabel.setOpaque(false);
        
        /**
         * background Panel Setting
         */
        backgroundPanel.add(backgroundLabel);
        backgroundPanel.setBounds(0,-50,1920,1080);
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
