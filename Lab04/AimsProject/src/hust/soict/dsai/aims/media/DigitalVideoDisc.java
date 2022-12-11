//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

package hust.soict.dsai.aims.media;

import java.lang.String;
public class DigitalVideoDisc extends  Disc implements Playable{
	
	   public DigitalVideoDisc(String title) {
	        super(title);
	    }

	    public DigitalVideoDisc(String title, String category, float cost) {
	        super(title, category, cost);
	    }

	    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
	        super(title, category, cost, director, length);
	    }
	
	// In ra thông tin sản phẩm bao gồm, tiêu đề, category, drectory, chiều dài, giá
	@Override
	public String toString() {
		return "DVD - " + "[id = " + getId() + getTitle() + " - " + getCategory() + " - " + getDirectory() + " - "
				+ getLength() + ": " + getCost() + "$";
	}
	
	// Hàm kiểm tra xem title nhập vào có trùng với title trong giỏ hàng không
	public boolean isMatchTitle(String title1) {
		return this.getTitle().equals(title1);
	}
	
	
	@Override
	// Triển khai phương thứ play cho lớp DigitalVideoDisc
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	
}
