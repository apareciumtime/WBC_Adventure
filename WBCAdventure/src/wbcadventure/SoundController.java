package wbcadventure;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundController {
    AudioInputStream audioInput;
    Clip soundControllerClip;
    File soundBackgroundFile;
    
    public SoundController(File file) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        soundBackgroundFile = file;
        this.audioInput = AudioSystem.getAudioInputStream(soundBackgroundFile);
        this.soundControllerClip = AudioSystem.getClip();
    }
    
    public Clip getSoundControllerClip(){
        return this.soundControllerClip;
    }
    
    public AudioInputStream getAudio(){
        return this.audioInput;
    }
    
}
