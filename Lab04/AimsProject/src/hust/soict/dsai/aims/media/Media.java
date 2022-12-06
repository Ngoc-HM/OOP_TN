package hust.soict.dsai.aims.disc.media;
class Media{
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();
    public Media(){
                
    }
    public class Book extends Media;
    public class DigitalVideoDisc extends Media;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public float getCost(){
        return cost;
    }
    public void setCost(float cost){
        this.cost = cost;
    }
    public List<String> getAuthors(){
        return authors;
    }
    public void setAuthors(List<String> authors){
        this.authors = authors;
    }
    public void addAuthor(String authorName){
        authors.add(authorName);
    }
    public void removeAuthor(String authorName){
        authors.remove(authorName);
    }
    public class Disc extends Media{
        private String director;
        private int length;
        public Disc(){
                    
        }
        public Disc(String title){
            super(title);
        }
        public Disc(String title, String category){
            super(title, category);
        }
        public Disc(String title, String category, float cost){
            super(title, category, cost);
        }
        public String getDirector(){
            return director;
        }
        public void setDirector(String director){
            this.director = director;
        }
        public int getLength(){
            return length;
        }
        public void setLength(int length){
            this.length = length;
        }

        public class Track extends Disc{
            private int length;
            public Track(){
                        
            }
            public Track(String title){
                super(title);
            }
            public Track(String title, String category){
                super(title, category);
            }
            public Track(String title, String category, float cost){
                super(title, category, cost);
            }
            public int getLength(){
                return length;
            }
            public void setLength(int length){
                this.length = length;
            }
        }
        public class CompactDisc extends Disc{
            private String artist;
            private List<Track> tracks = new ArrayList<Track>();
            public CompactDisc(){
                        
            }
            public CompactDisc(String title){
                super(title);
            }
            public CompactDisc(String title, String category){
                super(title, category);
            }
            public CompactDisc(String title, String category, float cost){
                super(title, category, cost);
            }
            public String getArtist(){
                return artist;
            }
            public void setArtist(String artist){
                this.artist = artist;
            }
            public List<Track> getTracks(){
                return tracks;
            }
            public void setTracks(List<Track> tracks){
                this.tracks = tracks;
            }
            public void addTrack(Track track){
                tracks.add(track);
            }
            public void removeTrack(Track track){
                tracks.remove(track);
            }
            public int getLength(){
                int length = 0;
                for(Track track : tracks){
                    length += track.getLength();
                }
                return length;
            }
            public void play(){
                System.out.println("Playing CD: " + this.getTitle());
                System.out.println("CD length: " + this.getLength());
                for(Track track : tracks){
                    System.out.println("Track: " + track.getTitle());
                    System.out.println("Track length: " + track.getLength());
                }
            }
            
        }

    }
}