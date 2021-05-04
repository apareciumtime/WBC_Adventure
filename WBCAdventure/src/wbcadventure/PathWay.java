package wbcadventure;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.border.Border;
public class PathWay {
    private Border border = BorderFactory.createLineBorder(Color.gray,1);
    private int pathType;
    private ArrayList<ImageIcon> platePlain = new ArrayList<>();
    private ArrayList<ImageIcon> square = new ArrayList<>();
    public PathWay(int pathType){
        this.pathType = pathType;
        platePlain.add(new ImageIcon("src/source/background/platePlain.png"));  //0
        platePlain.add(new ImageIcon("src/source/background/plateTurnTB.png")); //1
        platePlain.add(new ImageIcon("src/source/background/plateTurnTT.png")); //2
        platePlain.add(new ImageIcon("src/source/background/plateTurnBT.png")); //3
        platePlain.add(new ImageIcon("src/source/background/plateTurnBB.png")); //4
        platePlain.add(new ImageIcon("src/source/background/plateCross.png"));  //5
        platePlain.add(new ImageIcon("src/source/background/plateSecT.png"));   //6
        platePlain.add(new ImageIcon("src/source/background/platePlainT.png")); //7
        platePlain.add(new ImageIcon("src/source/background/plateSecB.png"));   //8
        platePlain.add(new ImageIcon("src/source/background/platePlainB.png")); //9
        platePlain.add(new ImageIcon("src/source/background/plateMergeB.png")); //10
        platePlain.add(new ImageIcon("src/source/background/plateMergeT.png")); //11
        
        platePlain.add(new ImageIcon("src/source/background/platePlainTFlip.png"));//12
        platePlain.add(new ImageIcon("src/source/background/plateSecTFlip.png")); //13
        platePlain.add(new ImageIcon("src/source/background/plateCrossFlip.png")); //14
        platePlain.add(new ImageIcon("src/source/background/plateSecBFlip.png")); //15
        platePlain.add(new ImageIcon("src/source/background/platePlainBFlip.png")); //16
        
        platePlain.add(new ImageIcon("src/source/background/semiPermible.png"));//17
        
        
        square.add(new ImageIcon("src/source/background/squareCenter.png"));    //0
        square.add(new ImageIcon("src/source/background/squareCornerLT.png"));  //1
        square.add(new ImageIcon("src/source/background/squareBorderT.png"));   //2
        square.add(new ImageIcon("src/source/background/squareCornerRT.png"));  //3
        square.add(new ImageIcon("src/source/background/squareCornerLB.png"));  //4
        square.add(new ImageIcon("src/source/background/squareBorderB.png"));   //5
        square.add(new ImageIcon("src/source/background/squareCornerRB.png"));  //6
        square.add(new ImageIcon("src/source/background/squareBorderL.png"));   //7
        square.add(new ImageIcon("src/source/background/squareBorderR.png"));   //8
        square.add(new ImageIcon("src/source/background/squareGateL.png"));     //9
        square.add(new ImageIcon("src/source/background/squareGateR.png"));     //10
        
    }
    
    public ImageIcon getIcon(int index){
        if(pathType == 0){
            return platePlain.get(index);
        }
        else if(pathType == 1){
            return square.get(index);
        }
        return null;
    }   
}
