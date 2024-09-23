package domain;

import java.util.Comparator;

public class Book implements Comparable<Book> , Comparator {
    private int pages;
    private String author;

    private String name;

    public Book(String name, int pages, String author) {
        this.name = name;
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
    public int compareTo(Book book) {
        return (this.pages - book.pages);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
