//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD,cinderellaDVD);
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
		// Đổi title
		String tempString = Object1.getTitle(); // gan title cua title 1 cho tempString
		Object1.setTitle(Object2.getTitle());    // gan title cua title 2 cho title 1
		Object2.setTitle(tempString);
		
		//Đổi category
		tempString = Object1.getCategory(); // gan Category cua Object1 cho tempString
		Object1.setCategory(Object2.getCategory());    // gan Category cua Object2 cho Object1
		Object2.setCategory(tempString);
		
		// Đổi directory
		tempString = Object1.getDirectory(); // gan directory cuar Object1 cho tempString
		Object1.setDirectory(Object2.getDirectory());    // gan directory cua Object2 cho Object1
		Object2.setDirectory(tempString);
		
		// Đổi lenght
		int temp ;
		temp = Object1.getLenght(); // gan lenght cuar Object1 cho tempString
		Object1.setLenght(Object2.getLenght());    // gan lenght cua Object2 cho Object1
		Object2.setLenght(temp);
		
		//Đổi cost
		float tempCost;
		tempCost = Object1.getCost(); // gan cost cuar Object1 cho tempString
		Object1.setCost(Object2.getCost());    // gan cost cua Object2 cho Object1
		Object2.setCost(tempCost);
		
	}
	
	// Hàm hoán đổi giá trị title
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
