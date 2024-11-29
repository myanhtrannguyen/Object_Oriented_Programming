package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{

    @Override
    public int compare(Media o1, Media o2) {
        // TODO Auto-generated method stub
        return o1.getTitle().compareTo(o2.getTitle());
    }

}