package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable{
	private String message;
    
	public DigitalVideoDisc(int id, String title, String director, int length){
        super(id,title, director, length);
    }
    
    public DigitalVideoDisc(int id,String title,String category, String director, int length){
        super(id,title, category,director,length);
    }

    public DigitalVideoDisc(int id,String title,String category,float cost, String director, int length){
        super(id,title,category,cost,director,length);
    }

    @Override
    public String toString(){
        return "DVD - "+super.getTitle()+" - "+super.getCategory()+" - "+this.getDirector()+" - "+this.getLength()+" : "+super.getCost()+" $";
    }

    public boolean search (String title){
        String[] token_search = title.toLowerCase().split(" ");
        String[] token_title = title.toLowerCase().split(" ");
        int flag = 0;
        for(int i = 0 ; i < token_search.length; i ++){
            for (int j = 0; j < token_title.length ; j++){
                if(token_search[i].equals(token_title[j])){
                    flag ++ ;
                    break;
                }
            }
        }
        if(flag == token_search.length)
            return true;
        else
            return false;
    }
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            message = "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
        }else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }
    public String getMessage(){
        return message;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof DigitalVideoDisc) {
            if(this.getCost() < ((Media)o).getCost())
                return -1;
            else if(this.getCost() > ((Media)o).getCost())
                return 1;
            else{
                if(this.getLength()< ((DigitalVideoDisc) o).getLength())
                    return -1;
                else if(this.getLength() > ((DigitalVideoDisc) o).getLength())
                    return 1;
                else{
                    return super.compareTo(o);
                }
            }
        }else {
            return super.compareTo(o);
        }
    }
}