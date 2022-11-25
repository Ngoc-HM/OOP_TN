//Họ Và Tên: Lê Thế Anh
//MSSV: 20200018
//Mã lớp TH: 721428
//Lap 03: 24/11/2022

package hust.soict.dsai.test.store.StoreTest;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.*;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store dvdStore = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		dvdStore.addDVD(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geoge Lucas", 87, 24.95f);
		dvdStore.addDVD(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 23.65f);
		dvdStore.addDVD(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Black Panther", "Science Action", "blabla",90 , 21.99f);
		dvdStore.addDVD(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("No Back", "Science Action", "blabla",90 , 21.99f);
		dvdStore.addDVD(dvd5);
		
		dvdStore.removeDVD(dvd3);
	}
}
