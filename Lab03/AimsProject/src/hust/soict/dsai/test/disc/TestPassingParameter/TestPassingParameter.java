//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427
package hust.soict.dsai.test.disc.TestPassingParameter;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		newSwap(jungleDVD,cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
	}

	// Hoán đổi Obj 1 Và Obj 2
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	//Please write a swap() method that can correctly swap the two objects.
	public static void newSwap(DigitalVideoDisc Object1, DigitalVideoDisc Object2) {
		
		DigitalVideoDisc tempObject = new DigitalVideoDisc(Object1.getTitle(), Object1.getCategory(), Object1.getDirectory(), Object1.getLenght(), Object1.getCost()) ;

		Object1.setTitle(Object2.getTitle());    // gan title cua title 2 cho title 1
		Object1.setCategory(Object2.getCategory());    // gan Category cua Object2 cho Object1
		Object1.setDirectory(Object2.getDirectory());    // gan directory cua Object2 cho Object1
		Object1.setLenght(Object2.getLenght());    // gan lenght cua Object2 cho Object1
		Object1.setCost(Object2.getCost());    // gan cost cua Object2 cho Object1
		Object2.setTitle(tempObject.getTitle());
		Object2.setCategory(tempObject.getCategory());
		Object2.setDirectory(tempObject.getDirectory());
		Object2.setLenght(tempObject.getLenght());
		Object2.setCost(tempObject.getCost());
	}
	
	// Hàm hoán đổi giá trị title
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
