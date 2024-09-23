package domain;

public class Book extends Thing {
    private int pages;
    private String author;

    public Book(String name) {
        super(name);
    }

    public Book(String name, int pages, String author) {
        super(name);
        this.pages = pages;
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
