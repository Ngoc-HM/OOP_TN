package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.exceptions.PlayerException;

public class Track implements Playable, Comparable<Object>{
    private String title;
    int length;

    public Track(String title) {
        this.title = title;
    }

    public Track(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public void play() throws PlayerException {
//        System.out.println(" Playing Track: " + this.getTitle());
        if(this.length >0){
//            System.out.println(" DVD Track: " + this.getLength());
        } else{
            throw new PlayerException("ERROR: CD length is non-positive");
        }
    }
    public String getMessage() {
        return "\nPlaying Track: " + this.getTitle() + "\nTrack length: " + this.getLength();
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Track) {
            if(length == ((Track) o).getLength() && title.equals(((Track) o).title)){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    // isEqualTittle()
    public boolean isEqualAll(Track aTrack) {
        if (this.title.equals(aTrack.getTitle())) {
            if (this.length == aTrack.length) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}