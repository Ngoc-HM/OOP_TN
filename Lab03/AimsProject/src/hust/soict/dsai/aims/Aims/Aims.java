//Họ Và Tên: Lê Thế Anh
//MSSV: 20200018
//Mã lớp TH: 721428
// Lap 03: 24/11/2022
package hust.soict.dsai.aims.Aims;


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

import java.util.Scanner;

public class Aims {
	public static void main(String [] args) {
		// TODO Auto-generated method
		//create a new cart
		Cart anOrderCart = new Cart();

		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrderCart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geoge Lucas", 87, 24.95f);
		anOrderCart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 23.65f);
		anOrderCart.addDigitalVideoDisc(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Black Panther", "Science Action", "blabla",90 , 21.99f);
		anOrderCart.addDigitalVideoDisc(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Black Panther", "Science Action", "blabla",90 , 21.99f);
		anOrderCart.addDigitalVideoDisc(dvd5);
		anOrderCart.addDigitalVideoDisc(dvd5);
		anOrderCart.addDigitalVideoDisc(dvd5);
		anOrderCart.addDigitalVideoDisc(dvd5);
		anOrderCart.addDigitalVideoDisc(dvd5);
		
		anOrderCart.removeDigitalVideoDisc(dvd5);
		//In ra total cost
		System.out.print("Total cost is: ");
		System.out.println(anOrderCart.totalCost());
		// In ra quantity
		System.out.print("Dvd quantity in cart: ");
		System.out.println(anOrderCart.qtyOrdered);
		// In ra danh sách giỏ hàng
		anOrderCart.printCart();
	}
}

// Code này chỉ dùng để test tính năng tương tác với người dùng
//Scanner keyboard = new Scanner(System.in);
//String check = "1"; 
//String title;
//String category;
//String directory ;
//int lenght = 0;
//float cost = 0;
//int checkInt = 0;
//while(check == "1") {
//	// input title
//	System.out.print("Input title: ");
//	title = keyboard.nextLine();
//	//input category
//	System.out.print("Input category: ");
//	category = keyboard.nextLine();
//	//input directory
//	System.out.print("Input directory: ");
//	directory = keyboard.nextLine();
//	//input lenght
//	System.out.print("Input lenght: ");
//	lenght = keyboard.nextInt();
//	// input cost
//	System.out.print("Input cost: ");
//	cost = keyboard.nextFloat();
//	DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,directory,lenght,cost);
//	anOrderCart.addDigitalVideoDisc(dvd);
//	System.out.print("Do you want to continue ?\nIf continue, press 1; else press any else:  ");
//	check = keyboard.next();
//}