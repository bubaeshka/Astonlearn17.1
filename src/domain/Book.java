package domain;

import java.util.Comparator;

public class Book extends Thing implements Comparable<Book> {
    private int pages; //опция
    private String author; //опция

    public Book(String name) {
        super(name);
    }

    /***
    public Book(String name, int pages, String author) {
        super(name);
        this.pages = pages;
        this.author = author;
    }
    **/

    private Book(BookBuilder bookBuilder) {
        //приватный конструктор билдера
        super(bookBuilder.name);
        this.pages = bookBuilder.pages;
        this.author = bookBuilder.author;
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
        return Comparator.comparing(Book::getPages)
                .thenComparing(Book::getAuthor)
                .thenComparing(Book::getName)
                .compare(this, book);
    }



    //сам билдер
    static class BookBuilder {
        private final String name;
        private int pages;
        private String author;

        //конструктор билдера с обязательным полем
        public BookBuilder(String name) {
            this.name = name;
        }

        //поле опция страницы
        public BookBuilder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        //поле опция авторов
        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='"+ super.getName() + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                '}';
    }

}
