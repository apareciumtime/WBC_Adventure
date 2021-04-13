package wbcadventure;
import javax.swing.ImageIcon;
public class Background {
    private ImageIcon backgroundImage;
    
    /**
     * Constructor keep default background image
     */
    public Background(){
        backgroundImage = new ImageIcon("src/source/background/background.JPG");
    }
    
    /**
     * Method getBackgroundImage
     * @return ImageIcon : backgroundImage
     */
    public ImageIcon getBackgroundImage(){
        return backgroundImage;
    }
    
}
