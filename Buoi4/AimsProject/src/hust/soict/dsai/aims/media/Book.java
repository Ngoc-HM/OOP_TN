//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

package hust.soict.dsai.aims.media;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	// constructor
	public Book(String titleString, String category, float cost, List<String> authors) {
		super(titleString, category,cost);
		this.authors = authors;
	}


	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	// Thêm author vào array list
	public void addAuthor(String authorName) {
		// Nếu ko thấy tên author trong list thì thêm vào
		if(authors.contains(authorName) == false) {
			authors.add(authorName);
		}
		System.out.println("The author " + authorName + " has been added");
	}
	
	// Xóa author vào array list
	public void removeAuthor(String authorName) {
		// Nếu thấy tên author trong list thì mới có thể xóa
		if(authors.contains(authorName) == true) {
			authors.remove(authorName);
		}
		System.out.println("The author " + authorName + " has been removed");
	}

	// Triển khai toString() cho class book
	@Override
	public String toString() {
		return "Book [id = " + id + ", title = " + getTitle() + ", category = " + getCategory() + ", cost = " + getCost() + ", Authors = " + getAuthors()+ "]";
	}


}
