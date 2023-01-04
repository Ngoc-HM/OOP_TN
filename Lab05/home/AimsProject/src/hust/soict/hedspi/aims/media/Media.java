package hust.soict.hedspi.aims.media;

//import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;

public abstract class Media implements Comparable<Object>{
    private String title;
    private String category;
    private float cost;
    private int id;

    public Media(){};


    public Media(int id, String title){
        this.id = id;
        this.title = title;
    }
    public Media(int id,String title,String category){
        this.id = id;
        this.title = title;
        this.category = category;
    }
    public Media(int id,String title,String category,float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public boolean equals(Object o) throws NullPointerException, ClassCastException{
        if(o != null){
            if(o instanceof Media){
                if(this.getTitle().equalsIgnoreCase( ((Media)o).getTitle() ) && this.getCost() == ((Media)o).getCost())
                    return true;
                return false;
            }else {
                throw new ClassCastException("ERROR: Object casting");
            }
        }else{
            throw new NullPointerException("ERROR: Null pointerexception");
        }
    }

    public int compareTo(Object o) throws NullPointerException, ClassCastException{

        if(o!=null){
            if(o instanceof Media){
                return this.title.compareTo(((Media) o).getTitle());
            }else{
                throw new ClassCastException("ERROR: Object casting");
            }
        }else{
            throw new NullPointerException("ERROR: Null pointerexception");
        }
    }
}