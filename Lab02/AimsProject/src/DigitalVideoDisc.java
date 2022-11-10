
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String directory;
	private int lenght;
	private float cost;
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc( String category,String title, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String directory, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String directory, int lenght, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.lenght = lenght;
		this.cost = cost;
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

	
}
