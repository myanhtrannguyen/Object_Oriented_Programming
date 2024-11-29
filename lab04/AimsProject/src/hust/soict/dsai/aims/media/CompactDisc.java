package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    // Getter method for artist
    public String getArtist() {
        return artist;
    }
    public ArrayList<Track> getTrack() {
        return tracks;
    }


    // Constructors

    public CompactDisc() {
        // TODO Auto-generated constructor stub
        super();
    }

    public CompactDisc(String artist) {
        super();
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    // Methods for tracks
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added successfully.");
        } else {
            System.out.println("Track already exists in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully.");
        } else {
            System.out.println("Track does not exist in the CD.");
        }
    }

    // Method to get the length of the CD
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        // Loop through each track and call play() method
        for (Track track : tracks) {
            track.play();
        }
    }
}
