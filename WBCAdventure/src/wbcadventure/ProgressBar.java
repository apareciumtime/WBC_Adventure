package wbcadventure;
import javax.swing.JProgressBar;
public class ProgressBar extends JProgressBar{
    JProgressBar HP = new JProgressBar();
    public ProgressBar(){
        HP.setVisible(true);
        HP.setBounds(0, 0, 500, 75);
        HP.setStringPainted(true);
        fill();
    }
    
    public void fill(){
        int counter = 0;
        HP.setValue(counter);
        while(counter<=100){
            try{Thread.sleep(100);}
            catch(InterruptedException e){
                e.printStackTrace();
            }
            counter+=2;
        }
    }
}
