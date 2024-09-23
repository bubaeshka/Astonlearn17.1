import domain.Book;

public class Main {
    public static void main(String[] args) {

        Book bb = new Book.BookBuilder("Изучаем Java").setPages(1000).setAuthor("Шилдт").build();

        System.out.println("Hello world!");

    }

}