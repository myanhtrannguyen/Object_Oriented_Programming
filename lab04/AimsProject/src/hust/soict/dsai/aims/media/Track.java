package hust.soict.dsai.aims.media;
public class Track implements Playable{
    private String title;
    private int length;

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Constructors
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play(){
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        Track tmp = (Track)o;
        if(this.getTitle() == tmp.getTitle() && this.getLength() == tmp.getLength()) {
            return true;
        }
        else return false;
    }
}
