//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427


package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class CartTest {
	public static void main(String[] args) {
		List<String> authors = new ArrayList<String>();
		authors.add("abc");
		authors.add("BNDH");
		authors.add("NVBSD");
		List<Media> mediae = new ArrayList<Media>();
		// create some media here
		// for examble : cd, dvd, book
		Media cd = new CompactDisc("The Lion King", "Animation", "Roger Allers","abc",19.95f);
		Media dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geoge Lucas", 87, 24.95f);
		Media book = new Book("Star Wars", "Science Fiction",24.95f, authors);
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for(Media m: mediae) {
			System.out.println(m.toString());
		}
	}
}