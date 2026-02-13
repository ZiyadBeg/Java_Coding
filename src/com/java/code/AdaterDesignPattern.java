package src.com.java.code;
interface MediaPlayer {
    void play(String fileName);
}
class MP4Player {
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
class MediaAdapter implements MediaPlayer {
    private MP4Player mp4Player ;
    MediaAdapter(MP4Player mp4Player){
        this.mp4Player=mp4Player;
    }

    @Override
    public void play(String fileName) {
        // Adapter ne MP4 player ka method use karke play() ko support kiya
        mp4Player.playMp4(fileName);
    }
}
public class AdaterDesignPattern {
    public static void main(String[] args) {
        MediaAdapter mediaAdapter=new MediaAdapter(new MP4Player());
        mediaAdapter.play("Play.mp3");
    }
}




