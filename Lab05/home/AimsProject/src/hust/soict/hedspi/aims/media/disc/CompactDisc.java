package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.exceptions.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public String message;
    public CompactDisc(String artist, List<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String artist, List<Track> tracks) {
        super(id, title);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, String artist, List<Track> tracks) {
        super(id, title, category);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(int id,String title,String category,float cost ,String artist){
        super(id,title,category,cost);
        this.artist = artist;
    }
    public CompactDisc(int id,String title,String category,float cost ,String artist,int length){
        super(id,title,category,cost,length);
        this.artist = artist;
    }
    public CompactDisc(int id, String title, String category, float cost,String director, String artist,int length) {
        super(id, title, category, cost,director,length);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        int flag = 0;
        for(Track o : tracks){
            if(o.getTitle().equals(track.getTitle()) && o.getLength() == track.getLength()){
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            tracks.add(track);
        else
            System.out.println("This track already exists in the track list");
    }

    public void removeTrack(Track track){
        int flag = 0;
        for(Track o : tracks){
            if(o.getTitle().equals(track.getTitle()) && o.getLength() == track.getLength()){
                flag = 1;
                break;
            }
        }
        if(flag == 1)
            tracks.remove(track);
        else
            System.out.println("This track not found in the track list");
    }
    public List<Track> getTracks(){
        return tracks;
    }
    public int getLength() {
        int sumOfTrackLength = 0;
        
        for (Track track : this.tracks) {
            sumOfTrackLength += track.getLength();
        }
        
        return sumOfTrackLength;
    }
    public int getNumOfTrack(){
       return tracks.size();

    }
    // search track by title and length
    public int searchTrack(Track cmpTrack) {
        for (int i = 0; i < this.tracks.size(); i++) {
            if (this.tracks.get(i).isEqualAll(cmpTrack)) {
                return i;
            }
        }
        
        return -1;
    }
    

    @Override
    public void play() throws PlayerException {
//        System.out.println("Playing CD: " + this.getTitle());
//        System.out.println("CD length: " + this.getLength());
        this.message = "Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength();
        if(this.getLength() > 0) {
            for(Track track: tracks) {
                track.play();
                message += track.getMessage();
            }
        }else {
            throw new PlayerException("ERROR: CD length is non-positive");
        }
    }
    
    public String toString(){
        return "CD - "+super.getTitle()+" - "+super.getCategory()+" - "+this.getArtist()+" - "+this.getLength()+" : "+super.getCost()+" $";
    }


    public int compareTo(Media o) {
        if(o instanceof CompactDisc){
            if(this.getNumOfTrack() > ((CompactDisc) o).getNumOfTrack())
                return 1;
            else if (this.getNumOfTrack() < ((CompactDisc) o).getNumOfTrack())
                return -1;
            else{
                if(this.getLength() > ((CompactDisc) o).getLength())
                    return 1;
                else if (this.getLength() > ((CompactDisc) o).getLength())
                    return -1;
                else
                    return super.compareTo(o);
            }
        }
        else
            return super.compareTo(o);
    }
}