package hust.soict.hedspi.test.utils;
import hust.soict.hedspi.aims.utils.DateUtils;
import java.util.Scanner;

import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {

	public static void main(String[] args)throws Exception {
		// initialize with a string date
		MyDate date1 = new MyDate("February 18th 2000");
		date1.print();
		System.out.println(" ");
		// initialize with current day
		MyDate date2 = new MyDate();
		date2.print();
		System.out.println(" ");
		// initialize with 3 parameters: string day, string month, string year
		MyDate date3 = new MyDate("second","September","Two Thousand Nine");
		date3.print();
		System.out.println(" ");
		// initialize with 3 parameters: int day, int month, int year
		MyDate date4 = new MyDate(2,4,2021);
		date4.print();
		System.out.println(" ");
		// date3 enter a date from keyboard (mm-dd-yyyy)
		// date3.accept();
		// date3.print();
		// date format
		System.out.println("Choose one option of date formats below:");
		System.out.println("1.yyyy-MM-dd");
		System.out.println("2.d/M/yyyy");
		System.out.println("3.dd-MMM-yyyy");
		System.out.println("4.MMM d yyyy");
		System.out.println("5.mm-dd-yyyy");
		Scanner keyboard = new Scanner(System.in);
		int formatChoice = 0;
		System.out.println("Enter number of the option you want");
//		formatChoice = keyboard.nextInt();
//		if (formatChoice < 6 && formatChoice > 0) {
//			MyDate.print(formatChoice);
//		} else {
//			System.out.println("Invalid option!");
//		}
//		keyboard.close();
//		// test DateUtils's method 
//		DateUtils.printResultCompare(DateUtils.compareTwoDates(date1, date2), date1, date2);
//		MyDate[] arrDates = {date1, date2, date3, date4};
//		DateUtils.sortDates(arrDates);
	}

}