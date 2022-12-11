//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

package hust.soict.dsai.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;  // số lượng tối đa của giỏ hàng ( hằng số )
	private float totalcost = 0;  // tổng giá trị giỏ hàng
	public int qtyOrdered = 0;  // Số lượng thực tế DVD trong giỏ hàng
	
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	

	//Tính tổng giá tiền dvd trong giỏ
	public float totalCost() {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			totalcost += itemsOrdered.get(i).getCost();
		}
		return totalcost;
	}
	
	// Thêm 1 media vào list
	public void addMedia (Media media) {
		// Nếu ko thấy media trong list thì thêm vào
		if(itemsOrdered.contains(media) == false) {
			itemsOrdered.add(media);
			System.out.println("The media has been added");
		}
		else System.out.println("The media is already in the list ");
	}
	
	// Xóa 1 media vào list
	public void removeMedia (Media media) {
		// Nếu ko thấy media trong list thì thêm vào
		if(itemsOrdered.contains(media) == true) {
			itemsOrdered.remove(media);
			System.out.println("The media has been removed");
		}
		else System.out.println("The media isn't in the list ");
	}
	
    /**
     * Prints the cart.
     */
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        System.out.println("1. " +itemsOrdered.get(0).toString());
        for(int i = 1; i < itemsOrdered.size(); i++) {
        	int j = i+1;
        	System.out.println(j + ". " +itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
        
    }

    
   
    /**
     * Search cart by title.
     *
     * @param title the title
     */
    public Media searchByTitle(String title) {
        for(Media m : itemsOrdered) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return m;
            }
        }
        return null;
    }

    /**
     * Search cart id.
     *
     * @param id the id
     */
    public Media searchById(int id) {
        for(Media m : itemsOrdered) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
    

    
    // Tạo phương thức contains kiểm tra đối tượng có trong list hay không

    public boolean contains(Media e) {
    	boolean check = false;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			check = (itemsOrdered.get(i) == null ? e == null : itemsOrdered.get(i).equals(e) );
		}
		
		return check;
	}
    
    public void playMedia(Media media) {
        if (media instanceof CompactDisc) {
            ((CompactDisc) media).play();
        }
        if (media instanceof DigitalVideoDisc) {
            ((DigitalVideoDisc) media).play();
        }
        if (media instanceof Book) {
            System.out.println("Cannot play a book");
        }
    }
    
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}
