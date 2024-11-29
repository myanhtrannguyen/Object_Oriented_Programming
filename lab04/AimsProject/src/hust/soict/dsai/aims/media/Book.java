package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Book(){
        // TODO Auto-generated constructor stub
        super();
    }
    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }
    public void addAuthor(String author) {
        for(String s: this.authors) {
            if(s == author) {
                System.out.println("The authors already exists");
                return;
            }
        }
        this.authors.add(author);
        System.out.println("The authors has been added");
    }
    public void removeAuthor(String author) {
        boolean check = false;
        for(String s: this.authors) {
            if(s == author) {
                check = true;
                break;
            }
        }
        if(check) {
            this.authors.remove(author);
            System.out.println("The authors has been removed");
        }
        else {
            System.out.println("The author does not exist");
        }
    }

}
