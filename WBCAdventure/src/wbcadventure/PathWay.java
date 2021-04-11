package wbcadventure;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class PathWay {
    ArrayList<ImageIcon> rowSquareImage = new ArrayList<>();
    ArrayList<ArrayList> squareImage = new ArrayList<>();
    public PathWay(){        
        
        
        ImageIcon squareCornerLT = new ImageIcon("src/source/background/squareCornerLT.png");
        ImageIcon squareBorderT = new ImageIcon("src/source/background/squareBorderT.png");
        ImageIcon squareCornerRT = new ImageIcon("src/source/background/squareCornerRT.png");
        
        rowSquareImage.add(squareCornerLT);
        rowSquareImage.add(squareBorderT);
        rowSquareImage.add(squareCornerRT);
        squareImage.add(rowSquareImage);
        
        for(int i = 0 ; i<3 ; i++){
            rowSquareImage.remove(i);
        }
        
        ImageIcon squareGateL = new ImageIcon("src/source/background/squareGateL.png");
        ImageIcon squareCenter = new ImageIcon("src/source/background/squareCenter.png");
        ImageIcon squareGateR = new ImageIcon("src/source/background/squareGateR.png");
        
        rowSquareImage.add(squareGateL);
        rowSquareImage.add(squareCenter);
        rowSquareImage.add(squareGateR);
        squareImage.add(rowSquareImage);
        
        for(int i = 0 ; i<3 ; i++){
            rowSquareImage.remove(i);
        }
        
        ImageIcon squareCornerLB = new ImageIcon("src/source/background/squareCornerLB.png");
        ImageIcon squareBorderB = new ImageIcon("src/source/background/squareBorderB.png");
        ImageIcon squareCornerRB = new ImageIcon("src/source/background/squareCornerRB.png");
        rowSquareImage.add(squareCornerLB);
        rowSquareImage.add(squareBorderB);
        rowSquareImage.add(squareCornerRB);
        squareImage.add(rowSquareImage);
        
        for(int i = 0 ; i<3 ; i++){
            rowSquareImage.remove(i);
        }   
    }
}
