package wbcadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
public class Battle extends JPanel{
    
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private WBC wbc = new WBC();
    private JLabel wbcLabel = new JLabel();
    private JLayeredPane layerPane = new JLayeredPane();
    ArrayList<Enemy> enemyArrayList=new ArrayList<>();
    private StartGame stgame;
    public Battle(StartGame stgame){
        
        this.stgame=stgame;
        NormalEnemy e1=new NormalEnemy(wbc);
        e1.setLocation(500,400);
        e1.setLayout(null);
        BossEnemy boss=new BossEnemy(wbc);
        boss.setLocation(900,125);
        boss.setLayout(null);
        
        enemyArrayList.add(e1);
        enemyArrayList.add(boss);

        layerPane.add(wbc,Integer.valueOf(0));
        layerPane.add(e1,Integer.valueOf(1));
        layerPane.add(boss,Integer.valueOf(2));
        
        layerPane.setBounds(0,0,1920,1080);
        layerPane.setOpaque(false);
        layerPane.setVisible(true);
        layerPane.setLayout(null);
        this.add(layerPane);

        WBCMovement move=new WBCMovement(wbc,this,stgame);
//        ClickListener clickListener=new ClickListener();
//        DragListener dragListener=new DragListener();
//        wbc.getWBCLabel().addMouseListener(clickListener);
//        wbc.getWBCLabel().addMouseMotionListener(dragListener);

    }
    
    public ArrayList<Enemy> getEnemyArr(){
        return enemyArrayList;
    }
    public void removeEnemy(int i){
        this.remove(enemyArrayList.get(i));
        enemyArrayList.remove(i);
    }
    
//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        wbc.getIconNowWBC().paintIcon(wbc.getWBCLabel(), g,(int)wbc.getImgCorner().getX(),(int)wbc.getImgCorner().getY());
//    }
//    
//    public class ClickListener extends MouseAdapter{
//        public void mousePressed(MouseEvent e){
//            wbc.getWBCLabel().setIcon(wbc.getCharacIcon(1));
//            wbc.setPrevPt(e.getPoint());
//        }
//        public void mouseClicked ( MouseEvent e ){
//            wbc.getWBCLabel().setIcon(wbc.getCharacIcon(1));
//        }
//	public void mouseEntered ( MouseEvent e ){}
//	public void mouseExited ( MouseEvent e ){}
//	public void mouseReleased ( MouseEvent e ){
//            wbc.getWBCLabel().setIcon(wbc.getCharacIcon(0));
//            if (wbc.getWBCLabel().getBounds().intersects(enemyArrayList.get(0).getBounds())){
//                System.out.println("Enemy mHP : "+enemyArrayList.get(0).getHPcontrol().getMaxHP());
//                System.out.println("Enemy HP : "+enemyArrayList.get(0).getHPcontrol().getHP());
//                System.out.println("wbc mHP : "+wbc.getHPcontrol().getMaxHP());
//                System.out.println("wbc HP : "+wbc.getHPcontrol().getHP());
//                wbc.getWBCLabel().setLocation(enemyArrayList.get(0).getX()-200,enemyArrayList.get(0).getY());
//                AttackController atk=new AttackController(wbc,enemyArrayList.get(0));
//                atk.duel();
//                Character win=atk.getWinner();
//                
//                if(win instanceof WBC){
//                    System.out.println("winnnn");
//                    enemyArrayList.get(0).setVisible(false);
//                    //remove(enemyArrayList.get(0));
//                    enemyArrayList.remove(0);
//                }
//                else{
//                    System.out.print("lose");
//                }
//                wbc.setImgCorner(enemyArrayList.get(0).getX()-200,enemyArrayList.get(0).getY());
//            }
//            
//        }
//    }
//    
//    public class DragListener extends MouseMotionAdapter{
//        public void mouseDragged(MouseEvent e){
//            Point currentpt=e.getPoint();
//            wbc.setImgCorner( (int)((currentpt.getX()+wbc.getPrevPt().getX()-563/2)*.05f),
//                    (int)((currentpt.getY()+wbc.getPrevPt().getY()-563/2)*.05f));
//            wbc.getWBCLabel().setLocation((int)wbc.getImgCorner().getX(),(int)wbc.getImgCorner().getY());
//            wbc.setPrevPt(currentpt); 
//            wbc.getWBCLabel().repaint();
//        }
//    }
}
