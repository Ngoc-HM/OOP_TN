//Họ Và Tên: Lê Thế Anh
//MSSV: 20200018
//Mã lớp TH: 721428
//Lap 03: 24/11/2022
package hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.lang.String;
public class DigitalVideoDisc {
	private static int nbDigitalVideoDisc = 0;
	private String title;
	private String category;
	private String directory;
	private int lenght;
	private float cost;
	public int id = nbDigitalVideoDisc;
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDisc++;
	}
	public DigitalVideoDisc( String title,String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}

	public DigitalVideoDisc(String title, String category, String directory, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}
	
	public DigitalVideoDisc(String title, String category, String directory, int lenght, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.lenght = lenght;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getDirectory() {
		return directory;
	}
	public int getLenght() {
		return lenght;
	}
	public float getCost() {
		return cost;
	}
	
	// In ra thông tin sản phẩm bao gồm, tiêu đề, category, drectory, chiều dài, giá
	@Override
	public String toString() {
		return "DVD - " + title + " - " + category + " - " + directory + " - "
				+ lenght + ": " + cost + "$";
	}
	
	// Hàm kiểm tra xem title nhập vào có trùng với title trong giỏ hàng không
	public boolean isMatchTitle(String title1) {
		return this.getTitle().equals(title1);
	}
	
}
