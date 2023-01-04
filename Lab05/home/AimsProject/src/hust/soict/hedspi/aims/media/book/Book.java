package hust.soict.hedspi.aims.media.book;
import hust.soict.hedspi.aims.media.Media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String content;
    public List<String>contentTokens =  new ArrayList<String>();
    public Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
    public Book(){};
    public Book(int id,String title){
        super(id,title);
    }
    public Book(int id,String title, String category){
        super(id,title, category);
    }
    public Book(int id,String title, String category, float cost){
        super(id,title, category,cost);
    }
    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);
        if(authors.size() != 0) {
            this.authors = authors;
        }else {
            System.out.println("Authors list is empty !");
        }
    }
    public Book(int id, String title, String category, float cost, ArrayList<String> authors, String content) {
        super(id, title, category, cost);
        if(authors.size() != 0) {
            this.authors = authors;
            this.content = content;
        }else {
            System.out.println("Authors list is empty !");
        }
    }
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        int flag = 0;
        for (String o : authors) {
            if(o.equals(authorName)){
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            authors.add(authorName);
        else
            System.out.println("Can not add the author's name because it existed !");

    }
    public void removeAuthor(String authorName){
        int flag = 0;
        for (String o : authors) {
            if(o.equals(authorName)){
                flag = 1;
                break;
            }
        }
        if(flag == 1)
            authors.removeIf(o->o.equals(authorName));
        else
            System.out.println("The author's name not found !");
    }
    @Override
    public String toString() {
        String string = "";
        string += "Id: " + super.getId() + "\n";
        string += "Title: "	+ super.getTitle() + "\n";
        string += "Category: " + super.getCategory() + "\n";
        string += "Cost: " + super.getCost()+ "\n";
        string += "Author: " + getAuthors()+ "\n";
        string += "Number of tokens: " + contentTokens.size() + "\n";
        string += "Work frequency \t" + "Word" + "\n";
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
            string += entry.getKey() + " - "+ entry.getValue() + "\n";
        }
        return string;
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }
    private void processContent() {
        content = content.replace('.',' ');
        contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        Collections.sort(contentTokens);
        Iterator<String> iterator = contentTokens.iterator();
        while(iterator.hasNext()) {
            String string = iterator.next();
            if (wordFrequency.containsKey(string) == false) {
                wordFrequency.put(string, 1);
            }else {
                int numOfToken = wordFrequency.get(string);
                numOfToken++;
                wordFrequency.put(string, numOfToken);
            }
        }
    }

}