import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Created by John on 15/12/2018.
 */
public class MusicPlayer {
    public static synchronized void playSound(final String file) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream("IceWaddling/sound/" + file));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
