//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;
public class Store<itemsInStore> {
	
	/** The items in store. */
	ArrayList<Media> itemsInStore = new ArrayList<Media>();
	

	/**
	 * Removes the DVD.
	 *
	 * @param disc the disc
	 */
	public void removeDVD(Media disc) {
		itemsInStore.remove(disc);
		System.out.println("The media " + disc.getTitle() + " has been removed");
	}

	/**
	 * Adds the digital video disc.
	 *
	 * @param disc the disc
	 */
	public void addDVD(Media disc) {
		// Nếu số lượng chưa max thì có thể thêm
			itemsInStore.add(disc);
			System.out.println("The disc " + disc.getTitle() + " has been added");
	}
	
	// Tìm kiếm thông qua title
    public Media searchByTitle(String title) {
        for(Media m : itemsInStore) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return m;
            }
        }
        return null;
    }
    
    
    // In ra toàn bộ store
    public void printStore() {

        System.out.println("***********************CART***********************");
        System.out.println("All item in store:");
        System.out.println("1. " +itemsInStore.get(0).toString());
        for(int i = 1; i < itemsInStore.size(); i++) {
        	int j = i+1;
        	System.out.println(j + ". " +itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }
    
}
