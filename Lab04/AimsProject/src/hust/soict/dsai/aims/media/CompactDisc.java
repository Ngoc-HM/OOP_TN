//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable
{
	private String artist;
	List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, cost, director);
        this.artist = artist;
    }
    
    public CompactDisc(String title, String category, float cost, String director) {
        super(title, category, cost, director);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
	// Thêm track vào array list
	public void addTrack(Track addtrack) {
		// Nếu ko thấy track trong list thì thêm vào
		if(tracks.contains(addtrack) == false) {
			tracks.add(addtrack);
			System.out.println("The track has been added");
		}
		
		else System.out.println("The track is already in the list ");
	}
	
	// Xóa track khỏi array list
	public void removeTrack(Track addtrack) {
		// Nếu  thấy track trong list thì có thể xóa
		if(tracks.contains(addtrack) == true) {
			tracks.remove(addtrack);
			System.out.println("The track has been added");
		}
		
		else System.out.println("The track is already in the list ");
	}
	
	// In ra độ dài của compact disc
	public int getLenght() {
		int sum = 0;
		for(int i = 0; i < tracks.size();i++) {
			sum +=  tracks.get(i).getLength();
		}
		return sum;
	}
	
	// Thực hiện phương thức play của lớp CompactDisc
	public void play() {
		for(int i = 0; i < tracks.size();i++) {
			tracks.get(i).play();
		}
	}
}
