//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public abstract class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	protected int id;
	private static int nbMedia = 0;
	private String title;
	private String category;
	private float cost;
	public Media() {
		// TODO Auto-generated constructor stub
        nbMedia++;
        this.id = nbMedia;
	}

	
	//-	Add the comparators as attributes of the Media class

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media( String title, String category, float cost) {
		this();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(String title) {
		// TODO Auto-generated constructor stub
		this();
	}
	
	@Override
	// Ghi đè phương thức equals trong lớp Objects
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (this == o) return true;
		if (o == null || getClass()!= o.getClass()) return false;
		Media temp = (Media) o;
		return title == temp.title;
	}



}
